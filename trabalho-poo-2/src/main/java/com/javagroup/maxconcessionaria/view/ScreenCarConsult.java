package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CarController;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenCarConsult extends javax.swing.JFrame {

    private final CarController carController;
    
    @Autowired
    public ScreenCarConsult(CarController carController) {
        this.carController = carController;
        initComponents();
        consultData();
    }

    private void consultData() {
        DefaultTableModel tableModel = (DefaultTableModel) tableCar.getModel();
        carController.consultAll(tableModel);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        table = new javax.swing.JScrollPane();
        tableCar = new javax.swing.JTable();
        TextTitle = new javax.swing.JLabel();
        ReturnButton3 = new javax.swing.JButton();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReturnButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButton3ActionPerformed
        ScreenEmployeeCarMenu screenEmployeeCarMenu = ScreenEmployeeCarMenu.geraScreenEmployeeCarMenu();
        screenEmployeeCarMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButton3ActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                CarController carController = context.getBean(CarController.class);
                new ScreenCarConsult(carController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ReturnButton3;
    private javax.swing.JLabel TextTitle;
    private javax.swing.JScrollPane table;
    private javax.swing.JTable tableCar;
    // End of variables declaration//GEN-END:variables
}
