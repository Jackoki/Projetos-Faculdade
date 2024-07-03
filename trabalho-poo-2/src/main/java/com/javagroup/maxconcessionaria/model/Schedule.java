package com.javagroup.maxconcessionaria.model;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
    private Integer idUser;
    private Date date;
    private String userName;

    public Schedule() {
    }
    
    public Schedule(Integer idUser, Date date, String userName) {
        this.idUser = idUser;
        this.date = date;
        this.userName = userName;
    }

    
    public Integer getIdUser() {
        return idUser;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public Date getDate() {
        return date;
    }

    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
        
    public void setDate(Date date) {
        this.date = date;
    }
    

}
