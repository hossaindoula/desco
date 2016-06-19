package com.ibcs.security.view.form;

import com.ibcs.base.view.form.BaseValidator;
import com.ibcs.security.dto.UserBean;
import com.ibcs.security.service.UserDetailsService;
import com.ibcs.util.AlphaNumericValidator;
import com.ibcs.util.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class UserFormValidator extends BaseValidator {

    @Autowired
    @Qualifier("emailValidator")
    EmailValidator emailValidator;

    @Autowired
    @Qualifier("alphaNumericValidator")
    AlphaNumericValidator alphaNumericValidator;

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;


    public boolean supports(Class<?> clazz) {
        return UserBean.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        UserBean user = (UserBean) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.userForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.userForm.confirmPassword");

        if(!alphaNumericValidator.validate(user.getUsername())){
            errors.rejectValue("username", "Pattern.userForm.username");
        }
        if(!emailValidator.validate(user.getEmail())){
            errors.rejectValue("email", "Pattern.userForm.email");
        }

        if(!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
        }
    }
}
