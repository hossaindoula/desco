package com.ibcs.security.dto;

import com.ibcs.base.view.form.dto.ModelForm;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Dell on 6/18/2016.
 */
public class FileUploadBean extends ModelForm {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public ModelForm getModelForm() {
        return new FileUploadBean();
    }
}
