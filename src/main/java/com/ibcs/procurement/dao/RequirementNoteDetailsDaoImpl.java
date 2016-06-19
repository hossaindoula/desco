package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.RequirementNoteDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("requirementNoteDetailsDao")
@Scope("singleton")
public class RequirementNoteDetailsDaoImpl extends InclusiveDaoImpl<RequirementNoteDetails,Integer>
        implements RequirementNoteDetailsDao {
    @Autowired
    public RequirementNoteDetailsDaoImpl(@Qualifier ("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,RequirementNoteDetails.class);
    }
}
