package com.ibcs.tag.ajax.manager;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.NotImplementedException;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
public class AjaxActionManager {
    /**
     * Some HTML-Header which can be easily enabled.
     */
    public static enum HTMLAjaxHeader {
        /**
         * Set HTTP/1.1 no-cache headers.
         */
        CACHE_CONTROL("Cache-Control",
                "no-store, max-age=0, no-cache, must-revalidate, post-check=0, pre-check=0"),
        /**
         * Set standard HTTP/1.0 no-cache header.
         */
        PRAGMA("Pragma", "no-cache");

        /**
         * Store the header name.
         */
        private String headerName;
        /**
         * Store the header value.
         */
        private String headerValue;

        /**
         * Create the header pair. This is a easy usage holding static header information.
         *
         * @param name
         *            the header name.
         * @param value
         *            the header value.
         */
        private HTMLAjaxHeader(final String name, final String value) {
            headerName = name;
            headerValue = value;
        }

        /**
         * Enable the header in the {@link HttpServletResponse}.
         *
         * @param response
         *            the {@link HttpServletResponse} where we should write the header to.
         */
        public void enable(final HttpServletResponse response) {
            response.setHeader(headerName, headerValue);
        }

        /**
         * Disable the header. This is not yet implemented.
         *
         * @param response
         *            the {@link HttpServletResponse}
         */
        public void disable(final HttpServletResponse response) {
            throw new NotImplementedException("This is not implemented yet.");
        }
    }

    /**
     * Do not create an object.
     */
    private AjaxActionManager() {
    }

    /**
     * Invoke the AJAX action and setup the request and response.
     *
     * @param action
     *            the BaseAjaxXmlAction implementation
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the XML content from action
     * @throws ServletException
     *             for any errors
     */
    public static String invoke(final BaseAjaxXmlManagable action, final HttpServletRequest request,
                                final HttpServletResponse response) throws ServletException {
        // prepare CALL
        try {
            request.setCharacterEncoding(action.getXMLEncoding());
            // we will use UTF-8
        } catch (UnsupportedEncodingException e) {
            throw new ServletException(e);
        }
        // Set content to XML
        response.setContentType("text/xml; charset=" + action.getXMLEncoding());

        // enable the ajaxheaders
        for (HTMLAjaxHeader header : HTMLAjaxHeader.values()) {
            header.enable(response);
        }

        try {
            return action.getXmlContent(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

}