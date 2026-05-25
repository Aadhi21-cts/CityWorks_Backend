package com.cts.entity;

import java.time.LocalDate;

import com.cts.enums.AssetCondition;
import com.cts.enums.AssetStatus;
import com.cts.enums.AssetType;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "asset")
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "asset_id")
	private Long assetId;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private AssetType type;
	
	private String location;
	
	@Column(name = "asset_condition")
	@Enumerated(EnumType.STRING)
	private AssetCondition condition;
	
	@Enumerated(EnumType.STRING)
	private AssetStatus status;
	
	private LocalDate installedAt;

}
