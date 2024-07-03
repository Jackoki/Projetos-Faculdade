package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CarController;
import com.javagroup.maxconcessionaria.controller.CustomerController;
import com.javagroup.maxconcessionaria.controller.exception.CarNotAvailableException;
import static com.javagroup.maxconcessionaria.view.ScreenCustomerConfirm.ScreenCustomerConfirm;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenCarBuy extends javax.swing.JFrame {

    private final CarController carController;
    
    @Autowired
    public ScreenCarBuy(CarController carController) {
        this.carController = carController;
        initComponents();
        consultData();
    }

    private void consultData() {
        DefaultTableModel tableModel = (DefaultTableModel) tableCar.getModel();
        carController.consultBuy(tableModel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        table = new javax.swing.JScrollPane();
        tableCar = new javax.swing.JTable();
        TextTitle = new javax.swing.JLabel();
        ReturnButton3 = new javax.swing.JButton();
        carText = new javax.swing.JLabel();
        carField = new javax.swing.JTextField();
        carButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Placa", "ID do Chassi", "Marca", "Modelo", "Cor", "Ano Fabricado", "Quantidade de AirBag"
            }
        ));
        table.setViewportView(tableCar);

        TextTitle.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        TextTitle.setText("Consulta de Carros");

        ReturnButton3.setText("Voltar");
        ReturnButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButton3ActionPerformed(evt);
            }
        });

        carText.setText("Placa do Carro:");

        carField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carFieldActionPerformed(evt);
            }
        });

        carButton.setText("Comprar");
        carButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carButtonActionPerformed(evt);
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
                        .addComponent(carField, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(carButton))
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
                        .addComponent(carField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(carButton)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButton3ActionPerformed
        ScreenCustomerMenu screenCustomerMenu = ScreenCustomerMenu.geraScreenCustomerMenu();
        screenCustomerMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButton3ActionPerformed

    private void carButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carButtonActionPerformed
        try {
            Boolean validPlate = carController.verifyCarPlate(carField.getText());
            
            if(validPlate){
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                CustomerController customerController = context.getBean(CustomerController.class);
        
                ScreenCustomerConfirm screenCustomerConfirm = ScreenCustomerConfirm(customerController, carField.getText());
                screenCustomerConfirm.setVisible(true);
            }
        } 
        
        catch (CarNotAvailableException cnae) {
            cnae.screenException();
        }

    }//GEN-LAST:event_carButtonActionPerformed

    private void carFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carFieldActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                CarController carController = context.getBean(CarController.class);
                new ScreenCarBuy(carController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReturnButton3;
    private javax.swing.JLabel TextTitle;
    private javax.swing.JButton carButton;
    private javax.swing.JTextField carField;
    private javax.swing.JLabel carText;
    private javax.swing.JScrollPane table;
    private javax.swing.JTable tableCar;
    // End of variables declaration//GEN-END:variables
}
