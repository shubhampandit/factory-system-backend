package com.springProject.factorysystem.dto;

public class GetTaskRequest {

    private String orderId;
    private String assignedTo;
    private String orderStatus;

    public GetTaskRequest() {
    }

    public GetTaskRequest(String orderId, String assignedTo, String orderStatus) {
        this.orderId = orderId;
        this.assignedTo = assignedTo;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
