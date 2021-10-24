package com.springProject.factorysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transport {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String transportCompany;
    private String transportAddress;
    private String contactPerson;
    private int contactNumber;
    private String transportType;
    private String transportNumber;

    @Column(name = "transport2task")
    @JsonIgnore
    private String transport2task;

    public Transport() {
    }

    public Transport(String transportCompany, String transportAddress, String contactPerson, int contactNumber, String transportType, String transportNumber, String transport2task) {
        this.transportCompany = transportCompany;
        this.transportAddress = transportAddress;
        this.contactPerson = contactPerson;
        this.contactNumber = contactNumber;
        this.transportType = transportType;
        this.transportNumber = transportNumber;
        this.transport2task = transport2task;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(String transportCompany) {
        this.transportCompany = transportCompany;
    }

    public String getTransportAddress() {
        return transportAddress;
    }

    public void setTransportAddress(String transportAddress) {
        this.transportAddress = transportAddress;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getTransportNumber() {
        return transportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    public String getTransport2task() {
        return transport2task;
    }

    public void setTransport2task(String transport2task) {
        this.transport2task = transport2task;
    }
}
