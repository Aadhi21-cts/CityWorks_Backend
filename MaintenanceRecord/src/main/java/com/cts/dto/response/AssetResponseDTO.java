package com.cts.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetResponseDTO {

	private Long assetId;

	private String name;

	private String type;

	private String location;

	private String condition;

	private String status;

	private LocalDate installedAt;

}
