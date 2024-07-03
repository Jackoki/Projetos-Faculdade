package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CustomerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenCustomerLogin extends javax.swing.JFrame {

    private final CustomerController customerController;
    private static ScreenCustomerLogin insUnic;
    private boolean activateLoginScreen;
    
    //Singleton
    public static ScreenCustomerLogin geraScreenCustomerLogin(CustomerController customerController){
        if(insUnic == null){
            insUnic = new ScreenCustomerLogin(customerController);
        }
        return insUnic;
    }
    
    @Autowired
    public ScreenCustomerLogin(CustomerController customerController) {
        this.customerController = customerController;
        initComponents();
    }
    
    public void activateScreenLogin(Boolean loginSucess){
        if(loginSucess == true){
            ScreenCustomerMenu screenCustomerMenu = ScreenCustomerMenu.geraScreenCustomerMenu();
            screenCustomerMenu.setVisible(true);
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
        LoginButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        TextRegister = new javax.swing.JLabel();
        EditButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextTitle.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        TextTitle.setText("Logar como Cliente");

        TextUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextUser.setText("Nome do Usuário:");

        TextPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextPassword.setText("Senha:");

        User.setViewportView(userField);

        LoginButton.setText("Logar");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        RegisterButton.setBackground(new java.awt.Color(242, 242, 242));
        RegisterButton.setForeground(new java.awt.Color(51, 51, 255));
        RegisterButton.setText("Registrar");
        RegisterButton.setBorder(null);
        RegisterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        TextRegister.setText("Não tem uma conta?");

        EditButton.setBackground(new java.awt.Color(242, 242, 242));
        EditButton.setForeground(new java.awt.Color(51, 51, 255));
        EditButton.setText("Editar Informações");
        EditButton.setBorder(null);
        EditButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TextRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterButton)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LoginButton)
                        .addGap(200, 200, 200))))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(EditButton)
                        .addGap(195, 195, 195))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextUser)
                                    .addComponent(TextPassword))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextTitle)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                        .addComponent(User))))
                            .addComponent(ReturnButton))
                        .addContainerGap(94, Short.MAX_VALUE))))
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
                .addComponent(LoginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegisterButton)
                    .addComponent(TextRegister))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditButton)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        activateLoginScreen = customerController.loginCustomer(userField.getText(), passwordField.getText());
        activateScreenLogin(activateLoginScreen);
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        ScreenUserLogin screenUserLogin = new ScreenUserLogin();
        screenUserLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        ScreenCustomerCreate screenCustomerCreate= new ScreenCustomerCreate(customerController);
        screenCustomerCreate.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        ScreenCustomerUpdate screenCustomerUpdate= new ScreenCustomerUpdate(customerController);
        screenCustomerUpdate.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EditButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                CustomerController customerController = context.getBean(CustomerController.class);
                new ScreenCustomerLogin(customerController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel TextPassword;
    private javax.swing.JLabel TextRegister;
    private javax.swing.JLabel TextTitle;
    private javax.swing.JLabel TextUser;
    private javax.swing.JScrollPane User;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextPane userField;
    // End of variables declaration//GEN-END:variables
}
