package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CarController;
import com.javagroup.maxconcessionaria.controller.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenEmployeeCarMenu extends javax.swing.JFrame {

    private static ScreenEmployeeCarMenu insUnic; 
    
    //Singleton
    public static ScreenEmployeeCarMenu geraScreenEmployeeCarMenu(){
        if(insUnic == null){
            insUnic = new ScreenEmployeeCarMenu();
        }
        return insUnic;
    }
    
    @Autowired
    public ScreenEmployeeCarMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ReturnButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ConsultButton = new javax.swing.JButton();
        ConsultAllButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ReturnButton.setText("Voltar");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        RegisterButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RegisterButton.setText("Registrar Carro");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        UpdateButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UpdateButton.setText("Atualizar Carro");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeleteButton.setText("Deletar Carro");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        ConsultButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ConsultButton.setText("Consultar Carro");
        ConsultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultButtonActionPerformed(evt);
            }
        });

        ConsultAllButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ConsultAllButton.setText("Consultar Todos os Carros");
        ConsultAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReturnButton)
                .addGap(416, 416, 416))
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConsultAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConsultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegisterButton)
                .addGap(27, 27, 27)
                .addComponent(UpdateButton)
                .addGap(28, 28, 28)
                .addComponent(DeleteButton)
                .addGap(29, 29, 29)
                .addComponent(ConsultButton)
                .addGap(26, 26, 26)
                .addComponent(ConsultAllButton)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        ScreenEmployeeMenu screenEmployeeMenu = ScreenEmployeeMenu.geraScreenEmployeeMenu();
        screenEmployeeMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CarController carController = context.getBean(CarController.class);
        
        ScreenCarCreate screenCarCreate = new ScreenCarCreate(carController);
        screenCarCreate.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CarController carController = context.getBean(CarController.class);
        
        ScreenCarDelete screenCarDelete = new ScreenCarDelete(carController);
        screenCarDelete.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CarController carController = context.getBean(CarController.class);
        
        ScreenCarUpdate screenCarUpdate = new ScreenCarUpdate(carController);
        screenCarUpdate.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void ConsultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CarController carController = context.getBean(CarController.class);
        
        ScreenCarConsultUnique screenCarConsultUnique = new ScreenCarConsultUnique(carController);
        screenCarConsultUnique.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ConsultButtonActionPerformed

    private void ConsultAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultAllButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CarController carController = context.getBean(CarController.class);
        
        ScreenCarConsult screenCarConsult = new ScreenCarConsult(carController);
        screenCarConsult.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ConsultAllButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                EmployeeController employeeController = context.getBean(EmployeeController.class);
                new ScreenEmployeeCarMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConsultAllButton;
    private javax.swing.JButton ConsultButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JButton UpdateButton;
    // End of variables declaration//GEN-END:variables
}
