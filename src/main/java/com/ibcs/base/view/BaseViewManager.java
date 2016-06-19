package com.ibcs.base.view;

import com.ibcs.configuration.AppConfiguration;
import com.ibcs.security.service.UserDetailsServiceImpl;
import com.ibcs.util.ApplicationContextHolder;
import com.ibcs.util.SpringBeanManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hossaindoula<hossaindoula@ibcs-primax.com> on 5/27/2016.
 */

public abstract class BaseViewManager {

    public static final String TEXT_INPUT = "text";
    public static final String PASSWORD_INPUT = "password";
    public static final String CHECKBOX_INPUT = "checkbox";
    public static final String RADIO_INPUT = "radio";
    public static final String DROPDOWN_INPUT = "select";
    public static final String DROPDOWN_MULTI_INPUT = "multiSelect";
    public static final String MULTI_INPUT = "multiInput";
    public static final String TEXT_AREA_INPUT = "textarea";
    public static final String NUMBER_AREA_INPUT = "number";
    public static final String TOGGLE_INPUT = "toggle";
    public static final String TITLE_INPUT = "title";
    public static final String DATE_INPUT = "date";
    public static final String FORM_BTN_INPUT = "formBtn";
    public static final String COLOR_INPUT = "color";
    public static final String RANGE_INPUT = "range";
    public static final String EMAIL_INPUT = "email";
    public static final String POPOVERS_INPUT = "popovers";
    public static final String INLINE_HELP_INPUT = "inlineHelp";
    public static final String TEXT_ICON_INPUT = "textIcon";
    public static final String PHONE_INPUT = "phone";
    public static final String FILE_UPLOAD_INPUT = "fileUpload";
    public static final String THUMB_FILE_UPLOAD_INPUT = "thumbFileUpload";
    public static final String AV_FILE_UPLOAD_INPUT = "avatarFileUpload";
    public static final String WYSIWYG_INPUT = "wysiwygEditor";
    public static final String CKE_INPUT = "ckEditor";
    public static final String TAGS_INPUT = "tags";
    public static final String ELSE_INPUT = "text";

    public String name = ""; // name of component/entity
    public String title = ""; // title of component/entity
    public String viewPath = "/common"; // view path string

    public String createViewPath; // path of create/edit view
    public String listViewPath; // path of list view
    public String showViewPath = ""; // path of show view
    public String assignmentViewPath;

    public boolean uploadForm = false;

    public boolean optionAsModal = true;

    public int defaultWindowWidth = 700;


    public String identityField = "uuid";// id or uuid

    public int formGroupNo = 0;
    public int showGroupNo = 0;

    protected ApplicationContext applicationContext;

    protected AnnotationConfigApplicationContext ctx;

    public BaseViewManager() {
        //applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        /*SpringBeanManager.getInstance().initApplicationContext();
        applicationContext = SpringBeanManager.getInstance().getApplicationContext();*/
    }

    /**
     * tool panel configuration
     */
    public String toolPanel;
    /**
     * to populate form
     */
    public String formList;
    /**
     * to populate list view
     */
    public String itemList;
    /**
     * to populate details [page
     */
    public String showList;
    /**
     * Extra panel load config in create form
     */
    public String includeCreateViews;
    /**
     * Extra panel load config in show
     */
    public String includeShowViews;
    /**
     * Extra panel load config in list
     */
    public String includeListViews;
    /**
     * Custom option button
     */
    public String includeListButtonViews;

    public abstract List<Map<String,Object>> initFormList();

    public abstract Map<String,Object> initItemList(Object object);

    public abstract List<Map<String,Object>> initShowList();

    public Map<String,Object> initAssignmentList(Map<String,Object> assignments){
        return null;
    }
}
