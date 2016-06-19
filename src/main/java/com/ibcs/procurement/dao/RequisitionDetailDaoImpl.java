package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.RequisitionDetail;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("requisitionDetailDao")
@Scope("singleton")
public class RequisitionDetailDaoImpl extends InclusiveDaoImpl<RequisitionDetail,Integer> implements RequisitionDetailDao{
    @Autowired
    public RequisitionDetailDaoImpl(@Qualifier ("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,RequisitionDetail.class);
    }
}
