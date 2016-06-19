package com.ibcs.tag.form;

import com.ibcs.tag.EveryTagSupport;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import java.io.IOException;

/**
 * Created by hossain.doula on 5/30/2016.
 */
public class FormButtonTagHandler extends EveryTagSupport {

    private String fieldPlaceholder;
    private String fieldId;
    private String fieldName;
    private String fieldClass;
    private String fieldTitle;
    private String fieldValue;

    protected BodyContent bodyContent;

    public int doStartTag(){
        return EVAL_BODY_BUFFERED;
    }

    public int doEndTag(){
        try{
            bodyContent = getBodyContent();
            String str = bodyContent.getString();
            JspWriter out = bodyContent.getEnclosingWriter();



            //Submit
            StringBuilder submitField = new StringBuilder();
            submitField.append(START_TAG);
            submitField.append("input");
            submitField.append(SPACE_DELIMITER);

            submitField.append("type");
            submitField.append(EQ_OP);
            submitField.append("'submit'");
            submitField.append(SPACE_DELIMITER);

            submitField.append("id");
            submitField.append(EQ_OP);
            submitField.append("'" + this.fieldId + "'");
            submitField.append(SPACE_DELIMITER);

            submitField.append("name");
            submitField.append(EQ_OP);
            submitField.append("'" + this.fieldId + "'");
            submitField.append(SPACE_DELIMITER);

            submitField.append("class");
            submitField.append(EQ_OP);
            submitField.append("'" + this.fieldClass + "'");
            submitField.append(SPACE_DELIMITER);

            submitField.append("value");
            submitField.append(EQ_OP);
            submitField.append("'" + this.fieldValue + "'");
            submitField.append(SPACE_DELIMITER);

            submitField.append("title");
            submitField.append(EQ_OP);
            submitField.append("'" + this.fieldTitle + "'");
            submitField.append(SPACE_DELIMITER);


            //Reset
            StringBuilder resetField = new StringBuilder();
            resetField.append(START_TAG);
            resetField.append("input");
            resetField.append(SPACE_DELIMITER);

            resetField.append("type");
            resetField.append(EQ_OP);
            resetField.append("'reset'");
            resetField.append(SPACE_DELIMITER);

            resetField.append("id");
            resetField.append(EQ_OP);
            resetField.append("'" + this.fieldId + "'");
            resetField.append(SPACE_DELIMITER);

            resetField.append("name");
            resetField.append(EQ_OP);
            resetField.append("'" + this.fieldId + "'");
            resetField.append(SPACE_DELIMITER);

            resetField.append("class");
            resetField.append(EQ_OP);
            resetField.append("'" + this.fieldClass + "'");
            resetField.append(SPACE_DELIMITER);

            resetField.append("value");
            resetField.append(EQ_OP);
            resetField.append("'" + this.fieldValue + "'");
            resetField.append(SPACE_DELIMITER);

            resetField.append("title");
            resetField.append(EQ_OP);
            resetField.append("'" + this.fieldTitle + "'");
            resetField.append(SPACE_DELIMITER);

            StringBuilder mergeField = new StringBuilder();
            mergeField.append(submitField);
            mergeField.append(resetField);

            if(str != null){
                out.println(mergeField.toString());
            }
        } catch (IOException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return EVAL_PAGE;
    }

    public String getFieldPlaceholder() {
        return fieldPlaceholder;
    }

    public void setFieldPlaceholder(String fieldPlaceholder) {
        this.fieldPlaceholder = fieldPlaceholder;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldClass() {
        return fieldClass;
    }

    public void setFieldClass(String fieldClass) {
        this.fieldClass = fieldClass;
    }

    public String getFieldTitle() {
        return fieldTitle;
    }

    public void setFieldTitle(String fieldTitle) {
        this.fieldTitle = fieldTitle;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
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