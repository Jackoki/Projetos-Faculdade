package com.javagroup.maxconcessionaria.controller.exception;

import javax.swing.JOptionPane;


public class IdDoesNotExistException extends Exception {
    public IdDoesNotExistException() {
    }
    
    public void screenException(){
        JOptionPane.showMessageDialog(null, "ID NÃO EXISTENTE NO SISTEMA!", "ERRO NO BANCO DE DADOS", 0);
    }
}
