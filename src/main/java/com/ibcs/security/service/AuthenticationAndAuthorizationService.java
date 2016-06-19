package com.ibcs.security.service;

import java.util.List;

import com.ibcs.security.model.Feature;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.AuthorizedGroups;
import com.ibcs.security.model.User;

public interface AuthenticationAndAuthorizationService {
	
	boolean authenticate(String username, String password);
	
	boolean checkAuthorization(List<Feature> features, String controller, String operation);
	
	boolean authorizedGroupsAssignmentToUser(User user, List<AuthorizedGroups> authorizedGroups);
	
	boolean authorityAssignmentToAuthorizedGroups(AuthorizedGroups authorizedGroups, List<Authority> authorities);
	
	boolean aspectAssignmentToAuthority(Authority authority, List<Feature> features);
	
}
