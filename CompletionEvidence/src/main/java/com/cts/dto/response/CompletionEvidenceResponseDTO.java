package com.cts.dto.response;

import java.time.LocalDateTime;

import com.cts.enums.EvidenceStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompletionEvidenceResponseDTO {

	private Long evidenceId;

	private Long taskId;
	
	private Long workOrderId;

	private String fileURI;

	private LocalDateTime uploadedAt;

	private EvidenceStatus status;

}
