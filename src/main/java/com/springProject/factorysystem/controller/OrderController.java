package com.springProject.factorysystem.controller;

import com.springProject.factorysystem.dto.GetOrderRequest;
import com.springProject.factorysystem.dto.GetOrdersRequest;
import com.springProject.factorysystem.dto.PostOrderRequest;
import com.springProject.factorysystem.dto.PostOrderResponse;
import com.springProject.factorysystem.entity.Orders;
import com.springProject.factorysystem.entity.Product;
import com.springProject.factorysystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public List<GetOrdersRequest> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/latest")
    @PreAuthorize("hasRole('ADMIN')")
    public List<GetOrdersRequest> getLatestOrders(){
        return null;
    }

    @GetMapping("/{orderId}")
    @PreAuthorize("hasRole('ADMIN')")
    public GetOrderRequest getOrder(@PathVariable String orderId){
        return orderService.getOrder(orderId);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> postOrder(@RequestBody PostOrderRequest request){
        PostOrderResponse response = orderService.postOrder(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
