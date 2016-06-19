package com.ibcs.security;

import com.ibcs.base.component.BaseController;
import com.ibcs.base.view.form.BaseValidator;
import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.dto.FileUploadBean;
import com.ibcs.security.view.form.FileUploadFormValidator;
import com.ibcs.security.view.manager.FileUploadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Dell on 6/18/2016.
 */

@Controller
@RequestMapping("/fileUpload")
public class FileUploadController extends BaseController {

    private static String UPLOAD_LOCATION = "D:/desco_file_upload_server/";

    @Autowired
    private FileUploadFormValidator fileUploadFormValidator;

    public FileUploadController() {
        super();
        viewManager = new FileUploadManager();
        title = "File Upload";
        entityName = "fileUpload";
        form = new FileUploadBean();
    }

    @PostConstruct
    protected BaseValidator initValidator(){
        return fileUploadFormValidator;
    }

    @PostConstruct
    @ModelAttribute("modelForm")
    public ModelForm initFileUploadForm(){
        return form;
    }

    protected Model beforeSave(Model modelInstance){
        FileUploadBean fileBucket = (FileUploadBean)modelInstance.asMap().get("modelForm");
        MultipartFile multipartFile = fileBucket.getFile();

        try{
            FileCopyUtils.copy(fileBucket.getFile().getBytes(),
                    new File(UPLOAD_LOCATION + fileBucket.getFile().getOriginalFilename()));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        // Now do something with file...

        String fileName = multipartFile.getOriginalFilename();
        modelInstance.addAttribute("fileName", fileName);

        return modelInstance;
    }


}
