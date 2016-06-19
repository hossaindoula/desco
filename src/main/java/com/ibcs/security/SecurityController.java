package com.ibcs.security;

import com.ibcs.AppConstants;
import com.ibcs.base.component.AppComponent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hossain.doula on 5/31/2016.
 */

@Controller
@RequestMapping("/security")
public class SecurityController extends AppComponent {

    private HttpSession userSession;

    @RequestMapping(method = RequestMethod.GET, value= "/")
    public ModelAndView home(){
        Map<String,String> securityHomePageMap = new HashMap<String,String>();
        securityHomePageMap.put("PageTitle", COMPANY_NAME + "login" );
        securityHomePageMap.put("Tile", "login");
        securityHomePageMap.put("companyName", COMPANY_NAME);
        securityHomePageMap.put("applicationName", APPLICATION_NAME);
        securityHomePageMap.put("copyRightText", COMPANY_COPYRIGHT_TEXT);

        return new ModelAndView("security/home", securityHomePageMap);
    }

    @RequestMapping(method=RequestMethod.GET, value="/logout")
    public ModelAndView logout(){
        userSession = SessionUtil.getSession();
        userSession.removeAttribute(AppConstants.SESSION_USER);
        userSession.removeAttribute(AppConstants.SESSION_USER_FEATURES);
        userSession.invalidate();

        return new ModelAndView("redirect:/");
    }

}
