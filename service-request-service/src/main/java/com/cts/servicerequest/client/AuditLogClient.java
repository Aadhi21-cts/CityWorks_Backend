package com.cts.servicerequest.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "audit-log-service")
public interface AuditLogClient {

    @PostMapping("/api/audit-logs")
    void createLog(@RequestBody Map<String, Object> payload);
}
