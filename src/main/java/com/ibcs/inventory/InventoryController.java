package com.ibcs.inventory;

import com.ibcs.base.component.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by hossain.doula on 5/17/2016.
 */

@Controller
@RequestMapping("/inventory/")
public class InventoryController extends BaseController {


    public ModelAndView list(){
        return new ModelAndView("common/list", new HashMap<String, Object>());
    }
}
