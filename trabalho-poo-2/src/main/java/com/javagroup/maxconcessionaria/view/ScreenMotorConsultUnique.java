package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.MotorcycleController;
import com.javagroup.maxconcessionaria.controller.exception.IdDoesNotExistException;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenMotorConsultUnique extends javax.swing.JFrame {

    private final MotorcycleController motorcycleController;
    
    @Autowired
    public ScreenMotorConsultUnique(MotorcycleController motorcycleController) {
        this.motorcycleController = motorcycleController;
        initComponents();
    }

    private void consultMotor() throws IdDoesNotExistException {
        DefaultTableModel tableModel = (DefaultTableModel) tabelaCarros.getModel();
        motorcycleController.consultMotor(jTextPane1.getText(), tableModel);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        table = new javax.swing.JScrollPane();
        tabelaCarros = new javax.swing.JTable();
        TextTitle = new javax.swing.JLabel();
        TextPlate = new javax.swing.JLabel();
        Plate = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        ButtonConsult = new javax.swing.JButton();
        ReturnButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaCarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Placa", "ID do Chassi", "Marca", "Modelo", "Ano Fabricado", "Tem Alforge"
            }
        ));
        table.setViewportView(tabelaCarros);

        TextTitle.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        TextTitle.setText("Consulta de Moto");

        TextPlate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextPlate.setText("Placa:");

        Plate.setViewportView(jTextPane1);

        ButtonConsult.setText("Consultar");
        ButtonConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonConsultActionPerformed(evt);
            }
        });

        ReturnButton6.setText("Voltar");
        ReturnButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ReturnButton6)
                        .addGap(209, 209, 209)
                        .addComponent(TextTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextPlate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Plate, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ButtonConsult)
                .addGap(347, 347, 347))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextPlate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Plate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(ButtonConsult)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonConsultActionPerformed
        try {
            consultMotor();
        } 
        
        catch (IdDoesNotExistException ex) {
            ex.screenException();
        }
    }//GEN-LAST:event_ButtonConsultActionPerformed

    private void ReturnButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButton6ActionPerformed
        ScreenEmployeeMotorMenu screenEmployeeMotorMenu = ScreenEmployeeMotorMenu.geraScreenEmployeeMotorMenu();
        screenEmployeeMotorMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButton6ActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                MotorcycleController motorcycleController = context.getBean(MotorcycleController.class);
                new ScreenMotorConsultUnique(motorcycleController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonConsult;
    private javax.swing.JScrollPane Plate;
    private javax.swing.JButton ReturnButton6;
    private javax.swing.JLabel TextPlate;
    private javax.swing.JLabel TextTitle;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable tabelaCarros;
    private javax.swing.JScrollPane table;
    // End of variables declaration//GEN-END:variables
}
