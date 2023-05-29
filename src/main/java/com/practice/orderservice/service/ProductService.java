package com.practice.orderservice.service;

import com.practice.orderservice.dto.product.ProductDTO;

public interface ProductService {
    ProductDTO getProductByProductId(String productId);
}
