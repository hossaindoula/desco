package com.ibcs.finance.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.finance.model.CostCenter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */
@Repository("costCenterDao")
@Scope("singleton")
public class CostCenterDaoImpl extends InclusiveDaoImpl<CostCenter, Integer>
        implements CostCenterDao {

    @Autowired
    public CostCenterDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, CostCenter.class);
    }
}
