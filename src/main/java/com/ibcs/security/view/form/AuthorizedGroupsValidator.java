package com.ibcs.security.view.form;

import com.ibcs.base.view.form.BaseValidator;
import com.ibcs.security.dto.AuthorityBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class AuthorizedGroupsValidator extends BaseValidator {

    public boolean supports(Class<?> clazz) {
        return AuthorityBean.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        AuthorityBean authorityBean = (AuthorityBean) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.authority.name");
    }
}
