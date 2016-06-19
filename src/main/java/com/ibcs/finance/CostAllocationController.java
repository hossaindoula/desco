package com.ibcs.finance;

import com.ibcs.base.component.BaseController;
import com.ibcs.finance.service.BudgetService;
import com.ibcs.finance.view.manager.CostAllocationViewManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */

@Controller
@RequestMapping("/costAllocation")
public class CostAllocationController extends BaseController {

    @Autowired
    private BudgetService budgetService;

    public CostAllocationController() {
        super();
        viewManager = CostAllocationViewManager.getInstance();
        title = "Cost Allocation";
        entityName = "Cost Allocation";
    }

    protected Object listPopulateJsonModel(){
        return budgetService.findAllCostAllocations();
    }

    @RequestMapping(value = "/showCreate", method = RequestMethod.GET)
    public ModelAndView showCreate(){
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("PageTitle", "Master Details");
        model.put("title", "Master Details");
        return new ModelAndView("/common/master_details_create", model);
    }

    /*@RequestMapping(method = RequestMethod.POST, value= "/save")
    public String save(@ModelAttribute("costAllocation") CostAllocation costAllocation,
                             final RedirectAttributes redirectAttributes) {
        String message = "";

        try{
            if(budgetService.save(costAllocation))
                message = entityName.toUpperCase() + " saved "  + STATUS_SUCCESS;
            else
                message = entityName.toUpperCase() + " saved "  + STATUS_FAILURE;
        } catch (Exception ex){
            ex.printStackTrace();
            message = SERVER_ERROR;
        }


        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/create";
    }*/
}
