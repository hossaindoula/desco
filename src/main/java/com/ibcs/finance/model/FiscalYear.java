package com.ibcs.finance.model;

import com.ibcs.base.model.BaseModel;
import com.ibcs.configuration.AppNamespaceSet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: hossain.doula
 * Date: 5/15/16
 * Time: 6:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = AppNamespaceSet.FINANCIAL_MODULE + "_fiscal_year")
public class FiscalYear extends BaseModel<FiscalYear>{

    private Date beginDate;
    private  Date endDate;
    private  Integer closed;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEnd(Date endDate) {
        this.endDate = endDate;
    }

    public int getClosed() {
        return closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }
}
