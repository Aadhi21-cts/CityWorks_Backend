package com.cts.dto.request;

import java.time.LocalDate;

import com.cts.enums.AssetCondition;
import com.cts.enums.AssetStatus;
import com.cts.enums.AssetType;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAssetRequestDTO {
	
	@NotBlank(message = "name should not be Blank")
	private String name;
	
	@NotBlank(message = "type should not be Blank")
	private AssetType type;
	
	@NotBlank(message = "location should not be Blank")
	private String location;
	
	@Column(name = "asset_condition")
	@NotBlank(message = "condition should not be Blank")
	private AssetCondition condition;
	
	@NotBlank(message = "status should not be Blank")
	private AssetStatus status;
	
	@PastOrPresent(message = "date should not be future")
	private LocalDate installedAt;

}
