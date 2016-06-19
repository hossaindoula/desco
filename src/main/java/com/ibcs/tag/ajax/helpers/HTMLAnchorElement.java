package com.ibcs.tag.ajax.helpers;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
/**
 * HTML &lt;a&gt; element.
 */
public class HTMLAnchorElement extends AbstractHTMLElement {

    public HTMLAnchorElement(String href) {
        super("a");
        setHref(href);
    }

    public String getHref() {
        return getAttributes().get(HTMLAttribute.HREF);
    }

    public void setHref(String href) {
        getAttributes().put(HTMLAttribute.HREF, href);
    }

    public String getTitle() {
        return getAttributes().get(HTMLAttribute.TITLE);
    }

    public void setTitle(String title) {
        getAttributes().put(HTMLAttribute.TITLE, title);
    }

}