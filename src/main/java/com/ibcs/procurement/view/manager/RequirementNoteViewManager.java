package com.ibcs.procurement.view.manager;

import com.ibcs.base.view.BaseViewManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hossain.doula on 6/12/2016.
 */

public class RequirementNoteViewManager extends BaseViewManager {

    private static RequirementNoteViewManager instance = null;

    public static RequirementNoteViewManager getInstance(){
        instance = new RequirementNoteViewManager();

        return instance;
    }

    private RequirementNoteViewManager(){
    }

    @Override
    public List<Map<String, Object>> initFormList() {
        List<Map<String,Object>> metaList = new ArrayList<Map<String, Object>>();
        Map<String,Object> meta = new HashMap<String, Object>();
        meta.put("type", DATE_INPUT);
        meta.put("id", "postingDate");
        meta.put("label", "Posting Date");
        meta.put("placeholder", "Username");
        meta.put("required", true);
        metaList.add(meta);

        List<Map<String,Object>> metaDetailList = new ArrayList<Map<String,Object>>();
        Map<String,Object> metaDetail = new HashMap<String, Object>();
        metaDetail.put("type", TEXT_INPUT);
        metaDetail.put("id", "itemCode");
        metaDetail.put("label", "Item Code");
        metaDetail.put("required", true);
        metaDetailList.add(metaDetail);

        metaDetail = new HashMap<String, Object>();
        metaDetail.put("type", TEXT_INPUT);
        metaDetail.put("id", "itemName");
        metaDetail.put("label", "Posting Date");
        metaDetail.put("placeholder", "Username");
        metaDetail.put("required", true);
        metaDetailList.add(metaDetail);

        metaDetail = new HashMap<String, Object>();
        metaDetail.put("type", TEXT_INPUT);
        metaDetail.put("id", "unit");
        metaDetail.put("label", "Posting Date");
        metaDetail.put("placeholder", "Username");
        metaDetail.put("required", true);
        metaDetailList.add(metaDetail);

        metaDetail = new HashMap<String, Object>();
        metaDetail.put("type", TEXT_INPUT);
        metaDetail.put("id", "quantityRequired");
        metaDetail.put("label", "Required Quantity");
        metaDetail.put("placeholder", "50");
        metaDetail.put("required", true);
        metaDetailList.add(metaDetail);

        metaDetail = new HashMap<String, Object>();
        metaDetail.put("type", NUMBER_AREA_INPUT);
        metaDetail.put("id", "estimatedCostUnit");
        metaDetail.put("label", "Required Quantity");
        metaDetail.put("placeholder", "50");
        metaDetail.put("required", true);
        metaDetailList.add(metaDetail);

        metaDetail = new HashMap<String, Object>();
        metaDetail.put("type", NUMBER_AREA_INPUT);
        metaDetail.put("id", "estimatedTotalCost");
        metaDetail.put("label", "Required Quantity");
        metaDetail.put("placeholder", "50");
        metaDetail.put("required", true);
        metaDetailList.add(metaDetail);

        metaDetail = new HashMap<String, Object>();
        metaDetail.put("type", NUMBER_AREA_INPUT);
        metaDetail.put("id", "previousYearConsumption");
        metaDetail.put("label", "Previous year consumption");
        metaDetail.put("placeholder", "50");
        metaDetail.put("required", true);
        metaDetailList.add(metaDetail);

        meta = new HashMap<String, Object>();
        meta.put("detail", metaDetailList);

        metaList.add(meta);

        System.out.println("metaList = " + metaList);

        return metaList;
    }

    @Override
    public Map<String, Object> initItemList(Object object) {
        return null;
    }

    @Override
    public List<Map<String, Object>> initShowList() {
        return null;
    }
}
