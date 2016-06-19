package com.ibcs.security.view.form;

import com.ibcs.base.view.form.BaseValidator;
import com.ibcs.security.dto.AuthorityBean;
import com.ibcs.util.AlphaNumericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class AuthorityValidator extends BaseValidator {

    public boolean supports(Class<?> clazz) {
        return AuthorityBean.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        AuthorityBean authorityBean = (AuthorityBean) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.authority.name");
    }
}
