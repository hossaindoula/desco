package com.ibcs.security.model;

import com.ibcs.base.model.BaseModel;
import org.hibernate.annotations.*;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
		{
				@NamedQuery(
						name = "findByAuthorityName",
						query = "from Authority au where au.name = :name"
				)
		}
)
public class Authority extends BaseModel<Authority> {
	
	private static final long serialVersionUID = -7056246735190005660L;

	@Column(unique=true)
	private String name;
	private String authorityDescription;
	
	@ManyToMany(mappedBy = "authorities")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<AuthorizedGroups> authorizedGroups;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Feature> features;

	@ManyToMany(mappedBy = "authorities")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<User> users;

	public List<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
	public List<AuthorizedGroups> getAuthorizedGroups() {
		return authorizedGroups;
	}
	public void setAuthorizedGroups(List<AuthorizedGroups> authorizedGroups) {
		this.authorizedGroups = authorizedGroups;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorityDescription() {
		return authorityDescription;
	}
	public void setAuthorityDescription(String authorityDescription) {
		this.authorityDescription = authorityDescription;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
