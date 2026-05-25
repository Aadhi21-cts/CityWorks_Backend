package com.cts.dto.response;

import java.time.LocalDateTime;

import com.cts.enums.InspectionStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetInspectionResponseDTO {

	private Long inspectionId;

	private LocalDateTime performedAt;

	private Integer conditionRating;

	private String findings;

	private String photoUri;

	private InspectionStatus status;

	private Long assetId;

}
