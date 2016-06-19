package com.ibcs.tag.ajax;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
import javax.servlet.jsp.JspException;

/**
 * Tag handler for the form field AJAX tag.
 */
public class AjaxFormFieldTag extends BaseAjaxTag {

    private static final long serialVersionUID = -7774526024294932262L;

    private boolean valueUpdateByName;

    @Override
    protected String getJsClass() {
        return JSCLASS_BASE + "UpdateField";
    }

    @Override
    protected OptionsBuilder getOptions() {
        final OptionsBuilder options = getOptionsBuilder();
        options.add("valueUpdateByName", String.valueOf(valueUpdateByName), false);
        return options;
    }

    @Override
    public int doEndTag() throws JspException {
        out(buildScript());
        return EVAL_PAGE;
    }

    @Override
    public void releaseTag() {
        valueUpdateByName = false;
    }

    public boolean getValueUpdateByName() {
        return valueUpdateByName;
    }

    public void setValueUpdateByName(final boolean valueUpdateByName) {
        this.valueUpdateByName = valueUpdateByName;
    }
}
