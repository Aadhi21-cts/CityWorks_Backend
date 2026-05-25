package com.cts.workorderservice.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompletionEvidenceResponseDTO {

	private Long evidenceId;

	private Long workOrderId;

	private String fileURI;

	private LocalDateTime uploadedAt;

	private String status;

}
