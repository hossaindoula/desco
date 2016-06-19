package com.ibcs.tag.ajax.helpers;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */

/**
 * HTML JavaScript element. This will help building JavaScript.
 */
public final class JavaScript extends AbstractHTMLElement {

    /**
     * Create a script element.
     */
    public JavaScript() {
        super("script");
    }

    /**
     * Constructor.
     *
     * @param script
     *            initial script content
     */
    public JavaScript(final String script) {
        this();
        append(script);
    }

    /**
     * Just allow type attribute. All others are dropped.
     */
    @Override
    protected void cleanAttributes() {
        getAttributes().clear();
        getAttributes().put("type", "text/javascript");
    }
}