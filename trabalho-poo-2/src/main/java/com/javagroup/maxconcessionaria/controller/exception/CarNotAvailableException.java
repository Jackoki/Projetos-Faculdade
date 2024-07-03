package com.javagroup.maxconcessionaria.controller.exception;

import javax.swing.JOptionPane;


public class CarNotAvailableException extends Exception {
    public CarNotAvailableException() {
    }
    
    public void screenException(){
        JOptionPane.showMessageDialog(null, "CARRO NÃO DISPONIVEL OU NÃO EXISTENTE!", "ERRO NA COMPRA", 0);
    }
}
