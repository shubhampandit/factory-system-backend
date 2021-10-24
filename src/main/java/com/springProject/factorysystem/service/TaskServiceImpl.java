package com.springProject.factorysystem.service;

import com.springProject.factorysystem.dto.GetTaskRequest;
import com.springProject.factorysystem.entity.Tasks;
import com.springProject.factorysystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<GetTaskRequest> getAllAssignedTasks(String assignedTo) {
        List<Tasks> taskList = taskRepository.findByAssignedTo(assignedTo);
        List<GetTaskRequest> taskRequestList = new ArrayList<>();

        for (Tasks task : taskList){
            GetTaskRequest taskRequest = new GetTaskRequest(task.getOrderId(), task.getAssignedTo(), task.getTaskStatus());
            taskRequestList.add(taskRequest);
        }
        return taskRequestList;
    }
}
