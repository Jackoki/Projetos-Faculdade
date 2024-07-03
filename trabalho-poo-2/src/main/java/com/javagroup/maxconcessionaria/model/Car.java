package com.javagroup.maxconcessionaria.model;

import org.springframework.stereotype.Component;

@Component
public class Car extends Vehicle{
    private Integer quantAirbag;

    public Car(Integer quantAirbag, String plate, String idChassis, String brand, String model, String color, Integer yearMade, Integer idUser, Boolean available) {
        super(plate, idChassis, brand, model, color, yearMade, idUser, available);
        this.quantAirbag = quantAirbag;
    }

    public Car() {
    }

    public Integer getQuantAirbag() {
        return quantAirbag;
    }

    public void setQuantAirbag(Integer quantAirbag) {
        this.quantAirbag = quantAirbag;
    }
    
}
