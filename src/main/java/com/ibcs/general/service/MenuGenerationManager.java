package com.ibcs.general.service;

import com.ibcs.general.model.Module;
import com.ibcs.general.model.ModuleGroup;

import java.util.List;

/**
 * Created by hossain.doula on 5/22/2016.
 */
public interface MenuGenerationManager {

    Module generateMenu();

    ModuleGroup generateMenuGroup();

}
