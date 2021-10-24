package com.springProject.factorysystem.service;

import com.springProject.factorysystem.dto.GetTaskRequest;

import java.util.List;

public interface TaskService {
    public List<GetTaskRequest> getAllAssignedTasks(String assignedTo);
}
