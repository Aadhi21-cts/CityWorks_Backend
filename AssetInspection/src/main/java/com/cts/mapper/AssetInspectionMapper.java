package com.cts.mapper;

import org.springframework.stereotype.Component;

import com.cts.dto.request.CreateAssetInspectionRequestDTO;
import com.cts.dto.response.AssetInspectionResponseDTO;
import com.cts.entity.AssetInspection;

@Component
public class AssetInspectionMapper {

	public AssetInspectionResponseDTO toResponse(AssetInspection inspection) {
		AssetInspectionResponseDTO dto = new AssetInspectionResponseDTO();

		dto.setInspectionId(inspection.getInspectionId());
		dto.setConditionRating(inspection.getConditionRating());
		dto.setFindings(inspection.getFindings());
		dto.setInspectionId(inspection.getInspectionId());
		dto.setPhotoUri(inspection.getPhotoUri());
		dto.setStatus(inspection.getStatus());
		dto.setPerformedAt(inspection.getPerformedAt());

		if (inspection.getAssetId() != null) {
			dto.setAssetId(inspection.getAssetId());
		}

		return dto;
	}

	public AssetInspection toEntity(CreateAssetInspectionRequestDTO dto) {
		AssetInspection inspection = new AssetInspection();

		inspection.setConditionRating(dto.getConditionRating());
		inspection.setFindings(dto.getFindings());
		inspection.setPhotoUri(dto.getPhotoUri());
		inspection.setStatus(dto.getStatus());
		inspection.setPerformedAt(dto.getPerformedAt());

		if (dto.getAssetId() != null) {
			inspection.setAssetId(dto.getAssetId());
		}
		
		return inspection;

	}

}
