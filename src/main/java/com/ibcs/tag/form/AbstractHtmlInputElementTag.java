
package com.ibcs.tag.form;


import javax.servlet.jsp.JspException;

/**
 * Base class for databinding-aware JSP tags that render HTML form input element.
 *
 * <p>Provides a set of properties corresponding to the set of HTML attributes
 * that are common across form input elements.
 *
 * @author hossain.doula
 * @since 2.0
 */
@SuppressWarnings("serial")
public abstract class AbstractHtmlInputElementTag extends AbstractHtmlElementTag {

	/**
	 * The name of the '{@code onfocus}' attribute.
	 */
	public static final String ONFOCUS_ATTRIBUTE = "onfocus";

	/**
	 * The name of the '{@code onblur}' attribute.
	 */
	public static final String ONBLUR_ATTRIBUTE = "onblur";

	/**
	 * The name of the '{@code onchange}' attribute.
	 */
	public static final String ONCHANGE_ATTRIBUTE = "onchange";

	/**
	 * The name of the '{@code accesskey}' attribute.
	 */
	public static final String ACCESSKEY_ATTRIBUTE = "accesskey";

	/**
	 * The name of the '{@code disabled}' attribute.
	 */
	public static final String DISABLED_ATTRIBUTE = "disabled";

	/**
	 * The name of the '{@code readonly}' attribute.
	 */
	public static final String READONLY_ATTRIBUTE = "readonly";


	private String onfocus;

	private String onblur;

	private String onchange;

	private String accesskey;

	private String disabled;

	private String readonly;


	/**
	 * Set the value of the '{@code onfocus}' attribute.
	 * May be a runtime expression.
	 */
	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	/**
	 * Get the value of the '{@code onfocus}' attribute.
	 */
	protected String getOnfocus() {
		return this.onfocus;
	}

	/**
	 * Set the value of the '{@code onblur}' attribute.
	 * May be a runtime expression.
	 */
	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	/**
	 * Get the value of the '{@code onblur}' attribute.
	 */
	protected String getOnblur() {
		return this.onblur;
	}

	/**
	 * Set the value of the '{@code onchange}' attribute.
	 * May be a runtime expression.
	 */
	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	/**
	 * Get the value of the '{@code onchange}' attribute.
	 */
	protected String getOnchange() {
		return this.onchange;
	}

	/**
	 * Set the value of the '{@code accesskey}' attribute.
	 * May be a runtime expression.
	 */
	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}

	/**
	 * Get the value of the '{@code accesskey}' attribute.
	 */
	protected String getAccesskey() {
		return this.accesskey;
	}

	/**
	 * Set the value of the '{@code disabled}' attribute.
	 * May be a runtime expression.
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	/**
	 * Get the value of the '{@code disabled}' attribute.
	 */
	protected String getDisabled() {
		return this.disabled;
	}

	/**
	 * Sets the value of the '{@code readonly}' attribute.
	 * May be a runtime expression.
	 * @see #isReadonly()
	 */
	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	/**
	 * Gets the value of the '{@code readonly}' attribute.
	 * May be a runtime expression.
	 * @see #isReadonly()
	 */
	protected String getReadonly() {
		return this.readonly;
	}


	/**
	 * Adds input-specific optional attributes as defined by this base class.
	 */
	@Override
	protected void writeOptionalAttributes(TagWriter tagWriter) throws JspException {
		super.writeOptionalAttributes(tagWriter);

		writeOptionalAttribute(tagWriter, ONFOCUS_ATTRIBUTE, getOnfocus());
		writeOptionalAttribute(tagWriter, ONBLUR_ATTRIBUTE, getOnblur());
		writeOptionalAttribute(tagWriter, ONCHANGE_ATTRIBUTE, getOnchange());
		writeOptionalAttribute(tagWriter, ACCESSKEY_ATTRIBUTE, getAccesskey());
		if (isDisabled()) {
			tagWriter.writeAttribute(DISABLED_ATTRIBUTE, "disabled");
		}
		if (isReadonly()) {
			writeOptionalAttribute(tagWriter, READONLY_ATTRIBUTE, "readonly");
		}
	}

	/**
	 * Is the current HTML tag disabled?
	 */
	protected boolean isDisabled() throws JspException {
		return true;//evaluateBoolean(DISABLED_ATTRIBUTE, getDisabled());
	}

	/**
	 * Is the current HTML tag readonly?
	 * <p>Note: some {@link AbstractHtmlInputElementTag} subclasses (such a those
	 * for checkboxes and radiobuttons)  may contain readonly attributes, but are
	 * not affected by them since their values don't change (only their status does.)
	 */
	protected boolean isReadonly() throws JspException {
		return true;//evaluateBoolean(READONLY_ATTRIBUTE, getReadonly());
	}

}
