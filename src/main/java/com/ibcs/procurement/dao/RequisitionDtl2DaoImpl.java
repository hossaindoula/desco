package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.RequisitionDtl2;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository
public class RequisitionDtl2DaoImpl extends InclusiveDaoImpl<RequisitionDtl2,Integer> implements RequisitionDtl2Dao{
    @Autowired
    public RequisitionDtl2DaoImpl(@Qualifier ("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,RequisitionDtl2.class);
    }
}
