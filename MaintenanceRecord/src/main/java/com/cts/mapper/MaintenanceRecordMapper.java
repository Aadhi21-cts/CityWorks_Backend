package com.cts.mapper;

import org.springframework.stereotype.Component;

import com.cts.dto.request.CreateMaintenanceRecordRequestDTO;
import com.cts.dto.response.MaintenanceRecordResponseDTO;

import com.cts.entity.MaintenanceRecord;

@Component
public class MaintenanceRecordMapper {
	
	public MaintenanceRecordResponseDTO toResponse(MaintenanceRecord record) {
		MaintenanceRecordResponseDTO dto = new MaintenanceRecordResponseDTO();
		dto.setMaintainId(record.getMaintainId());
		dto.setCost(record.getCost());
		dto.setPerformedAt(record.getPerformedAt());
		dto.setPerformedBy(record.getPerformedBy());
		dto.setStatus(record.getStatus());
		dto.setTaskDescription(record.getTaskDescription());
		
		if(record.getAssetId() != null) {
			dto.setAssetId(record.getAssetId());
		}
		
		return dto;
	}
	
	public MaintenanceRecord toEntity(CreateMaintenanceRecordRequestDTO dto) {
		
		MaintenanceRecord record = new MaintenanceRecord();
		
		record.setCost(dto.getCost());
		record.setPerformedAt(dto.getPerformedAt());
		record.setPerformedBy(dto.getPerformedBy());
		record.setStatus(dto.getStatus());
		record.setTaskDescription(dto.getTaskDescription());
		record.setAssetId(dto.getAssetId());
		
		return record;
	}
}
