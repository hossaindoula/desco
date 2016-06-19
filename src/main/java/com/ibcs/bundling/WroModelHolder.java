package com.ibcs.bundling;

/**
 * Created by hossain.doula on 5/24/2016.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ro.isdc.wro.http.support.ServletContextAttributeHelper;
import ro.isdc.wro.model.WroModel;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

/**
 * @author hossain.doula<hossain.doula@gmail.com>
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WroModelHolder {

    private ServletContext servletContext;
    private WroModel wroModel;

    public WroModel getWroModel() {
        servletContext = ((ServletRequestAttributes) RequestContextHolder.
                getRequestAttributes()).getRequest().getServletContext();
        System.out.println("servletContext.getAttributeNames().toString() = "
                + servletContext.getAttributeNames().toString());
        if (wroModel == null) {
            ServletContextAttributeHelper helper = new ServletContextAttributeHelper(servletContext);
            if (helper.getManagerFactory() != null) {
                wroModel = helper.getManagerFactory().create().getModelFactory().create();
            }
        }
        return wroModel;
    }

}