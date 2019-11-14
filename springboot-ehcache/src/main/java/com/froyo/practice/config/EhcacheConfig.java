package com.froyo.practice.config;

import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
@EnableCaching
public class EhcacheConfig extends CachingConfigurerSupport {

    @Bean
    public KeyGenerator multiplyKeyGenerator() {
        return (Object target, Method method, Object... params) -> method.getName() + "_" + Arrays.toString(params);
    }

    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration tenSecondCache = new CacheConfiguration();
        tenSecondCache.setName("ten-second-cache");
        tenSecondCache.setMemoryStoreEvictionPolicy("LRU");
        tenSecondCache.setMaxEntriesLocalHeap(1000);
        tenSecondCache.setTimeToLiveSeconds(10);

        CacheConfiguration twentySecondCache = new CacheConfiguration();
        twentySecondCache.setName("twenty-second-cache");
        twentySecondCache.setMemoryStoreEvictionPolicy("LRU");
        twentySecondCache.setMaxEntriesLocalHeap(1000);
        twentySecondCache.setTimeToLiveSeconds(20);

        CacheConfiguration tenMinutesCache = new CacheConfiguration();
        tenMinutesCache.setName("ten-minutes-cache");
        tenMinutesCache.setMemoryStoreEvictionPolicy("LRU");
        tenMinutesCache.setMaxEntriesLocalHeap(1000);
        tenMinutesCache.setTimeToLiveSeconds(600);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(tenSecondCache);
        config.addCache(twentySecondCache);
        config.addCache(tenMinutesCache);
        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

}
