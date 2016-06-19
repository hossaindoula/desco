package com.ibcs.security.dao;

import java.util.List;

import com.ibcs.security.model.Feature;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.AuthorizedGroups;
import com.ibcs.security.model.Component;

public interface SecurityDao {

    boolean save(Feature feature);

    boolean update(Feature feature);

    Feature findFeatureByOperation(String operation);

    Feature getFeature(int featureId);

    List<Feature> findAllFeatures();

    boolean delete(Feature feature);

    boolean save(Authority authority);

    boolean update(Authority authority);

    Authority getAuthority(int authorityId);

    List<Authority> findAllAuthorities();

    Authority findByAuthorityName(String authorityName);

    boolean delete(Authority authority);

    boolean save(Component component);

    boolean update(Component component);

    Component getComponent(int componentId);

    List<Component> findAllComponents();

    Component getComponentById(Long componentId);

    Component getComponentByName(String componentName);

    boolean delete(Component component);

    boolean save(AuthorizedGroups authorizedGroups);

    boolean update(AuthorizedGroups authorizedGroups);

    AuthorizedGroups getAuthorizedGroups(int authorizedGroupId);

    List<AuthorizedGroups> findAllAuthorizedGroups();

    List<Authority> findAllAuthorities(List<AuthorizedGroups> authorizedGroups);

    List<Feature> findAllFeatures(List<Authority> authorities);

}
