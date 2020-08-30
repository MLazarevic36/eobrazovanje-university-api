package com.eobrazovanje.university.mapper.dto;

import com.eobrazovanje.university.entity.Role;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private Long id;
    private String username;
    private String password;
    private Role role;
    private Boolean deleted;
    private String token;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String password, Role role, Boolean deleted) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
