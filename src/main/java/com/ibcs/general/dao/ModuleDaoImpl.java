package com.ibcs.general.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.general.model.Module;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/9/2016.
 */

@Repository
@Scope("singleton")
public class ModuleDaoImpl extends InclusiveDaoImpl<Module,Integer> implements ModuleDao {

    @Autowired
    public ModuleDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, Module.class);
    }
}
