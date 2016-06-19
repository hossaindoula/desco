package com.ibcs.security.dto;

import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.model.Feature;

/**
 * Created by Dell on 6/11/2016.
 */
public class FeatureBean extends ModelForm implements Cloneable {

    private String componentName;
    private String operationName;
    private String description;

    public FeatureBean() {
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Feature clone() throws CloneNotSupportedException {
        FeatureBean featureBean = (FeatureBean)super.clone();

        Feature feature = new Feature();

        return feature;
    }
}
