package com.ibcs.base.manager;

/**
 * * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Created by hossain.doula on 5/16/2016.
 */
public interface AuthViewManager {

    StringBuilder prepareCreateToolbarGrid(String title,String iconCls,String location);

    StringBuilder prepareAuthorityAssignmentToolbarGrid(String title,String iconCls,String location);

    StringBuilder editRenderer(String title,String iconCls,String location);

    StringBuilder showRenderer(String title, String location, String imageLocation);

    StringBuilder deleteRenderer(String title, String location,String imageLocation);

    StringBuilder approveRenderer(String title,String iconCls,String location);

    StringBuilder rejectRenderer(String title,String iconCls,String location);

}
