package com.ibcs.security;

import com.ibcs.common.service.EmailService;
import com.ibcs.security.dao.UserDao;
import com.ibcs.security.model.Token;
import com.ibcs.security.model.User;
import com.ibcs.util.UUIDFactory;
import org.springframework.stereotype.Controller;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * Created by hossain.doula on 5/26/2016.
 */

@Controller
public class RegistrationController {

    @Resource
    private Environment environment;
    @Resource
    private EmailService emailService;
    @Resource
    private UUIDFactory uuidFactory;

    private UserDao userDao;

    private void setupModel(Model model) {
        model.addAttribute("passwordPattern", Token.PASSWORD_PATTERN);
        model.addAttribute("emailPattern", Token.EMAIL_PATTERN);
        model.addAttribute("environment", environment);
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(HttpServletRequest request, Model model) {
        setupModel(model);
        model.addAttribute("user", new User());

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid User user,
                           BindingResult bindingResult,
                           HttpServletRequest request, Model model,
                           RedirectAttributes redirectAttributes)
                                    throws  MalformedURLException,
                                            UnsupportedEncodingException {

        /*boolean userAlreadyExists = user.getEmail() != null &&
                (userDao.findByUsername(user.getToken().getUsername()) != null);
        if (bindingResult.hasErrors() || userAlreadyExists) {
            setupModel(model);
            if (userAlreadyExists) {
                bindingResult.addError(new ObjectError("user", "validation.user.alreadyExists"));
            }
            model.addAttribute("bindingResult", bindingResult);
            model.addAttribute("user", user);
            return "register";
        }

        user.getToken().setOneTimeToken(uuidFactory.generateUUID());
        userDao.create(user);
        emailService.sendRegistrationMessage(user, request);
        redirectAttributes.addFlashAttribute("message", "Your account " +
                "has been created and an email has been sent to " +
                user.getEmail() + " with a link to create your " +
                "password and login, please check your spam " +
                "folder if you don't see the email within 5 minutes");

        redirectAttributes.addFlashAttribute("title", "Account Created");
        return "redirect:/message";*/
        return "";
    }
}
