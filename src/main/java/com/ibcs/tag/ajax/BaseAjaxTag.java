package com.ibcs.tag.ajax;

import javax.servlet.jsp.JspException;

/**
 * This class does not support body content.
 * Created by hossain.doula on 5/20/2016.
 */
public abstract class BaseAjaxTag extends BaseAjaxBodyTag {

    private static final long serialVersionUID = -6954908083925539558L;

    @Override
    protected void initParameters() throws JspException {
        super.initParameters();
        skipBody();
    }
}