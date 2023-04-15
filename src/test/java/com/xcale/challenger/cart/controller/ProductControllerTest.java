package com.xcale.challenger.cart.controller;

import com.xcale.challenger.cart.domain.service.ProductService;
import com.xcale.challenger.cart.persistence.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;
    @Test
    void getProductsTest() {
        Product product= new Product();
        product.setId(1);
        product.setAmount(1);
        product.setDescription("1");
        when(productService.getAll()).thenReturn(Flux.just(product));

        Flux<Product> products =productController.getProducts();
        assertEquals(product.getId(), products.blockFirst().getId());
    }

    @Test
    void getProduct() {
        Product product= new Product();
        product.setId(1);
        product.setAmount(1);
        product.setDescription("1");
        when(productService.getProduct(anyInt())).thenReturn(Mono.just(product));

        Mono<ResponseEntity<Product>> productEntity =productController.getProduct(1);
        assertEquals(product.getId(), productEntity.block().getBody().getId());
    }

    @Test
    void save() {
        Product productReturned= new Product();
        productReturned.setId(2);
        productReturned.setAmount(2);
        productReturned.setDescription("description 1");
        when(productService.save(any(Product.class))).thenReturn(Mono.just(productReturned));

        Product product= new Product();
        product.setAmount(2);
        product.setDescription("description 1");
        Mono<ResponseEntity<Product>> productEntity =productController.save(product);
        assertEquals(productReturned.getId(), productEntity.block().getBody().getId());
    }

    @Test
    void update() {
        Product productReturned= new Product();
        productReturned.setId(2);
        productReturned.setAmount(2);
        productReturned.setDescription("description 1");
        when(productService.update(anyInt(),any(Product.class))).thenReturn(Mono.just(productReturned));

        Product product= new Product();
        product.setAmount(2);
        product.setDescription("description 1");
        Mono<ResponseEntity<Product>> productEntity =productController.update(2,product);
    }

    @Test
    void delete() {

        when(productService.delete(anyInt())).thenReturn(Mono.empty().then());

        productController.delete(2).block();
    }
}