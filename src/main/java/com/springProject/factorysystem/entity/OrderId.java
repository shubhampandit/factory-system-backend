package com.springProject.factorysystem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderId {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private Long latestId;

    public OrderId() {
    }

    public OrderId(Long latestId) {
        this.latestId = latestId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLatestId() {
        return latestId;
    }

    public void setLatestId(Long latestId) {
        this.latestId = latestId;
    }
}
