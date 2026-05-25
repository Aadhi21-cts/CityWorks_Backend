package com.cts.service;

import java.util.List;

import com.cts.dto.request.CreateCompletionEvidenceRequestDTO;
import com.cts.dto.response.CompletionEvidenceResponseDTO;
import com.cts.enums.EvidenceStatus;

public interface CompletionEvidenceService {
	
	CompletionEvidenceResponseDTO addCompletionEvidence(CreateCompletionEvidenceRequestDTO dto);
	
	List<CompletionEvidenceResponseDTO> getAllCompletionEvidences();
	
	CompletionEvidenceResponseDTO getCompletionEvidenceById(Long id);
	
	CompletionEvidenceResponseDTO deleteCompletionById(Long id);
	
	List<CompletionEvidenceResponseDTO> getEvidenceByTaskId(Long id);
	
	List<CompletionEvidenceResponseDTO> getEvidenceByWorkOrderIdAndStatus(Long workOrderId, EvidenceStatus status);
	
	CompletionEvidenceResponseDTO updateStatusOfEvidenceBySupervisor(Long id, EvidenceStatus status);
	
	List<CompletionEvidenceResponseDTO> getEvidenceByWorkOrderId(Long id);

}
