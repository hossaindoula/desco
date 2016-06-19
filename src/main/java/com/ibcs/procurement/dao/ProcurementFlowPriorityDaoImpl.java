package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.ProcurementFlowPriority;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("procurementFlowPriorityDao")
@Scope("singleton")
public class ProcurementFlowPriorityDaoImpl extends InclusiveDaoImpl<ProcurementFlowPriority,Integer> implements ProcurementFlowPriorityDao{
    @Autowired
    public ProcurementFlowPriorityDaoImpl(@Qualifier ("sessionFactory")SessionFactory sessionFactory)  {
        super(sessionFactory,ProcurementFlowPriority.class);
    }
}
