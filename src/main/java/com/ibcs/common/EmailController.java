package com.ibcs.common;

import com.ibcs.common.model.EmailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Optimized by hossain.doula@ibcs-primax.com
 */
@Controller
@RequestMapping("/email/")
public class EmailController {

	/*@Autowired
	EmailService emailService;*/

	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public String showEmail(Model model) {
		EmailInfo email = new EmailInfo();
		model.addAttribute(email);
		return "test/email";
	}

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String doSendEmail(
			@ModelAttribute("email") EmailInfo email,
			@RequestParam("fileName") CommonsMultipartFile file,
			Model model) {
		//emailService.sendMail(email, file);
		model.addAttribute(new EmailInfo());
		return "redirect:/email.do";
	}
}
