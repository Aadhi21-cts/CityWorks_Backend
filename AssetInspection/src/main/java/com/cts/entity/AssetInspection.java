package com.cts.entity;

import java.time.LocalDateTime;

import com.cts.enums.InspectionStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name ="asset_inspection")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssetInspection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inspection_id")
	private Long inspectionId;
	
	@Column(name = "performed_at")
	private LocalDateTime performedAt;
	
	private Integer conditionRating;
	
	private String findings;
	
	private String photoUri;
	
	@Enumerated(EnumType.STRING)
	private InspectionStatus status;
	
	private Long assetId;

}
