package com.xcale.challenger.cart.domain.service;

import com.xcale.challenger.cart.persistence.entity.Cart;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartService {
    Flux<Cart> getAll();
    Mono<Cart> get(int idCart);
    Mono<Cart> save(Cart cart);
    Mono<Cart> update(int idCart, Cart cart);
    Mono<Void> delete(int idCart);
}
