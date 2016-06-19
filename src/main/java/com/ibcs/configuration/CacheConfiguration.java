package com.ibcs.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hossain.doula on 5/26/2016.
 */

@EnableCaching
@Configuration
public class CacheConfiguration {

    @Bean(name = "cacheManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("entities");
    }
}
