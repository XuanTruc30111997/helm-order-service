package com.practice.orderservice.service;

import com.practice.orderservice.dto.InvoiceDetail;
import com.practice.orderservice.dto.product.ProductDTO;
import com.practice.orderservice.model.InvoiceDetailProduct;
import com.practice.orderservice.model.OrderDetail;
import com.practice.orderservice.utils.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductService productService;

    @Autowired
    InvoiceService invoiceService;

    @Override
    public String createOrder(OrderDetail orderDetail) {
        String invoiceId = invoiceService.createInvoice(orderDetail.getCustomerName());
        invoiceService.addProductsToInvoice(invoiceId, orderDetail.getProductDetails());

        return invoiceId;
    }

    @Override
    public InvoiceDetail getInvoiceDetails(String invoiceId) {
        InvoiceDetailProduct invoiceDetailProduct = invoiceService.getInvoiceDetailProduct(invoiceId);

        List<CompletableFuture<ProductDTO>> completableFutures = invoiceDetailProduct.getProductQuantityDetails()
                .stream()
                .map(product -> CompletableFuture.supplyAsync(() -> productService.getProductByProductId(product.getProductId())))
                .collect(Collectors.toList());

        List<ProductDTO> products = completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        return OrderUtils.buildInvoiceDetail(invoiceDetailProduct, products);
    }
}
