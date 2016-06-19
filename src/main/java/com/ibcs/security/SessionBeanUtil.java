package com.ibcs.security;

import com.ibcs.AppConstants;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.AuthorizedGroups;
import com.ibcs.security.model.Feature;
import com.ibcs.security.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by hossain.doula on 5/19/2016.
 */

@Configuration
public class SessionBeanUtil {

    @Bean()
    @Scope(value="session")
    public HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }

    /**
     * Retrieves the logged-in user object
     * @return User
     * 		The logged-in user object
     */
    @Bean()
    @Scope(value="session")
    public User getSessionUser(){
        User user = (User) getSession().getAttribute(AppConstants.SESSION_USER);
        if(user instanceof User){
            return user;
        }
        return null;
    }

    /**
     * Retrieves the logged-in user
     * @return Long
     * 		The logged-in user id
     */
    @Bean()
    @Scope(value="session")
    public Long getSessionUserId(){

        Long userId = (Long) getSession().getAttribute(AppConstants.SESSION_USER_ID);
        if(userId instanceof Long){
            return userId;
        }
        return null;
    }

    /**
     * Retrieves the logged-in user groups
     * @return List<AuthorizedGroups>
     * 		The list of authorized user groups for the session user.
     */
    @Bean()
    @Scope(value="session")
    public List<AuthorizedGroups> getSessionUserAuthorizedGroups(){

        List<AuthorizedGroups>  authorizedGroups = (List<AuthorizedGroups>) getSession().getAttribute(AppConstants.SESSION_USER_AUTHORIZED_GROUPS);
        if(authorizedGroups != null){
            return authorizedGroups;
        }
        return null;
    }

    /**
     * Retrieves the logged-in user authorities
     * @return List<Authority>
     * 		The list of authorities for the session user.
     */
    @Bean()
    @Scope(value="session")
    public List<Authority> getSessionUserAuthorities(){

        List<Authority>  authorities = (List<Authority>) getSession().getAttribute(AppConstants.SESSION_USER_AUTHORITIES);
        if(authorities != null){
            return authorities;
        }
        return null;
    }

    /**
     * Retrieves the logged-in user aspects
     * @return List<Feature>
     * 		The list of authorities for the session user.
     */
    @Bean()
    @Scope(value="session")
    public List<Feature> getSessionUserFeatures(){

        List<Feature>  features = (List<Feature>) getSession().getAttribute(AppConstants.SESSION_USER_FEATURES);
        if(features != null){
            return features;
        }
        return null;
    }
}
