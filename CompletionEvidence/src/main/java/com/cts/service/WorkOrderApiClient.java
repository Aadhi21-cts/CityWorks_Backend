package com.cts.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.dto.response.WorkOrderResponseDTO;

@FeignClient(name = "work-order-service", url = "http://localhost:7078")
public interface WorkOrderApiClient {
	
	@GetMapping("/api/workorders/{id}")
	Optional<WorkOrderResponseDTO> getWorkOrderDetails(@PathVariable("id") Long workOrderId);
}
