package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenEmployeeMenu extends javax.swing.JFrame {

    private static ScreenEmployeeMenu insUnic; 
    
    //Singleton
    public static ScreenEmployeeMenu geraScreenEmployeeMenu(){
        if(insUnic == null){
            insUnic = new ScreenEmployeeMenu();
        }
        return insUnic;
    }
    
    @Autowired
    public ScreenEmployeeMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ReturnButton = new javax.swing.JButton();
        CarButton = new javax.swing.JButton();
        MotorcycleButton = new javax.swing.JButton();
        ScheduleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ReturnButton.setText("Voltar");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        CarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CarButton.setText("Gerenciar Carros");
        CarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarButtonActionPerformed(evt);
            }
        });

        MotorcycleButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MotorcycleButton.setText("Gerenciar Motos");
        MotorcycleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotorcycleButtonActionPerformed(evt);
            }
        });

        ScheduleButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ScheduleButton.setText("Gerenciar Agendas");
        ScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScheduleButtonActionPerformed(evt);
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
                    .addComponent(MotorcycleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ScheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CarButton)
                .addGap(27, 27, 27)
                .addComponent(MotorcycleButton)
                .addGap(28, 28, 28)
                .addComponent(ScheduleButton)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmployeeController employeeController = context.getBean(EmployeeController.class);
        
        ScreenEmployeeLogin employeeLoginScreen = ScreenEmployeeLogin.geraScreenEmployeeLogin(employeeController);
        employeeLoginScreen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void CarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarButtonActionPerformed
        ScreenEmployeeCarMenu screenEmployeeCarMenu = new ScreenEmployeeCarMenu();
        screenEmployeeCarMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CarButtonActionPerformed

    private void ScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScheduleButtonActionPerformed
        ScreenEmployeeScheduleMenu screenEmployeeScheduleMenu = new ScreenEmployeeScheduleMenu();
        screenEmployeeScheduleMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ScheduleButtonActionPerformed

    private void MotorcycleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotorcycleButtonActionPerformed
        ScreenEmployeeMotorMenu screenEmployeeMotorcycleMenu = new ScreenEmployeeMotorMenu();
        screenEmployeeMotorcycleMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MotorcycleButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                EmployeeController employeeController = context.getBean(EmployeeController.class);
                new ScreenEmployeeMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CarButton;
    private javax.swing.JButton MotorcycleButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JButton ScheduleButton;
    // End of variables declaration//GEN-END:variables
}
