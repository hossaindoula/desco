package com.ibcs.tag;

import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Created by hossain.doula on 5/30/2016.
 */
public abstract class EveryTagSupport extends BodyTagSupport {

    protected static final String START_TAG = "<";
    protected static final String START_END_TAG = ">";
    protected static final String END_TAG = "/";
    protected static final String SPACE_DELIMITER = " ";
    protected static final String EQ_OP = "=";
    protected static final String TEXT = "text";
    protected static final String PWD = "password";
    protected static final String TXT_AREA = "textarea";
}
