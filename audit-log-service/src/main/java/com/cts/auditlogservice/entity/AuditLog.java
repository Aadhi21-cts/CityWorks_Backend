package com.cts.auditlogservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@Table(name = "audit_log")
@EntityListeners(AuditingEntityListener.class)
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_id")
    private Long auditId;

    @Column(nullable = false)
    private String action;

    @Column(name = "resource_type")
    private String resourceType;


    @Column(length = 1000)
    private String details;

    @Column(name = "service_name")
    private String serviceName;

    @CreatedDate
    @Column(name = "timestamp", updatable = false, nullable = false)
    private LocalDateTime timestamp;


    public AuditLog() {
    }

    public AuditLog(Long auditId, String action, String resourceType,
                    String details, String serviceName, LocalDateTime timestamp) {
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
