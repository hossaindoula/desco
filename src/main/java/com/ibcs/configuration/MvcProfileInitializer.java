package com.ibcs.configuration;

import com.google.common.collect.Lists;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hossain.doula on 5/19/2016.
 */
public class MvcProfileInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public void initialize(ConfigurableApplicationContext ctx) {
        ConfigurableEnvironment environment = ctx.getEnvironment();
        List<String> profiles = new ArrayList<String>(getProfiles());
        if( profiles == null || profiles.isEmpty()){
            throw new IllegalArgumentException("Profiles have not been configured");
        }
        environment.setActiveProfiles(profiles.toArray( new String[0]));
    }

    private Collection<String> getProfiles() {
        return Lists.newArrayList("file_based", "test_data");
    }

}
