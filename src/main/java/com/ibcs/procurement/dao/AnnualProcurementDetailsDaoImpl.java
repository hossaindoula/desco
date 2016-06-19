package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.AnnualProcurementDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository
@Scope("singleton")
public class AnnualProcurementDetailsDaoImpl extends InclusiveDaoImpl<AnnualProcurementDetails,Integer> implements AnnualProcurementDetailsDao {
    @Autowired
    public AnnualProcurementDetailsDaoImpl (@Qualifier ("sessionFactory") SessionFactory sessionFactory) {
        super (sessionFactory,AnnualProcurementDetails.class);
    }
}
