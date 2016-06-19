package com.ibcs.general;

import com.ibcs.general.service.MenuGenerationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 5/23/2016.
 */
@Controller
@RequestMapping("/test/")
public class TestController {

    @Autowired
    MenuGenerationManager menuManager;

    public ModelAndView create(){
        menuManager.generateMenu();
        return new ModelAndView("ok",new HashMap<String, Object>());
    }
}
