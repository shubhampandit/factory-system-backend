package com.springProject.factorysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Workers {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String workerType;
    private int quantity;

    @Column(name = "workers2task")
    @JsonIgnore
    private String workers2task;

    public Workers() {
    }

    public Workers(String workerType, int quantity, String workers2task) {
        this.workerType = workerType;
        this.quantity = quantity;
        this.workers2task = workers2task;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkerType() {
        return workerType;
    }

    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWorkers2task() {
        return workers2task;
    }

    public void setWorkers2task(String workers2task) {
        this.workers2task = workers2task;
    }
}
