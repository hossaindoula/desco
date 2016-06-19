package com.ibcs.tag.form;

/**
 * Created by hossa on 5/31/2016.
 */
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class TagSupport implements IterationTag, Serializable {
    private Tag parent;
    private Hashtable<String, Object> values;
    protected String id;
    protected PageContext pageContext;

    public static final Tag findAncestorWithClass(Tag from, Class klass) {
        boolean isInterface = false;
        if(from != null && klass != null && (Tag.class.isAssignableFrom(klass) || (isInterface = klass.isInterface()))) {
            while(true) {
                Tag tag = from.getParent();
                if(tag == null) {
                    return null;
                }

                if(isInterface && klass.isInstance(tag) || klass.isAssignableFrom(tag.getClass())) {
                    return tag;
                }

                from = tag;
            }
        } else {
            return null;
        }
    }

    public TagSupport() {
    }

    public int doStartTag() throws JspException {
        return 0;
    }

    public int doEndTag() throws JspException {
        return 6;
    }

    public int doAfterBody() throws JspException {
        return 0;
    }

    public void release() {
        this.parent = null;
        this.id = null;
        if(this.values != null) {
            this.values.clear();
        }

        this.values = null;
    }

    public void setParent(Tag t) {
        this.parent = t;
    }

    public Tag getParent() {
        return this.parent;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    public void setValue(String k, Object o) {
        if(this.values == null) {
            this.values = new Hashtable();
        }

        this.values.put(k, o);
    }

    public Object getValue(String k) {
        return this.values == null?null:this.values.get(k);
    }

    public void removeValue(String k) {
        if(this.values != null) {
            this.values.remove(k);
        }

    }

    public Enumeration<String> getValues() {
        return this.values == null?null:this.values.keys();
    }
}
