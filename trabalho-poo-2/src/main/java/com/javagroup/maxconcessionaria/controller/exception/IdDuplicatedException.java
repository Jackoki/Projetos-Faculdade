package com.javagroup.maxconcessionaria.controller.exception;

import javax.swing.JOptionPane;


public class IdDuplicatedException extends RuntimeException {
    public IdDuplicatedException() {
    }
    
    public void screenException(){
        JOptionPane.showMessageDialog(null, "ID JÁ CADASTRADO NO SISTEMA, FAVOR INSERIR OUTRO!", "ERRO NA AÇÃO", 0);
    }
}
