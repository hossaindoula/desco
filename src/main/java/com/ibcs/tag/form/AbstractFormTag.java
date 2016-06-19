package com.ibcs.tag.form;

/**
 * Created by hossa on 5/31/2016.
 */
import java.beans.PropertyEditor;
import javax.servlet.jsp.JspException;

public abstract class AbstractFormTag extends HtmlEscapingAwareTag {
    public AbstractFormTag() {
    }

    protected Object evaluate(String attributeName, Object value) throws JspException {
        return value;
    }

    protected final void writeOptionalAttribute(TagWriter tagWriter, String attributeName, String value) throws JspException {
        if(value != null) {
            tagWriter.writeOptionalAttributeValue(attributeName, this.getDisplayString(this.evaluate(attributeName, value)));
        }

    }

    protected TagWriter createTagWriter() {
        return new TagWriter(this.pageContext);
    }

    protected final int doStartTagInternal() throws Exception {
        return this.writeTagContent(this.createTagWriter());
    }

    protected String getDisplayString(Object value) {
        return ValueFormatter.getDisplayString(value, this.isHtmlEscape());
    }

    protected String getDisplayString(Object value, PropertyEditor propertyEditor) {
        return ValueFormatter.getDisplayString(value, propertyEditor, this.isHtmlEscape());
    }

    protected boolean isDefaultHtmlEscape() {
        Boolean defaultHtmlEscape = this.getRequestContext().getDefaultHtmlEscape();
        return defaultHtmlEscape == null || defaultHtmlEscape.booleanValue();
    }

    protected abstract int writeTagContent(TagWriter var1) throws JspException;
}
