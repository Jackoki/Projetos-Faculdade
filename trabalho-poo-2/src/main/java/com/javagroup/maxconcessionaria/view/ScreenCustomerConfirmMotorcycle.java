package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CustomerController;
import com.javagroup.maxconcessionaria.controller.MotorcycleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenCustomerConfirmMotorcycle extends javax.swing.JFrame {

    private final CustomerController customerController;
    private static ScreenCustomerConfirmMotorcycle insUnic;
    private String motorPlate;
    private boolean confirmMotorBuy;
    
    //Singleton
    public static ScreenCustomerConfirmMotorcycle ScreenCustomerConfirmMotorcycle(CustomerController customerController, String motorPlate){
        if(insUnic == null){
            insUnic = new ScreenCustomerConfirmMotorcycle(customerController, motorPlate);
        }
        return insUnic;
    }
    
    @Autowired
    public ScreenCustomerConfirmMotorcycle(CustomerController customerController, String motorPlate) {
        this.customerController = customerController;
        this.motorPlate = motorPlate;
        initComponents();
    }
    
    public void confirmBuy(Boolean loginSucess, String plate, String userName){
        if(loginSucess == true){
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            MotorcycleController motorcycleController = context.getBean(MotorcycleController.class);
            
            motorcycleController.buyMotor(plate, userName);
            this.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextTitle = new javax.swing.JLabel();
        TextUser = new javax.swing.JLabel();
        TextPassword = new javax.swing.JLabel();
        User = new javax.swing.JScrollPane();
        userField = new javax.swing.JTextPane();
        passwordField = new javax.swing.JPasswordField();
        ConfirmButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextTitle.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        TextTitle.setText("Confirmar Compra Cliente");

        TextUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextUser.setText("Nome do Usuário:");

        TextPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextPassword.setText("Senha:");

        User.setViewportView(userField);

        ConfirmButton.setText("Confirmar");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReturnButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextUser)
                            .addComponent(TextPassword))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(User))))
                .addContainerGap(94, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ConfirmButton)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TextTitle)
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextUser)
                    .addComponent(User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextPassword)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ConfirmButton)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        confirmMotorBuy = customerController.loginCustomer(userField.getText(), passwordField.getText());
        confirmBuy(confirmMotorBuy, motorPlate, userField.getText());
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                CustomerController customerController = context.getBean(CustomerController.class);
                String motorPlate = null;
                
                new ScreenCustomerConfirmMotorcycle(customerController, motorPlate).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel TextPassword;
    private javax.swing.JLabel TextTitle;
    private javax.swing.JLabel TextUser;
    private javax.swing.JScrollPane User;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextPane userField;
    // End of variables declaration//GEN-END:variables
}
