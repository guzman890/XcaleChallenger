package com.xcale.challenger.cart.config;

import com.xcale.challenger.cart.persistence.entity.Cart;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;


@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        LettuceConnectionFactory lcf = new LettuceConnectionFactory();
        lcf.setHostName("localhost");
        lcf.setPort(6379);

        lcf.afterPropertiesSet();
        return lcf;
    }

    public RedisTemplate<String, Cart> redisTemplate() {
        RedisTemplate<String, Cart> redisTemplate = new RedisTemplate<String ,Cart>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.expire("Cart",60L, TimeUnit.SECONDS);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
