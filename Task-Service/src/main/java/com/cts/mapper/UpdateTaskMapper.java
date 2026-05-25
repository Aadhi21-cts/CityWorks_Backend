package com.cts.mapper;

import com.cts.dto.request.UpdateTaskDto;
import com.cts.entity.Task;

public class UpdateTaskMapper {
    private UpdateTaskMapper(){
        //utility class
    }

    public static void toEntity(Task task, UpdateTaskDto dto){
        if (dto == null || task == null){
            return;
        }

        //Update Work Order(F.K.)
        if(dto.getWorkOrderId() != null){
            task.setWorkOrder(dto.getWorkOrderId());
        }

        //Update Description
        if(dto.getDescription() != null){
            task.setDescription(dto.getDescription());
        }

        //Update Assigned To
        if(dto.getAssignedTo() != null){
            task.setAssignedTo(dto.getAssignedTo());
        }

        //Update Due Date
        if(dto.getDueDate() != null){
            task.setDueDate(dto.getDueDate());
        }

        //Update Status
        if(dto.getStatus() != null) {
            task.setStatus(dto.getStatus());
        }
    }
}
