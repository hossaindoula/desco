package com.ibcs.base.manager;

import org.springframework.stereotype.Service;

/**
 * * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Created by hossain.doula on 5/16/2016.
 */

@Service("authViewManager")
public class AuthViewManagerImpl implements AuthViewManager {


    public StringBuilder prepareCreateToolbarGrid(String title, String iconCls, String location) {
        return null;
    }

    public StringBuilder prepareAuthorityAssignmentToolbarGrid(String title, String iconCls, String location) {
        return null;
    }

    public StringBuilder editRenderer(String title, String iconCls, String location) {
        return null;
    }

    public StringBuilder showRenderer(String title, String location, String imageLocation) {
        return null;
    }

    public StringBuilder deleteRenderer(String title, String location, String imageLocation) {
        return null;
    }

    public StringBuilder approveRenderer(String title, String iconCls, String location) {
        return null;
    }

    public StringBuilder rejectRenderer(String title, String iconCls, String location) {
        return null;
    }
}
