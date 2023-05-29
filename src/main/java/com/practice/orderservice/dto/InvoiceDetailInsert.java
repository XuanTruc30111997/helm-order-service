package com.practice.orderservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InvoiceDetailInsert {
    private String invoiceId;
    private List<ProductQuantityDetail> productQuantityDetail;
}
