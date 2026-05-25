package com.cts.mapper;

import com.cts.dto.request.CreateTaskDto;
import com.cts.entity.Task;
import com.cts.enums.TaskStatus;

public class CreateTaskMapper {
    private CreateTaskMapper(){

    }

    public static Task toEntity(CreateTaskDto dto){
        if(dto == null) {
            return null;
        }

        return Task.builder()
                .workOrder(dto.getWorkOrderId())
                .description(dto.getDescription())
                .assignedTo(dto.getAssignedTo())
                .dueDate(dto.getDueDate())
                .status(TaskStatus.PENDING)
                .build();
    }

    public static CreateTaskDto toCreateTaskDto(Task task) {
        if (task == null) {
            return null;
        }

        return new CreateTaskDto(
                task.getWorkOrder(),
                task.getDescription(),
                task.getAssignedTo(),
                task.getDueDate()
        );
    }
}
