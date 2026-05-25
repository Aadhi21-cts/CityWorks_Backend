package com.cts.service;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.config.FeignClientConfig;
import com.cts.dto.response.AssetResponseDTO;

@FeignClient(name = "AssetService", url = "http://localhost:7071", configuration = FeignClientConfig.class)
public interface ApiClient {
	
	@GetMapping("/api/assets/{assetId}")
	Optional<AssetResponseDTO> getAssetDetails(@PathVariable Long assetId);
}
