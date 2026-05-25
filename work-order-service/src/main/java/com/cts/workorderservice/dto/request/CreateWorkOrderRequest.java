package com.cts.workorderservice.dto.request;

public class CreateWorkOrderRequest {

    private Long requestId;


    public CreateWorkOrderRequest() {
    }

    public CreateWorkOrderRequest(Long requestId) {
        this.requestId = requestId;
    }


    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
}
