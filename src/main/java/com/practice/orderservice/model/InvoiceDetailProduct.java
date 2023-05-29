package com.practice.orderservice.model;

import com.practice.orderservice.dto.ProductQuantityDetail;
import lombok.Data;

import java.util.List;

@Data
public class InvoiceDetailProduct {
    private String invoiceId;
    private String customerName;
    private List<ProductQuantityDetail> productQuantityDetails;
}
