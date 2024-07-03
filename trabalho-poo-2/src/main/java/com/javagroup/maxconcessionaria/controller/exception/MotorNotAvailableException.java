package com.javagroup.maxconcessionaria.controller.exception;

import javax.swing.JOptionPane;


public class MotorNotAvailableException extends Exception {
    public MotorNotAvailableException() {
    }
    
    public void screenException(){
        JOptionPane.showMessageDialog(null, "MOTO NÃO DISPONIVEL OU NÃO EXISTENTE!", "ERRO NA COMPRA", 0);
    }
}
