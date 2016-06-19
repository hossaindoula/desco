package com.ibcs.finance.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.finance.model.CostAllocationDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Repository("costAllocationDetailsDao")
@Scope("singleton")
public class CostAllocationDetailsDaoImpl
        extends InclusiveDaoImpl<CostAllocationDetails, Integer>
        implements CostAllocationDetailsDao {

    @Autowired
    public CostAllocationDetailsDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, CostAllocationDetails.class);
    }

}
