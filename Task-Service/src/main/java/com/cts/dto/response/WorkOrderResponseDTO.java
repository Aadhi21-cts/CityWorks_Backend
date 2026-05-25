package com.cts.dto.response;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class WorkOrderResponseDTO {
    private Long workOrderId;
    private Long requestId;
    private Long assetId;
    private Long assignedTo;
    private LocalDateTime assignedAt;
    private LocalDateTime dueDate;
    private String status;
}