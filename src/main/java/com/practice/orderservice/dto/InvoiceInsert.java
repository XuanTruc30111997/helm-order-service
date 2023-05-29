package com.practice.orderservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvoiceInsert {
    private String customerName;
}
