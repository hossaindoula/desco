package com.ibcs.general.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Dell on 6/16/2016.
 */

@Component
public class BaseUrlResolver {

    @Autowired
    protected RuntimeEnvironmentPropertiesManager propMgr;

    public String getSiteBaseUrl() {
        String baseUrl = propMgr.getProperty("site.baseurl");
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            return baseUrl.substring(0, baseUrl.length() - 1);
        }
        return baseUrl;
    }

    public String getAdminBaseUrl() {
        String baseUrl = propMgr.getProperty("admin.baseurl");
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            return baseUrl.substring(0, baseUrl.length() - 1);
        }
        return baseUrl;
    }
}
