package com.ibcs.security.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibcs.security.model.Feature;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.AuthorizedGroups;
import com.ibcs.security.model.User;
import com.ibcs.security.model.Component;

@Repository
public class AuthenticationAndAuthorizationDaoImpl implements
		AuthenticationAndAuthorizationDao {

	
	public boolean authorizedGroupsAssignmentToUser(
			User user, List<AuthorizedGroups> authorizedGroups) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean authorityAssignmentToAuthorizedGroups(
			AuthorizedGroups authorizedGroups, List<Authority> authorities) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean featureAssignmentToAuthority(Authority authority,
			List<Feature> features) {
		// TODO Auto-generated method stub
		return false;
	}

}
