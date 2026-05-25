package com.cts.workorderservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.workorderservice.api.ApiResponse;
import com.cts.workorderservice.dto.response.CompletionEvidenceResponseDTO;

@FeignClient(name = "COMPLETIONEVIDENCE")
public interface CompletionEvidenceClient {

    @GetMapping("/api/completion_evidence/workorders")
    ApiResponse<List<CompletionEvidenceResponseDTO>> getEvidenceByWorkOrderId(@RequestParam("workOrderId") Long workOrderId, @RequestParam("status") String status);
}
