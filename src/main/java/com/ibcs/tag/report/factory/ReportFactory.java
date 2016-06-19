package com.ibcs.tag.report.factory;


import com.ibcs.tag.report.delegation.ReportDelegation;
import com.ibcs.tag.report.generator.ReportGenerator;

/**
 * Created by hossain.doula on 4/17/2016.
 */
public abstract class ReportFactory {
    abstract ReportGenerator getGenerator(String generator);
    abstract ReportDelegation getDelegation(String delegation);
}
