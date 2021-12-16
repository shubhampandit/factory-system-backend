package com.springProject.factorysystem.controller;

import com.springProject.factorysystem.dto.GetTaskRequest;
import com.springProject.factorysystem.dto.UpdateOrderStatusRequest;
import com.springProject.factorysystem.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/task")
public class TaskController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @GetMapping("/{assignedTo}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<GetTaskRequest> getAllAssignedTask(@PathVariable String assignedTo) {
        return taskService.getAllAssignedTasks(assignedTo);
    }

    @PatchMapping("/updateStatus/{orderId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Object> updateTaskStatus(@RequestBody UpdateOrderStatusRequest updateOrderStatusRequest,
                                                   @PathVariable String orderId) {
        LOGGER.info("updated status");
        return taskService.updateTaskStatus(updateOrderStatusRequest, orderId);
    }
}
