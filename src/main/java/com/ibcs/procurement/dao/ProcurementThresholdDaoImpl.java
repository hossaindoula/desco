package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.ProcurementThreshold;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("procurementThresholdDao")
@Scope("singleton")
public class ProcurementThresholdDaoImpl extends InclusiveDaoImpl<ProcurementThreshold,Integer>
        implements ProcurementThresholdDao {

    @Autowired
    public ProcurementThresholdDaoImpl(@Qualifier("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,ProcurementThreshold.class);
    }
}
