package com.cts.auditlogservice.controller;

import com.cts.auditlogservice.api.ApiResponse;
import com.cts.auditlogservice.dto.request.CreateAuditLogDTO;
import com.cts.auditlogservice.dto.response.AuditLogResponseDTO;
import com.cts.auditlogservice.service.impl.AuditLogServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    private final AuditLogServiceImpl auditLogService;

    public AuditLogController(AuditLogServiceImpl auditLogService) {
        this.auditLogService = auditLogService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AuditLogResponseDTO>> createLog(
            @RequestBody CreateAuditLogDTO dto) {

        AuditLogResponseDTO data = auditLogService.createLog(dto);
        ApiResponse<AuditLogResponseDTO> response =
                new ApiResponse<>("SUCCESS", "Audit log saved successfully", data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PreAuthorize("hasRole('AUDITOR')")
    @GetMapping
    public ResponseEntity<ApiResponse<List<AuditLogResponseDTO>>> getAllLogs() {

        List<AuditLogResponseDTO> data = auditLogService.getAllLogs();
        ApiResponse<List<AuditLogResponseDTO>> response =
                new ApiResponse<>("FOUND", "All audit logs retrieved", data);
        return ResponseEntity.ok(response);
    }


    @PreAuthorize("hasRole('AUDITOR')")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AuditLogResponseDTO>> getById(
            @PathVariable Long id) {

        AuditLogResponseDTO data = auditLogService.getById(id);
        ApiResponse<AuditLogResponseDTO> response =
                new ApiResponse<>("FOUND", "Audit log retrieved", data);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('AUDITOR')")
    @GetMapping("/service/{serviceName}")
    public ResponseEntity<ApiResponse<List<AuditLogResponseDTO>>> getByServiceName(
            @PathVariable String serviceName) {

        List<AuditLogResponseDTO> data = auditLogService.getByServiceName(serviceName);
        ApiResponse<List<AuditLogResponseDTO>> response =
                new ApiResponse<>("FOUND",
                        "Audit logs for service " + serviceName + " retrieved", data);
        return ResponseEntity.ok(response);
    }


    @PreAuthorize("hasRole('AUDITOR')")
    @GetMapping("/resource/{resourceType}")
    public ResponseEntity<ApiResponse<List<AuditLogResponseDTO>>> getByResourceType(
            @PathVariable String resourceType) {

        List<AuditLogResponseDTO> data = auditLogService.getByResourceType(resourceType);
        ApiResponse<List<AuditLogResponseDTO>> response =
                new ApiResponse<>("FOUND",
                        "Audit logs for resource " + resourceType + " retrieved", data);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('AUDITOR')")
    @GetMapping("/action/{action}")
    public ResponseEntity<ApiResponse<List<AuditLogResponseDTO>>> getByAction(
            @PathVariable String action) {

        List<AuditLogResponseDTO> data = auditLogService.getByAction(action);
        ApiResponse<List<AuditLogResponseDTO>> response =
                new ApiResponse<>("FOUND",
                        "Audit logs for action " + action + " retrieved", data);
        return ResponseEntity.ok(response);
    }
}
