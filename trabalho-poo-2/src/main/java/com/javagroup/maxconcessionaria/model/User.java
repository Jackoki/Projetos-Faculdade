package com.javagroup.maxconcessionaria.model;

public abstract class User {
    private Integer id;
    private Integer category;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String password;

    public User(Integer id, Integer category, String name, String address, String email, String phone, String password) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    
    public User(Integer category, String name, String address, String email, String phone, String password) {
        this.category = category;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public User() {
    }
    
    public Integer getId() {
        return id;
    }

    public Integer getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    
    public String getPassword() {
        return password;
    }
    

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
}
