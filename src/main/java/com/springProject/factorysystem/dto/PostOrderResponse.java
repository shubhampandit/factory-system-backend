package com.springProject.factorysystem.dto;

public class PostOrderResponse {
    private String status;

    public PostOrderResponse() {
    }

    public PostOrderResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
