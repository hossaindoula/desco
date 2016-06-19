package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.RequisitionMaster;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("requisitionMasterDao")
@Scope("singleton")
public class RequisitionMasterDaoImpl extends InclusiveDaoImpl<RequisitionMaster,Integer> implements RequisitionMasterDao{
    @Autowired
    public RequisitionMasterDaoImpl(@Qualifier ("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,RequisitionMaster.class);
    }
}
