package com.springProject.factorysystem.service;

import com.springProject.factorysystem.dto.GetTaskRequest;
import com.springProject.factorysystem.dto.UpdateOrderStatusRequest;
import com.springProject.factorysystem.entity.Orders;
import com.springProject.factorysystem.entity.referenceEntities.master.CompanyMaster;
import com.springProject.factorysystem.repository.CompanyMasterRepository;
import com.springProject.factorysystem.repository.OrderRepository;
import com.springProject.factorysystem.service.whatsappService.messageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CompanyMasterRepository companyMasterRepository;

    @Autowired
    private messageSender messageSender;

    @Override
    public List<GetTaskRequest> getAllAssignedTasks(String assignedTo) {
        List<Orders> orderList = orderRepository.findByAssignedTo(assignedTo);
        return orderList
                .stream()
                .map(order -> new GetTaskRequest(order.getOrderId(), order.getAssignedTo(), order.getOrderStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Object> updateTaskStatus(UpdateOrderStatusRequest updateOrderStatusRequest, String orderId) {
        Orders order = orderRepository.findByOrderId(orderId);

        CompanyMaster company = companyMasterRepository.getById(order.getCompanyId());
        String phoneNumber = company.getContactDetails().getMobileNumber();

        messageSender.sendStatusMessage(phoneNumber, updateOrderStatusRequest.getOrderStatus());

        order.setOrderStatus(updateOrderStatusRequest.getOrderStatus());
        orderRepository.save(order);
        return ResponseEntity.ok("Updated Status");
    }
}
