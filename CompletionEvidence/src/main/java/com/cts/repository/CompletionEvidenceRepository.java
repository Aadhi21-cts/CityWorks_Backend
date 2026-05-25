package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.CompletionEvidence;
import com.cts.enums.EvidenceStatus;

public interface CompletionEvidenceRepository extends JpaRepository<CompletionEvidence, Long> {
	
	List<CompletionEvidence> findByTaskId(Long taskId);
	List<CompletionEvidence> findByWorkOrderIdAndStatus(Long workOrderId,EvidenceStatus status);
	List<CompletionEvidence> findByWorkOrderId(Long workOrderId);
}
