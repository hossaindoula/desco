package com.ibcs.finance.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.finance.model.CostAllocation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Repository("costAllocationDao")
@Scope("singleton")
public class CostAllocationDaoImpl
        extends InclusiveDaoImpl<CostAllocation, Integer>
        implements CostAllocationDao {

    @Autowired
    public CostAllocationDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, CostAllocation.class);
    }

}
