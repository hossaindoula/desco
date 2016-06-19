package com.ibcs.tag.form;

import com.ibcs.tag.EveryTagSupport;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import java.io.IOException;

/**
 * Created by hossain.doula on 5/30/2016.
 */
public class CustomTextFieldTagHandler extends EveryTagSupport {

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

            StringBuilder textField = new StringBuilder();
            textField.append(START_TAG);
            textField.append("input");
            textField.append(SPACE_DELIMITER);

            textField.append("type");
            textField.append(EQ_OP);
            textField.append("'" + TEXT + "'");
            textField.append(SPACE_DELIMITER);

            textField.append("id");
            textField.append(EQ_OP);
            textField.append("'" + this.fieldId + "'");
            textField.append(SPACE_DELIMITER);

            textField.append("name");
            textField.append(EQ_OP);
            textField.append("'" + this.fieldId + "'");
            textField.append(SPACE_DELIMITER);

            textField.append("class");
            textField.append(EQ_OP);
            textField.append("'" + this.fieldClass + "'");
            textField.append(SPACE_DELIMITER);

            textField.append("value");
            textField.append(EQ_OP);
            textField.append("'" + this.fieldValue + "'");
            textField.append(SPACE_DELIMITER);

            textField.append("title");
            textField.append(EQ_OP);
            textField.append("'" + this.fieldTitle + "'");
            textField.append(SPACE_DELIMITER);

            textField.append("placeholder");
            textField.append(EQ_OP);
            textField.append("'" + this.fieldPlaceholder + "'");
            textField.append(SPACE_DELIMITER);

            textField.append(START_END_TAG);

            if(str != null){
                out.println(textField.toString());
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
