package com.cts.auditlogservice.repository;

import com.cts.auditlogservice.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findByServiceName(String serviceName);

    List<AuditLog> findByResourceType(String resourceType);

    List<AuditLog> findByAction(String action);
}
