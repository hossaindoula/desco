package com.ibcs.security.filter;

import com.ibcs.AppConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This Filter is responsible to intercept or filter any unauthenticated request
 * and thus redirect the request to the EXCLUDED_FILTERED_URI
 * So this will not allow any user to access any unauthenticated URI.
 * No need to use any shitty Spring Security. Cause we are the
 * Software Engineer. This is some small piece of code.
 * Created by hossain.doula on 5/18/2016.
 */
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        String path = ((HttpServletRequest) servletRequest).getRequestURI();
        if(path.startsWith(AppConstants.EXCLUDE_FILTERED_URI))
            filterChain.doFilter(servletRequest, servletResponse);
        else {
            RequestDispatcher requestDispatcher = servletRequest.
                    getRequestDispatcher(AppConstants.LOGIN_URI);
            requestDispatcher.include(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
