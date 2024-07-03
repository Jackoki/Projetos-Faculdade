package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.MotorcycleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ScreenMotorDelete extends javax.swing.JFrame {
    private final MotorcycleController motorcycleController;
    
    @Autowired
    public ScreenMotorDelete(MotorcycleController motorcycleController) {
        this.motorcycleController = motorcycleController;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Plate = new javax.swing.JScrollPane();
        fieldPlate = new javax.swing.JTextPane();
        TextTItle = new javax.swing.JLabel();
        TextPlate = new javax.swing.JLabel();
        ButtonDelete = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Plate.setViewportView(fieldPlate);

        TextTItle.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        TextTItle.setText("Deletar Moto");

        TextPlate.setText("Placa:");

        ButtonDelete.setText("Deletar Moto");
        ButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeleteActionPerformed(evt);
            }
        });

        ReturnButton.setText("Voltar");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextPlate)
                        .addGap(18, 18, 18)
                        .addComponent(Plate, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ReturnButton)
                        .addGap(68, 68, 68)
                        .addComponent(TextTItle)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonDelete)
                .addGap(141, 141, 141))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextTItle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Plate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPlate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    
    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        motorcycleController.delete(fieldPlate.getText());
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        ScreenEmployeeMotorMenu screenEmployeeMotorMenu = ScreenEmployeeMotorMenu.geraScreenEmployeeMotorMenu();
        screenEmployeeMotorMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                MotorcycleController motorcycleController = context.getBean(MotorcycleController.class);
                new ScreenMotorDelete(motorcycleController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JScrollPane Plate;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel TextPlate;
    private javax.swing.JLabel TextTItle;
    private javax.swing.JTextPane fieldPlate;
    // End of variables declaration//GEN-END:variables
}
