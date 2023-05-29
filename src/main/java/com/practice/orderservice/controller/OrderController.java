package com.practice.orderservice.controller;

import com.practice.orderservice.dto.InvoiceDetail;
import com.practice.orderservice.model.OrderDetail;
import com.practice.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderDetail orderDetail) {
        System.out.println("Ahihi_start");
        String invoiceId = orderService.createOrder(orderDetail);
        return ResponseEntity.ok().body(invoiceId);
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceDetail> getInvoiceDetail(@PathVariable("invoiceId") String invoiceId) {
        log.info("Start getInvoiceDetail");
        InvoiceDetail invoiceDetail = orderService.getInvoiceDetails(invoiceId);
        log.info("End getInvoiceDetail with response {}", invoiceDetail);
        return ResponseEntity.ok(invoiceDetail);
    }
}
