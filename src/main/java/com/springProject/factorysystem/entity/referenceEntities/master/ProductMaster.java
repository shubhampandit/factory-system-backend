package com.springProject.factorysystem.entity.referenceEntities.master;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductMaster {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String hsnsac;
    private String type;
    private String unit;
    private Boolean isNonGSTGood;
    private String taxability;
    private Double basicRate;
    private Double guessingDiff;

    public ProductMaster() {
    }

    public ProductMaster(String name, String hsnsac, String type, String unit, Boolean isNonGSTGood, String taxability, Double basicRate, Double guessingDiff) {
        this.name = name;
        this.hsnsac = hsnsac;
        this.type = type;
        this.unit = unit;
        this.isNonGSTGood = isNonGSTGood;
        this.taxability = taxability;
        this.basicRate = basicRate;
        this.guessingDiff = guessingDiff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHsnsac() {
        return hsnsac;
    }

    public void setHsnsac(String hsnsac) {
        this.hsnsac = hsnsac;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getNonGSTGood() {
        return isNonGSTGood;
    }

    public void setNonGSTGood(Boolean nonGSTGood) {
        isNonGSTGood = nonGSTGood;
    }

    public String getTaxability() {
        return taxability;
    }

    public void setTaxability(String taxability) {
        this.taxability = taxability;
    }

    public Double getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(Double basicRate) {
        this.basicRate = basicRate;
    }

    public Double getGuessingDiff() {
        return guessingDiff;
    }

    public void setGuessingDiff(Double guessingDiff) {
        this.guessingDiff = guessingDiff;
    }
}
