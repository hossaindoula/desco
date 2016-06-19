package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.PurchaseRequisition;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("purchaseRequisitionDao")
@Scope("singleton")
public class PurchaseRequisitionDaoImpl extends InclusiveDaoImpl<PurchaseRequisition,Integer> implements PurchaseRequisitionDao{
    @Autowired
    public PurchaseRequisitionDaoImpl (@Qualifier ("sessionFactory")SessionFactory sessionFactory) {
        super(sessionFactory,PurchaseRequisition.class);
    }
}
