package com.ibcs.security.model;

import com.ibcs.base.model.BaseModel;
import org.hibernate.annotations.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("admin")
@Table(name = "user_auth")
public class User extends BaseModel<User> {
	
	private static final long serialVersionUID = 7389991231663740924L;

	@OneToOne
	private Token token;
	private boolean active;
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<AuthorizedGroups> authorizedGroups;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Authority> authorities;
	
	
	public List<AuthorizedGroups> getAuthorizedGroups() {
		return authorizedGroups;
	}
	public void setAuthorizedGroups(List<AuthorizedGroups> authorizedGroups) {
		this.authorizedGroups = authorizedGroups;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}
