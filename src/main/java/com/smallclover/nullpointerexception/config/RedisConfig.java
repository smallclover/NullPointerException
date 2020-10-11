package com.smallclover.nullpointerexception.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

/**
 * redis缓存配置
 * @Author: Amadeus
 * @Date: 2020/2/16 18:29
 */
@Configuration
@EnableCaching//开启缓存
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
        var template = new RedisTemplate<String, Object>();

        template.setConnectionFactory(factory);
        template.setKeySerializer(keySerializer());
        template.setValueSerializer(valueSerializer());

        template.setHashKeySerializer(keySerializer());
        template.setHashValueSerializer(valueSerializer());

        return template;
    }

    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory){
        // 缓存对象配置
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        // 这里不重新赋值仍然会采用默认的jdk序列化方式
        redisCacheConfiguration = redisCacheConfiguration.entryTtl(Duration.ofDays(1))
                .disableCachingNullValues() // 如果是null不缓存
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))//设置key序列化器
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()));//设置value序列化器

        return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }

    /**
     * key 的序列化方式
     * @return
     */
    private RedisSerializer<String> keySerializer(){
        return new StringRedisSerializer();
    }

    /**
     * value的序列化方式
     * @return
     */
    private RedisSerializer<Object> valueSerializer(){
        return new GenericJackson2JsonRedisSerializer();
    }
}
