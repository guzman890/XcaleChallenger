package com.xcale.challenger.cart.domain.repository.impl;

import com.xcale.challenger.cart.domain.repository.ProductRepository;
import com.xcale.challenger.cart.persistence.crud.ProductCrudRepository;
import com.xcale.challenger.cart.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Override
    public Flux<Product> getAll() {
        return productCrudRepository.findAll()
                .flatMap( product -> Mono.just(product));

    }

    @Override
    public Mono<Product> get(int id) {
        return productCrudRepository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        return productCrudRepository.save(product);
    }
    @Override
    public Mono<Product> update(int id, Product product){
        return productCrudRepository.findById(id)
                .flatMap(dbProduct -> {
                    dbProduct.setDescription(product.getDescription());
                    dbProduct.setAmount(product.getAmount());
                    return productCrudRepository.save(dbProduct);
                });
    }
    @Override
    public Mono<Void> delete(int id) {
        return productCrudRepository.findById(id)
                .flatMap(existingProduct -> productCrudRepository.delete(existingProduct));
    }
}
