package com.springProject.factorysystem.dto;

public class GetProductSearchDTO {
    private String productId;
    private String productName;
    private Double price;
    private Double guessingDiff;

    public GetProductSearchDTO() {
    }

    public GetProductSearchDTO(String productId, String productName, Double price, Double guessingDiff) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.guessingDiff = guessingDiff;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getGuessingDiff() {
        return guessingDiff;
    }

    public void setGuessingDiff(Double guessingDiff) {
        this.guessingDiff = guessingDiff;
    }
}
