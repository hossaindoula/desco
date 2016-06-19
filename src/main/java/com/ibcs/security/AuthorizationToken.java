package com.ibcs.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.ibcs.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibcs.security.model.Authority;
import com.ibcs.security.model.AuthorizedGroups;
import com.ibcs.security.model.Feature;
import com.ibcs.security.model.User;
import com.ibcs.security.service.UserDetailsService;


/**
 * This class contains the functionality to find out user's authorized groups,
 * authorities and authorized features and store them into session attributes. 
 *
 */
public class AuthorizationToken {
	
	public User principal;
	public List<Authority> credentials;
	public List<AuthorizedGroups> authorizedGroups;
	public List<Feature> authorities;
	public List<Feature> grantedAuthorities;
	
		
	private AuthorizationToken(User user) {
		setAuthenticationToken(user);
	}

	private static AuthorizationToken instance = null;

	public static AuthorizationToken getToken(User user) {
		instance = new AuthorizationToken(user);

		return instance;
	}
	
	/**
	 * This method contains the functionality to find out user's authorized groups,
	 * authorities and authorized features and store them into session attributes.
	 * @param principal
	 * 		The logged in user object.
	 */
	public void setAuthenticationToken(User principal){

		if(principal != null){
			
			HttpSession session = SessionUtil.getSession();
			
			session.setAttribute(com.ibcs.AppConstants.SESSION_USER, principal);
			
			authorizedGroups = principal.getAuthorizedGroups();
			
			grantedAuthorities = new ArrayList<Feature>();
			
			if(authorizedGroups != null){
				for(AuthorizedGroups authorizedGroup : authorizedGroups){
					credentials = authorizedGroup.getAuthorities();
					for(Authority authority : credentials){
						authorities = authority.getFeatures();
						grantedAuthorities.addAll(authorities);
					}
				}
			}
			
			session.setAttribute(AppConstants.SESSION_USER_FEATURES, grantedAuthorities);
		}
		
		// get the list of authorized groups, authorities and aspects and put them in session.
	}
	

}
