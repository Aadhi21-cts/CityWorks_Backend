package com.cts.workorderservice.dto.response;

import com.cts.workorderservice.enums.WorkOrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWorkOrderResponseDTO {
	
	private Long workOrderId;
    private Long requestId;
    private Long assetId;
    private WorkOrderStatus status;

}
