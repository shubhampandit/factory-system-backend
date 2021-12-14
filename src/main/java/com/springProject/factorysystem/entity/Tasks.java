package com.springProject.factorysystem.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String orderId;
    private String assignedTo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "workers2task", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Workers> workers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Transport> transports;

    public Tasks() {
    }

    public Tasks(String orderId, String assignedTo, List<Workers> workers, List<Transport> transports) {
        this.orderId = orderId;
        this.assignedTo = assignedTo;
        this.workers = workers;
        this.transports = transports;
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

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public List<Workers> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Workers> workers) {
        this.workers = workers;
    }

    public List<Transport> getTransports() {
        return transports;
    }

    public void setTransports(List<Transport> transports) {
        this.transports = transports;
    }
}
