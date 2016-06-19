package com.ibcs.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by hossain.doula on 5/31/2016.
 */
public class CreateLinkTagHandler extends EveryTagSupport {

    private String controller;
    private String action;
    private String innerText;

    protected BodyContent bodyContent;

    public int doStartTag(){
        return EVAL_BODY_BUFFERED;
    }

    public int doEndTag(){
        try{
            bodyContent = getBodyContent();
            String str = bodyContent.getString();
            JspWriter out = bodyContent.getEnclosingWriter();

            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

            StringBuilder linkBuilder = new StringBuilder();

            linkBuilder.append(START_TAG);
            linkBuilder.append("a");
            linkBuilder.append(SPACE_DELIMITER);
            linkBuilder.append("href");
            linkBuilder.append(EQ_OP);
            linkBuilder.append(request.getContextPath());
            linkBuilder.append(controller);
            linkBuilder.append("/");
            linkBuilder.append(action);
            linkBuilder.append(SPACE_DELIMITER);
            linkBuilder.append(START_END_TAG);
            linkBuilder.append(innerText);
            linkBuilder.append(START_TAG);
            linkBuilder.append(END_TAG);
            linkBuilder.append("a");
            linkBuilder.append(START_END_TAG);

            if(str != null){
                out.println(linkBuilder.toString());
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return EVAL_PAGE;
    }



    @Override
    public BodyContent getBodyContent() {
        return bodyContent;
    }

    @Override
    public void setBodyContent(BodyContent bodyContent) {
        this.bodyContent = bodyContent;
    }
}