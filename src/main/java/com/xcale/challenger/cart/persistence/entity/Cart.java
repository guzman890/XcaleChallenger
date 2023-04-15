package com.xcale.challenger.cart.persistence.entity;

import org.springframework.data.annotation.Id;


public class Cart {
    @Id
    private Integer id;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
