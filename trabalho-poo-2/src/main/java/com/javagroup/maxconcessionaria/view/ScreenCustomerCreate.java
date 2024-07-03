package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CustomerController;
import com.javagroup.maxconcessionaria.model.Customer;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenCustomerCreate extends javax.swing.JFrame {
    
    private final CustomerController customerController;
    
    @Autowired
    public ScreenCustomerCreate(CustomerController customerController) {
        this.customerController = customerController;
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextTitle = new javax.swing.JLabel();
        TextName = new javax.swing.JLabel();
        Name = new javax.swing.JScrollPane();
        fieldName = new javax.swing.JTextPane();
        TextAdress = new javax.swing.JLabel();
        Address = new javax.swing.JScrollPane();
        fieldAddress = new javax.swing.JTextPane();
        TextPhone = new javax.swing.JLabel();
        Phone = new javax.swing.JScrollPane();
        fieldPhone = new javax.swing.JTextPane();
        TextEmail = new javax.swing.JLabel();
        Email = new javax.swing.JScrollPane();
        fieldEmail = new javax.swing.JTextPane();
        TextCNH = new javax.swing.JLabel();
        CNH = new javax.swing.JScrollPane();
        fieldCNH = new javax.swing.JTextPane();
        ButtonRegister = new javax.swing.JButton();
        TextPassword = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        ReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextTitle.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        TextTitle.setText("Registre sua Conta");

        TextName.setText("Nome:");

        Name.setViewportView(fieldName);

        TextAdress.setText("Endereço:");

        Address.setViewportView(fieldAddress);

        TextPhone.setText("Telefone:");

        Phone.setViewportView(fieldPhone);

        TextEmail.setText("E-Mail:");

        Email.setViewportView(fieldEmail);

        TextCNH.setText("CNH:");

        CNH.setViewportView(fieldCNH);

        ButtonRegister.setText("Registrar Usuário");
        ButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegisterActionPerformed(evt);
            }
        });

        TextPassword.setText("Senha:");

        ReturnButton.setText("Voltar");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ReturnButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextTitle)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonRegister)
                        .addGap(217, 217, 217))))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextCNH)
                        .addGap(18, 18, 18)
                        .addComponent(CNH, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextPhone)
                            .addComponent(TextEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextAdress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextName, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Email)
                            .addComponent(Address)
                            .addComponent(Phone)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextPassword)
                        .addGap(18, 18, 18)
                        .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextName)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextAdress))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextPhone)
                    .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextEmail)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextCNH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextPassword)
                    .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(ButtonRegister)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegisterActionPerformed
        try {
            Customer customer = new Customer(fieldCNH.getText(), 1, fieldName.getText(), fieldAddress.getText(), fieldEmail.getText(), fieldPhone.getText(), fieldPassword.getText());
            
            customerController.save(customer);
        }
        
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NO CADASTRO DE CLIENTE", 0);
        }
    }//GEN-LAST:event_ButtonRegisterActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        ScreenCustomerLogin screenCustomerLogin = new ScreenCustomerLogin(customerController);
        screenCustomerLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                CustomerController customerController = context.getBean(CustomerController.class);
                new ScreenCustomerCreate(customerController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Address;
    private javax.swing.JButton ButtonRegister;
    private javax.swing.JScrollPane CNH;
    private javax.swing.JScrollPane Email;
    private javax.swing.JScrollPane Name;
    private javax.swing.JScrollPane Phone;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel TextAdress;
    private javax.swing.JLabel TextCNH;
    private javax.swing.JLabel TextEmail;
    private javax.swing.JLabel TextName;
    private javax.swing.JLabel TextPassword;
    private javax.swing.JLabel TextPhone;
    private javax.swing.JLabel TextTitle;
    private javax.swing.JTextPane fieldAddress;
    private javax.swing.JTextPane fieldCNH;
    private javax.swing.JTextPane fieldEmail;
    private javax.swing.JTextPane fieldName;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextPane fieldPhone;
    // End of variables declaration//GEN-END:variables
}
