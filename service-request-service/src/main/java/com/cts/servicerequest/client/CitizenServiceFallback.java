package com.cts.servicerequest.client;

import org.springframework.stereotype.Component;

import com.cts.servicerequest.dto.AssetResponseDTO;
import com.cts.servicerequest.exception.ServiceNotAvailableException;


@Component
public class CitizenServiceFallback implements CitizenServiceClient {

    @Override
    public AssetResponseDTO getAssetById(Long id) {
        
        throw new ServiceNotAvailableException("Asset service is Not Available");
    }
}
