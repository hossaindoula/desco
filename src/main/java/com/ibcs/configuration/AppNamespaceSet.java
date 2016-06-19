package com.ibcs.configuration;

import com.google.common.collect.Iterables;
import com.ibcs.AppConstants;
import com.ibcs.util.ClassFinder;
import org.apache.commons.collections.IteratorUtils;

import java.util.Iterator;
import java.util.List;

/**
 * For Application packages
 * Created by hossain.doula on 5/15/2016.
 */
public interface AppNamespaceSet {

    String SECURITY_MODULE = "security";
    String PROCUREMENT_MODULE = "procurement";
    String CONTRACTOR_MODULE = "contractor";
    String CENTRAL_STORE_MODULE = "cs";
    String SUB_STORE_MODULE = "ss";
    String LOCAL_STORE_MODULE = "ls";
    String INVENTORY_MODULE = "inventory";
    String COMMON_MODULE = "common";
    String ADMIN_MODULE = "admin";
    String FINANCIAL_MODULE = "finance";
    String ORG_MODULE = "organization";

    String SECURITY_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(SECURITY_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);
    String PROCUREMENT_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(PROCUREMENT_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);
    String CONTRACTOR_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(CONTRACTOR_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);
    String CENTRAL_STORE_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(CENTRAL_STORE_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);
    String SUB_STORE_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(SUB_STORE_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);
    String LOCAL_STORE_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(LOCAL_STORE_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);
    String INVENTORY_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(INVENTORY_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);
    String COMMON_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(COMMON_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);
    String ADMIN_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(ADMIN_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);
    String FINANCIAL_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(FINANCIAL_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);
    String ORG_MODEL_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(ORG_MODULE)
            .concat(".").concat(AppConstants.MODEL_STUB);

    String[] MODEL_NS = {
            SECURITY_MODEL_PKG,/*,
            ADMIN_MODEL_PKG,
            CENTRAL_STORE_MODEL_PKG,
            SUB_STORE_MODEL_PKG,
            LOCAL_STORE_MODEL_PKG,
            COMMON_MODEL_PKG,
            CONTRACTOR_MODEL_PKG,
            INVENTORY_MODEL_PKG,*/
            FINANCIAL_MODEL_PKG/*,
            PROCUREMENT_MODEL_PKG,
            ORG_MODEL_PKG*/
    };

    /*String SECURITY_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(SECURITY_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);
    String PROCUREMENT_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(PROCUREMENT_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);
    String CONTRACTOR_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(CONTRACTOR_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);
    String CENTRAL_STORE_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(CENTRAL_STORE_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);
    String SUB_STORE_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(SUB_STORE_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);
    String LOCAL_STORE_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(LOCAL_STORE_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);
    String INVENTORY_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(INVENTORY_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);
    String COMMON_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(COMMON_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);
    String ADMIN_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(ADMIN_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);
    String FINANCIAL_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(FINANCIAL_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);
    String ORG_PROXY_INTERFACES_PKG = AppConstants.BASE_NAME_SPACE.concat(".").concat(ORG_MODULE)
            .concat(".").concat(AppConstants.DAO_STUB);

    String[] PROXY_NS = {
            SECURITY_PROXY_INTERFACES_PKG,
            PROCUREMENT_PROXY_INTERFACES_PKG,
            CONTRACTOR_PROXY_INTERFACES_PKG,
            CENTRAL_STORE_PROXY_INTERFACES_PKG,
            SUB_STORE_PROXY_INTERFACES_PKG,
            LOCAL_STORE_PROXY_INTERFACES_PKG,
            INVENTORY_PROXY_INTERFACES_PKG,
            COMMON_PROXY_INTERFACES_PKG,
            ADMIN_PROXY_INTERFACES_PKG,
            FINANCIAL_PROXY_INTERFACES_PKG,
            ORG_PROXY_INTERFACES_PKG
    };

    List<Class<?>> classesSecurity = ClassFinder.find(SECURITY_PROXY_INTERFACES_PKG);
    List<Class<?>> classesProcurement = ClassFinder.find(PROCUREMENT_PROXY_INTERFACES_PKG);
    List<Class<?>> classesContractor = ClassFinder.find(CONTRACTOR_PROXY_INTERFACES_PKG);
    List<Class<?>> classesCentralStore = ClassFinder.find(CENTRAL_STORE_PROXY_INTERFACES_PKG);
    List<Class<?>> classesSubStore = ClassFinder.find(SUB_STORE_PROXY_INTERFACES_PKG);
    List<Class<?>> classesLocalStore = ClassFinder.find(LOCAL_STORE_PROXY_INTERFACES_PKG);
    List<Class<?>> classesInventory = ClassFinder.find(INVENTORY_PROXY_INTERFACES_PKG);
    List<Class<?>> classesCommon = ClassFinder.find(COMMON_PROXY_INTERFACES_PKG);
    //List<Class<?>> classesAdmin = ClassFinder.find(ADMIN_PROXY_INTERFACES_PKG);
    List<Class<?>> classesFinancial = ClassFinder.find(FINANCIAL_PROXY_INTERFACES_PKG);
    List<Class<?>> classesOrganization = ClassFinder.find(ORG_PROXY_INTERFACES_PKG);

    Iterable allProxyPackages = Iterables.concat(classesSecurity,classesProcurement,classesContractor,
            classesCentralStore,classesSubStore,classesLocalStore,classesInventory,classesCommon,
            classesFinancial,classesOrganization);

    Iterator allProxyPackage = allProxyPackages.iterator();

    List<Class<?>> allProxyPackageList = IteratorUtils.toList(allProxyPackage);

    Class[] classes = classesSecurity.toArray(new Class[allProxyPackageList.size()]);*/

    String[] interceptors = {"finderIntroductionAdvisor"};


}
