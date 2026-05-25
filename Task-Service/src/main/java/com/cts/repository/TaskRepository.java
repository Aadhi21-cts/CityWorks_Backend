package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTaskIdAndDeletedFalse(Long taskId);
    Optional<List<Task>> findAllByDeletedFalse();
    List<Task> findAllByAssignedTo(Long assignedTo);
}

