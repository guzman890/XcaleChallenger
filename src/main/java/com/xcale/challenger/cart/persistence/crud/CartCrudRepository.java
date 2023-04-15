package com.xcale.challenger.cart.persistence.crud;

import com.xcale.challenger.cart.persistence.entity.Cart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface CartCrudRepository extends ReactiveCrudRepository<Cart,Integer> {
}
