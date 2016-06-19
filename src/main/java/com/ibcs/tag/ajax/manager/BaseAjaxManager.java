package com.ibcs.tag.ajax.manager;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/20/2016.
 */
public abstract class BaseAjaxManager extends GenericServlet implements BaseAjaxXmlManagable {

    private static final long serialVersionUID = -1772422788542156185L;

    /**
     * Get information about servlet.
     *
     * @return information about servlet
     */
    @Override
    public String getServletInfo() {
        return "Ajax Servlet (AjaxTags)";
    }

    /**
     * Invoke the {@link #getXmlContent(HttpServletRequest, HttpServletResponse)} method.
     *
     * @param request
     *            the {@link ServletRequest}
     * @param response
     *            the {@link ServletResponse}
     * @throws ServletException
     *             any errors
     * @throws IOException
     *             any IO error
     */
    @Override
    public final void service(final ServletRequest request, final ServletResponse response)
    throws ServletException, IOException {
        final String xml = AjaxActionManager.invoke(this, (HttpServletRequest) request,
                (HttpServletResponse) response);

        final PrintWriter pw = response.getWriter();
        pw.write(xml);
        pw.flush(); // send all
    }

    /**
     * @return the encoding default to UTF-8
     */
    public String getXMLEncoding() {
        return "UTF-8";
    }
}
