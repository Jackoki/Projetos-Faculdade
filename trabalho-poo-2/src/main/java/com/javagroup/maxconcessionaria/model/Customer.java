package com.javagroup.maxconcessionaria.model;

import org.springframework.stereotype.Component;

@Component
public class Customer extends User{
    private String cnh;

    public Customer(String cnh, Integer id, Integer category, String name, String address, String email, String phone, String password) {
        super(id, category, name, address, email, phone, password);
        this.cnh = cnh;
    }
    
    public Customer(String cnh, Integer category, String name, String address, String email, String phone, String password) {
        super(category, name, address, email, phone, password);
        this.cnh = cnh;
    }

    public Customer() {
    }
    
    
    public String getCnh() {
        return this.cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
