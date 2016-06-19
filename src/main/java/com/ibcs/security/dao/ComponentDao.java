package com.ibcs.security.dao;

import com.ibcs.base.dao.InclusiveDao;
import com.ibcs.security.model.Component;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/8/2016.
 */
public interface ComponentDao extends InclusiveDao<Component, Integer> {

    Component findComponentByName(String componentName);

}
