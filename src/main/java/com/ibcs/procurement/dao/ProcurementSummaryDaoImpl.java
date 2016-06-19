package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.ProcurementSummary;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("procurementSummaryDao")
@Scope("singleton")
public class ProcurementSummaryDaoImpl extends InclusiveDaoImpl<ProcurementSummary,Integer> implements ProcurementSummaryDao{
    @Autowired
    public ProcurementSummaryDaoImpl (@Qualifier ("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,ProcurementSummary.class);
    }
}
