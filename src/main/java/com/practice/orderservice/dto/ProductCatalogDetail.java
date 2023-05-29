package com.practice.orderservice.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ProductCatalogDetail extends ProductQuantityDetail {
    private String productName;
}
