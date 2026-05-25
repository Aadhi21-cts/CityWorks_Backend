package com.cts.servicerequest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

import com.cts.servicerequest.enums.ServiceRequestStatus;

public class ServiceRequestDTO {

    private Long requestId;

    @NotNull(message = "Asset ID is required")
    private Long assetId;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    private LocalDateTime submittedAt;
    private ServiceRequestStatus status;


    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }

    public Long getAssetId() { return assetId; }
    public void setAssetId(Long assetId) { this.assetId = assetId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalDateTime submittedAt) { this.submittedAt = submittedAt; }

    public ServiceRequestStatus getStatus() { return status; }
    public void setStatus(ServiceRequestStatus status) { this.status = status; }

}
