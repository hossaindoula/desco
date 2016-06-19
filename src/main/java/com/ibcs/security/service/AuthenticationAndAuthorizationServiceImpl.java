package com.ibcs.security.service;

import java.util.List;

import com.ibcs.security.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibcs.security.AuthorizationBridge;
import com.ibcs.security.dao.UserDao;
import com.ibcs.security.model.Feature;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.AuthorizedGroups;
import com.ibcs.security.model.User;

@Service("authService")
public class AuthenticationAndAuthorizationServiceImpl implements
		AuthenticationAndAuthorizationService {

	@Autowired
	private UserDao userDao;

	public boolean authenticate(String username, String password) {
		User user = userDao.get(username, password);

		if(user instanceof User){
			AuthorizationBridge.setAuthorization(user);

			return true;
		}

		return false;
	}

	public boolean checkAuthorization(List<Feature> features, String controller, String operation) {
		boolean isAllowed = false;
		for(Feature feature : SessionUtil.getSessionUserFeatures()){
			if(feature.getComponent().getComponentName().equals(controller)
					&& feature.getOperation().equals(operation)){
				isAllowed = true;
				break;
			}
		}
		return isAllowed;
	}

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

	public boolean aspectAssignmentToAuthority(Authority authority,
											   List<Feature> features) {
		// TODO Auto-generated method stub
		return false;
	}


}
