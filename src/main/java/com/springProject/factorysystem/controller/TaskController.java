package com.springProject.factorysystem.controller;

import com.springProject.factorysystem.dto.GetTaskRequest;
import com.springProject.factorysystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{assignedTo}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<GetTaskRequest> getAllAssignedTask(@PathVariable String assignedTo){
        return taskService.getAllAssignedTasks(assignedTo);
    }
}
