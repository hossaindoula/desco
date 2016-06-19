package com.ibcs.tag.master;

/**
 * Created by hossain.doula on 5/30/2016.
 */
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class MasterDetailTag extends BodyTagSupport{
    /* Variables for storing back end specific information mapped to tag attributes*/
    private String dsnName;
    private String masterTableName;
    private String masterColumnName;
    private String masterColumnValue;
    private String databaseName;
    private String userName;
    private String password;
    private String backEnd;
    /*
           * *Accessors and Mutators for tag attributes
    */
    public String getMasterTableName() {
        return masterTableName;
    }

    public void setMasterTableName(String masterTableName) {
        this.masterTableName = masterTableName;
    }

    public String getMasterColumnName() {
        return masterColumnName;
    }

    public void setMasterColumnName(String masterColumnName) {
        this.masterColumnName = masterColumnName;
    }

    public String getMasterColumnValue() {
        return masterColumnValue;
    }

    public void setMasterColumnValue(String masterColumnValue) {
        this.masterColumnValue = masterColumnValue;
    }

    public String getDsnName() {
        return dsnName;
    }

    public void setDsnName(String dsnName)
    {
        this.dsnName=dsnName;
    }


    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBackEnd() {
        return backEnd;
    }

    public void setBackEnd(String backEnd) {
        this.backEnd = backEnd;
    }
    /* Invoked when start tag is rendered */
    public int doStartTag() {
        return EVAL_BODY_INCLUDE;
    }
}