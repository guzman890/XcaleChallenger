package com.xcale.challenger.cart.domain.repository;

import com.xcale.challenger.cart.persistence.entity.Cart;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CartRepository {
    Flux<Cart> getAll();
    Mono<Cart> get(int id);
    Mono<Cart> save(Cart cart);
    Mono<Cart> update(int id,  Cart cart);
    Mono<Void>  delete(int id);
}
