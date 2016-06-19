package com.ibcs.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

/**
 * Created by hossain.doula on 5/16/2016.
 */
public class CommonTagHandler extends TagSupport {

    public int doTag() throws JspException, IOException {
        try{
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

            String contextPath = request.getContextPath();
            pageContext.getOut().print(contextPath);
        } catch (Exception ex){
            throw new JspException(ex.toString());
        }

        return EVAL_PAGE;
    }
}
