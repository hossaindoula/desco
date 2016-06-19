package com.ibcs.general.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.general.model.ModuleGroup;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/9/2016.
 */
@Repository
public class ModuleGroupDaoImpl extends InclusiveDaoImpl<ModuleGroup,Integer> implements ModuleGroupDao{
    @Autowired
    public ModuleGroupDaoImpl (@Qualifier ("sessionFactory")SessionFactory sessionFactory) {
        super(sessionFactory, ModuleGroup.class);
    }
}
