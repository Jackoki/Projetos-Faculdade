package com.javagroup.maxconcessionaria.controller.exception;

import javax.swing.JOptionPane;


public class WrongDataException extends Exception {
    public WrongDataException() {
    }
    
    public void screenException(){
        JOptionPane.showMessageDialog(null, "DADOS INCORRETOS!", "ERRO NO BANCO DE DADOS", 0);
    }
}
