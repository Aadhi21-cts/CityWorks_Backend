package com.cts.servicerequest.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.cts.servicerequest.enums.ServiceRequestStatus;

/**
 * ServiceRequest entity in the dedicated service-request DB.
 *
 * In microservice architecture we do NOT join across service DBs.
 * citizenId references the user_id in the IAM DB and is resolved
 * at the application layer via Feign calls to citizen-service.
 * assetId references the asset table which belongs to the asset microservice
 * (or in this iteration, stored locally for simplicity).
 */
@Entity
@Table(name = "service_request")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "citizen_id", nullable = false)
    private Long citizenId;

    @Column(name = "asset_id", nullable = false)
    private Long assetId;

    @Column(length = 500)
    private String description;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @Enumerated(EnumType.STRING)
    private ServiceRequestStatus status;  // PENDING | APPROVED | REJECTED

    // Getters & Setters
    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }

    public Long getCitizenId() { return citizenId; }
    public void setCitizenId(Long citizenId) { this.citizenId = citizenId; }

    public Long getAssetId() { return assetId; }
    public void setAssetId(Long assetId) { this.assetId = assetId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }

    public ServiceRequestStatus getStatus() { return status; }
    public void setStatus(ServiceRequestStatus status) { this.status = status; }
}
