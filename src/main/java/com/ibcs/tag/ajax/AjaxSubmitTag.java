package com.ibcs.tag.ajax;

import javax.servlet.jsp.JspException;

/**
 * Created by hossain.doula on 5/20/2016.
 * Builds the JavaScript required to submit form and retrieve response via AJAX.
 */
public class AjaxSubmitTag extends BaseAjaxTag {

    private static final long serialVersionUID = -8804246033367573302L;

    @Override
    protected String getJsClass() {
        return JSCLASS_BASE + "Submit";
    }

    @Override
    public int doEndTag() throws JspException {
        out(buildScript());
        return EVAL_PAGE;
    }
}
