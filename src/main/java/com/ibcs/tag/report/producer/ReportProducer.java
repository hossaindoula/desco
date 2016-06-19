package com.ibcs.tag.report.producer;

import com.ibcs.tag.report.factory.DelegationFactory;
import com.ibcs.tag.report.factory.GeneratorFactory;
import com.ibcs.tag.report.factory.ReportFactory;

/**
 * Created by hossa on 4/17/2016.
 */
public class ReportProducer{

    public static ReportFactory getDelegation(String choice){
        if(choice.equalsIgnoreCase("delegation")){
            return new DelegationFactory();
        } else if(choice.equalsIgnoreCase("generator")){
            return new GeneratorFactory();
        }
        return null;
    }
}
