package com.ibcs.security.service;

import java.util.*;

import com.ibcs.security.dao.*;
import com.ibcs.security.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("securityService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private SecurityDao securityDao;

	@Autowired
	private AuthorityDao authorityDao;

	@Autowired
	private AuthorizedGroupsDao authorizedGroupsDao;

	@Autowired
	private FeatureDao featureDao;

	@Autowired
	private ComponentDao componentDao;


	// Feature
	public boolean save(Feature feature){
		return featureDao.create(feature);
	}

	public List<Feature> findAllFeatures(){
		return featureDao.findAll();
	}

	public List<Feature> findFeatureByOperation(String operation){
		return featureDao.findAllFeaturesByOperation(operation);
	}

	public boolean delete(Feature feature){
		return featureDao.delete(feature);
	}

	public boolean save(Authority authority){
		return authorityDao.create(authority);
	}
	// Feature



	//Authority
	public List<Authority> findAllAuthorities(){
		return authorityDao.findAll();
	}

	public Authority findByAuthorityName(String authorityName){
		return authorityDao.findByAuthorityName(authorityName);
	}

	public boolean delete(Authority authority){
		return authorityDao.delete(authority);
	}
	//Authority

	//Component
	public boolean save(Component component){
		return componentDao.create(component);
	}

	public List<Component> findAllComponents(){
		return componentDao.findAll();
	}

	public Component getComponentById(int componentId){
		return componentDao.get(componentId);
	}

	public Component getComponentByName(String componentName){
		return componentDao.findComponentByName(componentName);
	}

	public boolean delete(Component component){
		return componentDao.delete(component);
	}

	public List<Authority> findAllAuthorities(List<AuthorizedGroups> authorizedGroups) {
		return null;
	}

	public List<Feature> findAllFeatures(List<Authority> authorities) {
		return null;
	}
	//Component

	//authorized groups
	public boolean save(AuthorizedGroups authorizedGroups){
		return authorizedGroupsDao.create(authorizedGroups);
	}

	public List<AuthorizedGroups> findAllAuthorizedGroup(){
		return authorizedGroupsDao.findAll();
	}
	//authorized groups


	public Map<String, Object> loadMappedUnmappedAuthorities(int id) {
		User user = userDao.get(id);

		Map<String,Object> assignmentModel;

		List<Authority> mappedAuthorities = new ArrayList<Authority>();
		List<Authority> unmappedAuthorities = new ArrayList<Authority>();

		if(user != null){
			mappedAuthorities = user.getAuthorities();
			unmappedAuthorities = securityDao.findAllAuthorities();

			unmappedAuthorities.removeAll(mappedAuthorities);
		}

		assignmentModel = new HashMap<String, Object>();

		assignmentModel.put("UnmapperName", "Available authorities");
		assignmentModel.put("MapperName", "Assigned authorities");
		assignmentModel.put("unmappers", unmappedAuthorities);
		assignmentModel.put("mappers", mappedAuthorities);

		return assignmentModel;
	}

	public Map<String, Object> loadMappedUnmappedAuthorizedGroups(int id) {
		User user = userDao.get(id);

		List<AuthorizedGroups> mappedAuthorizedGroups = user.getAuthorizedGroups();
		List<AuthorizedGroups> unmappedAuthorities = securityDao.findAllAuthorizedGroups();

		unmappedAuthorities.removeAll(mappedAuthorizedGroups);
		Map<String,Object> assignmentModel = new HashMap<String, Object>();

		assignmentModel.put("UnmapperName", "Available User Groups");
		assignmentModel.put("MapperName", "Assigned User Groups");
		assignmentModel.put("unmappers", unmappedAuthorities);
		assignmentModel.put("mappers", mappedAuthorizedGroups);

		return assignmentModel;
	}

	/*@Autowired
	private SecurityDao securityDao;
	
	public List<Authority> findAllAuthorities(
			List<AuthorizedGroups> authorizedGroups) {
		return securityDao.findAllAuthorities(authorizedGroups);
	}

	public List<Feature> findAllFeatures(List<Authority> authorities) {
		return securityDao.findAllFeatures(authorities);
	}

    public Component getComponentById(Long componentId){
        return securityDao.getComponentById(componentId);
    }
    public Component getComponentByName(String componentName){
       return securityDao.getComponentByName(componentName);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(AuthorizedGroups authorizedGroups) {
        return securityDao.save(authorizedGroups);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean save(Feature feature) {
		return securityDao.save(feature);
	}
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Feature findFeatureByOperation(String operation){
      return securityDao.findFeatureByOperation(operation);
    }

	public List<Feature> findAllFeatures() {
		return securityDao.findAllFeatures();
	}

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean delete(Feature feature) {
		return securityDao.delete(feature);
	}

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean save(Authority authority) {
		return securityDao.save(authority);
	}

	public List<Authority> findAllAuthorities() {
		return securityDao.findAllAuthorities();
	}

	public Authority findByAuthorityName(String authorityName) {
		return securityDao.findByAuthorityName(authorityName);
	}

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean delete(Authority authority) {
		return securityDao.delete(authority);
	}

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean save(Component component) {
		return securityDao.save(component);
	}

	public List<Component> findAllComponents() {
		return securityDao.findAllComponents();
	}

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean delete(Component component) {
		return securityDao.delete(component);
	}
    public List<AuthorizedGroups> findAllAuthorizedGroup(){
        return null;
    }*/

}
