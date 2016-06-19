package com.ibcs.security.dao;

import com.ibcs.base.dao.InclusiveDao;
import com.ibcs.security.model.Feature;

import java.util.Iterator;
import java.util.List;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/8/2016.
 */
public interface FeatureDao extends InclusiveDao<Feature, Integer> {

    List<Feature> findAllFeaturesByOperation(String name);

    List<Feature> findAllFeaturesByComponent(String name);

}
