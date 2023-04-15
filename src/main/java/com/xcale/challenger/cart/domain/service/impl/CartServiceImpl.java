package com.xcale.challenger.cart.domain.service.impl;

import com.xcale.challenger.cart.domain.repository.CartRepository;
import com.xcale.challenger.cart.domain.service.CartService;
import com.xcale.challenger.cart.persistence.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Override
    public Flux<Cart> getAll() {
        return cartRepository.getAll();
    }
    @Override
    public Mono<Cart> get(int idCart) {
        return cartRepository.get(idCart);
    }
    @Override
    public Mono<Cart> save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Mono<Cart> update(int idCart, Cart cart) {
        return cartRepository.update(idCart,cart);
    }

    @Override
    public Mono<Void> delete(int idCart) {
        return cartRepository.delete(idCart);
    }
}
