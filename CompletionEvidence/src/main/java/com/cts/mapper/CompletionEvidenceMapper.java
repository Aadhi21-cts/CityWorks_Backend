package com.cts.mapper;

import org.springframework.stereotype.Component;

import com.cts.dto.request.CreateCompletionEvidenceRequestDTO;
import com.cts.dto.response.CompletionEvidenceResponseDTO;
import com.cts.entity.CompletionEvidence;

@Component
public class CompletionEvidenceMapper {
	
	public CompletionEvidenceResponseDTO toResponse(CompletionEvidence evidence) {
		CompletionEvidenceResponseDTO completionEvidence = new CompletionEvidenceResponseDTO();
		
		completionEvidence.setEvidenceId(evidence.getEvidenceId());
		completionEvidence.setFileURI(evidence.getFileURI());
		completionEvidence.setStatus(evidence.getStatus());
		completionEvidence.setUploadedAt(evidence.getUploadedAt());
		
		if(evidence.getTaskId() != null) {
			completionEvidence.setTaskId(evidence.getTaskId());
		}
		
		if(evidence.getWorkOrderId() != null) {
			completionEvidence.setWorkOrderId(evidence.getWorkOrderId());
		}
		
		return completionEvidence;
	}
	
	public CompletionEvidence toEntity(CreateCompletionEvidenceRequestDTO dto) {
		
		CompletionEvidence evidence = new CompletionEvidence();
		
		evidence.setFileURI(dto.getFileURI());
		evidence.setStatus(dto.getStatus());
		evidence.setTaskId(dto.getTaskId());
		evidence.setWorkOrderId(dto.getWorkOrderId());
		
		return evidence;
	}

}
