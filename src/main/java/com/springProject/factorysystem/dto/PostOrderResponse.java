package com.springProject.factorysystem.dto;

public class PostOrderResponse {
    private String status;
    private String orderId;

    public PostOrderResponse() {
    }

    public PostOrderResponse(String status, String orderId) {
        this.status = status;
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
