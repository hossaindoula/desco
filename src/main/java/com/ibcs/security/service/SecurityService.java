package com.ibcs.security.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ibcs.security.AuthorizationToken;
import com.ibcs.security.model.*;

public interface SecurityService {
	
	boolean save(Feature feature);
	
	List<Feature> findAllFeatures();
    
	List<Feature> findFeatureByOperation(String operation);
    
	boolean delete(Feature feature);
  
	
	boolean save(Authority authority);
	
	List<Authority> findAllAuthorities();
	
	Authority findByAuthorityName(String authorityName);
	
	boolean delete(Authority authority);
	
	boolean save(Component component);
	
	List<Component> findAllComponents();
    
    Component getComponentById(int componentId);
    
    Component getComponentByName(String componentName);
	
	boolean delete(Component component);
	
	List<Authority> findAllAuthorities(List<AuthorizedGroups> authorizedGroups);
	
	List<Feature> findAllFeatures(List<Authority> authorities);

    boolean save(AuthorizedGroups authorizedGroups);

    List<AuthorizedGroups> findAllAuthorizedGroup();

	Map<String,Object> loadMappedUnmappedAuthorities(int id);

	Map<String, Object> loadMappedUnmappedAuthorizedGroups(int id);

}
