package com.springProject.factorysystem.dto;

import com.springProject.factorysystem.entity.Product;

import java.util.List;

public class GetOrderRequest {

    private String orderId;
    private String companyName;
    private String companyAddress;
    private String contactName;
    private String contactNumber;
    private String assignedTo;
    private String orderStatus;

    private List<Product> products;

    public GetOrderRequest() {
    }

    public GetOrderRequest(String orderId, String companyName, String companyAddress, String contactName, String contactNumber, String assignedTo, String orderStatus, List<Product> products) {
        this.orderId = orderId;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.assignedTo = assignedTo;
        this.orderStatus = orderStatus;
        this.products = products;
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

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
