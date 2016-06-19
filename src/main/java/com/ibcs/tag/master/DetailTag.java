package com.ibcs.tag.master;

/**
 * Created by hossain.doula on 5/30/2016.
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class DetailTag extends BodyTagSupport {
    /* Variables for storing back end specific information mapped to tag attributes*/
    private String detailTableName;
    private String detailColumnName;
    /*
           * *Accessors and Mutators for tag attributes
    */
    public String getDetailTableName() {
        return detailTableName;
    }

    public void setDetailTableName(String detailTableName) {
        this.detailTableName = detailTableName;
    }

    public String getDetailColumnName() {
        return detailColumnName;
    }

    public void setDetailColumnName(String detailColumnName) {
        this.detailColumnName = detailColumnName;
    }
    /* Invoked when start tag is rendered */
    public int doStartTag() {
        try {
            JspWriter out=pageContext.getOut();
		 /* Loads appropriate driver class and constructs JDBC URL based on attribute values */
            MasterDetailTag parentTag=(MasterDetailTag)findAncestorWithClass(this,MasterDetailTag.class);
            String dsnName=parentTag.getDsnName();
            String masterTableName=parentTag.getMasterTableName();
            String masterColumnName=parentTag.getMasterColumnName();
            String masterColumnValue=parentTag.getMasterColumnValue();
            String backEnd=parentTag.getBackEnd();
            String databaseName=parentTag.getDatabaseName();
            String userName=parentTag.getUserName();
            String password=parentTag.getPassword();
            Connection con=null;

            if (backEnd == null)
                backEnd="MS-Access";
            if (backEnd.equals("MS-Access"))
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            else if (backEnd.equals("MySQL"))
                Class.forName("com.mysql.jdbc.Driver");
            if (backEnd.equals("MS-Access"))
                con=DriverManager.getConnection("jdbc:odbc:"+dsnName);
            else if (backEnd.equals("MySQL")) {
                String mysqlUrl="jdbc:mysql://localhost:3306/"+databaseName;
                con=DriverManager.getConnection(mysqlUrl,userName,password);
            }
            Statement st = con.createStatement();
	       /* Construct SQL Query based on attribute values */
            String query="SELECT * FROM " + masterTableName + " WHERE 1=2";
            ResultSet rs=st.executeQuery(query);
	       /* Display Column Headers by retrieving Database Meta data */
            ResultSetMetaData rsmd=rs.getMetaData();
            int nCols=rsmd.getColumnCount();
            int searchColumnIndex=-1;
            for(int j=1;j<=nCols;j++) {
                if ((rsmd.getColumnName(j)).equals(masterColumnName))
                    searchColumnIndex=j;
            }
            if (rsmd.getColumnTypeName(searchColumnIndex).equals("VARCHAR"))
                masterColumnValue="'" + masterColumnValue +"'";
            query="SELECT " + masterTableName + ".*, " + detailTableName + ".* FROM " + masterTableName + "," + detailTableName + " WHERE " + masterTableName + "." + masterColumnName + "=" + detailTableName + "." + detailColumnName + " AND " + detailTableName + "." + detailColumnName + "=" + masterColumnValue;
            st = con.createStatement();
            rs=st.executeQuery(query);
            rsmd=rs.getMetaData();
            nCols=rsmd.getColumnCount();
            String data="<table border><tr bgcolor='#670608' style='color:#ffffff'>";
            String datatype=null;
            String columnName=null;
            for(int i=1;i<=nCols;i++) {
                columnName=rsmd.getColumnName(i);
                data+="<th>";
                data+=columnName;
                data+="</th>";
            }
            data+="</tr>";
		       /* Retrieve Column Values by querying their data type using ResultSetMetaData class */
            int rowcount=0;
            while (rs.next()) {
                rowcount++;
                if ((rowcount % 2)==0)
                    data+="<tr bgcolor='#EDA9AB'>";
                for(int i=1;i<=nCols;i++) {
                    data+="<td>";
                    datatype=rsmd.getColumnTypeName(i);
                    if (datatype.equals("INTEGER")|| datatype.equals("INT"))
                        data+=rs.getInt(i);
                    else if(datatype.equals("VARCHAR") || datatype.equals("CHAR"))
                        data+=rs.getString(i);
                    else if(datatype.equals("DOUBLE") || datatype.equals("FLOAT"))
                        data+=rs.getFloat(i);
                    else if (datatype.equals("BIT")  || datatype.equals("TINYINT"))
                        data+=rs.getBoolean(i);
                    else if (datatype.equals("DATETIME") || datatype.equals("DATE"))
                        data+=rs.getDate(i);
                    data+="</td>";
                }
                data+="</tr>";
            }
            out.println("</table>");
            out.println(data);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
