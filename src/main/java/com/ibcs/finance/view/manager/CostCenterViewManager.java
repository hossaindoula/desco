package com.ibcs.finance.view.manager;

import com.ibcs.base.view.BaseViewManager;
import com.ibcs.finance.model.CostCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */
public class CostCenterViewManager extends BaseViewManager {

    private static CostCenterViewManager instance = null;

    public static CostCenterViewManager getInstance() {
        instance = new CostCenterViewManager();

        return instance;
    }

    @Override
    public List<Map<String, Object>> initFormList() {
        List<Map<String,Object>> metaList = new ArrayList<Map<String, Object>>();
        Map<String,Object> meta = new HashMap<String, Object>();
        meta.put("type", "text");
        meta.put("id", "name");
        meta.put("label", "Name");
        meta.put("placeholder", "Name");
        metaList.add(meta);

        meta = new HashMap<String, Object>();
        meta.put("type", "text");
        meta.put("id", "description");
        meta.put("label", "Description");
        meta.put("placeholder", "Description");
        metaList.add(meta);

        return metaList;
    }

    @Override
    public Map<String, Object> initItemList(Object object) {
        List<CostCenter> costCenters = (List<CostCenter>)object;

        Map<String,Object> wrapper = new HashMap<String, Object>();

        List<Map<String,Object>> headers = new ArrayList<Map<String, Object>>();
        List<Map<String,Object>> mappers = new ArrayList<Map<String,Object>>();

        Map<String,Object> header;

        header = new HashMap<String, Object>();
        header.put("id", "id");
        header.put("width", 50);
        header.put("type", "dyn");
        header.put("align", "right");
        header.put("sort", "int");
        header.put("value", "ID");
        headers.add(header);

        header = new HashMap<String, Object>();
        header.put("id", "name");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "str");
        header.put("value", "Name");
        headers.add(header);

        header = new HashMap<String, Object>();
        header.put("id", "description");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "str");
        header.put("value", "Description");
        headers.add(header);


        Map<String,Object> mapper;



        for(CostCenter costCenter : costCenters){
            mapper = new HashMap<String, Object>();
            mapper.put("id", costCenter.getId());
            mapper.put("name", costCenter.getName());
            mapper.put("description", costCenter.getDescription());

            mappers.add(mapper);
        }

        wrapper.put("head", headers);
        wrapper.put("data", mappers);
        wrapper.put("pos", 0);
        wrapper.put("total_count", costCenters.size());

        return wrapper;
    }

    @Override
    public List<Map<String, Object>> initShowList() {
        return null;
    }
}

