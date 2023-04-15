package com.xcale.challenger.cart.domain.service.impl;

import com.xcale.challenger.cart.domain.repository.ProductRepository;
import com.xcale.challenger.cart.domain.service.ProductService;
import com.xcale.challenger.cart.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Flux<Product> getAll() {
        return productRepository.getAll();
    }
    @Override
    public Mono<Product> getProduct(int idProduct) {
        return productRepository.get(idProduct);
    }
    @Override
    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(int idProduct, Product product) {
        return productRepository.update(idProduct,product);
    }
    @Override
    public Mono<Void> delete(int idProduct) {
        return productRepository.delete(idProduct);
    }
}
