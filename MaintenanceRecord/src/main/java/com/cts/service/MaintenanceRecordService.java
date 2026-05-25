package com.cts.service;

import java.util.List;

import java.util.Map;

import com.cts.dto.request.CreateMaintenanceRecordRequestDTO;
import com.cts.dto.response.MaintenanceRecordResponseDTO;

public interface MaintenanceRecordService {
	MaintenanceRecordResponseDTO createMaintenanceRecord(CreateMaintenanceRecordRequestDTO mRecord);
	MaintenanceRecordResponseDTO updateRecordPartiallyById(Long id, Map<String, Object> updates);
	void deleteRecordById(Long id);
	List<MaintenanceRecordResponseDTO> getAllMaintenanceRecord();
	MaintenanceRecordResponseDTO getMaintenanceById(Long id);
	MaintenanceRecordResponseDTO updateMaintenanceRecordById(Long id, CreateMaintenanceRecordRequestDTO mRecord);
}
