package com.xcale.challenger.cart.controller;

import com.xcale.challenger.cart.domain.service.ProductService;
import com.xcale.challenger.cart.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<Product> getProducts(){
        return productService.getAll();

    }
    @GetMapping("/{idProduct}")
    public Mono<ResponseEntity<Product>> getProduct( @PathVariable("idProduct") int idProduct){
        return productService.getProduct(idProduct)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Product>> save( @RequestBody Product product){
        return productService.save(product)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{idProduct}")
    public Mono<ResponseEntity<Product>> update(
            @PathVariable("idProduct") int idProduct,
            @RequestBody Product product){
        return productService.update(idProduct,product)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{idProduct}")
    public Mono<ResponseEntity<Void>> delete( @PathVariable("idProduct") int idProduct){
        return productService.delete(idProduct)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.notFound().build());
    }
}
