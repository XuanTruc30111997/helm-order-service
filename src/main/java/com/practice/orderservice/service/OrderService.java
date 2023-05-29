package com.practice.orderservice.service;

import com.practice.orderservice.dto.InvoiceDetail;
import com.practice.orderservice.model.OrderDetail;

public interface OrderService {
    String createOrder(OrderDetail orderDetail);
    InvoiceDetail getInvoiceDetails(String invoiceId);
}
