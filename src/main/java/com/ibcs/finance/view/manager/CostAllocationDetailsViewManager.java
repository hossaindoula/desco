package com.ibcs.finance.view.manager;

import com.ibcs.base.view.BaseViewManager;
import com.ibcs.finance.model.CostAllocation;
import com.ibcs.finance.model.CostAllocationDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/9/2016.
 */
public class CostAllocationDetailsViewManager extends BaseViewManager {

    private static CostAllocationDetailsViewManager instance = null;

    public static CostAllocationDetailsViewManager getInstance() {
        instance = new CostAllocationDetailsViewManager();

        return instance;
    }

    @Override
    public List<Map<String, Object>> initFormList() {
        List<Map<String,Object>> metaList = new ArrayList<Map<String, Object>>();
        Map<String,Object> meta = new HashMap<String, Object>();
        meta.put("type", "particulars");
        meta.put("id", "particulars");
        meta.put("label", "Particulars");
        meta.put("placeholder", "particulars");
        metaList.add(meta);

        meta = new HashMap<String, Object>();
        meta.put("type", "amount");
        meta.put("id", "amount");
        meta.put("label", "Amount");
        meta.put("placeholder", "2000");
        metaList.add(meta);

        return metaList;
    }

    @Override
    public Map<String, Object> initItemList(Object object) {
        List<CostAllocationDetails> costAllocationDetailsLists = (List<CostAllocationDetails>)object;

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
        header.put("id", "particulars");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "str");
        header.put("value", "Particulars");
        headers.add(header);

        header = new HashMap<String, Object>();
        header.put("id", "amount");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "str");
        header.put("value", "Amount");
        headers.add(header);

        Map<String,Object> mapper;



        for(CostAllocationDetails costAllocationDetails : costAllocationDetailsLists){
            mapper = new HashMap<String, Object>();
            mapper.put("id", costAllocationDetails.getId());
            mapper.put("particulars", costAllocationDetails.getParticulars());
            mapper.put("amount", costAllocationDetails.getAmount());

            mappers.add(mapper);
        }

        wrapper.put("head", headers);
        wrapper.put("data", mappers);
        wrapper.put("pos", 0);
        wrapper.put("total_count", costAllocationDetailsLists.size());

        return wrapper;
    }

    @Override
    public List<Map<String, Object>> initShowList() {
        return null;
    }
}
