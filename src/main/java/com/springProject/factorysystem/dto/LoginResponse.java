package com.springProject.factorysystem.dto;

public class LoginResponse {
    private String userName;
    private String role;
    private String jwt;

    public LoginResponse() {
    }

    public LoginResponse(String userName, String role, String jwt) {
        this.userName = userName;
        this.role = role;
        this.jwt = jwt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
