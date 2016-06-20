package com.ibcs.procurement.service;

import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.procurement.dao.RequirementNoteDao;
import com.ibcs.procurement.dto.RequirementNoteMasterDetailBean;
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


    public boolean save(RequirementNoteMasterDetailBean o) {
        return false;
    }

    public boolean delete(RequirementNoteMasterDetailBean o) {
        return false;
    }

    public boolean update(RequirementNoteMasterDetailBean o) {
        return false;
    }

    public List<RequirementNoteMasterDetailBean> findAll() {
        return null;
    }

    public RequirementNoteMasterDetailBean get(Integer id) {
        return null;
    }

    public ModelForm getModel() {
        return null;
    }
}
