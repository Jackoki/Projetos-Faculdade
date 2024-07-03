package com.javagroup.maxconcessionaria.view;

import com.javagroup.maxconcessionaria.controller.CarController;
import com.javagroup.maxconcessionaria.model.Car;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScreenCarCreate extends javax.swing.JFrame {
    
    private final CarController carController;
    
    @Autowired
    public ScreenCarCreate(CarController carroController) {
        this.carController = carroController;
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextTitle = new javax.swing.JLabel();
        TextPlate = new javax.swing.JLabel();
        Plate = new javax.swing.JScrollPane();
        fieldPlate = new javax.swing.JTextPane();
        TextChassis = new javax.swing.JLabel();
        Chassis = new javax.swing.JScrollPane();
        fieldChassis = new javax.swing.JTextPane();
        TextBrand = new javax.swing.JLabel();
        Brand = new javax.swing.JScrollPane();
        fieldBrand = new javax.swing.JTextPane();
        TextModel = new javax.swing.JLabel();
        Model = new javax.swing.JScrollPane();
        fieldModel = new javax.swing.JTextPane();
        TextColor = new javax.swing.JLabel();
        Color = new javax.swing.JScrollPane();
        fieldColor = new javax.swing.JTextPane();
        TextYear = new javax.swing.JLabel();
        Year = new javax.swing.JScrollPane();
        fieldYear = new javax.swing.JTextPane();
        TextAirBag = new javax.swing.JLabel();
        Airbag = new javax.swing.JScrollPane();
        fieldAirbag = new javax.swing.JTextPane();
        TextPassword = new javax.swing.JLabel();
        boxAvailable = new javax.swing.JComboBox<>();
        ButtonRegister = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextTitle.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        TextTitle.setText("Registre o Carro");

        TextPlate.setText("Placa:");

        Plate.setViewportView(fieldPlate);

        TextChassis.setText("Chassi:");

        Chassis.setViewportView(fieldChassis);

        TextBrand.setText("Marca:");

        Brand.setViewportView(fieldBrand);

        TextModel.setText("Modelo:");

        Model.setViewportView(fieldModel);

        TextColor.setText("Cor:");

        Color.setViewportView(fieldColor);

        TextYear.setText("Ano Fabricado:");

        Year.setViewportView(fieldYear);

        TextAirBag.setText("Quantidade de AirBags:");

        Airbag.setViewportView(fieldAirbag);

        TextPassword.setText("Disponível:");

        boxAvailable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        ButtonRegister.setText("Registrar Carro");
        ButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegisterActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextYear)
                                    .addComponent(TextPassword)
                                    .addComponent(TextAirBag))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Year)
                                        .addComponent(Airbag, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextModel)
                                    .addComponent(TextColor, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextBrand, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextChassis, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextPlate, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Color)
                                    .addComponent(Brand)
                                    .addComponent(Model)
                                    .addComponent(Chassis)
                                    .addComponent(Plate, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 108, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonRegister)
                        .addGap(236, 236, 236))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ReturnButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextTitle)
                        .addGap(205, 205, 205))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReturnButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Plate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextPlate))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextChassis)
                    .addComponent(Chassis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Brand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextBrand))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextModel)
                    .addComponent(Model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextColor)
                    .addComponent(Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextYear))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Airbag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextAirBag))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonRegister)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextPassword)
                            .addComponent(boxAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegisterActionPerformed
        try {
            Boolean available = boxAvailable.getSelectedItem().equals("Sim");
        
            if("".equals(fieldAirbag.getText()) || "".equals(fieldYear.getText())){
                JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NO CADASTRO DE CARRO", 0);
            }
        
            Car car = new Car(Integer.valueOf(fieldAirbag.getText()), fieldPlate.getText(), fieldChassis.getText(), fieldBrand.getText(), fieldModel.getText(), fieldColor.getText(), Integer.valueOf(fieldYear.getText()), null, available);
        
            carController.save(car);
        }
        
        catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NO CADASTRO DO CARRO", 0);
        }
    }//GEN-LAST:event_ButtonRegisterActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        ScreenEmployeeCarMenu screenEmployeeCarMenu = ScreenEmployeeCarMenu.geraScreenEmployeeCarMenu();
        screenEmployeeCarMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReturnButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
                CarController carController = context.getBean(CarController.class);
                new ScreenCarCreate(carController).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Airbag;
    private javax.swing.JScrollPane Brand;
    private javax.swing.JButton ButtonRegister;
    private javax.swing.JScrollPane Chassis;
    private javax.swing.JScrollPane Color;
    private javax.swing.JScrollPane Model;
    private javax.swing.JScrollPane Plate;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JLabel TextAirBag;
    private javax.swing.JLabel TextBrand;
    private javax.swing.JLabel TextChassis;
    private javax.swing.JLabel TextColor;
    private javax.swing.JLabel TextModel;
    private javax.swing.JLabel TextPassword;
    private javax.swing.JLabel TextPlate;
    private javax.swing.JLabel TextTitle;
    private javax.swing.JLabel TextYear;
    private javax.swing.JScrollPane Year;
    private javax.swing.JComboBox<String> boxAvailable;
    private javax.swing.JTextPane fieldAirbag;
    private javax.swing.JTextPane fieldBrand;
    private javax.swing.JTextPane fieldChassis;
    private javax.swing.JTextPane fieldColor;
    private javax.swing.JTextPane fieldModel;
    private javax.swing.JTextPane fieldPlate;
    private javax.swing.JTextPane fieldYear;
    // End of variables declaration//GEN-END:variables
}
