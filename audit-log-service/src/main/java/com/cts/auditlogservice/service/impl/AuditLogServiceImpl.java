package com.cts.auditlogservice.service.impl;

import com.cts.auditlogservice.dto.request.CreateAuditLogDTO;
import com.cts.auditlogservice.dto.response.AuditLogResponseDTO;
import com.cts.auditlogservice.entity.AuditLog;
import com.cts.auditlogservice.exception.ResourceNotFoundException;
import com.cts.auditlogservice.repository.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditLogServiceImpl {

    private final AuditLogRepository auditLogRepository;

    public AuditLogServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    public AuditLogResponseDTO createLog(CreateAuditLogDTO dto) {
        AuditLog log = new AuditLog();
        log.setAction(dto.getAction());
        log.setResourceType(dto.getResourceType());
        log.setDetails(dto.getDetails());
        log.setServiceName(dto.getServiceName());


        AuditLog saved = auditLogRepository.save(log);
        System.out.println("[AUDIT-LOG-SERVICE] Saved audit log id: "
                + saved.getAuditId()
                + " | action: " + saved.getAction()
                + " | service: " + saved.getServiceName());
        return toDTO(saved);
    }


    public List<AuditLogResponseDTO> getAllLogs() {
        return auditLogRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public AuditLogResponseDTO getById(Long id) {
        AuditLog log = auditLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Audit log not found with id: " + id));
        return toDTO(log);
    }

    public List<AuditLogResponseDTO> getByServiceName(String serviceName) {
        List<AuditLog> logs = auditLogRepository.findByServiceName(serviceName);
        if (logs.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No audit logs found for service: " + serviceName);
        }
        return logs.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AuditLogResponseDTO> getByResourceType(String resourceType) {
        List<AuditLog> logs = auditLogRepository.findByResourceType(resourceType);
        if (logs.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No audit logs found for resource type: " + resourceType);
        }
        return logs.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<AuditLogResponseDTO> getByAction(String action) {
        List<AuditLog> logs = auditLogRepository.findByAction(action);
        if (logs.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No audit logs found for action: " + action);
        }
        return logs.stream().map(this::toDTO).collect(Collectors.toList());
    }


    private AuditLogResponseDTO toDTO(AuditLog log) {
        return new AuditLogResponseDTO(
                log.getAuditId(),
                log.getAction(),
                log.getResourceType(),
                log.getDetails(),
                log.getServiceName(),
                log.getTimestamp()
        );
    }
}
