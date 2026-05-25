package com.cts.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.api.ApiResponse;
import com.cts.dto.request.CreateMaintenanceRecordRequestDTO;
import com.cts.dto.response.MaintenanceRecordResponseDTO;
import com.cts.service.MaintenanceRecordService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/api/maintenance_records")
@Validated
public class MaintenanceRecordController {
	
	@Autowired
	private MaintenanceRecordService maintenanceRecordService;
	
	@PreAuthorize("hasRole('SUPERVISOR')")
	@PostMapping
	public ResponseEntity<?> createMaintenanceRecord(@Valid @RequestBody CreateMaintenanceRecordRequestDTO mRecord){
		MaintenanceRecordResponseDTO record = maintenanceRecordService.createMaintenanceRecord(mRecord);
		return ResponseEntity.ok(ApiResponse.<MaintenanceRecordResponseDTO>builder()
				.status("SUCCESS")
				.message("Maintenance Record Created")
				.data(record)
				.build()
		);
	}
	
	@PreAuthorize("hasRole('SUPERVISOR')")
	@PatchMapping("/{id}")
	public ResponseEntity<?> updateRecordPartiallyById(@PathVariable @Positive(message = "id should be positive") Long id,@Valid @RequestBody Map<String, Object> updates){
		MaintenanceRecordResponseDTO record = maintenanceRecordService.updateRecordPartiallyById(id, updates); 
		return ResponseEntity.ok(ApiResponse.<MaintenanceRecordResponseDTO>builder()
				.status("SUCCESS")
				.message("Maintenance Record Modified")
				.data(record)
				.build()
		);
	}
	
	@PreAuthorize("hasRole('SUPERVISOR') or hasRole('ADMIN')")
	@GetMapping
	public ResponseEntity<?> getAllMaintenanceRecord(){
		List<MaintenanceRecordResponseDTO> records = maintenanceRecordService.getAllMaintenanceRecord();
		return ResponseEntity.ok(ApiResponse.<List<MaintenanceRecordResponseDTO>>builder()
				.status("FOUND")
				.message("Maintenance Records Retrived")
				.data(records)
				.build()
		);
	}
	
	@PreAuthorize("hasRole('SUPERVISOR') or hasRole('ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<?> getMaintenanceById(@PathVariable @Positive(message = "id should be positive") Long id){
		MaintenanceRecordResponseDTO record = maintenanceRecordService.getMaintenanceById(id);
		return ResponseEntity.ok(ApiResponse.<MaintenanceRecordResponseDTO>builder()
				.status("FOUND")
				.message("Maintenance Record Retrived")
				.data(record)
				.build()
		);
	}
	
	@PreAuthorize("hasRole('SUPERVISOR')")
	@PutMapping("/{id}")
	public ResponseEntity<?> updateMaintenanceRecordById(@PathVariable @Positive(message = "id should be positive") Long id,@Valid @RequestBody CreateMaintenanceRecordRequestDTO mRecord){
		MaintenanceRecordResponseDTO record = maintenanceRecordService.updateMaintenanceRecordById(id, mRecord);
		return ResponseEntity.ok(ApiResponse.<MaintenanceRecordResponseDTO>builder()
				.status("SUCCESS")
				.message("Maintenance Record Modified")
				.data(record)
				.build()
		);
	}
	
	@PreAuthorize("hasRole('SUPERVISOR')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRecordById(@PathVariable @Positive(message = "id should be positive") Long id){
		maintenanceRecordService.deleteRecordById(id);
		return ResponseEntity.ok(ApiResponse.<MaintenanceRecordResponseDTO>builder()
				.status("SUCCESS")
				.message("Record Deleted Successfull")
				.build()
		);
	}
}
