package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.ProcurementAmendmentHistory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("procurementAmendmentHistoryDao")
@Scope("singleton")
public class ProcurementAmendmentHistoryDaoImpl extends InclusiveDaoImpl<ProcurementAmendmentHistory,Integer> implements ProcurementAmendmentHistoryDao{
    @Autowired
    public ProcurementAmendmentHistoryDaoImpl(@Qualifier ("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, ProcurementAmendmentHistory.class);
    }
}
