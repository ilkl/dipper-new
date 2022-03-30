package com.yundasys.beidou.dipper.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Redis缓存dao
 */
@Component
@SuppressWarnings("unchecked")
public class RedisCache {

    private final RedisTemplate protoStuffTemplate;

    @Autowired
    public RedisCache(RedisTemplate protoStuffTemplate) {
        this.protoStuffTemplate = protoStuffTemplate;
    }

    /**
     * 设置过期时间，单位秒
     *
     * @param key     键的名称
     * @param timeout 过期时间
     * @return 成功：true，失败：false
     */
    public boolean setExpireTime(String key, long timeout) {
        return Optional
                .ofNullable(protoStuffTemplate.expire(key, timeout, TimeUnit.SECONDS))
                .orElse(Boolean.FALSE);
    }

    /**
     * 通过键删除一个值
     *
     * @param key 键的名称
     */
    public boolean delete(String key) {
        return protoStuffTemplate.delete(key);
    }

    /**
     * 判断key是否存在
     *
     * @param key 键的名称
     * @return 存在：true，不存在：false
     */
    public boolean hasKey(String key) {
        return Optional
                .ofNullable(protoStuffTemplate.hasKey(key))
                .orElse(Boolean.FALSE);
    }

    /**
     * 数据存储
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, Object value) {
        protoStuffTemplate.boundValueOps(key).set(value);
    }

    /**
     * 数据存储的同时设置过期时间
     *
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间（秒）
     */
    public void set(String key, Object value, Long expireTime) {
        protoStuffTemplate.boundValueOps(key).set(value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 数据取值
     *
     * @param key 键
     * @return 查询成功：值，查询失败，null
     */
    public <T> T get(String key) {
        return (T) protoStuffTemplate.boundValueOps(key).get();
    }
}
