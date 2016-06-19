package com.ibcs.tag.ajax;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
import javax.servlet.jsp.JspException;

/**
 * Tag handler for the HTML Content AJAX tag.
 */
public class AjaxHtmlContentTag extends BaseAjaxTag {

    private static final long serialVersionUID = -2633087429107457075L;

    @Override
    protected String getJsClass() {
        return JSCLASS_BASE + "HtmlContent";
    }

    @Override
    public int doEndTag() throws JspException {
        out(buildScript());
        return EVAL_PAGE;
    }
}
