package com.ibcs.tag.menu;

import com.ibcs.security.service.AuthenticationAndAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * This will depict the navigation menu for the each module
 * Created by hossain.doula on 5/16/2016.
 */
public class ModuleNavigationMenuTagHandler extends BodyTagSupport {

    protected BodyContent bodyContent;

    @Autowired
    private AuthenticationAndAuthorizationService authService;

    public int doStartTag(){
        return EVAL_BODY_BUFFERED;
    }

    public int doEndTag(){
        try{
            bodyContent = getBodyContent();
            String str = bodyContent.getString();
            JspWriter out = bodyContent.getEnclosingWriter();
            if(str != null){
                out.println("<br>"+str.toLowerCase());
            }
        } catch (IOException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return EVAL_PAGE;
    }
}
