package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.ScheduleController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenCustomerScheduleDelete extends javax.swing.JFrame {
    
    private final ScheduleController scheduleController;
    MaskFormatter mfData;
    
    @Autowired
    public ScreenCustomerScheduleDelete(ScheduleController scheduleController) {
        try {
            mfData = new MaskFormatter("##/##/####");  
        } 
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA CRIAÇÃO DA DATA!", "ERRO NO CADASTRO DE AGENDA", 0);
        }
        
        this.scheduleController = scheduleController;
        initComponents();
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextTitle = new javax.swing.JLabel();
        TextDate = new javax.swing.JLabel();
        DateData = new javax.swing.JFormattedTextField(mfData);
        ButtonDelete = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();
        UserName = new javax.swing.JScrollPane();
        fieldName = new javax.swing.JTextPane();
        TextUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextTitle.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        TextTitle.setText("Deletar a Agenda");

        TextDate.setText("Data:");

        DateData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DateDataFocusLost(evt);
            }
        });
        DateData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateDataActionPerformed(evt);
            }
        });

        ButtonDelete.setText("Deletar Agenda");
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

        UserName.setViewportView(fieldName);

        TextUser.setText("Nome do Usuário:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ReturnButton)
                .addGap(148, 148, 148)
                .addComponent(TextTitle)
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextUser, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextDate, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UserName, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(DateData))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonDelete)
                .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextDate)
                    .addComponent(DateData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(ButtonDelete)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeleteActionPerformed
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(DateData.getText());

            String userName = fieldName.getText();
            scheduleController.delete(date, userName);
        }
        
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NO CADASTRO DA AGENDA", 0);
        } 
        
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "DATA INVALIDA", "ERRO NO CADASTRO DE AGENDA", 0);
        }
    }//GEN-LAST:event_ButtonDeleteActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        ScreenCustomerScheduleMenu screenCustomerScheduleMenu = ScreenCustomerScheduleMenu.geraScreenCustomerScheduleMenu();
        screenCustomerScheduleMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void DateDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateDataActionPerformed

    private void DateDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DateDataFocusLost
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            Date date = sdf.parse(DateData.getText());
            DateData.setValue(sdf.format(date));
        }
        
        catch (ParseException e) {
            DateData.setFocusLostBehavior(JFormattedTextField.PERSIST);
            DateData.setText("");
            DateData.setValue(null);
        }
    }//GEN-LAST:event_DateDataFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                ScheduleController scheduleController = context.getBean(ScheduleController.class);
                new ScreenCustomerScheduleDelete(scheduleController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JFormattedTextField DateData;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel TextDate;
    private javax.swing.JLabel TextTitle;
    private javax.swing.JLabel TextUser;
    private javax.swing.JScrollPane UserName;
    private javax.swing.JTextPane fieldName;
    // End of variables declaration//GEN-END:variables
}
