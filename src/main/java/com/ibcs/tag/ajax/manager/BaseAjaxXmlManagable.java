package com.ibcs.tag.ajax.manager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
public interface BaseAjaxXmlManagable {
    /**
     * Each child class should override this method to generate the specific XML content necessary
     * for each AJAX action.
     *
     * @param request
     *            the HttpServletRequest object
     * @param response
     *            the HttpServletResponse object
     * @return a String representation of the XML response/content
     * @throws ServletException
     *             any errors
     * @throws IOException
     *             any IO error
     */
    String getXmlContent(final HttpServletRequest request, final HttpServletResponse response)
        throws ServletException, IOException;

    /**
     * Each child class should override this method to set the specific XML encoding.
     *
     * @return the XML encoding for the AJAX action
     */
    String getXMLEncoding();
}
