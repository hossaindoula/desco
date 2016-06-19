package com.ibcs.security.model;

import com.ibcs.base.model.BaseModel;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;

@Entity
@Table(name = "authorized_groups")
public class AuthorizedGroups extends BaseModel<AuthorizedGroups> {

	private static final long serialVersionUID = 1L;

	@Column(unique=true)
	private String name;
	private String authorizationDescription;
	private String dashboardUrl;
	
	@ManyToMany(mappedBy = "authorizedGroups", fetch = FetchType.EAGER)
	private List<User> users;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Authority> authorities;
	
	
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorizationDescription() {
		return authorizationDescription;
	}
	public void setAuthorizationDescription(String authorizationDescription) {
		this.authorizationDescription = authorizationDescription;
	}

	public String getDashboardUrl() {
		return dashboardUrl;
	}

	public void setDashboardUrl(String dashboardUrl) {
		this.dashboardUrl = dashboardUrl;
	}

}
