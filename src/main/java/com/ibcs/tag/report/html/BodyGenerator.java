package com.ibcs.tag.report.html;


import com.ibcs.tag.report.model.Report;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 4/16/2016.
 */
public class BodyGenerator {

    private Report report;

    public BodyGenerator(Report report) {
        this.report = report;
    }

    public StringBuilder bodyBuilder(){
        StringBuilder body = new StringBuilder("<body>\n" +
                "\n" +
                "\t\t<div id=\"page-wrap\">\n" +
                "\n" +
                "\t\t\t<textarea id=\"header\">" + report.getReportType() + "</textarea>\n" +
                "\t\t\t\n" +
                "\t\t\t<div id=\"identity\">\n" +
                "\t\t\t\n" +
                "\t\t\t\t<textarea id=\"address\">"+report.getUpperLeftCornerElem()+"\n" +"</textarea>\n" +
                "\n" +
                "\t\t\t\t<div id=\"logo\">\n" +
                "\n" +
                "\t\t\t\t  <div id=\"logoctr\">\n" +
                "\t\t\t\t\t<a href=\"javascript:;\" id=\"change-logo\" title=\"Change logo\">Change Logo</a>\n" +
                "\t\t\t\t\t<a href=\"javascript:;\" id=\"save-logo\" title=\"Save changes\">Save</a>\n" +
                "\t\t\t\t\t|\n" +
                "\t\t\t\t\t<a href=\"javascript:;\" id=\"cancel-logo\" title=\"Cancel changes\">Cancel</a>\n" +
                "\t\t\t\t  </div>\n" +
                "\n" +
                "\t\t\t\t  <div id=\"logohelp\">\n" +
                "\t\t\t\t\t<input id=\"imageloc\" type=\"text\" size=\"50\" value=\"\" /><br />\n" +
                "\t\t\t\t\t(max width: 540px, max height: 100px)\n" +
                "\t\t\t\t  </div>\n" +
                "\t\t\t\t  <img id=\"image\" src='"+ report.getLogoUrl() +"' alt=\"logo\" />\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\n" +
                "\t\t\t<div style=\"clear:both\"></div>\n" +
                "\t\t\t\n" +
                "\t\t\t<div id=\"customer\">\n" +
                "\n" +
                "\t\t\t\t<textarea id=\"customer-title\">" + report.getBelowUpperLeftCornerElem() + "\n" +
                "\t</textarea>\n" +
                "\n" +
                "\t\t\t\t<table id=\"meta\">\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"meta-head\">Invoice #</td>\n" +
                "\t\t\t\t\t\t<td><textarea>" + report.getInvoiceAutoNumber() + "</textarea></td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\n" +
                "\t\t\t\t\t\t<td class=\"meta-head\">Date</td>\n" +
                "\t\t\t\t\t\t<td><textarea id=\"date\">"+ report.getDate().toString() +"</textarea></td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"meta-head\">Amount Due</td>\n" +
                "\t\t\t\t\t\t<td><div class=\"due\">" + report.getAmount() + "</div></td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\n" +
                "\t\t\t<table id=\"items\">\n" +
                "\t\t\t\n" +
                "\t\t\t  <tr>\n" +
                "\t\t\t\t  <th>"+ "" +"</th>\n" +
                "\t\t\t\t  <th>Description</th>\n" +
                "\t\t\t\t  <th>Unit Cost</th>\n" +
                "\t\t\t\t  <th>Quantity</th>\n" +
                "\t\t\t\t  <th>Price</th>\n" +
                "\t\t\t  </tr>\n" +
                "\t\t\t  \n" +
                "\t\t\t  <tr class=\"item-row\">\n" +
                "\t\t\t\t  <td class=\"item-name\"><textarea>Web Updates</textarea></td>\n" +
                "\t\t\t\t  <td class=\"description\"><textarea>Monthly web updates for http://widgetcorp.com (Nov. 1 - Nov. 30, 2009)</textarea></td>\n" +
                "\t\t\t\t  <td><textarea class=\"cost\">$650.00</textarea></td>\n" +
                "\t\t\t\t  <td><textarea class=\"qty\">1</textarea></td>\n" +
                "\t\t\t\t  <td><span class=\"price\">$650.00</span></td>\n" +
                "\t\t\t  </tr>\n" +
                "\t\t\t  \n" +
                "\t\t\t  <tr class=\"item-row\">\n" +
                "\t\t\t\t  <td class=\"item-name\"><textarea>SSL Renewals</textarea></td>\n" +
                "\n" +
                "\t\t\t\t  <td class=\"description\"><textarea>Yearly renewals of SSL certificates on main domain and several subdomains</textarea></td>\n" +
                "\t\t\t\t  <td><textarea class=\"cost\">$75.00</textarea></td>\n" +
                "\t\t\t\t  <td><textarea class=\"qty\">3</textarea></td>\n" +
                "\t\t\t\t  <td><span class=\"price\">$225.00</span></td>\n" +
                "\t\t\t  </tr>\n" +
                "\t\t\t  \n" +
                "\t\t\t  <tr id=\"hiderow\">\n" +
                "\t\t\t\t<td colspan=\"5\"><a id=\"addrow\" href=\"javascript:;\" title=\"Add a row\">Add a row</a></td>\n" +
                "\t\t\t  </tr>\n" +
                "\t\t\t  \n" +
                "\t\t\t  <tr>\n" +
                "\t\t\t\t  <td colspan=\"2\" class=\"blank\"> </td>\n" +
                "\t\t\t\t  <td colspan=\"2\" class=\"total-line\">Subtotal</td>\n" +
                "\t\t\t\t  <td class=\"total-value\"><div id=\"subtotal\">$875.00</div></td>\n" +
                "\t\t\t  </tr>\n" +
                "\t\t\t  <tr>\n" +
                "\n" +
                "\t\t\t\t  <td colspan=\"2\" class=\"blank\"> </td>\n" +
                "\t\t\t\t  <td colspan=\"2\" class=\"total-line\">Total</td>\n" +
                "\t\t\t\t  <td class=\"total-value\"><div id=\"total\">$875.00</div></td>\n" +
                "\t\t\t  </tr>\n" +
                "\t\t\t  <tr>\n" +
                "\t\t\t\t  <td colspan=\"2\" class=\"blank\"> </td>\n" +
                "\t\t\t\t  <td colspan=\"2\" class=\"total-line\">Amount Paid</td>\n" +
                "\n" +
                "\t\t\t\t  <td class=\"total-value\"><textarea id=\"paid\">$0.00</textarea></td>\n" +
                "\t\t\t  </tr>\n" +
                "\t\t\t  <tr>\n" +
                "\t\t\t\t  <td colspan=\"2\" class=\"blank\"> </td>\n" +
                "\t\t\t\t  <td colspan=\"2\" class=\"total-line balance\">Balance Due</td>\n" +
                "\t\t\t\t  <td class=\"total-value balance\"><div class=\"due\">" + report.getAmount() + "</div></td>\n" +
                "\t\t\t  </tr>\n" +
                "\t\t\t\n" +
                "\t\t\t</table>\n" +
                "\t\t\t\n" +
                "\t\t\t<div id=\"terms\">\n" +
                "\t\t\t  <h5>Terms</h5>\n" +
                "\t\t\t  <textarea>" + report.getTerms() + "</textarea>\n" +
                "\t\t\t</div>\n" +
                "\t\t\n" +
                "\t\t</div>\n" +
                "\t\t\n" +
                "\t</body>");

        return body;
    }
}
