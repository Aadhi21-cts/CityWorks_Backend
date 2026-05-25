package com.cts.auditlogservice.dto.request;

public class CreateAuditLogDTO {

    private String action;
    private String resourceType;
    private String details;
    private String serviceName;


    public CreateAuditLogDTO() {
    }

    public CreateAuditLogDTO(String action, String resourceType,
                              String details, String serviceName) {
        this.action = action;
        this.resourceType = resourceType;
        this.details = details;
        this.serviceName = serviceName;
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
}
