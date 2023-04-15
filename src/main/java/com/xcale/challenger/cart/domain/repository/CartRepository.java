package com.xcale.challenger.cart.domain.repository;

import com.xcale.challenger.cart.persistence.entity.Cart;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface CartRepository {
    Cart saveCart(Cart cart);
    Cart getCart(Integer id);
    Cart updateCart(Cart cart);
    Void deleteCart(Integer id);
}
