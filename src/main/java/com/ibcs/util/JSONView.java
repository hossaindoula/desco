/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibcs.util;

import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.web.servlet.View;

/**
 *
 * @author ronnie
 */
public class JSONView implements View {
    
    private String contentType = "application/json";
    
    public String getContentType() {
        return contentType;
    }

    public void render(Map map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject(map);
        PrintWriter writer = response.getWriter();
        writer.write(jsonObject.toString());
    }
    
}
