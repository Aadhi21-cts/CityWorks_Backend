package com.cts.workorderservice.dto.response;

import java.time.LocalDateTime;

import com.cts.workorderservice.enums.WorkOrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignWorkerResponseDTO {
	
	private Long workOrderId;
    private Long requestId;
    private Long assetId;
    private Long assignedWorkerId;
    private LocalDateTime assignedAt;
    private WorkOrderStatus status;

}
