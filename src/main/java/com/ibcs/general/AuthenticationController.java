package com.ibcs.general;

import com.ibcs.AppConstants;
import com.ibcs.base.component.AppComponent;
import com.ibcs.security.service.AuthenticationAndAuthorizationService;
import com.ibcs.security.service.BootStrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/")
public class AuthenticationController extends AppComponent {
	
	@Autowired
	private AuthenticationAndAuthorizationService authService;

    @Autowired
	private BootStrap bootStrap;

	/**
	 * This is the welcome page of the application
	 * which will render the display of login items
	 * such as <label>username:</label><input type='text'>
	 * <label>password:</label><input type='password'>
	 *
	 * @return ModelAndView
	 *
	 */
    @RequestMapping(method = RequestMethod.GET, value = AppConstants.LOGIN_URI)
	public ModelAndView login() {
        bootStrap.createDefaultAdmin();
        Map<String,String> loginPageMap = new HashMap<String,String>();
        loginPageMap.put("PageTitle", COMPANY_NAME + "login" );
        loginPageMap.put("Tile", "login");
        loginPageMap.put("companyName", COMPANY_NAME);
		loginPageMap.put("applicationName", APPLICATION_NAME);
		loginPageMap.put("copyRightText", COMPANY_COPYRIGHT_TEXT);

		return new ModelAndView("authentication/login", loginPageMap);
    }

	/**
	 * This is the welcome page of the application
	 * which will render the display of login items
	 * such as <label>username:</label><input type='text'>
	 * <label>password:</label><input type='password'>
	 *
	 * @param username  Username
	 * @param password  Password
	 * @return ModelAndView
	 * 				if SUCCESS == true then redirect to dashboard page
	 * 				else redirect to login page
	 *
	 */
	@RequestMapping(method=RequestMethod.POST, value="/authenticateUser")
	public ModelAndView authenticateUser(
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		if(authService.authenticate(username, password))
			return new ModelAndView("redirect:/Dashboard/");
		else {
			return new ModelAndView("redirect:/");
		}

	}
}
