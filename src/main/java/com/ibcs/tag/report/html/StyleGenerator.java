package com.ibcs.tag.report.html;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 4/16/2016.
 */
public class StyleGenerator {

    public static StringBuilder greyCssInit(){
        StringBuilder cssBuilder = new StringBuilder("<style>\n" +
                "\t\t\t* { margin: 0; padding: 0; }\n" +
                "\t\t\tbody { font: 14px/1.4 Georgia, serif; }\n" +
                "\t\t\t#page-wrap { width: 800px; margin: 0 auto; }\n" +
                "\n" +
                "\t\t\ttextarea { border: 0; font: 14px Georgia, Serif; overflow: hidden; resize: none; }\n" +
                "\t\t\ttable { border-collapse: collapse; }\n" +
                "\t\t\ttable td, table th { border: 1px solid black; padding: 5px; }\n" +
                "\n" +
                "\t\t\t#header { height: 15px; width: 100%; margin: 20px 0; background: #222; text-align: center; color: white; font: bold 15px Helvetica, Sans-Serif; text-decoration: uppercase; letter-spacing: 20px; padding: 8px 0px; }\n" +
                "\n" +
                "\t\t\t#address { width: 250px; height: 150px; float: left; }\n" +
                "\t\t\t#customer { overflow: hidden; }\n" +
                "\n" +
                "\t\t\t#logo { text-align: right; float: right; position: relative; margin-top: 25px; border: 1px solid #fff; max-width: 540px; max-height: 100px; overflow: hidden; }\n" +
                "\t\t\t#logo:hover, #logo.edit { border: 1px solid #000; margin-top: 0px; max-height: 125px; }\n" +
                "\t\t\t#logoctr { display: none; }\n" +
                "\t\t\t#logo:hover #logoctr, #logo.edit #logoctr { display: block; text-align: right; line-height: 25px; background: #eee; padding: 0 5px; }\n" +
                "\t\t\t#logohelp { text-align: left; display: none; font-style: italic; padding: 10px 5px;}\n" +
                "\t\t\t#logohelp input { margin-bottom: 5px; }\n" +
                "\t\t\t.edit #logohelp { display: block; }\n" +
                "\t\t\t.edit #save-logo, .edit #cancel-logo { display: inline; }\n" +
                "\t\t\t.edit #image, #save-logo, #cancel-logo, .edit #change-logo, .edit #delete-logo { display: none; }\n" +
                "\t\t\t#customer-title { font-size: 20px; font-weight: bold; float: left; }\n" +
                "\n" +
                "\t\t\t#meta { margin-top: 1px; width: 300px; float: right; }\n" +
                "\t\t\t#meta td { text-align: right;  }\n" +
                "\t\t\t#meta td.meta-head { text-align: left; background: #eee; }\n" +
                "\t\t\t#meta td textarea { width: 100%; height: 20px; text-align: right; }\n" +
                "\n" +
                "\t\t\t#items { clear: both; width: 100%; margin: 30px 0 0 0; border: 1px solid black; }\n" +
                "\t\t\t#items th { background: #eee; }\n" +
                "\t\t\t#items textarea { width: 80px; height: 50px; }\n" +
                "\t\t\t#items tr.item-row td { border: 0; vertical-align: top; }\n" +
                "\t\t\t#items td.description { width: 300px; }\n" +
                "\t\t\t#items td.item-name { width: 175px; }\n" +
                "\t\t\t#items td.description textarea, #items td.item-name textarea { width: 100%; }\n" +
                "\t\t\t#items td.total-line { border-right: 0; text-align: right; }\n" +
                "\t\t\t#items td.total-value { border-left: 0; padding: 10px; }\n" +
                "\t\t\t#items td.total-value textarea { height: 20px; background: none; }\n" +
                "\t\t\t#items td.balance { background: #eee; }\n" +
                "\t\t\t#items td.blank { border: 0; }\n" +
                "\n" +
                "\t\t\t#terms { text-align: center; margin: 20px 0 0 0; }\n" +
                "\t\t\t#terms h5 { text-transform: uppercase; font: 13px Helvetica, Sans-Serif; letter-spacing: 10px; border-bottom: 1px solid black; padding: 0 0 8px 0; margin: 0 0 8px 0; }\n" +
                "\t\t\t#terms textarea { width: 100%; text-align: center;}\n" +
                "\n" +
                "\t\t\ttextarea:hover, textarea:focus, #items td.total-value textarea:hover, #items td.total-value textarea:focus, .delete:hover { background-color:#EEFF88; }\n" +
                "\n" +
                "\t\t\t.delete-wpr { position: relative; }\n" +
                "\t\t\t.delete { display: block; color: #000; text-decoration: none; position: absolute; background: #EEEEEE; font-weight: bold; padding: 0px 3px; border: 1px solid; top: -6px; left: -22px; font-family: Verdana; font-size: 12px; }\n" +
                "\t\t</style>");
        return cssBuilder;
    }
}
