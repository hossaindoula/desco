package com.ibcs.tag;

import com.ibcs.security.service.AuthenticationAndAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * This is responsible date picker based
 * Created by hossain.doula on 5/16/2016.
 */
public class DatePickerTagHandler extends BodyTagSupport {

    protected BodyContent bodyContent;

    @Autowired
    private AuthenticationAndAuthorizationService authService;

    public int doStartTag(){
        return EVAL_BODY_BUFFERED;
    }

    public int doEndTag(){
        try{
            //authService.checkAuthorization();
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
