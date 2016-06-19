package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.ProcurementItemCategory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("procurementItemCategoryDao")
@Scope("singleton")
public class ProcurementItemCategoryDaoImpl extends InclusiveDaoImpl<ProcurementItemCategory,Integer> implements ProcurementItemCategoryDao {
    @Autowired
    public ProcurementItemCategoryDaoImpl (@Qualifier ("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,ProcurementItemCategory.class);
    }
}
