package com.cts.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.dto.response.TaskResponseDTO;


@FeignClient(name = "Task-Service", url = "http://localhost:7076")
public interface TaskApiClient {
	
	@GetMapping("/api/tasks/{id}")
	Optional<TaskResponseDTO> getTaskDetails(@PathVariable("id") Long taskId);
}
