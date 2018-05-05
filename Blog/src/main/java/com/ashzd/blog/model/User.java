package com.ashzd.blog.model;

import org.springframework.stereotype.Component;

@Component
public class User {
    private int id;
    private String name;
    private String password;
    private String email;

    private String salt;
    private String headUrl;
    private String role;

    public User(){}

    public User(String name) {
        this.name = name;
        this.password = "";
        this.email = "";
        this.salt = "";
        this.headUrl = "";
        this.role = "user";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
