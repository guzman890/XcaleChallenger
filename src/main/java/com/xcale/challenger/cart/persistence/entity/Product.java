package com.xcale.challenger.cart.persistence.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
@Data
@ToString
public class Product {
    @Id
    private Integer id;
    private String description;
    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
