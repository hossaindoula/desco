package com.ibcs.base.component;

import com.ibcs.AppConstants;
import com.ibcs.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.DataBinder;
import org.springframework.web.context.request.RequestContextListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a component class which will be inherited by BaseComponent
 * and eventually in every controller which will not be public by this
 * application HAS TO BE inherited in order to get the perfect functional
 * implication. This is a pure Spring Oriented Component abstract class. Because we
 * don't want to get constructed this class by it's own but it will have to be inherited in order
 * to get the required functionality. So, this abstract class is the real blueprint of
 * the App model. This can be utilized  by any kind of Spring oriented application.
 * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Created by hossain.doula on 5/15/2016.
 */

@Component
public abstract class AppComponent implements AppConstants {

    protected static final String ADD_RECORD_CLS = "addRecord";
    protected static final String ASSIGNMENT_CLS = "assignment";
    protected static final String EDIT_CLS = "editRecord";
    protected static final String SHOW_CLS = "showRecord";
    protected static final String ACCEPT_CLS = "acceptRecord";
    protected static final String REJECT_CLS = "rejectRecord";
    protected static final String DELETE_CLS = "deleteRecord";

    protected static final String CREATE_OP = "create";
    protected static final String EDIT_OP = "edit";
    protected static final String SHOW_OP = "show";
    protected static final String DELETE_OP = "delete";
    protected static final String ACCEPT_OP = "accept";
    protected static final String REJECT_OP = "reject";
    protected static final String OWN_OP = "own";

    protected static final String USER_GROUP_SUPER_ADMIN = "SUPER_ADMIN";

    protected static final String USER_GROUP_CS_JAM = "CS_JAM";
    protected static final String USER_GROUP_CS_AM = "CS_AM";
    protected static final String USER_GROUP_CS_XEN = "CS_XEN";

    protected static final String USER_GROUP_SS_JAM = "SS_JAM";
    protected static final String USER_GROUP_SS_AM = "SS_AM";
    protected static final String USER_GROUP_SS_XEN = "SS_XEN";

    protected static final String USER_GROUP_LS_JAM = "LS_JAM";
    protected static final String USER_GROUP_LS_AM = "LS_AM";
    protected static final String USER_GROUP_LS_XEN = "LS_XEN";

    protected static final String COOKIE_AUTH_REMEMBER = "IBCS_AUTH_REMEMBER";

    protected static final String COOKIE_LANG = "lang";

    public static final String DEFAULT_CONTENT_TYPE = "text/html;charset=UTF-8";

    public static final String SERVER_ERROR = "Processing failed due to Server Error!!!";

    // Status Constant
    public static final String STATUS_ACTIVE = "A";
    protected static final String STATUS_INACTIVE = "I";
    protected static final String STATUS_ARCHIVE = "AR";
    protected static final String STATUS_RESET = "R";
    protected static final String STATUS_WITHDRAW = "W";
    protected static final String STATUS_DELETED = "D";
    protected static final String STATUS_ALL = "AL";
    protected static final String STATUS_EXPIRING = "EX";
    protected static final String STATUS_SYSTEM = "S";
    protected static final String STATUS_SUCCESS = "SU";
    protected static final String STATUS_FAILURE = "F";
    protected static final String STATUS_VALID = "V";
    protected static final String STATUS_INVALID = "IV";
    protected static final String STATUS_PAID = "P";
    protected static final String STATUS_UNPAID = "UP";
    protected static final String STATUS_PARTIAL_PAID = "PP";
    protected static final String STATUS_PARTIAL_PAID_ACTIVE = "PPA";


    protected static final String CUSTOMER_PREFIX = "CUST-";
    protected static final String SALES_ORDER_PREFIX = "SO-";
    protected static final String DIRECT_PURCHASE_ORDER_PREFIX = "DP-";
    protected static final String WORK_ORDER_PREFIX = "WO-";
    protected static final String DELIVERY_ORDER_PREFIX = "DO-";
    protected static final String PURCHASE_ORDER_PREFIX = "PO-";

    protected static final String CS_RECEIVING_ITEMS = "CS_RECEIVING_ITEMS";
    protected static final String LS_CS_REQUISITION = "LS_CS_REQUISITION";
    protected static final String SS_CS_REQUISITION = "SS_CS_REQUISITION";
    protected static final String OPEN = "OPEN";
    protected static final String DONE = "DONE";
    protected static final String BACK = "BACK";
    protected static final String RECEIVED = "RECEIVED";
    protected static final String CS_STORE_TICKET = "CS_STORE_TICKET";
    protected static final String CS_GATE_PASS = "CS_GATE_PASS";
    protected static final String LS_CS_RETURN_SLIP = "LS_CS_RETURN_SLIP";
    protected static final String SS_CS_RETURN_SLIP = "SS_CS_RETURN_SLIP";
    protected static final String CN2_LS_RETURN_SLIP = "CN2_LS_RETURN_SLIP";
    protected static final String LS_GATE_PASS = "LS_GATE_PASS";

    protected static final String NEW_SERVICEABLE = "NEW_SERVICEABLE";
    protected static final String RECOVERY_SERVICEABLE = "RECOVERY_SERVICEABLE";
    protected static final String UNSERVICEABLE = "UNSERVICEABLE";
    protected static final String AUCTION = "AUCTION";
    protected static final String REVENUE = "SND";

    //Changed by hossain.doula
    // Added by Ashid || All Ledger Name should be added inside enum
    protected enum LedgerBook {
        NEW_SERVICEABLE, RECOVERY_SERVICEABLE, UNSERVICEABLE, AUCTION
    }


    // Setting constant value for this controller
    protected static final String LS_SS_REQUISITION = "LS_SS_REQUISITION";
    protected static final String SS_STORE_TICKET = "SS_STORE_TICKET";

    //Changed by hossain.doula
    protected static final String LS_SS_RETURN_SLIP = "LS_SS_RETURN_SLIP";

    //Changed by hossain.doula
    protected static final String LS_ISSUED_REQUISITION = "LS_ISSUED_REQUISITION";
    protected static final String LS_STORE_TICKET = "LS_STORE_TICKET";

    //Changed by hossain.doula
    protected static final String CS_VEHICLE_PERMISSION = "CS_VEHICLE_PERMISSION";

    //Changed by hossain.doula
    // constant for CS khath transfer
    protected static final String CS_KHATH_TRANSFER = "CS_KHATH_TRANSFER";
    protected static final String CS_KHATH_TRANSFER_APPROVED = "1";

    //Changed by hossain.doula
    //Added by Nasrin
    protected static final String CN_SS_REQUISITION = "CN_SS_REQUISITION";
    protected static final String SS_GATE_PASS = "SS_GATE_PASS";
    protected static final String CN_SS_RETURN_SLIP = "CN_SS_RETURN_SLIP";
    protected static final String SS_RECEIVING_ITEMS = "SS_RECEIVING_ITEMS";

    Map<String,Object> appState;

    public List<Map<String, Object>> APP_STATES =
            new ArrayList<Map<String, Object>>();

    Map<String,Object> status;
    public List<Map<String, Object>> STATUS_LIST = new ArrayList<Map<String, Object>>();



    public void generateAppStatuses() {
        status = new HashMap<String, Object>();
        status.put("statusCode", "A");
        status.put("statusName", "Active");
        STATUS_LIST.add(status);

        status = new HashMap<String, Object>();
        status.put("statusCode", "I");
        status.put("statusName", "Inactive");
        STATUS_LIST.add(status);

        status = new HashMap<String, Object>();
        status.put("statusCode", "D");
        status.put("statusName", "Deleted");
        STATUS_LIST.add(status);

        status = new HashMap<String, Object>();
        status.put("statusCode", "S");
        status.put("statusName", "System");
        STATUS_LIST.add(status);

    }

    public void generateApprovalStates() {
        appState = new HashMap<String, Object>();
        appState.put("stateCode", 50);
        appState.put("stateName", StringUtils.capitalize("review"));
        APP_STATES.add(appState);

        appState = new HashMap<String, Object>();
        appState.put("stateCode", 100);
        appState.put("stateName", StringUtils.capitalize("initiate"));
        APP_STATES.add(appState);

        appState = new HashMap<String, Object>();
        appState.put("stateCode", 100);
        appState.put("stateName", "initiated".toUpperCase());
        APP_STATES.add(appState);

        appState = new HashMap<String, Object>();
        appState.put("stateCode", 200);
        appState.put("stateName", StringUtils.capitalize("verify"));
        APP_STATES.add(appState);

        appState = new HashMap<String, Object>();
        appState.put("stateCode", 300);
        appState.put("stateName", StringUtils.capitalize("recommend"));
        APP_STATES.add(appState);

        appState = new HashMap<String, Object>();
        appState.put("stateCode", 400);
        appState.put("stateName", StringUtils.capitalize("check"));
        APP_STATES.add(appState);

        appState = new HashMap<String, Object>();
        appState.put("stateCode", 500);
        appState.put("stateName", StringUtils.capitalize("check & verify"));
        APP_STATES.add(appState);

        appState = new HashMap<String, Object>();
        appState.put("stateCode", 600);
        appState.put("stateName", StringUtils.capitalize("Approve"));
        APP_STATES.add(appState);
    }
}