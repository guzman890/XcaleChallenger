package com.xcale.challenger.cart.domain.repository.impl;

import com.xcale.challenger.cart.domain.repository.CartRepository;
import com.xcale.challenger.cart.persistence.crud.CartCrudRepository;
import com.xcale.challenger.cart.persistence.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CartRepositoryImpl implements CartRepository {
    @Autowired
    private CartCrudRepository cartCrudRepository;

    @Override
    public Flux<Cart> getAll() {
        return cartCrudRepository.findAll();
    }

    @Override
    public Mono<Cart> get(int id) {
        return cartCrudRepository.findById(id);
    }
    @Override
    public Mono<Cart> save(Cart cart) {
        return cartCrudRepository.save(cart);
    }
    @Override
    public Mono<Cart> update(int id, Cart cart) {
        return cartCrudRepository.findById(id)
                .flatMap(dbCart -> {
                    return cartCrudRepository.save(dbCart);
                });
    }
    @Override
    public Mono<Void> delete(int id) {
        return cartCrudRepository.findById(id)
                .flatMap(existingCart -> cartCrudRepository.delete(existingCart));
    }
}
