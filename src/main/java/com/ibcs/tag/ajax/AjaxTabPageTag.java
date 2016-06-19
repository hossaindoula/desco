package com.ibcs.tag.ajax;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Tag handler for individual page within a AJAX tabbed panel.
 */
public class AjaxTabPageTag extends BaseAjaxTag {

    private static final long serialVersionUID = 2438025605821348018L;

    private String caption;

    private String defaultTab;

    public final String getCaption() {
        return caption;
    }

    public final void setCaption(final String caption) {
        this.caption = caption;
    }

    public final String getDefaultTab() {
        return defaultTab;
    }

    public final void setDefaultTab(final String defaultTab) {
        this.defaultTab = String.valueOf(defaultTab);
    }

    @Override
    public String toString() {
        final OptionsBuilder options = getOptionsBuilder(true); // clean one
        // options.add("id", getId(), true);
        // options.add("caption", getCaption(), true);
        // options.add("baseUrl", getBaseUrl(), true);
        options.add("parameters", getParameters(), true);
        options.add("defaultTab", getDefaultTab(), false);
        return "{" + options.toString() + "}";
    }

    @Override
    public int doEndTag() throws JspException {
        final AjaxTabPanelTag parent = (AjaxTabPanelTag) TagSupport.findAncestorWithClass(this,
                AjaxTabPanelTag.class);
        parent.addPage(this);
        return EVAL_PAGE;
    }

    @Override
    public void releaseTag() {
        id = null; // NOPMD
        caption = null; // NOPMD
        defaultTab = null; // NOPMD
    }
}