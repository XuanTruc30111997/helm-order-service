package com.practice.orderservice.service;

import com.practice.orderservice.constants.PathConstants;
import com.practice.orderservice.dto.InvoiceDetailInsert;
import com.practice.orderservice.dto.InvoiceInsert;
import com.practice.orderservice.model.InvoiceDetailProduct;
import com.practice.orderservice.model.ProductDetail;
import com.practice.orderservice.properties.EndpointProperties;
import com.practice.orderservice.utils.HeaderUtils;
import com.practice.orderservice.utils.OrderUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    EndpointProperties endpointProperties;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void addProductsToInvoice(String invoiceId, List<ProductDetail> productDetails) {
        String url = new StringBuilder(endpointProperties.getInvoiceHost())
                .append(PathConstants.SLASH)
                .append(PathConstants.INVOICE_DETAIL_PATH)
                .toString();

        InvoiceDetailInsert invoiceDetailInsert = InvoiceDetailInsert.builder()
                .invoiceId(invoiceId)
                .productQuantityDetail(OrderUtils.buildProductQuantityDetails(productDetails))
                .build();

        log.info("Call to add invoice detail with {}", invoiceDetailInsert.toString());

        HttpEntity<InvoiceDetailInsert> entity = new HttpEntity<>(invoiceDetailInsert, HeaderUtils.builderHeaders());

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }

    @Override
    public String createInvoice(String customerName) {
        String url = new StringBuilder(endpointProperties.getInvoiceHost())
                .append(PathConstants.SLASH)
                .toString();

        HttpEntity<InvoiceInsert> entity = new HttpEntity<>(InvoiceInsert.builder().customerName(customerName).build(), HeaderUtils.builderHeaders());

        ResponseEntity<String> invoiceId = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

        return invoiceId.getBody();
    }

    @Override
    public InvoiceDetailProduct getInvoiceDetailProduct(String invoiceId) {
        String url = new StringBuilder(endpointProperties.getInvoiceHost())
                .append(PathConstants.SLASH)
                .append(PathConstants.INVOICE_DETAIL_PATH)
                .append(PathConstants.SLASH)
                .append("{invoiceId}")
                .toString();
        ResponseEntity<InvoiceDetailProduct> invoiceDetailProduct = restTemplate.exchange(url, HttpMethod.GET, null, InvoiceDetailProduct.class, invoiceId);

        return invoiceDetailProduct.getBody();
    }
}
