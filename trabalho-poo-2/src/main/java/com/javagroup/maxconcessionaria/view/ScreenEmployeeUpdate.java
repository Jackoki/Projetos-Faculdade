package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.EmployeeController;
import com.javagroup.maxconcessionaria.controller.exception.WrongDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenEmployeeUpdate extends javax.swing.JFrame {
    
    private final EmployeeController employeeController;
    private static ScreenEmployeeUpdate insUnic;
    
    //Singleton
    public static ScreenEmployeeUpdate geraScreenEmployeeUpdate(EmployeeController employeeController){
        if(insUnic == null){
            insUnic = new ScreenEmployeeUpdate(employeeController);
        }
        return insUnic;
    }
    
    @Autowired
    public ScreenEmployeeUpdate(EmployeeController employeeController) {
        this.employeeController = employeeController;
        initComponents();
    }
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        Title2 = new javax.swing.JLabel();
        TextName = new javax.swing.JLabel();
        Name = new javax.swing.JScrollPane();
        fieldName = new javax.swing.JTextPane();
        TextPassword = new javax.swing.JLabel();
        TextAddress = new javax.swing.JLabel();
        Address = new javax.swing.JScrollPane();
        fieldAddress = new javax.swing.JTextPane();
        TextEmail = new javax.swing.JLabel();
        Email = new javax.swing.JScrollPane();
        fieldEmail = new javax.swing.JTextPane();
        TextPhone = new javax.swing.JLabel();
        Phone = new javax.swing.JScrollPane();
        fieldPhone = new javax.swing.JTextPane();
        ButtonUpdate = new javax.swing.JButton();
        fieldPassword = new javax.swing.JPasswordField();
        fieldPasswordChecker = new javax.swing.JPasswordField();
        TextPassword1 = new javax.swing.JLabel();
        ReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        Title.setText("Atualização do Funcionário");

        Title2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        Title2.setText("Informações para Mudar:");

        TextName.setText("Nome:");

        Name.setViewportView(fieldName);

        TextPassword.setText("Senha:");

        TextAddress.setText("Endereço:");

        Address.setViewportView(fieldAddress);

        TextEmail.setText("Email:");

        Email.setViewportView(fieldEmail);

        TextPhone.setText("Telefone:");

        Phone.setViewportView(fieldPhone);

        ButtonUpdate.setText("Atualizar Informações");
        ButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonUpdateActionPerformed(evt);
            }
        });

        TextPassword1.setText("Senha:");

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
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TextPhone, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TextAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TextPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TextEmail, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextPassword1)
                            .addComponent(TextName))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Email)
                    .addComponent(Address)
                    .addComponent(Phone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Name)
                    .addComponent(fieldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(fieldPasswordChecker))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ReturnButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Title)
                        .addGap(138, 138, 138))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ButtonUpdate)
                                .addGap(200, 200, 200))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Title2)
                                .addGap(179, 179, 179))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextPassword1)
                    .addComponent(fieldPasswordChecker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(Title2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextPassword)
                    .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextAddress))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextEmail)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextPhone)
                    .addComponent(Phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(ButtonUpdate)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonUpdateActionPerformed
        try {
            employeeController.update(fieldName.getText(), fieldPasswordChecker.getText(), fieldPassword.getText(), fieldAddress.getText(), fieldEmail.getText(), fieldPhone.getText());
        } 
        
       catch (WrongDataException wde) {
            wde.screenException();
        }
    }//GEN-LAST:event_ButtonUpdateActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        ScreenEmployeeLogin screenEmployeeLogin = new ScreenEmployeeLogin(employeeController);
        screenEmployeeLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                EmployeeController employeeController = context.getBean(EmployeeController.class);
                new ScreenEmployeeUpdate(employeeController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Address;
    private javax.swing.JButton ButtonUpdate;
    private javax.swing.JScrollPane Email;
    private javax.swing.JScrollPane Name;
    private javax.swing.JScrollPane Phone;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel TextAddress;
    private javax.swing.JLabel TextEmail;
    private javax.swing.JLabel TextName;
    private javax.swing.JLabel TextPassword;
    private javax.swing.JLabel TextPassword1;
    private javax.swing.JLabel TextPhone;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Title2;
    private javax.swing.JTextPane fieldAddress;
    private javax.swing.JTextPane fieldEmail;
    private javax.swing.JTextPane fieldName;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JPasswordField fieldPasswordChecker;
    private javax.swing.JTextPane fieldPhone;
    // End of variables declaration//GEN-END:variables
}
