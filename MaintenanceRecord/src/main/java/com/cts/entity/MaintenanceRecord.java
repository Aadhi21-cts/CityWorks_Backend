package com.cts.entity;

import java.time.LocalDate;

import com.cts.enums.MaintenanceStatus;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenance_record")
public class MaintenanceRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maintainId;
	
	@Column(name = "task_description")
	private String taskDescription;
	
	@Column(name = "performed_by")
	private String performedBy;
	
	@Column(name = "performed_at")
	private LocalDate performedAt;
	
	private Double cost;
	
	@Enumerated(EnumType.STRING)
	private MaintenanceStatus status;
	
	private Long assetId;
}
