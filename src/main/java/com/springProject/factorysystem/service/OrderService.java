package com.springProject.factorysystem.service;

import com.springProject.factorysystem.dto.GetOrderRequest;
import com.springProject.factorysystem.dto.GetOrdersRequest;
import com.springProject.factorysystem.dto.PostOrderRequest;
import com.springProject.factorysystem.dto.PostOrderResponse;

import java.util.List;

public interface OrderService {

    public List<GetOrdersRequest> getOrders();
    public GetOrderRequest getOrder(String orderId);
    public PostOrderResponse postOrder(PostOrderRequest postOrderRequest);

}
