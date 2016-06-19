package com.ibcs.security.view.form;

import com.ibcs.base.view.form.BaseValidator;
import com.ibcs.security.dto.FileUploadBean;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 * Created by Dell on 6/18/2016.
 */

@Component
public class FileUploadFormValidator extends BaseValidator {
    public boolean supports(Class<?> clazz) {
        return FileUploadBean.class.isAssignableFrom(clazz);
    }

    public void validate(Object obj, Errors errors) {
        FileUploadBean file = (FileUploadBean) obj;

        if(file.getFile()!=null){
            if (file.getFile().getSize() == 0) {
                errors.rejectValue("file", "missing.file");
            }
        }
    }
}
