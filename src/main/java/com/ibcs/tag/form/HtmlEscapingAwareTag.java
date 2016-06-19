package com.ibcs.tag.form;

/**
 * Created by hossa on 5/31/2016.
 */
import javax.servlet.jsp.JspException;
import org.springframework.web.util.HtmlUtils;

public abstract class HtmlEscapingAwareTag extends RequestContextAwareTag {
    private Boolean htmlEscape;

    public HtmlEscapingAwareTag() {
    }

    public void setHtmlEscape(boolean htmlEscape) throws JspException {
        this.htmlEscape = Boolean.valueOf(htmlEscape);
    }

    protected boolean isHtmlEscape() {
        return this.htmlEscape != null?this.htmlEscape.booleanValue():this.isDefaultHtmlEscape();
    }

    protected boolean isDefaultHtmlEscape() {
        return this.getRequestContext().isDefaultHtmlEscape();
    }

    protected boolean isResponseEncodedHtmlEscape() {
        return this.getRequestContext().isResponseEncodedHtmlEscape();
    }

    protected String htmlEscape(String content) {
        String out = content;
        if(this.isHtmlEscape()) {
            if(this.isResponseEncodedHtmlEscape()) {
                out = HtmlUtils.htmlEscape(content, this.pageContext.getResponse().getCharacterEncoding());
            } else {
                out = HtmlUtils.htmlEscape(content);
            }
        }

        return out;
    }
}
