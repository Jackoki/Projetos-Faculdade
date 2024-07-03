package com.javagroup.maxconcessionaria.model;

public abstract class Vehicle {
    private String plate;
    private String idChassis;
    private String brand;
    private String model;
    private String color;
    private Integer yearMade;
    private Integer idUser;
    private Boolean available;
    private Boolean sold;

    public Vehicle() {
    }
    
    public Vehicle(String plate, String idChassis, String brand, String model, String color, Integer yearMade, Integer idUser, Boolean available) {
        this.plate = plate;
        this.idChassis = idChassis;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearMade = yearMade;
        this.idUser = idUser;
        this.available = available;
    }

    
    public String getPlate(){
        return this.plate;
    }
    
    public String getIdChassis(){
        return this.idChassis;
    }
        
    public String getBrand(){
        return this.brand;
    }
    
    public String getModel(){
        return this.model;
    }
        
    public String getColor(){
        return this.color;
    }
    
    public Integer getYearMade(){
        return this.yearMade;
    }
    
    public Integer getIdUser(){
        return this.idUser;
    }
    
    public Boolean getAvailable(){
        return this.available;
    }
    
    public Boolean getSold(){
        return this.sold;
    }
    
    
    
    
    public void setPlate(String plate){
        this.plate = plate;
    }
    
    public void setIdChassis(String idChassis){
        this.idChassis = idChassis;
    }
        
    public void setBrand(String brand){
        this.brand = brand;
    }
    
    public void setModel(String model){
        this.model = model;
    }
        
    public void setColor(String color){
        this.color = color;
    }
    
    public void setIdUser(Integer idUser){
        this.idUser = idUser;
    }
    
    public void setYearMade(Integer yearMade) throws NumberFormatException{
        this.yearMade = yearMade;
    }
    
    public void setAvailable(Boolean available){
        this.available = available;
    }
    
    public void setSold(Boolean sold){
        this.sold = sold;
    }
}
