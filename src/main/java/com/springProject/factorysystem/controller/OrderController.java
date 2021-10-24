package com.springProject.factorysystem.controller;

import com.springProject.factorysystem.dto.GetOrderRequest;
import com.springProject.factorysystem.dto.PostOrderRequest;
import com.springProject.factorysystem.dto.PostOrderResponse;
import com.springProject.factorysystem.entity.Orders;
import com.springProject.factorysystem.entity.Product;
import com.springProject.factorysystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<GetOrderRequest> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/{orderId}")
    public GetOrderRequest getOrder(@PathVariable String orderId){
        return orderService.getOrder(orderId);
    }

    @PostMapping("/")
    public ResponseEntity<Object> postOrder(@RequestBody PostOrderRequest request){
        PostOrderResponse response = orderService.postOrder(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
