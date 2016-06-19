package com.ibcs.tag.report.html;

/**
 * Created by hossa on 4/17/2016.
 */
public class HeadGenerator {

    public static StringBuilder headBuilder(){
        StringBuilder headBuilder = new StringBuilder("<head>\n" +
                "\t\t<meta charset='UTF-8'>\n" +
                "\t\t\n" +
                "\t\t<title>Editable Invoice</title>");
        headBuilder.append(StyleGenerator.greyCssInit());
        headBuilder.append("</head>");
        return headBuilder;
    }
}
