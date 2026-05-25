package com.cts.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cts.aspect.audit.Auditable;
import com.cts.service.AuditLogClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Aspect
@Component
public class AuditLogAspect {

    private final AuditLogClient auditLogClient;

    public AuditLogAspect(AuditLogClient auditLogClient) {
        this.auditLogClient = auditLogClient;
    }

    @AfterReturning(value = "@annotation(auditable)", returning = "result")
    public void logActivity(JoinPoint joinPoint, Auditable auditable, Object result) {
        try {
            String performedBy = "anonymous";
            if (SecurityContextHolder.getContext().getAuthentication() != null
                    && !"anonymousUser".equals(
                            SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
                performedBy = SecurityContextHolder.getContext().getAuthentication().getName();
            }

            Map<String, Object> payload = new HashMap<>();
            payload.put("action",       auditable.action());
            payload.put("resourceType", auditable.resourceType());
            payload.put("serviceName",  "Asset Inspection");
            payload.put("details",
                    "Performed by: " + performedBy
                    + " | Method: " + joinPoint.getSignature().getName());

            sendAuditLog(payload);

        } catch (Exception e) {
            System.err.println("[AUDIT FAILED] Unexpected error: " + e.getMessage());
        }
    }

    @CircuitBreaker(name = "auditLogService", fallbackMethod = "auditFallback")
    public void sendAuditLog(Map<String, Object> payload) {
        auditLogClient.createLog(payload);
        System.out.println("[AUDIT] Sent to audit-log-service: "
                + payload.get("action") + " on " + payload.get("resourceType"));
    }

    public void auditFallback(Map<String, Object> payload, Throwable ex) {
        System.err.println("[AUDIT FALLBACK] audit-log-service unavailable."
                + " Action: " + payload.get("action")
                + " | Reason: " + ex.getMessage());
    }
}
