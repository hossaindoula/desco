package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.AnnualProcurementPlan;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("annualProcurementPlanDao")
@Scope("singleton")
public class AnnualProcurementPlanDaoImpl extends InclusiveDaoImpl<AnnualProcurementPlan,Integer> implements AnnualProcurementPlanDao{
    @Autowired
    public AnnualProcurementPlanDaoImpl (@Qualifier ("sessionFactory") SessionFactory sessionFactory) {
        super (sessionFactory, AnnualProcurementPlan.class);
    }
}
