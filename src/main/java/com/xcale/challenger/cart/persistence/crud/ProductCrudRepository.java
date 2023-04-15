package com.xcale.challenger.cart.persistence.crud;

import com.xcale.challenger.cart.persistence.entity.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCrudRepository extends R2dbcRepository<Product,Integer> {
}
