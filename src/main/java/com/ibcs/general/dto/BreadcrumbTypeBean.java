/*
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2015 Broadleaf Commerce
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package com.ibcs.general.dto;


import com.ibcs.util.EnumerationType;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An extensible enumeration of breadcrumb types.   Useful in the view layer to vary the presentation
 * based on the Breadcrumb type.
 * 
 * @author hossaindoula
 *
 */
public class BreadcrumbTypeBean implements Serializable, EnumerationType {

    private static final long serialVersionUID = 1L;

    private static final Map<String, BreadcrumbTypeBean> TYPES = new LinkedHashMap<String, BreadcrumbTypeBean>();

    public static final BreadcrumbTypeBean HOME = new BreadcrumbTypeBean("HOME", "Home");
    public static final BreadcrumbTypeBean CATEGORY = new BreadcrumbTypeBean("CATEGORY", "Category");
    public static final BreadcrumbTypeBean PRODUCT = new BreadcrumbTypeBean("PRODUCT", "Product");
    public static final BreadcrumbTypeBean SEARCH = new BreadcrumbTypeBean("SEARCH", "Search");
    public static final BreadcrumbTypeBean PAGE = new BreadcrumbTypeBean("PAGE", "Page");

    public static BreadcrumbTypeBean getInstance(final String type) {
        return TYPES.get(type);
    }

    private String type;
    private String friendlyType;

    public BreadcrumbTypeBean() {
        //do nothing
    }

    public BreadcrumbTypeBean(final String type, final String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    public String getType() {
        return type;
    }

    public String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final String type) {
        this.type = type;
        if (!TYPES.containsKey(type)) {
            TYPES.put(type, this);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        BreadcrumbTypeBean other = (BreadcrumbTypeBean) obj;
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        return true;
    }

}
