package com.javagroup.maxconcessionaria.controller.exception;

import javax.swing.JOptionPane;


public class ScheduleAlreadyExistsException extends RuntimeException {
    public ScheduleAlreadyExistsException() {
    }
    
    public void screenException(){
        JOptionPane.showMessageDialog(null, "AGENDA JÁ ESTÁ OCUPADA NESSE DIA!", "ERRO NA AÇÃO", 0);
    }
}
