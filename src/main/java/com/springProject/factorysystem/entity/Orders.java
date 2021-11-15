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
    private String companyName;
    private String orderStatus;
    private String companyAddress;
    private String contactPerson;
    private String contactNumber;
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

    public Orders(String orderId, String companyName, String orderStatus, String companyAddress, String contactPerson, String contactNumber, String assignedTo, int duration, List<Product> products, Tasks task) {
        this.orderId = orderId;
        this.companyName = companyName;
        this.orderStatus = orderStatus;
        this.companyAddress = companyAddress;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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
