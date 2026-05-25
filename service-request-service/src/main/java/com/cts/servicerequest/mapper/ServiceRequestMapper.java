package com.cts.servicerequest.mapper;

import com.cts.servicerequest.dto.ServiceRequestDTO;
import com.cts.servicerequest.entity.ServiceRequest;
import org.springframework.stereotype.Component;

@Component
public class ServiceRequestMapper {

    public ServiceRequestDTO toDTO(ServiceRequest entity) {
        ServiceRequestDTO dto = new ServiceRequestDTO();
        dto.setRequestId(entity.getRequestId());
        dto.setAssetId(entity.getAssetId());
        dto.setDescription(entity.getDescription());
        dto.setSubmittedAt(entity.getSubmittedAt());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    public ServiceRequest toEntity(ServiceRequestDTO dto) {
        ServiceRequest entity = new ServiceRequest();
        entity.setAssetId(dto.getAssetId());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
