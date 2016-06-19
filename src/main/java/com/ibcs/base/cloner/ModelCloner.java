package com.ibcs.base.cloner;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.ibcs.base.model.BaseModel;
import com.ibcs.base.util.ModelUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.collection.internal.PersistentList;
import org.hibernate.collection.internal.PersistentSet;

/**
 * This class is used to convert a POJO Hibernate into a detached POJO.
 * 		Example of using this class:
 * 		<code>
 * 			// <b>This function receives as input a bean attached to Hibernate session</b>
 * 			// <b>The below line specifies the attributes to be copied when the bean is attached to the collections and hibernate beans</b>
 * 			// <b>this avoids loading all the elements of the bean in memory and in its copy.</b>
 * 			String[] levelsToCopy = new String[] {"language", "chapters/book", "authors"};<br/>
 *			// This bean is attached to Hibernate Session<br/>
 * 			Book hibernateAttachedBean = new Book();<br/>
 * 			[...]<br/>
 * 			Book hibernateDetachedBean = (new ModelCloner<PojoType>()).clone(hibernateAttachedBean, levelsToCopy);<br/>
 * 		</code>
 * </p>
 *
 * @author Mohammed Hossain Doula
 */
public class ModelCloner <PojoType> {

    // --------------------------------------------------------------------- ATTRIBUTES
    /**
     * <p>
     * This map lists the objects already processed in order to avoid creating cycles (infinite loops) but also to recover the instances of identical objects.<br/>
     * This Map is based on the methods 'HashCode' and 'Equals' of the HibernateObject (see the AbstractPersistentObject class).<br/>
     *
     * </p>
     */
    private final Map<Integer, Object> alreadyProcessedObjects = new HashMap<Integer, Object>();

    // --------------------------------------------------------------- PUBLIC METHODS
    /**
     * <p>
     * 		Syntax:
     * 		<ul>
     * 			<li>
     * 				(new ModelCloner<PojoType>()).clone(bean, new String{"language", "chapters/book", "authors"}); :
     * 				copy all primitive attributes of:
     * 					- "language" attribute of first level,
     * 					- each instance "chapter" in "chapters" attribute of first level,
     * 					- each instance "book" of second level in above "chapters/chapter" attribute of first level,
     * 					- each instance "author" in "authors" of first level.
     * 			</li>
     * 			<li>
     * 				(new ModelCloner<PojoType>()).clone(bean, new String[] {}); :
     * 				copy all primitive attributes of the first level.
     * 			</li>
     * 			<li>
     * 				(new ModelCloner<PojoType>()).clone(bean, new String[] {"*"}); :
     * 				copy all attributes (primitive, collection, hibernate types) of the first level.
     * 			</li>
     * 			<li>
     * 				(new ModelCloner<PojoType>()).clone(bean, new String{"*&#47*"}); :
     * 				copy all attributes (primitive, collection, hibernate types) of the first and second levels.
     * 			</li>
     * 		</ul>
     * </p>
     */
    @SuppressWarnings("unchecked")
    public final PojoType clone (final PojoType source, String[] levelsToCopy) {
        return (PojoType) deepClone(source, levelsToCopy, 0);
    }


    // ------------------------------------------------------------------ PRIVATE METHODS
    /**
     *	For given levels in the form:<br/>
     *		new String[]{"chapters/paragraphs", "chapters/book/language", "language", "authors/language"},<br/>
     *	and a current property:<br/>
     *		"chapters",<br/>
     *	returns the sub-levels of the current property:<br/>
     *		new String[]{"paragraphs", "book/language"},<br/>
     */
    private final String[] getRemainingLevelsToCopy(String[] levelsToCopy, String currProperty) {

        ArrayList<String> output = new ArrayList<String>();
        if (null != levelsToCopy){
            for (String currLevel : levelsToCopy) {
                if (null != currLevel) {
                    // Check if the currProperty is in the levels to copy
                    int indexOfSlash = currLevel.indexOf(currProperty+"/");
                    if (-1 != indexOfSlash) {
                        // Get the sub-levels
                        String remainingLevel = currLevel.substring(indexOfSlash + (currProperty+"/").length());
                        output.add(remainingLevel);
                    }else if(currLevel.indexOf("*/")==0){
                        String remainingLevel = currLevel.substring(0+("*/").length());
                        output.add(remainingLevel);
                    }
                } // end-if
            } // end-if
        } // end-if

        return (String[]) output.toArray((new String[output.size()]));
    }

    /**
     * 	Returns true if the property named propertyName must be copied.
     */
    private final boolean isLevelCopyNecessary(String propertyName, String[] levelsToCopy) {

        if (null != levelsToCopy){
            for (String currLevel : levelsToCopy) {
                if (null != currLevel) {
                    String authorizedLevel = currLevel.split("/")[0];
                    if (authorizedLevel.equals("*") || authorizedLevel.equals(propertyName)) {
                        return true;
                    }
                }
            } // end-for
        }

        return false;
    }

    /**
     * Clone a primitive property
     *
     * @param sourceBean: original source bean to detach
     * @param targetBean: result bean of detaching
     * @param propertyName: property name
     * @param currLevel: current level
     */
    private final void cloneProperty(Object sourceBean, Object targetBean, String propertyName, Integer currLevel) {
        try {
            Object propertyToClone = PropertyUtils.getProperty(sourceBean, propertyName);
            // Calendar specific case
            if ( null != propertyToClone && propertyToClone instanceof Calendar ) {
                BeanUtils.setProperty(targetBean, propertyName, ((Calendar)propertyToClone).clone());
            }else {
                BeanUtils.copyProperty(targetBean, propertyName, propertyToClone);
            } // end-if

        } catch (IllegalAccessException e) {
            logErrorMessage("sourceBean= " + sourceBean + " propertyName = " +propertyName, e);
        } catch (InvocationTargetException e) {
            logErrorMessage("sourceBean= " + sourceBean + " propertyName = " +propertyName, e);
        } catch (NoSuchMethodException e) {
            logErrorMessage("sourceBean= " + sourceBean + " propertyName = " +propertyName, e);
        }//end-try
        logMessage("copy of the property: " + propertyName , currLevel);
    }

    /**
     * Get the already detached object in the MAP
     * @param objectBean: Object sought in the MAP
     * @return
     */
    private final Object getAlreadyDetachedCorrespondingObject(final Object objectBean) {
        Object output = null;
        if (null != objectBean) {
            output = alreadyProcessedObjects.get(objectBean.hashCode());
        } // end-if
        return output;
    }

    /**
     * Put the already detached in the MAP
     * @param objectBean to out in the MAP
     */
    private final void putDetachedObject(final Object objectBean){
        if (null != objectBean) {
            alreadyProcessedObjects.put(objectBean.hashCode(), objectBean);
            logMessage("putDetachedObject : " + objectBean.hashCode(), 0);
        } // end-if
    }

    /**
     * Clone a property with a type of hibernate object
     *
     * @param currProperty: the name of property to copy/clone
     * @param askedLevelsToCopy: original levels asked
     * @param sourceBean: original source bean to detach
     * @param currLevel: current level
     * @param remainingLevelsToCopy: sub-levels of the current property to copy
     * @param output: result bean of detaching
     * @return
     */
    private final Object cloneHibernateObject(
            String currProperty,
            String[] askedLevelsToCopy,
            Object sourceBean,
            Integer currLevel,
            String[] remainingLevelsToCopy,
            Object output
    ) {
        try {
            // Check if the current hibernate property must be copied according to the asked properties
            if (isLevelCopyNecessary(currProperty, askedLevelsToCopy)) {

                // Get the object to detach from the source bean
                Object propertyToClone = PropertyUtils.getProperty(sourceBean, currProperty);
                if (null != propertyToClone) {

                    // Check if this object has been already detached
                    Object alreadyProcessedObject = getAlreadyDetachedCorrespondingObject(propertyToClone);
                    if (null == alreadyProcessedObject) {
                        logMessage("recursive 'deepClone' copy of hibernate object : " + currProperty , currLevel);

                        // Clone recursively the Hibernate Object
                        Object clonedObject = deepClone (
                                propertyToClone,
                                remainingLevelsToCopy,
                                currLevel+1
                        );
                        // Set the property into the result bean
                        PropertyUtils.setProperty(output, currProperty, clonedObject);

                        // Put the result of cloning in the MAP of already processing objects
                        putDetachedObject(clonedObject);

                    }else{
                        // Set the property into the result bean
                        PropertyUtils.setProperty(output, currProperty, alreadyProcessedObject);
                    }
                }//end-if

            } // end-if

        } catch (IllegalAccessException e) {
            logErrorMessage("sourceBean= " + sourceBean + " propertyName = " +currProperty, e);
        } catch (InvocationTargetException e) {
            logErrorMessage("sourceBean= " + sourceBean + " propertyName = " +currProperty, e);
        } catch (NoSuchMethodException e) {
            logErrorMessage("sourceBean= " + sourceBean + " propertyName = " +currProperty, e);
        } // end-try

        return output;

    }

    /**
     * Clone a property with a type of collection object
     *
     * @param propertyToClone
     * @param currLevel
     * @param remainingLevelsToCopy
     * @return
     */
    @SuppressWarnings("unchecked")
    private final Collection cloneCollection(Collection propertyToClone, Integer currLevel, String[] remainingLevelsToCopy ) {

        Collection output = null;
        try {
            if (null != propertyToClone) {
                // Instance of Set
                if (propertyToClone instanceof PersistentSet) {
                    output = new HashSet();

                    // Instance of List
                }else  if (propertyToClone instanceof PersistentList){
                    output = new ArrayList();

                    // Other
                } else {
                    // Initialization needed in order to not clone the Proxy class of Spring/Hibernate Javassist
                    propertyToClone = ModelUtils.initializeAndUnproxy(propertyToClone);
                    // Create a new EMPTY instance of the source bean
                    output = propertyToClone.getClass().newInstance();
                } // end-if


                for (Object currCollectionBean : propertyToClone) {
                    logMessage("recursive 'deepClone' copy of the elements of collection Object " , currLevel+1);

                    // Clone recursively the elements of collection Object
                    Object clonedObject = deepClone (
                            currCollectionBean,
                            remainingLevelsToCopy,
                            currLevel+1);

                    output.add(clonedObject);

                } // end-for
            } //end-for

        } catch (IllegalAccessException e) {
            logErrorMessage("propertyToClone= " + propertyToClone , e);
        } catch (InstantiationException e) {
            logErrorMessage("propertyToClone= " + propertyToClone , e);
        } // end-try
        return output;
    }

    /**
     * Get the attribute with a type of collection and clone it.
     *
     * @param currProperty
     * @param askedLevelsToCopy
     * @param sourceBean
     * @param currLevel
     * @param remainingLevelsToCopy
     * @param output
     */
    @SuppressWarnings("unchecked")
    private final void cloneCollectionAttribute(
            String currProperty,
            String[] askedLevelsToCopy,
            Object sourceBean,
            Integer currLevel,
            String[] remainingLevelsToCopy,
            Object output) {
        try {
            // Check if the current hibernate property must be copied according to the asked properties
            if (isLevelCopyNecessary(currProperty, askedLevelsToCopy)) {
                logMessage("loop on: " + currProperty, currLevel);

                //Collection
                Collection propertyToClone = (Collection) PropertyUtils.getProperty(sourceBean, currProperty);

                // Clone collection
                Collection clonedProperty = cloneCollection(propertyToClone, currLevel, remainingLevelsToCopy);

                // Set the collection property into the result object
                PropertyUtils.setProperty(output, currProperty, clonedProperty);
            } // end-if

        } catch (IllegalAccessException e) {
            logErrorMessage("sourceBean= " + sourceBean + " currProperty=" +  currProperty , e);
        } catch (InvocationTargetException e) {
            logErrorMessage("sourceBean= " + sourceBean + " currProperty=" +  currProperty , e);
        } catch (NoSuchMethodException e) {
            logErrorMessage("sourceBean= " + sourceBean + " currProperty=" +  currProperty , e);
        } // end-try
    }

    /**
     * Return true if the abstract class 'AbstractPersistentObject' is either the same as,
     * or is a superclass or superinterface of, the class or interface represented by the specified
     * <code>Class</code> parameter.
     *
     * @param propertyClass
     * @return
     */
    @SuppressWarnings("unchecked")
    private final boolean isHibernateObject(Class propertyClass) {
        return BaseModel.class.isAssignableFrom(propertyClass);
    }

    /**
     * Return true if the <code>Class</code> parameter is a 'Collection'.
     * @param propertyClass
     * @return
     */
    @SuppressWarnings("unchecked")
    private final boolean isCollection(Class propertyClass) {
        return Collection.class.isAssignableFrom(propertyClass);
    }

    /**
     * Returns the names of the bean properties for which there is a get / set pair.
     */
    private final String[] describe(Object bean) {
        ArrayList<String> output = new ArrayList<String>();

        PropertyDescriptor[] properties = PropertyUtils.getPropertyDescriptors(bean); // Properties

        for (PropertyDescriptor currPropertyDescriptor : properties) {
            String currProperty = currPropertyDescriptor.getName();
            if (
                    PropertyUtils.isWriteable(bean, currProperty) &&
                            PropertyUtils.isReadable(bean, currProperty)
                    ) {
                output.add(currProperty);
            } // end-if
        } //end-for


        return output.toArray(new String[output.size()]);
    }

    /**
     * This method allows:
     * - the recursive 'deepClone' copy of hibernate object;
     * - recursive 'deepClone' copy of the elements of collection Object;
     *
     * @param sourceBean:  original source bean to detac
     * @param askedLevelsToCopy: the levels asked to copy
     * @param currLevel: current level
     * @return
     */
    @SuppressWarnings("unchecked")
    private final Object deepClone (Object sourceBean,  String[] askedLevelsToCopy, Integer currLevel) {

        Object output = null; //Object result

        try {
            if(sourceBean==null){
                return output;
            }

            // Collection of objects
            if (sourceBean instanceof Collection) {
                output = cloneCollection((Collection) sourceBean, currLevel, askedLevelsToCopy);

            } else{
                // Initialization needed in order to not clone the Proxy class of Spring/Hibernate Javassist
                sourceBean = ModelUtils.initializeAndUnproxy(sourceBean);
                // Create a new EMPTY instance of the source bean
                output = sourceBean.getClass().newInstance();

                // Properties of this object
                String[] properties = describe(sourceBean); // PropertyUtils.describe(bean);

                // Range all properties
                for (String currProperty : properties) {

                    // If it is a Writeable property
                    if (PropertyUtils.isWriteable(sourceBean, currProperty)) {
                        // Class of current property
                        Class propertyClass = PropertyUtils.getPropertyType(sourceBean, currProperty);

                        // Levels to copy
                        String[] remainingLevelsToCopy = getRemainingLevelsToCopy(askedLevelsToCopy, currProperty);

                        // Hibernate Object 'AbstractPersistentObject'
                        if (isHibernateObject(propertyClass)) {
                            output = cloneHibernateObject(currProperty, askedLevelsToCopy, sourceBean, currLevel, remainingLevelsToCopy, output);
                            // Collection property
                        } else if (isCollection(propertyClass)){
                            cloneCollectionAttribute(currProperty, askedLevelsToCopy, sourceBean, currLevel, remainingLevelsToCopy, output);
                            // Primitive property
                        } else {
                            cloneProperty(sourceBean, output, currProperty, currLevel);
                        } // end-if

                    } // end-if
                } // end-for

            } // end-if

        } catch (IllegalAccessException e) {
            logErrorMessage("sourceBean= " + sourceBean , e);
        } catch (InvocationTargetException e) {
            logErrorMessage("sourceBean= " + sourceBean , e);
        } catch (NoSuchMethodException e) {
            logErrorMessage("sourceBean= " + sourceBean , e);
        } catch (InstantiationException e) {
            logErrorMessage("sourceBean= " + sourceBean , e);
        } //end-try

        return output;

    }

    /**
     * Log message
     * @param message
     * @param level
     */
    private final void logMessage(String message, Integer level) {
        final String tabulation = "\t";
        System.out.println(StringUtils.repeat(tabulation, level)+ message);
    }

    /**
     * Log error message
     * @param message
     * @param exception
     */
    private final void logErrorMessage(String message, Throwable exception) {
        String exceptionMessage = ExceptionUtils.getStackTrace(exception);
        logMessage(message+exceptionMessage, 1);
    }

}