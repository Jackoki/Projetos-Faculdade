package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CustomerController;
import com.javagroup.maxconcessionaria.controller.MotorcycleController;
import com.javagroup.maxconcessionaria.controller.exception.MotorNotAvailableException;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenMotorBuy extends javax.swing.JFrame {

    private final MotorcycleController motorcycleController;
    
    @Autowired
    public ScreenMotorBuy(MotorcycleController motorcycleController) {
        this.motorcycleController = motorcycleController;
        initComponents();
        consultData();
    }

    private void consultData() {
        DefaultTableModel tableModel = (DefaultTableModel) tableCar.getModel();
        motorcycleController.consultBuy(tableModel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        table = new javax.swing.JScrollPane();
        tableCar = new javax.swing.JTable();
        TextTitle = new javax.swing.JLabel();
        ReturnButton3 = new javax.swing.JButton();
        carText = new javax.swing.JLabel();
        motorField = new javax.swing.JTextField();
        motorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Placa", "ID do Chassi", "Marca", "Modelo", "Cor", "Ano Fabricado", "Tem Alforge"
            }
        ));
        table.setViewportView(tableCar);

        TextTitle.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        TextTitle.setText("Consulta de Moto");

        ReturnButton3.setText("Voltar");
        ReturnButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButton3ActionPerformed(evt);
            }
        });

        carText.setText("Placa da Moto:");

        motorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorFieldActionPerformed(evt);
            }
        });

        motorButton.setText("Comprar");
        motorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(carText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(motorField, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(motorButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ReturnButton3)
                        .addGap(211, 211, 211)
                        .addComponent(TextTitle))
                    .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnButton3))
                .addGap(30, 30, 30)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carText)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(motorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(motorButton)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButton3ActionPerformed
        ScreenCustomerMenu screenCustomerMenu = ScreenCustomerMenu.geraScreenCustomerMenu();
        screenCustomerMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButton3ActionPerformed

    private void motorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorButtonActionPerformed
        try {
            Boolean validPlate = motorcycleController.verifyMotorPlate(motorField.getText());
            
            if(validPlate){
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                CustomerController customerController = context.getBean(CustomerController.class);
        
                ScreenCustomerConfirmMotorcycle screenCustomerConfirmMotorcycle = ScreenCustomerConfirmMotorcycle.ScreenCustomerConfirmMotorcycle(customerController, motorField.getText());
                screenCustomerConfirmMotorcycle.setVisible(true);
            }
        } 
        
        catch (MotorNotAvailableException mnae) {
            mnae.screenException();
        }

    }//GEN-LAST:event_motorButtonActionPerformed

    private void motorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motorFieldActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                MotorcycleController motorcycleController = context.getBean(MotorcycleController.class);
                new ScreenMotorBuy(motorcycleController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReturnButton3;
    private javax.swing.JLabel TextTitle;
    private javax.swing.JLabel carText;
    private javax.swing.JButton motorButton;
    private javax.swing.JTextField motorField;
    private javax.swing.JScrollPane table;
    private javax.swing.JTable tableCar;
    // End of variables declaration//GEN-END:variables
}
