package com.ibcs.tag.ajax;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.lang3.StringUtils;

import com.ibcs.tag.ajax.helpers.HTMLAnchorElement;
import com.ibcs.tag.ajax.helpers.HTMLDivElement;
import com.ibcs.tag.ajax.helpers.HTMLLIElement;
import com.ibcs.tag.ajax.helpers.HTMLUListElement;

/**
 * Tag handler for AJAX tabbed panel.
 */
public class AjaxTabPanelTag extends BaseAjaxBodyTag {

    private static final long serialVersionUID = 4008240512963947567L;

    private static final char PAGES_DELIMITER = ',';

    private String contentId;

    private List<String> pages = new ArrayList<String>();
    private List<HTMLLIElement> listItems = new ArrayList<HTMLLIElement>();

    /**
     * @return the contentId
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * @param contentId
     *            the contentId to set
     */
    public void setContentId(final String contentId) {
        this.contentId = contentId;
    }

    @Override
    protected void initParameters() throws JspException {
        pages = new ArrayList<String>();
        listItems = new ArrayList<HTMLLIElement>();
    }

    @Override
    protected String getJsClass() {
        return JSCLASS_BASE + "TabPanel";
    }

    @Override
    protected OptionsBuilder getOptions() {
        final OptionsBuilder options = getOptionsBuilder();
        options.add("id", getId(), true);
        // options.add("styleClass", getStyleClass(), true);
        options.add("contentId", getContentId(), true);
        options.add("pages", getPages(), false);
        return options;
    }

    @Override
    public int doEndTag() throws JspException {
        // check for tabs presence
        if (pages.isEmpty()) {
            throw new JspException("No tabs added to tab panel.");
        }

        // wrapper
        final HTMLDivElement tabPanel = new HTMLDivElement(getId());
        tabPanel.setClassName(getStyleClass() == null ? "tabPanel" : getStyleClass() + " tabPanel");

        HTMLDivElement tabNavigation = new HTMLDivElement();
        tabNavigation.setClassName("tabNavigation");

        HTMLUListElement ul = new HTMLUListElement();
        ul.setBody(getListItems());

        tabPanel.append(tabNavigation.append(ul));

        tabPanel.append(buildScript());

        out(tabPanel);
        return EVAL_PAGE;
    }

    @Override
    public void releaseTag() {
        pages = null; // NOPMD
        listItems = null; // NOPMD
    }

    /**
     * Add one tab to panel.
     *
     * @param tabPage
     *            tab
     */
    public final void addPage(final AjaxTabPageTag tabPage) {
        pages.add(tabPage.toString());

        HTMLAnchorElement a = new HTMLAnchorElement(tabPage.getBaseUrl());
        a.setBody(tabPage.getCaption());

        HTMLLIElement li = new HTMLLIElement();
        li.setId(tabPage.getId());
        li.append(a);
        listItems.add(li);
    }

    protected String getListItems() {
        return StringUtils.join(listItems, StringUtils.EMPTY);
    }

    /**
     * Get list of tabs as JavaScript array (JSON).
     *
     * @return JSON string with array of tabs
     */
    protected String getPages() {
        return '[' + StringUtils.join(pages, PAGES_DELIMITER) + ']';
    }
}