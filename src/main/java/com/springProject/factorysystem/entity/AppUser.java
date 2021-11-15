package com.springProject.factorysystem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role2user", referencedColumnName = "id")
    private List<AppRole> roles;

    public AppUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AppRole> roles) {
        this.roles = roles;
    }
}
