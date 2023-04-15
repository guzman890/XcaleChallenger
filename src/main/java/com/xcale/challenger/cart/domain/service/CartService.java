package com.xcale.challenger.cart.domain.service;

import com.xcale.challenger.cart.persistence.entity.Cart;
import reactor.core.publisher.Mono;

public interface CartService {
    Mono<Cart> get(int idCart);
    Mono<Cart> save(Cart cart);
    Mono<Cart> update(int idCart, Cart cart);
    Mono<Boolean> delete(int idCart);
}
