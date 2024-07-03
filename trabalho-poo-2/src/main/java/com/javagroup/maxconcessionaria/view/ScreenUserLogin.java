package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CustomerController;
import com.javagroup.maxconcessionaria.controller.EmployeeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ScreenUserLogin extends javax.swing.JFrame {

    public ScreenUserLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextTitle = new javax.swing.JLabel();
        buttonCustomer = new javax.swing.JButton();
        buttonEmployee = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextTitle.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        TextTitle.setText("Selecione o Tipo de Usuário");

        buttonCustomer.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonCustomer.setText("Cliente");
        buttonCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustomerActionPerformed(evt);
            }
        });

        buttonEmployee.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buttonEmployee.setText("Funcionário");
        buttonEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonEmployee)
                            .addComponent(buttonCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(105, 105, 105)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(buttonCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonEmployee)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustomerActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerController customerController = context.getBean(CustomerController.class);
        
        // Gere a instância da tela e a torne visível
        ScreenCustomerLogin customerLoginScreen = ScreenCustomerLogin.geraScreenCustomerLogin(customerController);
        customerLoginScreen.setVisible(true); // Adicione esta linha para tornar a tela visível
        this.dispose();
    }//GEN-LAST:event_buttonCustomerActionPerformed

    private void buttonEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEmployeeActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeController employeeController = context.getBean(EmployeeController.class);
        
        // Gere a instância da tela e a torne visível
        ScreenEmployeeLogin employeeLoginScreen = ScreenEmployeeLogin.geraScreenEmployeeLogin(employeeController);
        employeeLoginScreen.setVisible(true); // Adicione esta linha para tornar a tela visível
        this.dispose();
    }//GEN-LAST:event_buttonEmployeeActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenUserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TextTitle;
    private javax.swing.JButton buttonCustomer;
    private javax.swing.JButton buttonEmployee;
    // End of variables declaration//GEN-END:variables
}
