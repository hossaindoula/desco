package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.Vendor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("vendorDao")
@Scope("singleton")
public class VendorDaoImpl extends InclusiveDaoImpl<Vendor,Integer> implements VendorDao{
    @Autowired
    public VendorDaoImpl(@Qualifier ("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,Vendor.class);
    }
}