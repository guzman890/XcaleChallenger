package com.xcale.challenger.cart.domain.repository.impl;

import com.xcale.challenger.cart.domain.repository.CartRepository;
import com.xcale.challenger.cart.persistence.entity.Cart;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Repository
public class CartRepositoryImpl implements CartRepository {
    private final String hashReference= "Cart";

    @Resource(name="redisTemplate")
    private HashOperations<String, Integer, Cart> hashOperations;

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Cart saveCart(Cart cart) {
        redisTemplate.opsForHash().putIfAbsent(hashReference+cart.getId(),cart.getId(),cart);
        redisTemplate.expire(hashReference+cart.getId(),60, TimeUnit.SECONDS);
        return cart;
    }
    @Override
    public Cart getCart(Integer id) {
        return hashOperations.get(hashReference+id, id);
    }
    @Override
    public Cart updateCart(Cart cart) {
        redisTemplate.opsForHash().put(hashReference+cart.getId(), cart.getId(), cart);
        redisTemplate.expire(hashReference+cart.getId(),60, TimeUnit.SECONDS);
        return cart;
    }
    @Override
    public Void deleteCart(Integer id) {
        hashOperations.delete(hashReference+id, id);
        return null;
    }


}
