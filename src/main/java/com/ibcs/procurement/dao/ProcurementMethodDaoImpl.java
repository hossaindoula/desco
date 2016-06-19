package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.ProcurementMethod;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("procurementMethodDao")
@Scope("singleton")
public class ProcurementMethodDaoImpl extends InclusiveDaoImpl<ProcurementMethod,Integer> implements ProcurementMethodDao {
    @Autowired
    public ProcurementMethodDaoImpl (@Qualifier ("sessionFactory")SessionFactory sessionFactory) {
        super(sessionFactory,ProcurementMethod.class);
    }
}
