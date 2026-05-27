package com.cts.dto.request;

import com.cts.enums.EvidenceStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompletionEvidenceRequestDTO {
	
	@NotBlank(message = "fileURI should not be null")
	private String fileURI;
	
	@NotNull(message = "Status should not be null")
	private EvidenceStatus status;

	private Long taskId;
	
	private Long workOrderId;
	
}
