package com.practice.orderservice.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EndpointProperties {
    @Autowired
    private Environment env;

    public String getInvoiceHost() {
        return getProperty("spring.endpoints.invoiceHost");
    }
    public String getCatalogHost() {
        return getProperty("spring.endpoints.catalogHost");
    }

    private String getProperty(String property) {
        return env.getProperty(property);
    }

}
