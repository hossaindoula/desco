package com.ibcs.finance.view.manager;

import com.ibcs.base.view.BaseViewManager;
import com.ibcs.finance.model.CostAllocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */
public class CostAllocationViewManager extends BaseViewManager {

    private static CostAllocationViewManager instance = null;

    public static CostAllocationViewManager getInstance() {
        instance = new CostAllocationViewManager();

        return instance;
    }

    @Override
    public List<Map<String, Object>> initFormList() {
        List<Map<String,Object>> metaList = new ArrayList<Map<String, Object>>();
        Map<String,Object> meta = new HashMap<String, Object>();
        meta.put("type", "text");
        meta.put("id", "code");
        meta.put("label", "Code");
        meta.put("placeholder", "Code");
        metaList.add(meta);

        meta = new HashMap<String, Object>();
        meta.put("type", "number");
        meta.put("id", "quantity");
        meta.put("label", "Quantity");
        meta.put("placeholder", "2000");
        metaList.add(meta);

        meta = new HashMap<String, Object>();
        meta.put("type", "text");
        meta.put("id", "uom");
        meta.put("label", "Unit of Measurement");
        meta.put("placeholder", "Unit of Measurement");
        metaList.add(meta);

        meta = new HashMap<String, Object>();
        meta.put("type", "number");
        meta.put("id", "rate");
        meta.put("label", "Rate");
        meta.put("placeholder", "2000");
        metaList.add(meta);

        meta = new HashMap<String, Object>();
        meta.put("type", "number");
        meta.put("id", "amount");
        meta.put("label", "Amount");
        meta.put("placeholder", "2000");
        metaList.add(meta);

        return metaList;
    }

    @Override
    public Map<String, Object> initItemList(Object object) {
        List<CostAllocation> costAllocations = (List<CostAllocation>)object;

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
        header.put("id", "code");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "str");
        header.put("value", "Code");
        headers.add(header);

        header = new HashMap<String, Object>();
        header.put("id", "uom");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "str");
        header.put("value", "Unit of Measurement");
        headers.add(header);

        header = new HashMap<String, Object>();
        header.put("id", "quantity");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "int");
        header.put("value", "Quantity");
        headers.add(header);

        header = new HashMap<String, Object>();
        header.put("id", "rate");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "int");
        header.put("value", "Rate");
        headers.add(header);

        header = new HashMap<String, Object>();
        header.put("id", "amount");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "int");
        header.put("value", "Amount");
        headers.add(header);

        Map<String,Object> mapper;



        for(CostAllocation costAllocation : costAllocations){
            mapper = new HashMap<String, Object>();
            mapper.put("id", costAllocation.getId());
            mapper.put("code", costAllocation.getCode());
            mapper.put("uom", costAllocation.getUom());
            mapper.put("quantity", costAllocation.getQuantity());
            mapper.put("rate", costAllocation.getRate());
            mapper.put("amount", costAllocation.getAmount());

            mappers.add(mapper);
        }

        wrapper.put("head", headers);
        wrapper.put("data", mappers);
        wrapper.put("pos", 0);
        wrapper.put("total_count", costAllocations.size());

        return wrapper;
    }

    @Override
    public List<Map<String, Object>> initShowList() {
        return null;
    }
}
