package com.javagroup.maxconcessionaria.model;

import org.springframework.stereotype.Component;

@Component
public class Motorcycle extends Vehicle {
    private Boolean saddlebag;

    public Boolean getSaddlebag() {
        return saddlebag;
    }

    public void setSaddlebag(Boolean saddlebag) {
        this.saddlebag = saddlebag;
    }

    public Motorcycle() {
    }
    
    public Motorcycle(Boolean saddlebag, String plate, String idChassis, String brand, String model, String color, Integer yearMade, Integer idUser, Boolean available) {
        super(plate, idChassis, brand, model, color, yearMade, idUser, available);
        this.saddlebag = saddlebag;
    }
   
}
