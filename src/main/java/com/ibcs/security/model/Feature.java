package com.ibcs.security.model;

import com.ibcs.base.model.BaseModel;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;

import java.io.Serializable;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;


@Entity
@NamedQueries(
		{
				@NamedQuery(
						name = "findAllFeaturesByOperation",
						query = "from Feature f where f.operation = :operation"
				),

				@NamedQuery(
						name = "findAllFeaturesByComponent",
						query = "from Feature f where f.component.id = :componentId"
				)
		}
)
public class Feature extends BaseModel<Feature> {
	
	private static final long serialVersionUID = 8506032467669918398L;

	@ManyToOne
	private Component component;
    private String operation;
    private String description;
    
    @ManyToMany(mappedBy = "features")
	@LazyCollection(LazyCollectionOption.FALSE)
    private List<Authority> authorities;
    
    
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Component getComponent() {
		return component;
	}
	public void setComponent(Component component) {
		this.component = component;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
