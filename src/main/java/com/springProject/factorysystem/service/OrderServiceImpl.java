package com.springProject.factorysystem.service;

import com.springProject.factorysystem.constant.OrderConstant;
import com.springProject.factorysystem.dto.GetOrderRequest;
import com.springProject.factorysystem.dto.GetOrdersRequest;
import com.springProject.factorysystem.dto.PostOrderRequest;
import com.springProject.factorysystem.dto.PostOrderResponse;
import com.springProject.factorysystem.entity.Orders;
import com.springProject.factorysystem.entity.Tasks;
import com.springProject.factorysystem.repository.OrderRepository;
import com.springProject.factorysystem.service.idGenerator.IDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private IDGeneratorService idGeneratorService;

    @Override
    public List<GetOrdersRequest> getOrders() {
        List<Orders> orders = orderRepository.findAll();
        List<GetOrdersRequest> requestList = new ArrayList<>();
        for(Orders order : orders){
            GetOrdersRequest request = new GetOrdersRequest(order.getOrderId(), order.getCompanyName(), order.getAssignedTo(), order.getOrderStatus());
            requestList.add(request);
        }
        return requestList;
    }

    @Override
    public GetOrderRequest getOrder(String orderId) {
        Orders order = orderRepository.findByOrderId(orderId);
        return new GetOrderRequest(order.getOrderId(), order.getCompanyName(), order.getCompanyAddress(), order.getContactPerson(), order.getContactNumber(), order.getAssignedTo(), order.getOrderStatus(), order.getProducts());
    }

    @Override
    public PostOrderResponse postOrder(PostOrderRequest postOrderRequest) {
        String uniqueOrderID = idGeneratorService.generateID();

        Orders order = createOrder(uniqueOrderID, postOrderRequest);

        Tasks task = new Tasks();
        task.setOrderId(uniqueOrderID);
        task.setAssignedTo(postOrderRequest.getAssignedTo());
        task.setTaskStatus(OrderConstant.OrderStatus.ORDER_PLACED);
        order.setTask(task);

        orderRepository.save(order);

        return new PostOrderResponse("Created", uniqueOrderID);
    }

    private Orders createOrder(String uniqueOrderID, PostOrderRequest postOrderRequest){
        Orders order = new Orders();
        order.setOrderId(uniqueOrderID);
        order.setCompanyName(postOrderRequest.getCompanyName());
        order.setOrderStatus(OrderConstant.OrderStatus.ORDER_PLACED);
        order.setCompanyAddress(postOrderRequest.getCompanyAddress());
        order.setContactPerson(postOrderRequest.getContactPerson());
        order.setContactNumber(postOrderRequest.getContactNumber());
        order.setAssignedTo(postOrderRequest.getAssignedTo());
        order.setProducts(postOrderRequest.getProducts());

        return order;
    }
}
