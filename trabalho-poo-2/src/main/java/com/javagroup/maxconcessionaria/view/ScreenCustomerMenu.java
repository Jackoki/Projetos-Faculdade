package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CarController;
import com.javagroup.maxconcessionaria.controller.CustomerController;
import com.javagroup.maxconcessionaria.controller.EmployeeController;
import com.javagroup.maxconcessionaria.controller.MotorcycleController;
import static com.javagroup.maxconcessionaria.view.ScreenCustomerConfirmConsult.ScreenCustomerConfirmConsult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenCustomerMenu extends javax.swing.JFrame {

    private static ScreenCustomerMenu insUnic; 
    
    //Singleton
    public static ScreenCustomerMenu geraScreenCustomerMenu(){
        if(insUnic == null){
            insUnic = new ScreenCustomerMenu();
        }
        return insUnic;
    }
    
    @Autowired
    public ScreenCustomerMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ReturnButton = new javax.swing.JButton();
        CarButton = new javax.swing.JButton();
        MotorcycleButton = new javax.swing.JButton();
        VehiclesButton = new javax.swing.JButton();
        ScheduleButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ReturnButton.setText("Voltar");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        CarButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CarButton.setText("Comprar Carros");
        CarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarButtonActionPerformed(evt);
            }
        });

        MotorcycleButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MotorcycleButton.setText("Comprar Motos");
        MotorcycleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MotorcycleButtonActionPerformed(evt);
            }
        });

        VehiclesButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        VehiclesButton.setText("Visualizar Seus Veículos");
        VehiclesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehiclesButtonActionPerformed(evt);
            }
        });

        ScheduleButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ScheduleButton.setText("Solicitar Consulta");
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
                    .addComponent(VehiclesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(18, 18, 18)
                .addComponent(MotorcycleButton)
                .addGap(18, 18, 18)
                .addComponent(VehiclesButton)
                .addGap(18, 18, 18)
                .addComponent(ScheduleButton)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerController customerController = context.getBean(CustomerController.class);
        
        ScreenCustomerLogin screenCustomerLogin = ScreenCustomerLogin.geraScreenCustomerLogin(customerController);
        screenCustomerLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void CarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CarController carController = context.getBean(CarController.class);
        
        ScreenCarBuy screenCarBuy = new ScreenCarBuy(carController);
        screenCarBuy.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CarButtonActionPerformed

    private void ScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScheduleButtonActionPerformed
        ScreenCustomerScheduleMenu screenCustomerScheduleMenu = new ScreenCustomerScheduleMenu();
        screenCustomerScheduleMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ScheduleButtonActionPerformed

    private void MotorcycleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MotorcycleButtonActionPerformed
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MotorcycleController motorcycleController = context.getBean(MotorcycleController.class);
        
        ScreenMotorBuy screenMotorBuy = new ScreenMotorBuy(motorcycleController);
        screenMotorBuy.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MotorcycleButtonActionPerformed

    private void VehiclesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehiclesButtonActionPerformed
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            CustomerController customerController = context.getBean(CustomerController.class);
         
            ScreenCustomerConfirmConsult screenCustomerConfirmConsult = ScreenCustomerConfirmConsult(customerController);
            screenCustomerConfirmConsult.setVisible(true);  
            this.dispose();
    }//GEN-LAST:event_VehiclesButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                EmployeeController employeeController = context.getBean(EmployeeController.class);
                new ScreenCustomerMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CarButton;
    private javax.swing.JButton MotorcycleButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JButton ScheduleButton;
    private javax.swing.JButton VehiclesButton;
    // End of variables declaration//GEN-END:variables
}
