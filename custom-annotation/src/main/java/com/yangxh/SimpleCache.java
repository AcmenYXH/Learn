package com.yangxh;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 简单缓存设计
 * @Author yangxh8
 * @Date 2024/5/10 20:33
 */
public class SimpleCache {
    private Map<String, Long> cache;
    private long defaultTimeout = 60 * 60 * 1000;

    public SimpleCache() {
        cache = new HashMap<>();
    }
    public SimpleCache(long timeout) {
        cache = new HashMap<>();
        this.defaultTimeout = timeout;
    }

    public void setDefaultTimeout(long timeout) {
        this.defaultTimeout = timeout;
    }

    public void put(String key, Long value) throws Exception {
        if (key == null || value == null) {
            throw new Exception("Key or value为空");
        }
        cache.put(key, value);
        cache.put(key + "_ex", System.currentTimeMillis() + defaultTimeout);
    }

    public Object get(String key) throws Exception {
        if (key == null) {
            throw new Exception("Key 不存在！");
        }
        Long expireTime = cache.get(key + "_ex");
        if (expireTime != null && System.currentTimeMillis() > expireTime) {
            cache.remove(key);
            return null;
        } else {
            return cache.get(key);
        }
    }

    public void remove(String key) throws Exception {
        if (key == null) {
            throw new Exception("key 不存在！");
        }
        cache.remove(key);
        cache.remove(key + "_ex");
    }
}
