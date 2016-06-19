package com.ibcs.tag.ajax;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
import javax.servlet.jsp.JspException;

/**
 * Tag handler for the select AJAX tag.
 */
public class AjaxSelectTag extends BaseAjaxTag {

    private static final long serialVersionUID = -686763601190277341L;

    private String emptyOptionValue;

    private String emptyOptionName;

    private boolean executeOnLoad;

    private String defaultOptions;

    public String getEmptyOptionName() {
        return emptyOptionName;
    }

    public void setEmptyOptionName(final String emptyOptionName) {
        this.emptyOptionName = emptyOptionName;
    }

    public String getEmptyOptionValue() {
        return emptyOptionValue;
    }

    public void setEmptyOptionValue(final String emptyOptionValue) {
        this.emptyOptionValue = emptyOptionValue;
    }

    public boolean getExecuteOnLoad() {
        return executeOnLoad;
    }

    public void setExecuteOnLoad(final boolean executeOnLoad) {
        this.executeOnLoad = executeOnLoad;
    }

    public String getDefaultOptions() {
        return defaultOptions;
    }

    public void setDefaultOptions(final String defaultOptions) {
        this.defaultOptions = defaultOptions;
    }

    @Override
    protected String getJsClass() {
        return JSCLASS_BASE + "Select";
    }

    @Override
    protected OptionsBuilder getOptions() {
        final OptionsBuilder options = getOptionsBuilder();
        options.add("executeOnLoad", this.executeOnLoad);
        options.add("defaultOptions", this.defaultOptions, true);
        options.add("emptyOptionValue", emptyOptionValue, true);
        options.add("emptyOptionName", emptyOptionName, true);
        return options;
    }

    @Override
    public int doEndTag() throws JspException {
        out(buildScript());
        return EVAL_PAGE;
    }

    @Override
    public void releaseTag() {
        this.executeOnLoad = false;
        this.defaultOptions = null; // NOPMD
        this.emptyOptionName = null; // NOPMD
        this.emptyOptionValue = null; // NOPMD
    }
}