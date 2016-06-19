package com.ibcs.tag.form;

/**
 * Created by hossa on 5/31/2016.
 */
import java.beans.PropertyEditor;
import javax.servlet.jsp.JspException;

public interface EditorAwareTag {
    PropertyEditor getEditor() throws JspException;
}
