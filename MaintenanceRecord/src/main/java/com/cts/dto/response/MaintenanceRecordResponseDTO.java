package com.cts.dto.response;

import java.time.LocalDate;

import com.cts.enums.MaintenanceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceRecordResponseDTO {

	private Long maintainId;

	private String taskDescription;

	private String performedBy;

	private LocalDate performedAt;

	private Double cost;

	private MaintenanceStatus status;

	private Long assetId;

}
