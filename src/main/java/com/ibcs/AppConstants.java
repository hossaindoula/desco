package com.ibcs;

import com.ibcs.util.DateUtils;

import java.util.Date;

/**
 * Basic Constants where no method need not to be present
 * It is used for basic configuration or data related fact
 * Created by hossain.doula on 5/15/2016.
 */
public interface AppConstants {

    String BASE_NAME_SPACE = "com.ibcs";
    String SEC_NAME_SPACE = "com.ibcs.security";

    String SESSION_USER = "sessionUser";
    String SESSION_USER_ID = "sessionUserId";
    String SESSION_USER_AUTHORIZED_GROUPS = "sessionUserAuthorizedGroups";
    String SESSION_USER_AUTHORITIES = "sessionUserAuthorities";
    String SESSION_USER_FEATURES = "sessionUserFeatures";
    String SESSION_SAVE = "save";
    String DASHBOARD_LINK = "Dashboard";

    String MODEL_STUB = "model";
    String DAO_STUB = "dao";

    String APP_NAME = "desco-iis";
    String APPLICATION_NAME = "Desco Integrated Inventory Management System";
    String SEPARATOR = "-";
    String COMPANY_NAME = "IBCS-Primax";
    String ADDRESS = "Rd No. 10A, Dhaka, Bangladesh \n" +
    "info@ibcs-primax.com \n" +
    "Dhanmondi-10/A,Dhaka";
    String SUCCESS_MESSAGE = "success";
    String FAILED_MESSAGE = "failed";
    String SB_KEY = "ibcs-primax";

    String TEMPLATE_LOADER_PATH = "classpath:templates";
    String VIEW_PREFIX = "/WEB-INF/views/";
    String VIEW_SUFFIX = ".ftl";
    String RC_CTX_ATTR = "rc";
    String RESOURCE_HANDLER = "/assets/**";
    String RESOURCE_LOCATION = "/assets/";

    String EXCLUDE_FILTERED_URI = "/";
    String LOGIN_URI = "/";
    String UNAUTHORIZED_URI = "/unauthorized";

    String COMPANY_COPYRIGHT_TEXT = DateUtils.getYear(new Date()) + " " +  COMPANY_NAME + " . All Rights Reserved";



}
