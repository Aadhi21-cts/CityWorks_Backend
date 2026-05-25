package com.cts.workorderservice.mapper;

import com.cts.workorderservice.dto.response.AssignWorkerResponseDTO;
import com.cts.workorderservice.dto.response.CreateWorkOrderResponseDTO;
import com.cts.workorderservice.dto.response.WorkOrderResponseDTO;
import com.cts.workorderservice.entity.WorkOrder;

public class WorkOrderMapper {

    public static WorkOrderResponseDTO toResponse(WorkOrder wo) {
        return new WorkOrderResponseDTO(
                wo.getWorkOrderId(),
                wo.getRequestId(),
                wo.getAssetId(),
                wo.getAssignedWorkerId(),
                wo.getAssignedAt(),
                wo.getCompletedAt(),
                wo.getStatus()
        );
    }
    
    public static CreateWorkOrderResponseDTO toCreateResponse(WorkOrder wo) {
    	return new CreateWorkOrderResponseDTO(
    			wo.getWorkOrderId(), 
    			wo.getRequestId(),
    			wo.getAssetId(), 
    			wo.getStatus());
    	
    }
    
    public static AssignWorkerResponseDTO toAssignResponse(WorkOrder wo) {
    	return new AssignWorkerResponseDTO(
    			wo.getWorkOrderId(), 
    			wo.getRequestId(), 
    			wo.getAssetId(), 
    			wo.getAssignedWorkerId(), 
    			wo.getAssignedAt(), 
    			wo.getStatus());
    }
}
