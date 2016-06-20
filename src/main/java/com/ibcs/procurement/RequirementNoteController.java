package com.ibcs.procurement;

import com.ibcs.base.component.BaseController;
import com.ibcs.base.view.form.BaseValidator;
import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.procurement.dto.RequirementNoteMasterDetailBean;
import com.ibcs.procurement.service.RequirementNoteService;
import com.ibcs.procurement.view.manager.RequirementNoteViewManager;
import com.ibcs.procurement.view.validator.RequirementNoteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

/**
 * Created by Dell on 6/12/2016.
 */

@Controller
@RequestMapping("/requirementNote")
public class RequirementNoteController extends BaseController {

    @Autowired
    private RequirementNoteValidator requirementNoteValidator;

    @Autowired
    public RequirementNoteController(@Qualifier("requirementNoteService") RequirementNoteService
                                                 requirementNoteService){
        super();
        viewManager = RequirementNoteViewManager.getInstance();
        title = "Requirement note";
        entityName = "requirementNote";
        controllerService = requirementNoteService;
        formValidator = requirementNoteValidator;
        form = new RequirementNoteMasterDetailBean();
    }

    @PostConstruct
    protected BaseValidator initValidator(){
        return requirementNoteValidator;
    }

    @ModelAttribute("modelForm")
    public ModelForm initRequirementNoteForm(){
        return form;
    }
}
