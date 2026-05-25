package com.cts.workorderservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import com.cts.workorderservice.enums.WorkOrderStatus;

@Entity
@Table(name = "work_order")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workOrderId;

    @Column(name = "request_id", unique = true)
    private Long requestId;

    @Column(name = "asset_id")
    private Long assetId;

    @Column(name = "assigned_worker_id")
    private Long assignedWorkerId;

    private LocalDateTime assignedAt;

    private LocalDateTime completedAt;

    @Enumerated(EnumType.STRING)
    private WorkOrderStatus status;


    public WorkOrder() {
    }

    public WorkOrder(Long workOrderId, Long requestId, Long assetId,
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
