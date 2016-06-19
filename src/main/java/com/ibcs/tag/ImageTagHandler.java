package com.ibcs.tag;

import com.ibcs.security.service.AuthenticationAndAuthorizationService;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * This is responsible for custom form display
 * Created by hossain.doula on 5/16/2016.
 */
public class ImageTagHandler extends BodyTagSupport {

    protected BodyContent bodyContent;

    private String uri;
    private String dir;
    private boolean hasResourceProcessor;
    private RequestDataValueProcessor requestDataValueProcessor;

    @Autowired
    private AuthenticationAndAuthorizationService authService;

    public int doStartTag(){
        return EVAL_BODY_BUFFERED;
    }

    public int doEndTag(){
        try{
            if (uri != null && dir != null) {
                this.dir = "images";
            }
            if (hasResourceProcessor) {
                //return r.img(attrs)
            }

            //String uri = this.uri != null ? processedUrl(uri, (HttpServletRequest) pageContext.getRequest()) : resource(attrs)

            String[] excludes = {"dir", "uri", "file", "plugin"};

            //String attrsAsString = attrsToString(attrs.findAll { !(it.key in excludes) })
            //String imgSrc = uri.encodeAsHTML();
            String processedString = "<img src=\"${imgSrc}\"${attrsAsString} />";
            //authService.checkAuthorization();
            bodyContent = getBodyContent();
            String str = bodyContent.getString();
            JspWriter out = bodyContent.getEnclosingWriter();
            if(str != null){
                out.println(processedString);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return EVAL_PAGE;
    }

    /**
     * Filters the url through the RequestDataValueProcessor bean if it is registered.
     */
    private String processedUrl(String link, HttpServletRequest request) {
        if (requestDataValueProcessor == null) {
            return link;
        }

        return requestDataValueProcessor.processUrl(request, link);
    }

    private String attrsToString(Map attrs) {
        // Output any remaining user-specified attributes
        StringBuilder sb=new StringBuilder();
        // For some strange reason Groovy creates ClassCastExceptions internally in PogoMetaMethodSite.checkCall without this hack
        for (Iterator i = InvokerHelper.asIterator(attrs); i.hasNext();) {
            Map.Entry e = (Map.Entry)i.next();
            if (e.getValue() != null) {
                sb.append(' ');
                sb.append(e.getKey());
                sb.append("='");
                sb.append(InvokerHelper.invokeMethod(String.valueOf(e.getValue()), "encodeAsHTML", null));
                sb.append("'");
            }
        }
        return sb.toString();
    }
}
