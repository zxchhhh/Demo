package com.zcx.entity;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author zcx
 * @version 1.0
 * @date 2020/3/11 21:23
 */
public class User implements Serializable {

    private Integer id;
    private String name;
    private String password;
    private Integer role;

    public User() {
    }

    public User(Integer id, String name, String password, Integer role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
