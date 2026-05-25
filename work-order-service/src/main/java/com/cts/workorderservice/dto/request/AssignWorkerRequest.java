package com.cts.workorderservice.dto.request;

public class AssignWorkerRequest {

    private Long orderId;
    private Long workerId;


    public AssignWorkerRequest() {
    }

    public AssignWorkerRequest(Long orderId, Long workerId) {
        this.orderId = orderId;
        this.workerId = workerId;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
}
