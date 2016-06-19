package com.ibcs.tag.report.factory;

import com.ibcs.tag.report.delegation.HTMLDelegation;
import com.ibcs.tag.report.delegation.JasperDelegation;
import com.ibcs.tag.report.delegation.ReportDelegation;
import com.ibcs.tag.report.delegation.StringDelegation;
import com.ibcs.tag.report.generator.ReportGenerator;

/**
 * Created by hossa on 4/17/2016.
 */
public class DelegationFactory extends ReportFactory {
    @Override
    ReportGenerator getGenerator(String generator) {
        return null;
    }

    @Override
    ReportDelegation getDelegation(String delegation) {
        if(delegation.equalsIgnoreCase("html")){
            return new HTMLDelegation();
        } else if(delegation.equalsIgnoreCase("jasper")){
            return new JasperDelegation();
        } else if(delegation.equalsIgnoreCase("string")){
            return new StringDelegation();
        }
        return null;
    }
}
