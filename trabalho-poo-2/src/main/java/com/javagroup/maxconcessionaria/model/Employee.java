package com.javagroup.maxconcessionaria.model;

import org.springframework.stereotype.Component;

@Component
public class Employee extends User{
    private Integer lvlPermission;

    public Employee(Integer lvlPermission, Integer id, Integer category, String name, String address, String email, String phone, String password) {
        super(id, category, name, address, email, phone, password);
        this.lvlPermission = lvlPermission;
    }
    
    public Employee(Integer lvlPermission, Integer category, String name, String address, String email, String phone, String password) {
        super(category, name, address, email, phone, password);
        this.lvlPermission = lvlPermission;
    }
    
    public Employee() {
    }
    
    public Integer getLvlPermission() {
        return lvlPermission;
    }

    public void setLvlPermission(Integer lvlPermission) {
        this.lvlPermission = lvlPermission;
    }

}
