package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.EmployeeController;
import com.javagroup.maxconcessionaria.controller.MotorcycleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenEmployeeMotorMenu extends javax.swing.JFrame {

    private static ScreenEmployeeMotorMenu insUnic; 
    
    //Singleton
    public static ScreenEmployeeMotorMenu geraScreenEmployeeMotorMenu(){
        if(insUnic == null){
            insUnic = new ScreenEmployeeMotorMenu();
        }
        return insUnic;
    }
    
    @Autowired
    public ScreenEmployeeMotorMenu() {
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
        RegisterButton.setText("Registrar Moto");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        UpdateButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UpdateButton.setText("Atualizar Moto");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeleteButton.setText("Deletar Moto");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        ConsultButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ConsultButton.setText("Consultar Moto");
        ConsultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultButtonActionPerformed(evt);
            }
        });

        ConsultAllButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ConsultAllButton.setText("Consultar Todos as Motos");
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
        MotorcycleController motorcycleController = context.getBean(MotorcycleController.class);
        
        ScreenMotorCreate screenMotorCreate = new ScreenMotorCreate(motorcycleController);
        screenMotorCreate.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MotorcycleController motorcycleController = context.getBean(MotorcycleController.class);
        
        ScreenMotorDelete screenMotorDelete = new ScreenMotorDelete(motorcycleController);
        screenMotorDelete.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MotorcycleController motorcycleController = context.getBean(MotorcycleController.class);
        
        ScreenMotorUpdate screenMotorUpdate = new ScreenMotorUpdate(motorcycleController);
        screenMotorUpdate.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void ConsultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MotorcycleController motorcycleController = context.getBean(MotorcycleController.class);
        
        ScreenMotorConsultUnique screenMotorConsultUnique = new ScreenMotorConsultUnique(motorcycleController);
        screenMotorConsultUnique.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ConsultButtonActionPerformed

    private void ConsultAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultAllButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MotorcycleController motorcycleController = context.getBean(MotorcycleController.class);
        
        ScreenMotorConsult screenMotorConsult = new ScreenMotorConsult(motorcycleController);
        screenMotorConsult.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ConsultAllButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                EmployeeController employeeController = context.getBean(EmployeeController.class);
                new ScreenEmployeeMotorMenu().setVisible(true);
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
