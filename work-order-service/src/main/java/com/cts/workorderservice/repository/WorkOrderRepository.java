package com.cts.workorderservice.repository;

import com.cts.workorderservice.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {

    List<WorkOrder> findByAssignedWorkerId(Long workerId);

    Optional<WorkOrder> findByRequestId(Long requestId);
}
