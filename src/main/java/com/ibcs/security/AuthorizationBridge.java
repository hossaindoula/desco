package com.ibcs.security;

import com.ibcs.security.model.User;

/**
 * This class acts as a bridge between AuthenticationController and AuthorizationToken  
 *
 */
public class AuthorizationBridge {
	public static AuthorizationToken setAuthorization(User user) {
		// Instatiates AuthorizationToken with the username and password
        // which in in turn set the 
        return AuthorizationToken.getToken(user);
    }
}
