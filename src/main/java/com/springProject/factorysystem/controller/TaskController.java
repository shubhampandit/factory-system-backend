package com.springProject.factorysystem.controller;

import com.springProject.factorysystem.dto.GetTaskRequest;
import com.springProject.factorysystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{assignedTo}")
    public List<GetTaskRequest> getAllAssignedTask(@PathVariable String assignedTo){
        return taskService.getAllAssignedTasks(assignedTo);
    }
}
