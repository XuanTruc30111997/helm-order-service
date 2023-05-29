package com.practice.orderservice.model;

import lombok.Data;

@Data
public class ProductDetail {
    private String productId;
    private int quantity;
    private float price;
}
