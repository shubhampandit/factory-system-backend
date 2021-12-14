package com.springProject.factorysystem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String orderId;
    private String companyId;
    private String orderStatus;
    private String brokerId;
    private String assignedTo;
    private int duration;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product2order", referencedColumnName = "id")
    private List<Product> products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order2tasks", referencedColumnName = "id")
    private Tasks task;

    public Orders() {
    }

    public Orders(String orderId, String companyId, String orderStatus, String brokerId, String assignedTo, int duration, List<Product> products, Tasks task) {
        this.orderId = orderId;
        this.companyId = companyId;
        this.orderStatus = orderStatus;
        this.brokerId = brokerId;
        this.assignedTo = assignedTo;
        this.duration = duration;
        this.products = products;
        this.task = task;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Tasks getTask() {
        return task;
    }

    public void setTask(Tasks task) {
        this.task = task;
    }
}
