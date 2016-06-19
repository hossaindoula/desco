package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.RequestForQuotation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Repository("rfqDao")
@Scope("singleton")
public class RequestForQuotationDaoImpl extends InclusiveDaoImpl<RequestForQuotation, Integer>
                                implements RfqDao {

    @Autowired
    public RequestForQuotationDaoImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory, RequestForQuotation.class);
    }
}
