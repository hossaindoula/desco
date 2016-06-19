package com.ibcs.tag.form;

import com.ibcs.tag.EveryTagSupport;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import java.io.IOException;

/**
 * Created by hossain.doula on 5/30/2016.
 */
public class TextAreaTagHandler extends EveryTagSupport {

    private String fieldPlaceholder;
    private String fieldId;
    private String fieldName;
    private String fieldClass;
    private String fieldTitle;
    private String fieldCols;
    private String fieldRows;
    protected BodyContent bodyContent;

    public int doStartTag(){
        return EVAL_BODY_BUFFERED;
    }

    public String getFieldRows() {
        return fieldRows;
    }

    public void setFieldRows(String fieldRows) {
        this.fieldRows = fieldRows;
    }

    public int doEndTag(){

        try{
            bodyContent = getBodyContent();
            String str = bodyContent.getString();
            JspWriter out = bodyContent.getEnclosingWriter();

            StringBuilder textArea = new StringBuilder();
            textArea.append(START_TAG);
            textArea.append("input");
            textArea.append(SPACE_DELIMITER);

            textArea.append("id");
            textArea.append(EQ_OP);
            textArea.append("'" + this.fieldId + "'");
            textArea.append(SPACE_DELIMITER);

            textArea.append("name");
            textArea.append(EQ_OP);
            textArea.append("'" + this.fieldId + "'");
            textArea.append(SPACE_DELIMITER);

            textArea.append("class");
            textArea.append(EQ_OP);
            textArea.append("'" + this.fieldClass + "'");
            textArea.append(SPACE_DELIMITER);

            textArea.append("cols");
            textArea.append(EQ_OP);
            textArea.append("'" + this.fieldCols + "'");
            textArea.append(SPACE_DELIMITER);

            textArea.append("rows");
            textArea.append(EQ_OP);
            textArea.append("'" + this.fieldCols + "'");
            textArea.append(SPACE_DELIMITER);

            textArea.append("title");
            textArea.append(EQ_OP);
            textArea.append("'" + this.fieldTitle + "'");
            textArea.append(SPACE_DELIMITER);

            if(str != null){
                out.println(textArea.toString());
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

    public String getFieldCols() {
        return fieldCols;
    }

    public void setFieldCols(String fieldCols) {
        this.fieldCols = fieldCols;
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