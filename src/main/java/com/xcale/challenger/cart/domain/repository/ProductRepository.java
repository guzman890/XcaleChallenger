package com.xcale.challenger.cart.domain.repository;

import com.xcale.challenger.cart.persistence.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Flux<Product> getAll();
    Mono<Product> get(int id);
    Mono<Product> save(Product product);
    Mono<Product> update(int id, Product product);
    Mono<Void>  delete(int id);
}
