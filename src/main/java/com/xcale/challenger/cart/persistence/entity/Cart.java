package com.xcale.challenger.cart.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {
    private static final long serialVersionUID = -7817224776021728682L;
    private Integer id;
    private List<Integer> products;
    public List<Integer> getProducts() {
        return products;
    }
    public void setProducts(List<Integer> products) {
        this.products = products;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
