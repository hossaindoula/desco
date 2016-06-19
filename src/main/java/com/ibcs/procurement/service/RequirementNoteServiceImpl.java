package com.ibcs.procurement.service;

import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.procurement.dao.RequirementNoteDao;
import com.ibcs.procurement.model.RequirementNote;
import com.ibcs.security.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 6/12/2016.
 */

@Service("requirementNoteService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RequirementNoteServiceImpl implements RequirementNoteService {

    @Autowired
    private RequirementNoteDao requirementNoteDao;


    public boolean save(RequirementNote o) {
        return requirementNoteDao.create(o);
    }

    public boolean delete(RequirementNote o) {
        return requirementNoteDao.delete(o);
    }

    public boolean update(RequirementNote o) {
        return requirementNoteDao.update(o);
    }

    public List<RequirementNote> findAll() {
        return requirementNoteDao.findAll();
    }

    public RequirementNote get(Integer id) {
        return requirementNoteDao.get(id);
    }

    public ModelForm getModel() {
        return null;
    }
}
