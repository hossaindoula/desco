package com.ibcs.procurement.dao;

import com.ibcs.base.dao.InclusiveDaoImpl;
import com.ibcs.procurement.model.RequirementNote;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 6/10/2016.
 */
@Repository("requirementNoteDao")
@Scope("singleton")
public class RequirementNoteDaoImpl extends InclusiveDaoImpl<RequirementNote,Integer> implements RequirementNoteDao{
    @Autowired
    public RequirementNoteDaoImpl (@Qualifier ("sessionFactory")SessionFactory sessionFactory){
        super(sessionFactory,RequirementNote.class);
    }
}
