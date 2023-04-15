package com.xcale.challenger.cart.domain.service;


import com.xcale.challenger.cart.persistence.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> getAll();
    Mono<Product> getProduct(int idProduct);
    Mono<Product> save(Product product);
    Mono<Product> update(int idProduct, Product product);
    Mono<Void> delete(int idProduct);
}
