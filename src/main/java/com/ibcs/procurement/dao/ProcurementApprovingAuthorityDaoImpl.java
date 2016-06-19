package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.ProcurementApprovingAuthority;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("procurementApprovingAuthorityDao")
@Scope("singleton")
public class ProcurementApprovingAuthorityDaoImpl extends InclusiveDaoImpl<ProcurementApprovingAuthority,Integer> implements ProcurementApprovingAuthorityDao{
    @Autowired
    public ProcurementApprovingAuthorityDaoImpl (@Qualifier ("sessionFactory") SessionFactory sessionFactory){
        super(sessionFactory,ProcurementApprovingAuthority.class);
    }
}
