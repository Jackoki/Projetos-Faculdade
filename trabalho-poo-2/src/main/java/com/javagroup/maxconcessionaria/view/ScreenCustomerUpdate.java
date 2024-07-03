package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CustomerController;
import com.javagroup.maxconcessionaria.controller.exception.WrongDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenCustomerUpdate extends javax.swing.JFrame {
    
    private final CustomerController customerController;
    private static ScreenCustomerLogin insUnic;
     
    @Autowired
    public ScreenCustomerUpdate(CustomerController customerController) {
        this.customerController = customerController;
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        Title2 = new javax.swing.JLabel();
        TextName = new javax.swing.JLabel();
        Name = new javax.swing.JScrollPane();
        fieldName = new javax.swing.JTextPane();
        TextPassword = new javax.swing.JLabel();
        TextAddress = new javax.swing.JLabel();
        Address = new javax.swing.JScrollPane();
        fieldAddress = new javax.swing.JTextPane();
        TextEmail = new javax.swing.JLabel();
        Email = new javax.swing.JScrollPane();
        fieldEmail = new javax.swing.JTextPane();
        TextPhone = new javax.swing.JLabel();
        Phone = new javax.swing.JScrollPane();
        fieldPhone = new javax.swing.JTextPane();
        ButtonUpdate = new javax.swing.JButton();
        fieldPassword = new javax.swing.JPasswordField();
        fieldPasswordChecker = new javax.swing.JPasswordField();
        ReturnButton = new javax.swing.JButton();
        TextPassword1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        Title.setText("Atualização do Cliente");

        Title2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        Title2.setText("Informações para Mudar:");

        TextName.setText("Nome:");

        Name.setViewportView(fieldName);

        TextPassword.setText("Senha:");

        TextAddress.setText("Endereço:");

        Address.setViewportView(fieldAddress);

        TextEmail.setText("Email:");

        Email.setViewportView(fieldEmail);

        TextPhone.setText("Telefone:");

        Phone.setViewportView(fieldPhone);

        ButtonUpdate.setText("Atualizar Informações");
        ButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateActionPerformed(evt);
            }
        });

        ReturnButton.setText("Voltar");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        TextPassword1.setText("Senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(221, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Title2)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonUpdate)
                        .addGap(206, 206, 206))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TextPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TextAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TextPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TextEmail, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(TextName, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Email)
                                    .addComponent(Address)
                                    .addComponent(Phone, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Name)
                                    .addComponent(fieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(TextPassword1)
                                .addGap(18, 18, 18)
                                .addComponent(fieldPasswordChecker))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(ReturnButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(208, Short.MAX_VALUE)
                    .addComponent(Title)
                    .addGap(166, 166, 166)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextPassword1)
                    .addComponent(fieldPasswordChecker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(Title2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextPassword)
                    .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextAddress))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextEmail)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextPhone)
                    .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(ButtonUpdate)
                .addGap(26, 26, 26))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(431, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateActionPerformed
        try {
            customerController.update(fieldName.getText(), fieldPasswordChecker.getText(), fieldPassword.getText(), fieldAddress.getText(), fieldEmail.getText(), fieldPhone.getText());
        } 
        
       catch (WrongDataException wde) {
            wde.screenException();
        }
    }//GEN-LAST:event_ButtonUpdateActionPerformed

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
                new ScreenCustomerUpdate(customerController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Address;
    private javax.swing.JButton ButtonUpdate;
    private javax.swing.JScrollPane Email;
    private javax.swing.JScrollPane Name;
    private javax.swing.JScrollPane Phone;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel TextAddress;
    private javax.swing.JLabel TextEmail;
    private javax.swing.JLabel TextName;
    private javax.swing.JLabel TextPassword;
    private javax.swing.JLabel TextPassword1;
    private javax.swing.JLabel TextPhone;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Title2;
    private javax.swing.JTextPane fieldAddress;
    private javax.swing.JTextPane fieldEmail;
    private javax.swing.JTextPane fieldName;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JPasswordField fieldPasswordChecker;
    private javax.swing.JTextPane fieldPhone;
    // End of variables declaration//GEN-END:variables
}
