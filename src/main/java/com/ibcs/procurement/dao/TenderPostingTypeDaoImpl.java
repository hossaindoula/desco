package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.TenderPostingType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("tenderPostingTypeDao")
@Scope("singleton")
public class TenderPostingTypeDaoImpl extends InclusiveDaoImpl<TenderPostingType,Integer> implements TenderPostingTypeDao{
    @Autowired
    public TenderPostingTypeDaoImpl(@Qualifier ("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,TenderPostingType.class);
    }
}
