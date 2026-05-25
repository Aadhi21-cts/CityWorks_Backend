package com.cts.mapper;

import com.cts.dto.request.CreateAssetRequestDTO;
import com.cts.dto.response.AssetResponseDTO;
import com.cts.entity.Asset;

public class AssetMapper {
	
	public static Asset toEntity(CreateAssetRequestDTO req) {
		Asset asset = new Asset();
		
		asset.setCondition(req.getCondition());
		asset.setLocation(req.getLocation());
		asset.setInstalledAt(req.getInstalledAt());
		asset.setName(req.getName());
		asset.setStatus(req.getStatus());
		asset.setType(req.getType());
		
		return asset;
	}
	
	public static AssetResponseDTO toResponse(Asset asset) {
		
		AssetResponseDTO response = new AssetResponseDTO();
		
		response.setAssetId(asset.getAssetId());
		response.setCondition(asset.getCondition());
		response.setLocation(asset.getLocation());
		response.setInstalledAt(asset.getInstalledAt());
		response.setName(asset.getName());
		response.setStatus(asset.getStatus());
		response.setType(asset.getType());
		
		return response;
	}

}
