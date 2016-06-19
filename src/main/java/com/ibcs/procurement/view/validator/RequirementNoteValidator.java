package com.ibcs.procurement.view.validator;

import com.ibcs.base.view.form.BaseValidator;
import com.ibcs.procurement.dto.RequirementNoteMasterDetail;
import com.ibcs.procurement.service.ProcurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RequirementNoteValidator extends BaseValidator {

    @Autowired
    ProcurementService procurementService;


    public boolean supports(Class<?> clazz) {
        return RequirementNoteMasterDetail.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        RequirementNoteMasterDetail requirementNoteMasterDetail = (RequirementNoteMasterDetail) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.userForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.userForm.confirmPassword");

        if(requirementNoteMasterDetail.getItemName() == null)
            errors.rejectValue("itemName", "Diff.userform.confirmPassword");

        /*if(!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userform.confirmPassword");
        }*/
    }
}
