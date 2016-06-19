package com.ibcs.base.loader;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

import com.ibcs.base.util.ModelUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.collection.internal.PersistentList;
import org.hibernate.collection.internal.PersistentSet;
import java.util.Collection;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * This class is used to load the lazy attributes of Hibernate or Collection types in a POJO Hibernate.
 * 		Example of using this class:
 * 		<code>
 * 			// <b>This function receives as input a bean attached to Hibernate session</b>
 * 			// <b>The below line specifies the attributes to be loaded when the bean is attached to the collections and hibernate beans</b>
 * 			// <b>this avoids loading all the elements of the bean in memory.</b>
 * 			String[] levelsToLoad = new String[] {"language", "chapters/book", "authors"};<br/>
 *			// This bean is attached to Hibernate Session<br/>
 * 			Book hibernateAttachedBean = new Book();<br/>
 * 			[...]<br/>
 * 			Book hibernateDetachedBean = (new ModelLazyLoader<Book>()).lazyLoad(hibernateAttachedBean, levelsToLoad);<br/>
 * 		</code>
 * </p>
 *
 * @author Huseyin Ozveren
 */
public class ModelLazyLoader<PojoType> {

    // --------------------------------------------------------------------- ATTRIBUTES
    // --------------------------------------------------------------- PUBLIC METHODS
    /**
     * <p>
     * 		Syntax:
     * 		<ul>
     * 			<li>
     * 				(new ORMLazyLoader<Book>()).lazyLoad(bean, new String{"language", "chapters/book", "authors"}); :
     * 				load all primitive attributes of:
     * 					- "language" attribute of first level,
     * 					- each instance "chapter" in "chapters" attribute of first level,
     * 					- each instance "book" of second level in above "chapters/chapter" attribute of first level,
     * 					- each instance "author" in "authors" of first level.
     * 			</li>
     * 			<li>
     * 				(new ORMLazyLoader<Book>()).lazyLoad(bean, new String[] {}); :
     * 				load all primitive attributes of the first level.
     * 			</li>
     * 			<li>
     * 				(new ORMLazyLoader<Book>()).lazyLoad(bean, new String[] {"*"}); :
     * 				load all attributes (primitive, collection, hibernate types) of the first level.
     * 			</li>
     * 			<li>
     * 				(new ORMLazyLoader<Book>()).lazyLoad(bean, new String{"*&#47*"}); :
     * 				load all attributes (primitive, collection, hibernate types) of the first and second levels.
     * 			</li>
     * 		</ul>
     * </p>
     */
    @SuppressWarnings("unchecked")
    public final PojoType lazyLoad(final PojoType source, String[] levelsToLoad) {
        return (PojoType) deepLazyLoad(source, levelsToLoad, 0);
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
    private final String[] getRemainingLevelsToLoad(String[] levelsToLoad, String currProperty) {

        ArrayList<String> output = new ArrayList<String>();
        if (null != levelsToLoad){
            for (String currLevel : levelsToLoad) {
                if (null != currLevel) {
                    // Check if the currProperty is in the levels to load
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
     * 	Returns true if the property named propertyName must be loaded.
     */
    private final boolean isLevelLoadNecessary(String propertyName, String[] levelsToLoad) {

        if (null != levelsToLoad){
            for (String currLevel : levelsToLoad) {
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
     * Load a lazy property with a type of hibernate object
     *
     * @param currProperty: the name of property to load
     * @param askedLevelsToLoad: original levels asked
     * @param sourceBean: original source bean to detach
     * @param currLevel: current level
     * @param remainingLevelsToLoad: sub-levels of the current property to load
     */
    private final void lazyLoadHibernateObject(
            String currProperty,
            String[] askedLevelsToLoad,
            Object sourceBean,
            Integer currLevel,
            String[] remainingLevelsToLoad
    ) {
        try {
            // Check if the current hibernate property must be loaded according to the asked properties
            if (isLevelLoadNecessary(currProperty, askedLevelsToLoad)) {

                // Get the object to detach from the source bean
                Object propertyToLoad = PropertyUtils.getProperty(sourceBean, currProperty);
                if (null != propertyToLoad) {
                    // Load recursively the Hibernate Object
                    Object loadedObject = deepLazyLoad (propertyToLoad, remainingLevelsToLoad, currLevel+1);

                    // Set the property into the result bean
                    PropertyUtils.setProperty(sourceBean, currProperty, loadedObject);

                }//end-if

            } // end-if

        } catch (IllegalAccessException e) {
            logErrorMessage("sourceBean= " + sourceBean + " propertyName = " +currProperty, e);
        } catch (InvocationTargetException e) {
            logErrorMessage("sourceBean= " + sourceBean + " propertyName = " +currProperty, e);
        } catch (NoSuchMethodException e) {
            logErrorMessage("sourceBean= " + sourceBean + " propertyName = " +currProperty, e);
        } // end-try
    }

    /**
     * Load a lazy property with a type of collection object
     *
     * @param propertyToLoad
     * @param currLevel
     * @param remainingLevelsToLoad
     * @return
     */
    @SuppressWarnings("unchecked")
    private final Collection lazyLoadCollection(Collection propertyToLoad, Integer currLevel, String[] remainingLevelsToLoad ) {

        Collection output = null;
        try {
            if (null != propertyToLoad) {
                // Instance of Set
                if (propertyToLoad instanceof PersistentSet) {
                    output = new HashSet();

                    // Instance of List
                }else  if (propertyToLoad instanceof PersistentList){
                    output = new ArrayList();

                    // Other
                } else {
                    // Initialization needed in order to not clone the Proxy class of Spring/Hibernate Javassist
                    propertyToLoad = ModelUtils.initializeAndUnproxy(propertyToLoad);
                    // Create a new EMPTY instance of the source bean
                    output = propertyToLoad.getClass().newInstance();
                } // end-if


                // Initialization needed in order to load the current object
                propertyToLoad = ModelUtils.initializeAndUnproxy(propertyToLoad);

                for (Object currCollectionBean : propertyToLoad) {
                    logMessage("recursive 'deepLazyLoad' loading of the elements of collection Object " , currLevel+1);

                    // Load recursively the elements of collection Object
                    Object loadedObject = deepLazyLoad (currCollectionBean,  remainingLevelsToLoad, currLevel+1);

                    output.add(loadedObject);
                } // end-for
            } //end-for

        } catch (Throwable e) {
            logErrorMessage("propertyToLoad= " + propertyToLoad , e);
        } // end-try

        return output;
    }

    /**
     * Get the attribute with a type of collection and load it.
     *
     * @param currProperty
     * @param askedLevelsToLoad
     * @param sourceBean
     * @param currLevel
     * @param remainingLevelsToLoad
     */
    @SuppressWarnings("unchecked")
    private final void lazyLoadCollectionAttribute(
            String currProperty,
            String[] askedLevelsToLoad,
            Object sourceBean,
            Integer currLevel,
            String[] remainingLevelsToLoad
    ) {
        try {
            // Check if the current hibernate property must be loaded according to the asked properties
            if (isLevelLoadNecessary(currProperty, askedLevelsToLoad)) {
                logMessage("loop on: " + currProperty, currLevel);

                // Collection
                Collection propertyToLoad = (Collection) PropertyUtils.getProperty(sourceBean, currProperty);

                // Load collection
                Collection loadedProperty = lazyLoadCollection(propertyToLoad, currLevel, remainingLevelsToLoad);

                // Set the collection property into the result object
                PropertyUtils.setProperty(sourceBean, currProperty, loadedProperty);

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
        return ModelUtils.class.isAssignableFrom(propertyClass);
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
            if (PropertyUtils.isWriteable(bean, currProperty) && PropertyUtils.isReadable(bean, currProperty)) {
                output.add(currProperty);
            } // end-if
        } //end-for


        return output.toArray(new String[output.size()]);
    }

    /**
     * This method allows:
     * - the recursive 'deepLazyLoad' loading of hibernate object;
     * - recursive 'deepLazyLoad' loading of the elements of collection Object;
     *
     * @param sourceBean:  original source bean to load
     * @param askedLevelsToLoad: the levels asked to load
     * @param currLevel: current level
     * @return
     */
    @SuppressWarnings("unchecked")
    private final Object deepLazyLoad (Object sourceBean,  String[] askedLevelsToLoad, Integer currLevel) {

        try {
            if(sourceBean==null){
                return null;
            }

            // Collection of objects
            if (sourceBean instanceof Collection) {
                lazyLoadCollection((Collection) sourceBean, currLevel, askedLevelsToLoad);

            } else{
                // Initialization needed in order to load the current object
                sourceBean = ModelUtils.initializeAndUnproxy(sourceBean);

                // Properties of this object
                String[] properties = describe(sourceBean); // PropertyUtils.describe(bean);

                // Range all properties
                for (String currProperty : properties) {

                    // If it is a Writeable property
                    if (PropertyUtils.isWriteable(sourceBean, currProperty)) {
                        // Class of current property
                        Class propertyClass = PropertyUtils.getPropertyType(sourceBean, currProperty);

                        // Levels to load
                        String[] remainingLevelsToLoad = getRemainingLevelsToLoad(askedLevelsToLoad, currProperty);

                        // Hibernate Object 'AbstractPersistentObject'
                        if (isHibernateObject(propertyClass)) {
                            lazyLoadHibernateObject(currProperty, askedLevelsToLoad, sourceBean, currLevel, remainingLevelsToLoad);
                            // Collection property
                        } else if (isCollection(propertyClass)){
                            lazyLoadCollectionAttribute(currProperty, askedLevelsToLoad, sourceBean, currLevel, remainingLevelsToLoad);
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
        } //end-try

        return sourceBean;
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
