package com.ibcs.general;

import com.ibcs.AppConstants;
import com.ibcs.base.component.AppComponent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hossain.doula on 5/31/2016.
 */

@Controller
@RequestMapping("/Dashboard")
public class DashboardController extends AppComponent {

    @RequestMapping(method = RequestMethod.GET, value= "/")
    public ModelAndView home() {
        Map<String,String> dashboardPageMap = new HashMap<String,String>();
        dashboardPageMap.put("PageTitle", COMPANY_NAME + "login" );
        dashboardPageMap.put("Tile", "login");
        dashboardPageMap.put("companyName", COMPANY_NAME);
        dashboardPageMap.put("applicationName", APPLICATION_NAME);
        dashboardPageMap.put("copyRightText", COMPANY_COPYRIGHT_TEXT);

        return new ModelAndView("dashboard/home", dashboardPageMap);
    }


}
