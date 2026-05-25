package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.MaintenanceRecord;

public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord, Long> {
	

}
