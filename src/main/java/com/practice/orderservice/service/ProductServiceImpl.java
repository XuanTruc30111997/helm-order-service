package com.practice.orderservice.service;

import com.practice.orderservice.constants.PathConstants;
import com.practice.orderservice.dto.product.ProductDTO;
import com.practice.orderservice.model.InvoiceDetailProduct;
import com.practice.orderservice.properties.EndpointProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EndpointProperties endpointProperties;

    @Override
    public ProductDTO getProductByProductId(String productId) {
        String url = new StringBuilder(endpointProperties.getCatalogHost())
                .append(PathConstants.SLASH)
                .append(PathConstants.PRODUCT_PATH)
                .append(PathConstants.SLASH)
                .append("{productId}")
                .toString();

        ResponseEntity<ProductDTO> product = restTemplate.exchange(url, HttpMethod.GET, null, ProductDTO.class, productId);

        return product.getBody();
    }
}
