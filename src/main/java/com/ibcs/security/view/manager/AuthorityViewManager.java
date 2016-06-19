package com.ibcs.security.view.manager;

import com.ibcs.base.view.BaseViewManager;
import com.ibcs.security.dto.AuthorityBean;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/2/2016.
 */

public class AuthorityViewManager extends BaseViewManager {

    public AuthorityViewManager(){
    }

    @Override
    public List<Map<String, Object>> initFormList() {
        List<Map<String,Object>> metaList = new ArrayList<Map<String, Object>>();
        Map<String,Object> meta = new HashMap<String, Object>();
        meta.put("type", TEXT_INPUT);
        meta.put("id", "name");
        meta.put("label", "Authority Name");
        meta.put("placeholder", "Authority Name");
        meta.put("required", true);
        metaList.add(meta);

        meta = new HashMap<String, Object>();
        meta.put("type", TEXT_AREA_INPUT);
        meta.put("id", "description");
        meta.put("label", "Description");
        meta.put("required", false);
        metaList.add(meta);

        return metaList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String,Object> initItemList(Object object){
        List<AuthorityBean> authorities = (List<AuthorityBean>)object;

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



        for(AuthorityBean authority : authorities){
            mapper = new HashMap<String, Object>();
            mapper.put("id", authority.getId());
            mapper.put("name", authority.getName());
            mapper.put("description", authority.getDescription());

            mappers.add(mapper);
        }

        wrapper.put("head", headers);
        wrapper.put("data", mappers);
        wrapper.put("pos", 0);
        wrapper.put("total_count", authorities.size());

        return wrapper;
    }

    @Override
    public List<Map<String, Object>> initShowList() {
        return null;
    }

    /*private ApplicationContext applicationContext;

    public void afterPropertiesSet() throws Exception {
        userDetailsService = (UserDetailsService) applicationContext.getBean("userDetailsService");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }*/
}
