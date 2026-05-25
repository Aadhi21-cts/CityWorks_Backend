package com.cts.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import com.cts.enums.TaskStatus;

@Getter
@Setter
public class UpdateTaskDto {
    private Long workOrderId;

    @Size(max = 255, message = "Description must not exceed 255 characters")

    private String description;

    private Long assignedTo;

    @FutureOrPresent(message = "Due date must be today or in the future")
    private LocalDateTime dueDate;

    private TaskStatus status;
}

