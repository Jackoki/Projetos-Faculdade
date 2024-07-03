package com.javagroup.maxconcessionaria.controller.exception;

import javax.swing.JOptionPane;


public class UserException extends RuntimeException {
    public UserException() {
    }
    
    public void screenException(){
        JOptionPane.showMessageDialog(null, "USUÁRIO NÃO EXISTENTE OU DADOS ERRADOS!", "ERRO NA AÇÃO", 0);
    }
}
