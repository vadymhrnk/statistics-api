package com.example.statisticsapi.config.cache;

import java.util.List;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

@Component
public class SimpleCacheCustomizer
        implements CacheManagerCustomizer<ConcurrentMapCacheManager> {
    public static final String REPORT_CACHE = "reportCache";

    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setCacheNames(List.of(REPORT_CACHE));
    }
}
