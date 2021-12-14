package com.springProject.factorysystem.service;

import com.springProject.factorysystem.dto.GetTaskRequest;
import com.springProject.factorysystem.entity.Orders;
import com.springProject.factorysystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<GetTaskRequest> getAllAssignedTasks(String assignedTo) {
        List<Orders> orderList = orderRepository.findByAssignedTo(assignedTo);
        return orderList
                .stream()
                .map(order -> new GetTaskRequest(order.getOrderId(), order.getAssignedTo(), order.getOrderStatus()))
                .collect(Collectors.toList());
    }
}
