package com.practice.orderservice.utils;

import com.practice.orderservice.dto.InvoiceDetail;
import com.practice.orderservice.dto.ProductCatalogDetail;
import com.practice.orderservice.dto.ProductQuantityDetail;
import com.practice.orderservice.dto.product.ProductDTO;
import com.practice.orderservice.model.InvoiceDetailProduct;
import com.practice.orderservice.model.ProductDetail;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderUtils {
    public static List<ProductQuantityDetail> buildProductQuantityDetails(List<ProductDetail> productDetails) {
        return productDetails.stream().map(product -> ProductQuantityDetail.builder()
                .productId(product.getProductId())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .build()).collect(Collectors.toList());
    }

    public static InvoiceDetail buildInvoiceDetail(InvoiceDetailProduct invoiceDetailProduct, List<ProductDTO> products) {
        return InvoiceDetail.builder()
                .invoiceId(invoiceDetailProduct.getInvoiceId())
                .customerName(invoiceDetailProduct.getCustomerName())
                .productCatalogDetails(invoiceDetailProduct.getProductQuantityDetails()
                        .stream()
                        .map(product -> ProductCatalogDetail.builder()
                                .productId(product.getProductId())
                                .productName(getProductName(product.getProductId(), products))
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public static String getProductName(String productId, List<ProductDTO> products) {
        Optional<ProductDTO> productOtp = products.stream().filter(product -> Objects.equals(product.getProductId(), productId)).findFirst();
        if (productOtp.isPresent()) {
            return productOtp.get().getProductName();
        }

        return "N/a";
    }
}
