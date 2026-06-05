package com.cts.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.api.ApiResponse;
import com.cts.dto.request.CreateCompletionEvidenceRequestDTO;
import com.cts.dto.response.CompletionEvidenceResponseDTO;
import com.cts.enums.EvidenceStatus;
import com.cts.service.CompletionEvidenceService;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/completion_evidence")
@RequiredArgsConstructor
@Validated
public class CompletionEvidenceController {
	
	private final CompletionEvidenceService evidenceService;
	
	@PreAuthorize("hasRole('WORKER')")
	@PostMapping
	public ResponseEntity<?> addCompletionEvidence(@RequestBody CreateCompletionEvidenceRequestDTO dto){
		CompletionEvidenceResponseDTO responseDto = evidenceService.addCompletionEvidence(dto);
		
		
		return ResponseEntity.ok(ApiResponse.<CompletionEvidenceResponseDTO>builder()
				.status("SUCCESS")
				.message("Evidence Created Successfully")
				.data(responseDto)
				.build()
				);
	}
	
	@PreAuthorize("hasRole('SUPERVISOR') or hasRole('WORKER')")
	@GetMapping
	public ResponseEntity<?> getAllCompletionEvidences(){
		List<CompletionEvidenceResponseDTO> dtos = evidenceService.getAllCompletionEvidences();
		
		return ResponseEntity.ok(ApiResponse.<List<CompletionEvidenceResponseDTO>>builder()
				.status("FOUND")
				.message("Evidences Retrived Successfully")
				.data(dtos)
				.build());
	}
	
	@PreAuthorize("hasRole('SUPERVISOR') or hasRole('WORKER')")
	@GetMapping("/{id}")
	public ResponseEntity<?> getCompletionEvidenceById(@PathVariable @Positive(message = "id should be Positive") Long id){
		CompletionEvidenceResponseDTO dto = evidenceService.getCompletionEvidenceById(id);
		
		return ResponseEntity.ok(ApiResponse.<CompletionEvidenceResponseDTO>builder()
				.status("FOUND")
				.message("Evidence Retrived Successfully")
				.data(dto)
				.build());
	}
	
	@PreAuthorize("hasRole('SUPERVISOR')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCompletionById(@PathVariable @Positive(message = "id should be Positive") Long id){
		CompletionEvidenceResponseDTO dto = evidenceService.deleteCompletionById(id);
		
		return ResponseEntity.ok(ApiResponse.<CompletionEvidenceResponseDTO>builder()
				.status("DELETED")
				.message("Evidence deleted Successfully")
				.data(dto)
				.build());
	}
	
	@PreAuthorize("hasAnyRole('SUPERVISOR','WORKER')")
	@GetMapping("/tasks")
	public ResponseEntity<?> getEvidenceByTaskId(@RequestParam Long taskId){
		List<CompletionEvidenceResponseDTO> dto = evidenceService.getEvidenceByTaskId(taskId);
		
		return ResponseEntity.ok(ApiResponse.<List<CompletionEvidenceResponseDTO>>builder()
				.status("FOUND")
				.message("Evidence Found")
				.data(dto)
				.build());
	}
	
	@PreAuthorize("hasAnyRole('SUPERVISOR','WORKER')")
	@GetMapping("/workorders")
	public ResponseEntity<?> getEvidenceByWorkOrderIdAndStatus(@RequestParam Long workOrderId,@RequestParam String status){
		EvidenceStatus enumStatus = EvidenceStatus.valueOf(status.toUpperCase());
		List<CompletionEvidenceResponseDTO> dto = evidenceService.getEvidenceByWorkOrderIdAndStatus(workOrderId,enumStatus);
		
		return ResponseEntity.ok(ApiResponse.<List<CompletionEvidenceResponseDTO>>builder()
				.status("FOUND")
				.message("Evidence Found")
				.data(dto)
				.build());
	}
	
	@PreAuthorize("hasAnyRole('SUPERVISOR','WORKER')")
	@GetMapping("/workorder")
	public ResponseEntity<?> getEvidenceByWorkOrderId(@RequestParam Long workOrderId){
		List<CompletionEvidenceResponseDTO> dto = evidenceService.getEvidenceByWorkOrderId(workOrderId);
		return ResponseEntity.ok(ApiResponse.<List<CompletionEvidenceResponseDTO>>builder()
				.status("FOUND")
				.message("Evidence Found")
				.data(dto)
				.build());
	}
	
	@PreAuthorize("hasRole('SUPERVISOR')")
	@PatchMapping("/{id}/status")
	public ResponseEntity<ApiResponse<CompletionEvidenceResponseDTO>> updateEvidenceStatusBySupervisor(@PathVariable Long id,@RequestParam EvidenceStatus status){
		CompletionEvidenceResponseDTO dto = evidenceService.updateStatusOfEvidenceBySupervisor(id, status);
		return ResponseEntity.ok(ApiResponse.<CompletionEvidenceResponseDTO>builder()
				.status("UPDATED")
				.message("SUCCESS")
				.data(dto)
				.build());
	}

}
