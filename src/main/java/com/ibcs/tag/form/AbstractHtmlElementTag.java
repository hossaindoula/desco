package com.ibcs.tag.form;

/**
 * Created by hossa on 5/31/2016.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public abstract class AbstractHtmlElementTag extends AbstractDataBoundFormElementTag implements DynamicAttributes {
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String STYLE_ATTRIBUTE = "style";
    public static final String LANG_ATTRIBUTE = "lang";
    public static final String TITLE_ATTRIBUTE = "title";
    public static final String DIR_ATTRIBUTE = "dir";
    public static final String TABINDEX_ATTRIBUTE = "tabindex";
    public static final String ONCLICK_ATTRIBUTE = "onclick";
    public static final String ONDBLCLICK_ATTRIBUTE = "ondblclick";
    public static final String ONMOUSEDOWN_ATTRIBUTE = "onmousedown";
    public static final String ONMOUSEUP_ATTRIBUTE = "onmouseup";
    public static final String ONMOUSEOVER_ATTRIBUTE = "onmouseover";
    public static final String ONMOUSEMOVE_ATTRIBUTE = "onmousemove";
    public static final String ONMOUSEOUT_ATTRIBUTE = "onmouseout";
    public static final String ONKEYPRESS_ATTRIBUTE = "onkeypress";
    public static final String ONKEYUP_ATTRIBUTE = "onkeyup";
    public static final String ONKEYDOWN_ATTRIBUTE = "onkeydown";
    private String cssClass;
    private String cssErrorClass;
    private String cssStyle;
    private String lang;
    private String title;
    private String dir;
    private String tabindex;
    private String onclick;
    private String ondblclick;
    private String onmousedown;
    private String onmouseup;
    private String onmouseover;
    private String onmousemove;
    private String onmouseout;
    private String onkeypress;
    private String onkeyup;
    private String onkeydown;
    private Map<String, Object> dynamicAttributes;

    public AbstractHtmlElementTag() {
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    protected String getCssClass() {
        return this.cssClass;
    }

    public void setCssErrorClass(String cssErrorClass) {
        this.cssErrorClass = cssErrorClass;
    }

    protected String getCssErrorClass() {
        return this.cssErrorClass;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    protected String getCssStyle() {
        return this.cssStyle;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    protected String getLang() {
        return this.lang;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected String getTitle() {
        return this.title;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    protected String getDir() {
        return this.dir;
    }

    public void setTabindex(String tabindex) {
        this.tabindex = tabindex;
    }

    protected String getTabindex() {
        return this.tabindex;
    }

    public void setOnclick(String onclick) {
        this.onclick = onclick;
    }

    protected String getOnclick() {
        return this.onclick;
    }

    public void setOndblclick(String ondblclick) {
        this.ondblclick = ondblclick;
    }

    protected String getOndblclick() {
        return this.ondblclick;
    }

    public void setOnmousedown(String onmousedown) {
        this.onmousedown = onmousedown;
    }

    protected String getOnmousedown() {
        return this.onmousedown;
    }

    public void setOnmouseup(String onmouseup) {
        this.onmouseup = onmouseup;
    }

    protected String getOnmouseup() {
        return this.onmouseup;
    }

    public void setOnmouseover(String onmouseover) {
        this.onmouseover = onmouseover;
    }

    protected String getOnmouseover() {
        return this.onmouseover;
    }

    public void setOnmousemove(String onmousemove) {
        this.onmousemove = onmousemove;
    }

    protected String getOnmousemove() {
        return this.onmousemove;
    }

    public void setOnmouseout(String onmouseout) {
        this.onmouseout = onmouseout;
    }

    protected String getOnmouseout() {
        return this.onmouseout;
    }

    public void setOnkeypress(String onkeypress) {
        this.onkeypress = onkeypress;
    }

    protected String getOnkeypress() {
        return this.onkeypress;
    }

    public void setOnkeyup(String onkeyup) {
        this.onkeyup = onkeyup;
    }

    protected String getOnkeyup() {
        return this.onkeyup;
    }

    public void setOnkeydown(String onkeydown) {
        this.onkeydown = onkeydown;
    }

    protected String getOnkeydown() {
        return this.onkeydown;
    }

    protected Map<String, Object> getDynamicAttributes() {
        return this.dynamicAttributes;
    }

    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        if(this.dynamicAttributes == null) {
            this.dynamicAttributes = new HashMap();
        }

        if(!this.isValidDynamicAttribute(localName, value)) {
            throw new IllegalArgumentException("Attribute " + localName + "=\"" + value + "\" is not allowed");
        } else {
            this.dynamicAttributes.put(localName, value);
        }
    }

    protected boolean isValidDynamicAttribute(String localName, Object value) {
        return true;
    }

    protected void writeDefaultAttributes(TagWriter tagWriter) throws JspException {
        super.writeDefaultAttributes(tagWriter);
        this.writeOptionalAttributes(tagWriter);
    }

    protected void writeOptionalAttributes(TagWriter tagWriter) throws JspException {
        tagWriter.writeOptionalAttributeValue("class", this.resolveCssClass());
        tagWriter.writeOptionalAttributeValue("style", ObjectUtils.getDisplayString(this.evaluate("cssStyle", this.getCssStyle())));
        this.writeOptionalAttribute(tagWriter, "lang", this.getLang());
        this.writeOptionalAttribute(tagWriter, "title", this.getTitle());
        this.writeOptionalAttribute(tagWriter, "dir", this.getDir());
        this.writeOptionalAttribute(tagWriter, "tabindex", this.getTabindex());
        this.writeOptionalAttribute(tagWriter, "onclick", this.getOnclick());
        this.writeOptionalAttribute(tagWriter, "ondblclick", this.getOndblclick());
        this.writeOptionalAttribute(tagWriter, "onmousedown", this.getOnmousedown());
        this.writeOptionalAttribute(tagWriter, "onmouseup", this.getOnmouseup());
        this.writeOptionalAttribute(tagWriter, "onmouseover", this.getOnmouseover());
        this.writeOptionalAttribute(tagWriter, "onmousemove", this.getOnmousemove());
        this.writeOptionalAttribute(tagWriter, "onmouseout", this.getOnmouseout());
        this.writeOptionalAttribute(tagWriter, "onkeypress", this.getOnkeypress());
        this.writeOptionalAttribute(tagWriter, "onkeyup", this.getOnkeyup());
        this.writeOptionalAttribute(tagWriter, "onkeydown", this.getOnkeydown());
        if(!CollectionUtils.isEmpty(this.dynamicAttributes)) {
            Iterator var2 = this.dynamicAttributes.keySet().iterator();

            while(var2.hasNext()) {
                String attr = (String)var2.next();
                tagWriter.writeOptionalAttributeValue(attr, this.getDisplayString(this.dynamicAttributes.get(attr)));
            }
        }

    }

    protected String resolveCssClass() throws JspException {
        return this.getBindStatus().isError() && StringUtils.hasText(this.getCssErrorClass())?ObjectUtils.getDisplayString(this.evaluate("cssErrorClass", this.getCssErrorClass())):ObjectUtils.getDisplayString(this.evaluate("cssClass", this.getCssClass()));
    }
}
