package com.cts.servicerequest.service;

import com.cts.servicerequest.dto.ServiceRequestDTO;
import com.cts.servicerequest.enums.ServiceRequestStatus;

import java.util.List;

public interface ServiceRequestService {

    ServiceRequestDTO createRequest(ServiceRequestDTO dto);

    List<ServiceRequestDTO> getAllRequests();

    ServiceRequestDTO getById(Long id);

    ServiceRequestDTO approveRequest(Long id);

    ServiceRequestDTO rejectRequest(Long id);

    List<ServiceRequestDTO> getAllByCitizenId(Long citizenId);
    
    void updateRequestStatusById(Long requestId, ServiceRequestStatus status);

    void delete(Long id);
}
