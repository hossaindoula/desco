package com.ibcs.security.view.manager;

import com.ibcs.base.view.BaseViewManager;
import com.ibcs.configuration.AppConfiguration;
import com.ibcs.security.dto.UserBean;
import com.ibcs.security.model.Authority;
import com.ibcs.security.model.User;
import com.ibcs.security.service.UserDetailsService;
import com.ibcs.security.service.UserDetailsServiceImpl;
import com.ibcs.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/2/2016.
 */

public class UserViewManager extends BaseViewManager {

    private static UserViewManager instance = null;

    public static UserViewManager getInstance() {
        instance = new UserViewManager();

        return instance;
    }

    private UserViewManager() {
    }

    @Override
    public List<Map<String, Object>> initFormList() {
        List<Map<String,Object>> metaList = new ArrayList<Map<String, Object>>();
        Map<String,Object> meta = new HashMap<String, Object>();
        meta.put("type", TEXT_INPUT);
        meta.put("id", "username");
        meta.put("label", "Username");
        meta.put("placeholder", "Username");
        meta.put("required", true);
        metaList.add(meta);

        meta = new HashMap<String, Object>();
        meta.put("type", PASSWORD_INPUT);
        meta.put("id", "password");
        meta.put("label", "Password");
        meta.put("required", true);
        metaList.add(meta);

        meta = new HashMap<String, Object>();
        meta.put("type", PASSWORD_INPUT);
        meta.put("id", "confirmPassword");
        meta.put("label", "Confirm Password");
        meta.put("required", true);
        metaList.add(meta);

        meta = new HashMap<String, Object>();
        meta.put("type", EMAIL_INPUT);
        meta.put("id", "email");
        meta.put("label", "Email");
        meta.put("required", true);
        metaList.add(meta);

        System.out.println("metaList = " + metaList);

        return metaList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String,Object> initItemList(Object object){
        List<UserBean> users = (List<UserBean>)object;

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
        header.put("id", "username");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "str");
        header.put("value", "Username");
        headers.add(header);

        header = new HashMap<String, Object>();
        header.put("id", "password");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "str");
        header.put("value", "Password");
        headers.add(header);

        header = new HashMap<String, Object>();
        header.put("id", "active");
        header.put("width", 100);
        header.put("type", "ed");
        header.put("align", "right");
        header.put("sort", "str");
        header.put("value", "Active");
        headers.add(header);

        Map<String,Object> mapper;



        for(UserBean user : users){
            mapper = new HashMap<String, Object>();
            mapper.put("id", user.getId());
            mapper.put("username", user.getUsername());
            mapper.put("password", user.getPassword());
            mapper.put("email", user.getEmail());

            mappers.add(mapper);
        }

        wrapper.put("head", headers);
        wrapper.put("data", mappers);
        wrapper.put("pos", 0);
        wrapper.put("total_count", users.size());

        return wrapper;
    }

    @Override
    public List<Map<String, Object>> initShowList() {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String,Object> initAssignmentList(Map<String,Object> assignments){

        String unmapperName = assignments.get("UnmapperName").toString();
        String mapperName = assignments.get("MapperName").toString();
        List<Authority> unmappedAuthorities = (List<Authority>) assignments.get("unmappers");
        List<Authority> mappedAuthorities = (List<Authority>) assignments.get("mappers");
        Map<String,Object> assignmentModel = new HashMap<String, Object>();

        assignmentModel.put("UnmapperName", unmapperName);
        assignmentModel.put("MapperName", mapperName);
        assignmentModel.put("unmappers", unmappedAuthorities);
        assignmentModel.put("mappers", mappedAuthorities);

        return assignmentModel;
    }

    @SuppressWarnings("unchecked")
    public Map<String,Object> initGroupAssignmentList(Map<String,Object> assignments){
        Map<String,Object> unmapperName = (Map<String,Object>)assignments.get("unmapperName");
        Map<String,Object> mapperName = (Map<String,Object>)assignments.get("mapperName");
        List<Authority> unmappedAuthorities = (List<Authority>) assignments.get("unmappedAuthorities");
        List<Authority> mappedAuthorities = (List<Authority>) assignments.get("mappedAuthorities");
        Map<String,Object> assignmentModel = new HashMap<String, Object>();

        assignmentModel.put("UnmapperName", unmapperName);
        assignmentModel.put("MapperName", mapperName);
        assignmentModel.put("unmappers", unmappedAuthorities);
        assignmentModel.put("mappers", mappedAuthorities);

        return assignmentModel;
    }

    /*private ApplicationContext applicationContext;

    public void afterPropertiesSet() throws Exception {
        userDetailsService = (UserDetailsService) applicationContext.getBean("userDetailsService");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }*/
}
