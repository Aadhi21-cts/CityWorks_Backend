package com.cts.service;

import java.util.List;
import java.util.Map;

import com.cts.dto.request.CreateAssetInspectionRequestDTO;
import com.cts.dto.response.AssetInspectionResponseDTO;

public interface AssetInspectionService {
	
	AssetInspectionResponseDTO createAssetInspection(CreateAssetInspectionRequestDTO assetInspection);
	List<AssetInspectionResponseDTO> getAllAssetInspection();
	AssetInspectionResponseDTO getAssetInspectionById(Long id);
	AssetInspectionResponseDTO updateAssetInspectionById(Long id, CreateAssetInspectionRequestDTO assetInspection);
	AssetInspectionResponseDTO updateAssetInspectionPartiallyById(Long id, Map<String, Object> field);
	boolean deleteAssetById(Long id);

}
