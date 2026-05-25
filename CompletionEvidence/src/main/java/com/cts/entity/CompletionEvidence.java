package com.cts.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.cts.enums.EvidenceStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "completion_evidence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CompletionEvidence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "evidence_id")
	private Long evidenceId;
	
	private Long taskId;
	
	private Long workOrderId;
	
	@Column(name = "file_uri", nullable = false)
	private String fileURI;
	
	@CreatedDate
	@Column(name = "uploaded_at")
	private LocalDateTime uploadedAt;
	
	@Enumerated(EnumType.STRING)
	private EvidenceStatus status;

}
