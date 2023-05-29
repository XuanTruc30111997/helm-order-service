package com.practice.orderservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InvoiceDetail {
    private String invoiceId;
    private String customerName;
    private List<ProductCatalogDetail> productCatalogDetails;
}
