package com.xcale.challenger.cart.domain.service.impl;

import com.xcale.challenger.cart.domain.repository.CartRepository;
import com.xcale.challenger.cart.domain.service.CartService;
import com.xcale.challenger.cart.persistence.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Override
    public Mono<Cart> get(int idCart) {
        return Mono.just(cartRepository.getCart(idCart));
    }
    @Override
    public Mono<Cart> save(Cart cart) {
        Cart cartRD = cartRepository.getCart(cart.getId());
        if( Objects.nonNull(cartRD) )
            return Mono.empty();
        return Mono.just(cartRepository.saveCart(cart));
    }

    @Override
    public Mono<Cart> update(int idCart, Cart cart) {
        Cart cartRD = cartRepository.getCart(idCart);
        if( Objects.isNull(cartRD) )
            return Mono.empty();
        cartRD.setProducts(cart.getProducts());
        return Mono.just(cartRepository.updateCart(cartRD));
    }

    @Override
    public Mono<Boolean> delete(int idCart) {
        Cart cartRD = cartRepository.getCart(idCart);
        if( Objects.isNull(cartRD) )
            return Mono.empty();
        cartRepository.deleteCart(idCart);
        return Mono.just(Boolean.TRUE);
    }
}
