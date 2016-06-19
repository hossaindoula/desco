package com.ibcs.tag.ajax;

import javax.servlet.jsp.JspException;

import com.ibcs.tag.ajax.helpers.HTMLDivElement;

/**
 * Tag handler for the tree AJAX tag.
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
/**
 *
 */
public class AjaxTreeTag extends BaseAjaxTag {

    private static final long serialVersionUID = -1607090849231461287L;

    private String collapsedClass;

    private String expandedClass;

    private String nodeClass;

    private String treeClass;

    public String getTreeClass() {
        return treeClass;
    }

    public void setTreeClass(final String treeClass) {
        this.treeClass = treeClass;
    }

    public String getNodeClass() {
        return nodeClass;
    }

    public void setNodeClass(final String nodeClass) {
        this.nodeClass = nodeClass;
    }

    public String getCollapsedClass() {
        return collapsedClass;
    }

    public void setCollapsedClass(final String collapsedClass) {
        this.collapsedClass = collapsedClass;
    }

    public String getExpandedClass() {
        return expandedClass;
    }

    public void setExpandedClass(final String expandedClass) {
        this.expandedClass = expandedClass;
    }

    @Override
    protected String getJsClass() {
        return JSCLASS_BASE + "Tree";
    }

    @Override
    protected OptionsBuilder getOptions() {
        final OptionsBuilder options = getOptionsBuilder();
        options.add("target", getId(), true);
        options.add("collapsedClass", this.collapsedClass, true);
        options.add("expandedClass", this.expandedClass, true);
        options.add("treeClass", this.treeClass, true);
        options.add("nodeClass", this.nodeClass, true);
        return options;
    }

    @Override
    public int doEndTag() throws JspException {
        final HTMLDivElement div = new HTMLDivElement(getId());
        div.setBody(buildScript());
        out(div);
        return EVAL_PAGE;
    }

    @Override
    protected void releaseTag() {
        collapsedClass = null; // NOPMD
        expandedClass = null; // NOPMD
        nodeClass = null; // NOPMD
        treeClass = null; // NOPMD
    }
}

