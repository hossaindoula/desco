package com.ibcs.tag.report.factory;


import com.ibcs.tag.report.delegation.ReportDelegation;
import com.ibcs.tag.report.generator.ExcelReportGenerator;
import com.ibcs.tag.report.generator.PDFReportGenerator;
import com.ibcs.tag.report.generator.ReportGenerator;

/**
 * Created by hossa on 4/17/2016.
 */
public class GeneratorFactory extends ReportFactory {
    @Override
    ReportGenerator getGenerator(String generator) {
        if(generator.equalsIgnoreCase("pdf"))
            return new PDFReportGenerator();
        else if(generator.equalsIgnoreCase("excel"))
            return new ExcelReportGenerator();
        return null;
    }

    @Override
    ReportDelegation getDelegation(String delegation) {
        return null;
    }
}
