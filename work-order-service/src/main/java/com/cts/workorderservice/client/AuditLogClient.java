package com.cts.workorderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "audit-log-service")
public interface AuditLogClient {

    @PostMapping("/api/audit-logs")
    void createLog(@RequestBody Map<String, Object> payload);
}
