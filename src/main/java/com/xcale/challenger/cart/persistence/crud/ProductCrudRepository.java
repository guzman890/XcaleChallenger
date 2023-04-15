package com.xcale.challenger.cart.persistence.crud;

import com.xcale.challenger.cart.persistence.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCrudRepository extends ReactiveCrudRepository<Product,Integer> {
}
