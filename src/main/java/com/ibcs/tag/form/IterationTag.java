package com.ibcs.tag.form;

/**
 * Created by hossa on 5/31/2016.
 */
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

public interface IterationTag extends Tag {
    int EVAL_BODY_AGAIN = 2;

    int doAfterBody() throws JspException;
}
