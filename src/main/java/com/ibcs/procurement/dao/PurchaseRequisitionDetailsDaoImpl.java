package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDao;
import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.PurchaseRequisitionDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("purchaseRequisitionDetailsDao")
@Scope("singleton")
public class PurchaseRequisitionDetailsDaoImpl extends InclusiveDaoImpl<PurchaseRequisitionDetails,Integer> implements PurchaseRequisitionDetailsDao{
    @Autowired
    public PurchaseRequisitionDetailsDaoImpl (@Qualifier ("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,PurchaseRequisitionDetails.class);
    }
}
