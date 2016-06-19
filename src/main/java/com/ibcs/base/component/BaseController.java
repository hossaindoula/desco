package com.ibcs.base.component;

import com.ibcs.base.view.BaseViewManager;
import com.ibcs.base.manager.AuthViewManager;
import com.ibcs.base.service.DomainPersistentService;
import com.ibcs.base.view.form.BaseValidator;
import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.SessionBeanUtil;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.AuthorizedGroups;
import com.ibcs.security.model.Feature;
import com.ibcs.security.model.User;
import com.ibcs.util.JSONView;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.env.Environment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This controller is responsible for centralized common view inheritance,
 * to be accessed by other controller classes globally, which in turns gives automation
 * in the view layer, which will actually reduces the loads for creating any pages from scratch.
 * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Created by hossain.doula on 5/15/2016.
 */
@Controller
@RequestMapping("/{entityName}")
public abstract class BaseController extends AppComponent {

    @Autowired
    protected AuthViewManager authViewManager;

    protected List<Feature> FEATURES;

    protected List<Authority> AUTHORITIES;

    protected List<AuthorizedGroups> USER_GROUPS;

    protected User USER;

    protected long USER_ID;

    @Autowired
    protected SessionBeanUtil sessionBeanUtil;

    protected String listPage;

    protected Map<String,Object> listModel;

    protected Map<String,Object> commonPageModel;

    protected Map<String,Object> combinedPageModel;

    protected BaseViewManager viewManager;

    protected DomainPersistentService controllerService;

    protected String defaultPage;

    protected String entityName = "";

    protected String entityForm;

    protected String entityShow;

    protected String title;

    protected Object controllerList;

    protected Map<String,Object> assignments;

    protected String assignmentName;

    protected String assignmentPage;

    protected BaseValidator formValidator;

    protected ModelForm form;

    protected String createPage;
	
    protected String editPage;

    @Resource
    protected Environment environment;

    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setAutoGrowCollectionLimit(5000);
        binder.setValidator(initValidator());
    }


    @InitBinder
    public void initStringBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @InitBinder
    public void initListBinder(WebDataBinder binder) {
        binder.setAutoGrowCollectionLimit(1000);
    }*/

    @PostConstruct
    protected BaseValidator initValidator(){
        return null;
    }

    public Map<String,Object> commonModel(){
        commonPageModel = new HashMap<String, Object>();
        commonPageModel.put("PageTitle", title);
        commonPageModel.put("Tile", title);
        commonPageModel.put("companyName", COMPANY_NAME);
        commonPageModel.put("applicationName", APPLICATION_NAME);
        commonPageModel.put("copyRightText", COMPANY_COPYRIGHT_TEXT);
        return commonPageModel;
    }

    public BaseController(){
        /*ApplicationContext beanFactory =
                WebApplicationContextUtils
                        .getRequiredWebApplicationContext(servletContext);
        SessionBeanUtil sessionBeanUtil = beanFactory
                .getBean("sessionBeanUtil", SessionBeanUtil.class);*/
        USER = null;//SessionUtil.getSessionUser();
        FEATURES = null;//SessionUtil.getSessionUserFeatures();
        USER_ID = 1l;//SessionUtil.getSessionUserId();
        AUTHORITIES = null;//SessionUtil.getSessionUserAuthorities();
        USER_GROUPS = null;//SessionUtil.getSessionUserAuthorizedGroups();
        listPage = "/list";
        combinedPageModel = new HashMap<String, Object>();
        commonPageModel = new HashMap<String, Object>();
    }


    /**
     * To toggle between dashboard, home and list
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object home() {
        String returnPage = "";
        combinedPageModel.putAll(commonModel());

        if(defaultPage != null){
            returnPage = entityName + "/" + defaultPage;
            return new ModelAndView(returnPage, combinedPageModel);
        } else {
            return "redirect:/" + entityName + "/list";
        }
    }


    /**
     * List all user group
     */
    @RequestMapping(method= RequestMethod.GET, value="/list")
    public ModelAndView list(){
        if(viewManager.listViewPath != null){ //my custom page to load
            listPage = viewManager.listViewPath;
        } else { //common page to load
            listPage =  viewManager.viewPath +  "/list";
        }

        combinedPageModel = new HashMap<String, Object>();

        listModel = new HashMap<String, Object>();
        listModel.put("mappingData", viewManager);
        listModel.put("toolPanel", viewManager.toolPanel);
        listModel.put("PageTitle", entityName + " "  + "List");


        combinedPageModel.putAll(listModel);
        combinedPageModel.putAll(commonModel());
        combinedPageModel.putAll(listPopulateModel());

        return new ModelAndView(listPage, combinedPageModel);
    }

    @RequestMapping(method = RequestMethod.GET, value= "/json")
    public ModelAndView json(){
        return new ModelAndView(new JSONView(), viewManager.initItemList(listPopulateJsonModel()));
    }

    @RequestMapping(method = RequestMethod.GET, value= "/assignment")
    public ModelAndView assignment(@RequestParam("id") int id){
        if(viewManager.assignmentViewPath != null){ //my custom page to load
            assignmentPage = viewManager.assignmentViewPath;
        } else { //common page to load
            assignmentPage =  viewManager.viewPath +  "/assignment";
        }

        assignments = new HashMap<String, Object>();
        assignments.put("AssignmentType", assignmentName);
        combinedPageModel = new HashMap<String, Object>();

        combinedPageModel.putAll(assignments);
        combinedPageModel.putAll(commonModel());
        combinedPageModel.putAll(viewManager.initAssignmentList(createPopulateAssignmentModel(id)));

        return new ModelAndView(assignmentPage, combinedPageModel);
    }

    /*@RequestMapping(method = RequestMethod.GET, value= "/create")
    public ModelAndView create(){
        Map<String,Object> createPageMap = new HashMap<String,Object>();
        createPageMap.put("PageTitle", COMPANY_NAME + " User " );
        createPageMap.put("Tile", "login");
        createPageMap.put("companyName", COMPANY_NAME);
        createPageMap.put("applicationName", APPLICATION_NAME);
        createPageMap.put("copyRightText", COMPANY_COPYRIGHT_TEXT);
        createPageMap.put("forms", viewManager.initFormList());

        return new ModelAndView(viewManager.viewPath + "/master_create", createPageMap);
    }*/

    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for list5
     * @return modelInstance custom model from customized controllers
     */
    protected Map<String,Object> listPopulateModel(){
        return listModel;
    }

    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for list
     * @return modelInstance custom model from customized controllers
     */
    protected Object listPopulateJsonModel(){
        return controllerService.findAll();
    }

    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for list
     * @return modelInstance custom model from customized controllers
     */
    protected Map<String,Object> createPopulateAssignmentModel(int id){
        return assignments;
    }



    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for
     * @param modelInstance custom model from customized controllers
     * @return modelInstance custom model from customized controllers
     */
    protected Model createBeforeRender(Model modelInstance) {
        combinedPageModel = new HashMap<String, Object>();
        combinedPageModel.putAll(commonModel());
        for (Map.Entry<String, Object> entry : combinedPageModel.entrySet()) {
            modelInstance.addAttribute(entry.getKey(), entry.getValue());
        }
        modelInstance.addAttribute("environment", environment);
        modelInstance.addAttribute("forms", viewManager.initFormList());
        return modelInstance;
    }

    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for
     * @param modelInstance custom model from customized controllers
     */
    protected Model populateDefaultModel(Model modelInstance) {
        modelInstance.addAttribute("modelForm", form);
        return modelInstance;
    }

    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for
     * @param modelInstance custom model from customized controllers
     */
    protected Model populateShowModel(Model modelInstance) {
        return modelInstance;
    }

    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for
     * @param modelInstance custom model from customized controllers
     * @return modelInstance custom model from customized controllers
     */
    protected Model beforeSave(Model modelInstance) {
        return modelInstance;
    }

    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for
     * @param modelInstance custom model from customized controllers
     * @return modelInstance custom model from customized controllers
     */
    protected Model afterSave(Model modelInstance) {
        return modelInstance;
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {
        ModelAndView model = new ModelAndView();
        model.setViewName(entityName + "/show");
        model.addObject("msg", entityName + " not found");

        return model;
    }

    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for
     * @param id model's identifier from customized controllers
     * @param redirectAttributes custom model from customized controllers
     * @return modelInstance custom model from customized controllers
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {
        controllerService.delete(id);
        redirectAttributes.addFlashAttribute("css", SUCCESS_MESSAGE);
        redirectAttributes.addFlashAttribute("msg", entityName + " is deleted!");

        return "redirect:/" + entityName;
    }


    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for
     * @param id model's identifier from customized controllers
     * @param model custom model from customized controllers
     * @return modelInstance custom model from customized controllers
     */
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") int id, Model model){
        populateShowModel(model);
        return entityName + "/" + entityShow;
    }

    /**
     * Render default view if data not found
    * @param messageStr -  Message string if you have
    * @return void
    */
    public String renderNotFound(String messageStr, final RedirectAttributes redirectAttributes) {
        if (messageStr != null) {
            messageStr = "default.not.found.message";
        }
        redirectAttributes.addFlashAttribute("message", messageStr);
        return "redirect:/" + listPage;
    }

    /**
     * Render default view if data not found
    * @param model -  Message string if you have
    * @return createForm
    */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute(createBeforeRender(model));
        model.addAttribute("modelForm", form);

        if(viewManager.createViewPath != null){ //my custom page to load
            createPage = viewManager.createViewPath;
        } else { //common page to load
            createPage =  viewManager.viewPath +  "/master_create";
        }

        return createPage;
    }

    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for
     * @param id model's identifier from customized contro5llers
     * @param model custom model from customized controllers
     * @return modelInstance custom model from customized controllers
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("modelForm", form);

        populateDefaultModel(model);
        if(viewManager.createViewPath != null){ //my custom page to load
            editPage = viewManager.createViewPath;
        } else { //common page to load
            editPage =  viewManager.viewPath +  "/master_create";
        }

        return editPage;
    }

    /**
     * This is a callback method to manipulate models for custom usage
     * and generic model generation for
     * @param model custom model from customized controllers
     * @return modelInstance custom model from customized controllers
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("modelForm") ModelForm modelForm,
                       Model model, final RedirectAttributes redirectAttributes){
        try {
            form = modelForm;
            DataBinder binder = new DataBinder(form);
            binder.setValidator(initValidator());

            HttpServletRequest request =
                    ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            ServletRequestParameterPropertyValues propertyValues =
                    new ServletRequestParameterPropertyValues(request);
            //MutablePropertyValues propertyValues = new MutablePropertyValues();
            // bind to the target object
            binder.bind(propertyValues);

            // validate the target object
            binder.validate();

            // get BindingResult that includes any validation errors
            BindingResult results = binder.getBindingResult();

            if(results.hasErrors()){
                populateDefaultModel(model);

                return "redirect:/" + entityName + "/create";
            } else {
                redirectAttributes.addFlashAttribute("css", SUCCESS_MESSAGE);

                if(form.isNew()){
                    redirectAttributes.addFlashAttribute("message", entityName + "save.success");
                } else {
                    redirectAttributes.addFlashAttribute("message", entityName + "update.success");
                }

                beforeSave(model);
                controllerService.save(form);
                afterSave(model);
            }

            return "redirect:/" + entityName + "/create";
        } catch (Exception ex){
            redirectAttributes.addFlashAttribute("message", entityName + "save.server.error");
            return "redirect:/" + entityName + "/create";
        }
    }

    public ModelForm getForm() {
        return form;
    }
}
