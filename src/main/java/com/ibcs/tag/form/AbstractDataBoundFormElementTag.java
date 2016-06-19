package com.ibcs.tag.form;

/**
 * Created by hossa on 5/31/2016.
 */
import java.beans.PropertyEditor;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.BindStatus;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

public abstract class AbstractDataBoundFormElementTag extends AbstractFormTag implements EditorAwareTag {
    protected static final String NESTED_PATH_VARIABLE_NAME = "nestedPath";
    private String path;
    private String id;
    private BindStatus bindStatus;

    public AbstractDataBoundFormElementTag() {
    }

    public void setPath(String path) {
        this.path = path;
    }

    protected final String getPath() throws JspException {
        String resolvedPath = (String)this.evaluate("path", this.path);
        return resolvedPath != null?resolvedPath:"";
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    protected void writeDefaultAttributes(TagWriter tagWriter) throws JspException {
        this.writeOptionalAttribute(tagWriter, "id", this.resolveId());
        this.writeOptionalAttribute(tagWriter, "name", this.getName());
    }

    protected String resolveId() throws JspException {
        Object id = this.evaluate("id", this.getId());
        if(id != null) {
            String idString = id.toString();
            return StringUtils.hasText(idString)?idString:null;
        } else {
            return this.autogenerateId();
        }
    }

    protected String autogenerateId() throws JspException {
        return StringUtils.deleteAny(this.getName(), "[]");
    }

    protected String getName() throws JspException {
        return this.getPropertyPath();
    }

    protected BindStatus getBindStatus() throws JspException {
        if(this.bindStatus == null) {
            String nestedPath = this.getNestedPath();
            String pathToUse = nestedPath != null?nestedPath + this.getPath():this.getPath();
            if(pathToUse.endsWith(".")) {
                pathToUse = pathToUse.substring(0, pathToUse.length() - 1);
            }

            this.bindStatus = new BindStatus(this.getRequestContext(), pathToUse, false);
        }

        return this.bindStatus;
    }

    protected String getNestedPath() {
        return (String)this.pageContext.getAttribute("nestedPath", 2);
    }

    protected String getPropertyPath() throws JspException {
        String expression = this.getBindStatus().getExpression();
        return expression != null?expression:"";
    }

    protected final Object getBoundValue() throws JspException {
        return this.getBindStatus().getValue();
    }

    protected PropertyEditor getPropertyEditor() throws JspException {
        return this.getBindStatus().getEditor();
    }

    public final PropertyEditor getEditor() throws JspException {
        return this.getPropertyEditor();
    }

    protected String convertToDisplayString(Object value) throws JspException {
        PropertyEditor editor = value != null?this.getBindStatus().findEditor(value.getClass()):null;
        return this.getDisplayString(value, editor);
    }

    protected final String processFieldValue(String name, String value, String type) {
        RequestDataValueProcessor processor = this.getRequestContext().getRequestDataValueProcessor();
        ServletRequest request = this.pageContext.getRequest();
        if(processor != null && request instanceof HttpServletRequest) {
            value = processor.processFormFieldValue((HttpServletRequest)request, name, value, type);
        }

        return value;
    }

    public void doFinally() {
        super.doFinally();
        this.bindStatus = null;
    }
}

