package com.ibcs.finance;

import com.ibcs.base.component.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Controller
@RequestMapping("/budget")
public class BudgetController extends BaseController {

    public BudgetController(){
        super();
        title = "Budget";
        entityName = "budget";
        defaultPage = "/home";
    }

}
