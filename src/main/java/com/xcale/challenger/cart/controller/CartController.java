package com.xcale.challenger.cart.controller;

import com.xcale.challenger.cart.domain.service.CartService;
import com.xcale.challenger.cart.persistence.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/")
    public Flux<Cart> getProduct(){
        return cartService.getAll();

    }

    @GetMapping("/{idCart}")
    public Mono<ResponseEntity<Cart>> getProduct(@PathVariable("idCart") int idCart){
        return cartService.get(idCart)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public Mono<ResponseEntity<Cart>> save( @RequestBody Cart Cart){
        return cartService.save(Cart)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{idCart}")
    public Mono<ResponseEntity<Cart>> update(
            @PathVariable("idCart") int idCart,
            @RequestBody Cart Cart){
        return cartService.update(idCart,Cart)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idCart}")
    public Mono<ResponseEntity<Void>> delete( @PathVariable("idCart") int idCart){
        return cartService.delete(idCart)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
