package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.EmployeeController;
import com.javagroup.maxconcessionaria.controller.ScheduleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenEmployeeScheduleMenu extends javax.swing.JFrame {

    private static ScreenEmployeeScheduleMenu insUnic; 
    
    //Singleton
    public static ScreenEmployeeScheduleMenu geraScreenEmployeeScheduleMenu(){
        if(insUnic == null){
            insUnic = new ScreenEmployeeScheduleMenu();
        }
        return insUnic;
    }
    
    @Autowired
    public ScreenEmployeeScheduleMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ReturnButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ConsultButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ReturnButton.setText("Voltar");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        RegisterButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RegisterButton.setText("Registrar Agenda");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeleteButton.setText("Deletar Agenda");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        ConsultButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ConsultButton.setText("Consultar Agenda");
        ConsultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultButtonActionPerformed(evt);
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
                    .addComponent(ConsultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(37, 37, 37)
                .addComponent(DeleteButton)
                .addGap(34, 34, 34)
                .addComponent(ConsultButton)
                .addContainerGap(38, Short.MAX_VALUE))
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
        ScheduleController scheduleController = context.getBean(ScheduleController.class);
        
        ScreenScheduleCreate screenScheduleCreate = new ScreenScheduleCreate(scheduleController);
        screenScheduleCreate.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ScheduleController scheduleController = context.getBean(ScheduleController.class);
        
        ScreenScheduleDelete screenScheduleDelete = new ScreenScheduleDelete(scheduleController);
        screenScheduleDelete.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void ConsultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ScheduleController scheduleController = context.getBean(ScheduleController.class);
        
        ScreenScheduleConsult screenScheduleConsult = new ScreenScheduleConsult(scheduleController);
        screenScheduleConsult.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ConsultButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                EmployeeController employeeController = context.getBean(EmployeeController.class);
                new ScreenEmployeeScheduleMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConsultButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JButton ReturnButton;
    // End of variables declaration//GEN-END:variables
}
