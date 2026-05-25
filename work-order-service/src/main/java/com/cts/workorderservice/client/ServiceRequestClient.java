package com.cts.workorderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient(name = "service-request-service")
public interface ServiceRequestClient {

    @GetMapping("/api/requests/{id}")
    Map<String, Object> getServiceRequestById(@PathVariable Long id);
}
