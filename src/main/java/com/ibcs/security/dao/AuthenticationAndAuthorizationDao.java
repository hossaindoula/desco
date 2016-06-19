package com.ibcs.security.dao;

import java.util.List;

import com.ibcs.security.model.Feature;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.AuthorizedGroups;
import com.ibcs.security.model.User;
import com.ibcs.security.model.Component;

public interface AuthenticationAndAuthorizationDao {

	boolean authorizedGroupsAssignmentToUser(User user, List<AuthorizedGroups> authorizedGroups);
	
	boolean authorityAssignmentToAuthorizedGroups(AuthorizedGroups authorizedGroups, List<Authority> authorities);
	
	boolean featureAssignmentToAuthority(Authority authority, List<Feature> features);

}
