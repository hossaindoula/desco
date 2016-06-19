package com.ibcs.security.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author hossain.doula <hossain.doula@ibcs-primax.com>
 * Created by hossain.doula on 5/24/2016.
 */
public abstract class EqualsHashCodeToString implements Serializable {

    static {
        ReflectionToStringBuilder.setDefaultStyle(ToStringStyle.MULTI_LINE_STYLE);
    }

    protected String[] fieldsExcludedFromEqualsAndHashCode() {
        return new String[]{"logger"};
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, fieldsExcludedFromEqualsAndHashCode());
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other, fieldsExcludedFromEqualsAndHashCode());
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, fieldsExcludedFromEqualsAndHashCode());
    }
}