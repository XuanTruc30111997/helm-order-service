package com.practice.orderservice.service;

import com.practice.orderservice.model.InvoiceDetailProduct;
import com.practice.orderservice.model.ProductDetail;

import java.util.List;

public interface InvoiceService {
    void addProductsToInvoice(String invoiceId, List<ProductDetail> productDetails);
    String createInvoice(String customerName);
    InvoiceDetailProduct getInvoiceDetailProduct(String invoiceId);
}
