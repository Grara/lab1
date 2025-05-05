package com.lab1;


import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Expiry;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        List<CaffeineCache> caches = List.of(new CaffeineCache("menu", Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES).build()));
        /*
        List<CaffeineCache> caches = Arrays.stream(CacheType.values())
            .map(cache -> new CaffeineCache(cache.getCacheName(), Caffeine.newBuilder().recordStats()
                            .expireAfterWrite(cache.getExpiredAfterWrite(), TimeUnit.SECONDS)
                            .maximumSize(cache.getMaximumSize())
                            .build()
                    )
            )
            .collect(Collectors.toList());
         */
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
