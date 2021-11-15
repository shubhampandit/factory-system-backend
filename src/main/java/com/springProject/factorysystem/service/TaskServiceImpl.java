package com.springProject.factorysystem.service;

import com.springProject.factorysystem.dto.GetTaskRequest;
import com.springProject.factorysystem.entity.Tasks;
import com.springProject.factorysystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<GetTaskRequest> getAllAssignedTasks(String assignedTo) {
        List<Tasks> taskList = taskRepository.findByAssignedTo(assignedTo);
        return taskList
                .stream()
                .map(task -> new GetTaskRequest(task.getOrderId(), task.getAssignedTo(), task.getTaskStatus()))
                .collect(Collectors.toList());
    }
}
