package com.cts.servicerequest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.servicerequest.config.FeignClientConfig;
import com.cts.servicerequest.dto.AssetResponseDTO;

/**
 * Feign client to call citizen-service.
 * fallback = CitizenServiceFallback.class handles circuit-open / service-down scenarios.
 */
@FeignClient(
    name = "AssetService", url = "http://localhost:7071/api/assets",
    fallback = CitizenServiceFallback.class, configuration = FeignClientConfig.class
)
public interface CitizenServiceClient {

    @GetMapping("/{id}")
    AssetResponseDTO getAssetById(@PathVariable("id") Long id);
}
