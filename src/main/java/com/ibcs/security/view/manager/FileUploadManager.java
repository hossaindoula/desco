package com.ibcs.security.view.manager;

import com.ibcs.base.view.BaseViewManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dell on 6/18/2016.
 */
public class FileUploadManager extends BaseViewManager {

    @Override
    public List<Map<String, Object>> initFormList() {
        List<Map<String,Object>> metaList = new ArrayList<Map<String, Object>>();
        Map<String,Object> meta = new HashMap<String, Object>();
        meta.put("type", FILE_UPLOAD_INPUT);
        meta.put("id", "file");
        meta.put("label", "File");
        meta.put("placeholder", "file");
        meta.put("required", true);
        metaList.add(meta);

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
