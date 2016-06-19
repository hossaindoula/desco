package com.ibcs.procurement;

import com.ibcs.base.component.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hossain.doula on 5/15/2016.
 */

@Controller
@RequestMapping("/procurement")
public class ProcurementController extends BaseController {

    public ProcurementController(){
        super();
        title = "Procurement";
        entityName = "procurement";
        defaultPage = "/home";
    }
}
