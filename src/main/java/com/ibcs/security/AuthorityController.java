package com.ibcs.security;

import com.ibcs.base.component.BaseController;
import com.ibcs.base.view.form.BaseValidator;
import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.dto.AuthorityBean;
import com.ibcs.security.service.AuthorityService;
import com.ibcs.security.view.form.AuthorityValidator;
import com.ibcs.security.view.manager.AuthorityViewManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/6/2016.
 */
@Controller
@RequestMapping("/authority")
public class AuthorityController extends BaseController {

    @Autowired
    private AuthorityValidator authorityValidator;

    public AuthorityController(){}

    @Autowired
    public AuthorityController(@Qualifier("authorityService") AuthorityService authorityService){
        super();
        title = "Authority";
        viewManager = new AuthorityViewManager();
        controllerService = authorityService;
        entityName = "authority";
        form = new AuthorityBean();
    }

    @PostConstruct
    protected BaseValidator initValidator(){
        return authorityValidator;
    }

    @ModelAttribute("modelForm")
    public ModelForm initAuthorityForm(){
        return form;
    }

}
