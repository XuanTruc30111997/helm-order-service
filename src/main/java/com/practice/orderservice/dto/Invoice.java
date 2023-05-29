package com.practice.orderservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Invoice {
    private String id;
    private String customerName;
    private String totalPrice;
}
