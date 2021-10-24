package com.springProject.factorysystem.dto;

import com.springProject.factorysystem.entity.Product;

import java.util.List;

public class GetOrderRequest {

    private String orderId;
    private String companyName;
    private String assignedTo;
    private String orderStatus;

    public GetOrderRequest() {
    }

    public GetOrderRequest(String orderId, String companyName, String assignedTo, String orderStatus) {
        this.orderId = orderId;
        this.companyName = companyName;
        this.assignedTo = assignedTo;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
