package com.cts.auditlogservice.dto.response;

import java.time.LocalDateTime;

public class AuditLogResponseDTO {

    private Long auditId;
    private String action;
    private String resourceType;
    private String details;
    private String serviceName;
    private LocalDateTime timestamp;


    public AuditLogResponseDTO() {
    }

    public AuditLogResponseDTO(Long auditId, String action, String resourceType,
                                String details, String serviceName,
                                LocalDateTime timestamp) {
        this.auditId = auditId;
        this.action = action;
        this.resourceType = resourceType;
        this.details = details;
        this.serviceName = serviceName;
        this.timestamp = timestamp;
    }

    public Long getAuditId() {
        return auditId;
    }

    public String getAction() {
        return action;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getDetails() {
        return details;
    }

    public String getServiceName() {
        return serviceName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }


    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
