package com.ibcs.tag.form;

/**
 * Created by hossa on 5/31/2016.
 */
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.JspAwareRequestContext;
import org.springframework.web.servlet.support.RequestContext;

public abstract class RequestContextAwareTag extends TagSupport implements TryCatchFinally {
    public static final String REQUEST_CONTEXT_PAGE_ATTRIBUTE = "org.springframework.web.servlet.tags.REQUEST_CONTEXT";
    protected final Log logger = LogFactory.getLog(this.getClass());
    private RequestContext requestContext;

    public RequestContextAwareTag() {
    }

    public final int doStartTag() throws JspException {
        try {
            this.requestContext = (RequestContext)this.pageContext.getAttribute("org.springframework.web.servlet.tags.REQUEST_CONTEXT");
            if(this.requestContext == null) {
                this.requestContext = new JspAwareRequestContext(this.pageContext);
                this.pageContext.setAttribute("org.springframework.web.servlet.tags.REQUEST_CONTEXT", this.requestContext);
            }

            return this.doStartTagInternal();
        } catch (JspException var2) {
            this.logger.error(var2.getMessage(), var2);
            throw var2;
        } catch (RuntimeException var3) {
            this.logger.error(var3.getMessage(), var3);
            throw var3;
        } catch (Exception var4) {
            this.logger.error(var4.getMessage(), var4);
            throw new JspTagException(var4.getMessage());
        }
    }

    protected final RequestContext getRequestContext() {
        return this.requestContext;
    }

    protected abstract int doStartTagInternal() throws Exception;

    public void doCatch(Throwable throwable) throws Throwable {
        throw throwable;
    }

    public void doFinally() {
        this.requestContext = null;
    }
}
