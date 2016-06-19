package com.ibcs.tag.ajax.helpers;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
/**
 * HTML &lt;div&gt; element. Try to avoid building HTML code in TAGs or Servlets.
 */
public final class HTMLDivElement extends AbstractHTMLElement {

    /**
     * Create a HTML &lt;div&gt; element.
     *
     * @param id
     *            the id for the div element
     */
    public HTMLDivElement(final String id) {
        super("div", id, null);
    }

    /**
     * Create a HTML &lt;div&gt; element with no ID.
     */
    public HTMLDivElement() {
        this(null);
    }

}