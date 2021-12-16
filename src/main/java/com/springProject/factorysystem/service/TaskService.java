package com.springProject.factorysystem.service;

import com.springProject.factorysystem.dto.GetTaskRequest;
import com.springProject.factorysystem.dto.UpdateOrderStatusRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    public List<GetTaskRequest> getAllAssignedTasks(String assignedTo);

    public ResponseEntity<Object> updateTaskStatus(UpdateOrderStatusRequest updateOrderStatusRequest, String orderId);
}
