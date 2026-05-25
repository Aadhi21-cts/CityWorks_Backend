package com.cts.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 
import com.cts.config.FeignConfig;
import com.cts.dto.response.UserResponseDto;
 
@FeignClient(name = "IamService", url = "http://localhost:7075/api/auth", configuration = FeignConfig.class)
public interface WorkerClient{
	@GetMapping("/users/workers/{id}")
	UserResponseDto getWorker(@PathVariable("id") Long workerId);
}