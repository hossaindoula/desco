package com.ibcs.base.model;

import com.ibcs.base.cloner.CloneException;
import com.ibcs.base.component.AppComponent;
import com.ibcs.security.model.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * This is an abstract @MappedSuperclass which has to be
 * inherited by other Entities to get those common properties
 * No need to write those common properties again and again
 * We have to reuse those common properties whenever we need to use them
 * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Created by hossain.doula<hossain.doula@ibcs-primax.com> on 5/16/2016.
 */

@MappedSuperclass
public abstract class BaseModel<T extends BaseModel> implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    private String uuid; // for uniquely identification used this property
    private String status = AppComponent.STATUS_ACTIVE; // A=active,I=inactive,D=deleted
    private Long sortOrder = 1L; // Sort order for custom ordering

    @Version
    private Integer version; //for optimistic locking

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated; // created date when create

    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified; // modified date when every time update

    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeleted; // deleted date when any data virtually deleted

    @ManyToOne
    private User createdBy; // created by user who create/save date firstly

    @ManyToOne
    private User modifiedBy; // modified by user who update data lastly

    @ManyToOne
    private User deletedBy; // deleted by user who delete data
    private String deletedRemark; // track comment/remark for deleted data

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = UUID.randomUUID().toString();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Date getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public User getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(User deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getDeletedRemark() {
        return deletedRemark;
    }

    public void setDeletedRemark(String deletedRemark) {
        this.deletedRemark = deletedRemark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    @SuppressWarnings("unchecked")
    public T merge(T other) {
        // do not copy id so as not to confuse hibernate
        this.uuid = other.getUuid();
        this.status = other.getStatus();
        this.sortOrder = other.getSortOrder();
        this.dateCreated = other.getDateCreated();
        this.dateModified = other.getDateModified();
        this.dateDeleted = other.getDateDeleted();
        this.createdBy = other.getCreatedBy();
        this.modifiedBy = other.getModifiedBy();
        this.deletedBy = other.getDeletedBy();
        this.deletedRemark = other.getDeletedRemark();

        return (T) this;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||
                !(o instanceof BaseModel )) {

            return false;
        }

        BaseModel other  = (BaseModel ) o;

        // if the id is missing, return false
        if (id == null) return false;

        // equivalence by id
        return id.equals(other.getId());
    }

    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        } else {
            return super.hashCode();
        }
    }

    public String toString() {
        return this.getClass().getName()
                + "[id=" + id + "]";
    }

    public boolean isCreation() {
        return version == null;
    }

    private void putClonedObject(Map<String, BaseModel> clonedObjects, BaseModel clone) {
        clonedObjects.put(clone.getClass().getName() + ":" + clone.getId(), clone);
    }

    private boolean existClonedObject(Map<String, BaseModel> clonedObjects, BaseModel object) {
        return clonedObjects.containsKey(object.getClass().getName() + ":" + object.getId());
    }

    private BaseModel getClonedObject(Map<String, BaseModel> clonedObjects, BaseModel object) {
        return clonedObjects.get(object.getClass().getName() + ":" + object.getId());
    }

    @SuppressWarnings("unchecked")
    private Object copy(Map<String, BaseModel> clonedObjects) throws CloneNotSupportedException, IllegalArgumentException, IllegalAccessException, InstantiationException {
        BaseModel cloneOfThis = (BaseModel) super.clone();
        putClonedObject(clonedObjects, cloneOfThis);

        /**
         * get all fields of class and super class
         */
        Collection<Field> fields = new ArrayList<Field>();
        fields.addAll(Arrays.asList(cloneOfThis.getClass().getDeclaredFields()));
        Class superClass = cloneOfThis.getClass().getSuperclass();
        while (BaseModel.class.isAssignableFrom(superClass)) {
            fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
            superClass = superClass.getSuperclass();
        }

        for (Field field : fields) {
            boolean changeAccessible = false;
            //if (Modifier.isPrivate(field.getModifiers())) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            if (field.get(cloneOfThis) instanceof BaseModel) {
                BaseModel object = (BaseModel) field.get(cloneOfThis);
                if (existClonedObject(clonedObjects, object)) {
                    field.set(cloneOfThis, getClonedObject(clonedObjects, object));
                } else {
                    field.set(cloneOfThis, object.copy(clonedObjects));
                }
            } else if (field.get(cloneOfThis) instanceof Collection) {
                Collection<Object> objects = (Collection) field.get(cloneOfThis);
                Collection<Object> clones = new HashSet<Object>(); //(Collection) field.get(cloneOfThis).getClass().newInstance();
                for (Iterator<Object> iter = objects.iterator(); iter.hasNext();) {
                    Object obj = iter.next();
                    if (obj instanceof BaseModel) {
                        BaseModel object = (BaseModel) obj;
                        if (existClonedObject(clonedObjects, object)) {
                            clones.add(getClonedObject(clonedObjects, object));
                        } else {
                            clones.add(object.copy(clonedObjects));
                        }
                    }
                }
                field.set(cloneOfThis, clones);
            }
            if (changeAccessible) {
                field.setAccessible(false);
            }
        }
        return cloneOfThis;
    }

    /**
     * @return return a copy of this object
     */
    public Object copy() {
        try {
            Map<String, BaseModel> clonedObjects = new HashMap<String, BaseModel>();
            return copy(clonedObjects);
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new CloneException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new CloneException(e);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new CloneException(e);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new CloneException(e);
        }
    }
}
