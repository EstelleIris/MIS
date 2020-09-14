package com.model;

import java.io.Serializable;

public class User implements Serializable {
    private String no;
    private String role;
    private String password;

    public User() {
    }

    public User(String no, String role, String password) {
        this.no = no;
        this.role = role;
        this.password = password;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
