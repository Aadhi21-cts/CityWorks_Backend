package com.cts.workorderservice.dto.response;

import java.time.LocalDateTime;

import com.cts.workorderservice.enums.WorkOrderStatus;

public class WorkOrderResponseDTO {

    private Long workOrderId;
    private Long requestId;
    private Long assetId;
    private Long assignedWorkerId;
    private LocalDateTime assignedAt;
    private LocalDateTime completedAt;
    private WorkOrderStatus status;


    public WorkOrderResponseDTO() {
    }

    public WorkOrderResponseDTO(Long workOrderId, Long requestId, Long assetId,
                                Long assignedWorkerId, LocalDateTime assignedAt,
                                LocalDateTime completedAt, WorkOrderStatus status) {
        this.workOrderId = workOrderId;
        this.requestId = requestId;
        this.assetId = assetId;
        this.assignedWorkerId = assignedWorkerId;
        this.assignedAt = assignedAt;
        this.completedAt = completedAt;
        this.status = status;
    }


    public Long getWorkOrderId() {
        return workOrderId;
    }

    public Long getRequestId() {
        return requestId;
    }

    public Long getAssetId() {
        return assetId;
    }

    public Long getAssignedWorkerId() {
        return assignedWorkerId;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public WorkOrderStatus getStatus() {
        return status;
    }


    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public void setAssignedWorkerId(Long assignedWorkerId) {
        this.assignedWorkerId = assignedWorkerId;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public void setStatus(WorkOrderStatus status) {
        this.status = status;
    }
}
