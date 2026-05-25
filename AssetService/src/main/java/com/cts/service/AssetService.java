package com.cts.service;

import java.util.List;

import java.util.Map;

import com.cts.dto.request.CreateAssetRequestDTO;
import com.cts.dto.response.AssetResponseDTO;

public interface AssetService {
	
	AssetResponseDTO addAssets(CreateAssetRequestDTO assets);
	List<AssetResponseDTO> getAllAssets();
	AssetResponseDTO getAssetById(Long assetId);
	AssetResponseDTO updateAssetPartiallyById(Long assetId, Map<String,Object> updates);
	void deleteAssetById(Long assetId);
	AssetResponseDTO updateAssetById(Long assetId, CreateAssetRequestDTO asset);

}
