package com.yundasys.beidou.dipper.common.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis序列化方式更改为ProtoStuff
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Object, Object> protoStuffTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // redis value使用的序列化器
        template.setValueSerializer(new ProtostuffSerializer());
        // redis key使用的序列化器
        template.setKeySerializer(new StringRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }
}