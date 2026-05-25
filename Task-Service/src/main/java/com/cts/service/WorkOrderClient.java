package com.cts.service;

import java.util.Optional;
 
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 
import com.cts.config.FeignConfig;
//import com.cts.dto.response.UserResponseDTO;
import com.cts.dto.response.WorkOrderResponseDTO;
 
@FeignClient(name = "work-order-service", url = "http://localhost:7078", configuration = FeignConfig.class)
public interface WorkOrderClient {
    @GetMapping("/api/workorders/{workOrderId}")
    Optional<WorkOrderResponseDTO> getWorkOrder(@PathVariable("workOrderId") Long workOrderId);
}