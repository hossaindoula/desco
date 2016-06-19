package com.ibcs.security;

import com.ibcs.base.component.BaseController;
import com.ibcs.base.view.form.BaseValidator;
import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.dto.UserBean;
import com.ibcs.security.service.SecurityService;
import com.ibcs.security.service.UserDetailsService;
import com.ibcs.security.view.form.UserFormValidator;
import com.ibcs.security.view.manager.UserViewManager;
import com.ibcs.util.JSONView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by hossain.doula on 5/31/2016.
 */

@Controller
@RequestMapping("/user")
//@SessionAttributes("userBean")
public class UserController extends BaseController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserFormValidator userFormValidator;

    @Autowired
    public UserController(@Qualifier("userDetailsService")
                              UserDetailsService userDetailsService){
        super();
        viewManager = UserViewManager.getInstance();
        title = "User";
        entityName = "user";
        assignmentName = "User Authority Assignment";
        controllerService = userDetailsService;
        form = new UserBean();
    }

    public UserController(){}

    @PostConstruct
    protected BaseValidator initValidator(){
        return userFormValidator;
    }

    @ModelAttribute("modelForm")
    public ModelForm initUserForm(){
        return form;
    }


    protected Map<String,Object> createPopulateAssignmentModel(int id){
        return securityService.loadMappedUnmappedAuthorities(id);
    }


    protected Map<String,Object> createPopulateGroupAssignmentModel(int id){
        return securityService.loadMappedUnmappedAuthorities(id);
    }


    @RequestMapping(method = RequestMethod.GET, value= "/groupAssignment")
    public ModelAndView groupAssignment(@RequestParam("id") int id){
        return new ModelAndView(new JSONView(), UserViewManager.getInstance().
                initGroupAssignmentList(createPopulateGroupAssignmentModel(id)));
    }
}
