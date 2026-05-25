package com.cts.dto.response;

import java.time.LocalDate;

import com.cts.enums.AssetCondition;
import com.cts.enums.AssetStatus;
import com.cts.enums.AssetType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetResponseDTO {

	private Long assetId;

	private String name;

	private AssetType type;

	private String location;

	private AssetCondition condition;

	private AssetStatus status;

	private LocalDate installedAt;

}
