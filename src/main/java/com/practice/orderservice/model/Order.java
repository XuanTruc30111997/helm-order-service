package com.practice.orderservice.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Order extends OrderDetail {
    private String invoiceId;
}
