package com.xcale.challenger.cart;

import com.xcale.challenger.cart.domain.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CartApplicationTests {
    @Autowired
    private ProductService productService;
}
