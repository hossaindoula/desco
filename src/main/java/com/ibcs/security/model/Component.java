package com.ibcs.security.model;

import com.ibcs.base.model.BaseModel;
import javax.persistence.*;

@Entity
@NamedQueries(
		{
				@NamedQuery(
						name = "findComponentByName",
						query = "from Component comp where comp.componentName = :componentName"
				)
		}
)
public class Component extends BaseModel<Component> {
	
	private static final long serialVersionUID = 5368971495940924284L;

	@Column(name = "component_name", unique=true)
	private String componentName;
	private String description;

	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
