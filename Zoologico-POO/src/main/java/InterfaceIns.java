//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;

public class InterfaceIns extends javax.swing.JFrame {
    
    private static InterfaceIns insUnic;
    
    private InterfaceInsAnfibio interAnf;
    private InterfaceInsAve interAve;
    private InterfaceInsMamifero interMam;
    private InterfaceInsPeixe interPei;
    private InterfaceInsReptil interRep;
    
    public InterfaceIns() {
        initComponents();
    }
    
    //Singleton
    public static InterfaceIns geraIntIns(){
        if(insUnic == null){
            insUnic = new InterfaceIns();
        }
        return insUnic;
    }
    
    public void geraInterfaceTipo(){
            String tipoSelecionado = TipoOpcao.getSelectedItem().toString();

            switch (tipoSelecionado) {
                case "Anfibio":
                    geraInsAnfibio();
                    break;
                
                case "Ave":
                    geraInsAve();
                    break;
                    
                case "Mamifero":
                    geraInsMamifero();
                    break;
                
                case "Peixe":
                    geraInsPeixe();
                    break;
                    
                case "Reptil":
                    geraInsReptil();
                    break;
                    
                    
                default:
                    break;
            }
    }
    
    //Singleton
    public InterfaceInsAnfibio geraInsAnfibio() {
        try {
            interAnf = InterfaceInsAnfibio.geraInsAnfibio();
            boolean funcionou = interAnf.setValores(getNome(), getIdade(), getPeso(), getAltura(), getEspecie(), getSexo(), getHerbivoro(), getCarnivoro(), getNomeHabitat(), getTemperatura(), getArea(), getSolo());
            
            if (funcionou){
                interAnf.setVisible(true);
                return interAnf;
            }
            
            else{
                return null;
            }      
        }
        
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "NAO PODE COLOCAR VALOR VAZIO!",
                 "ERRO CADASTRO DE ANFIBIO",
                 0
            );
            
            return null;
        }
    } 
    
    //Singleton
    public InterfaceInsAve geraInsAve() {
        try {
            interAve = InterfaceInsAve.geraInsAve();
            boolean funcionou = interAve.setValores(getNome(), getIdade(), getPeso(), getAltura(), getEspecie(), getSexo(), getHerbivoro(), getCarnivoro(), getNomeHabitat(), getTemperatura(), getArea(), getSolo());
            
            if (funcionou){
                interAve.setVisible(true);
                return interAve;
            }
            
            else{
                return null;
            }
        }
        
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "NAO PODE COLOCAR VALOR VAZIO!",
                 "ERRO CADASTRO DE AVE",
                 0
            );
            
            return null;
        }
    }  
    
    
    //Singleton
    public InterfaceInsMamifero geraInsMamifero() {
        try {
            interMam = InterfaceInsMamifero.geraInsMamifero();
            boolean funcionou = interMam.setValores(getNome(), getIdade(), getPeso(), getAltura(), getEspecie(), getSexo(), getHerbivoro(), getCarnivoro(), getNomeHabitat(), getTemperatura(), getArea(), getSolo());
            
            if(funcionou){
                interMam.setVisible(true);
                return interMam;
            }
            
            else{
                return null;
            }
        }
        
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "NAO PODE COLOCAR VALOR VAZIO!",
                 "ERRO CADASTRO DE MAMIFERO",
                 0
            );
            
            return null;
        }
    } 
    
    //Singleton
    public InterfaceInsPeixe geraInsPeixe() {
        try {
            interPei = InterfaceInsPeixe.geraInsPeixe();
            boolean funcionou = interPei.setValores(getNome(), getIdade(), getPeso(), getAltura(), getEspecie(), getSexo(), getHerbivoro(), getCarnivoro(), getNomeHabitat(), getTemperatura(), getArea(), getSolo());
            
            if(funcionou){
                interPei.setVisible(true);
                return interPei;
            }
            
            else{
                return null;
            }
        }
        
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "NAO PODE COLOCAR VALOR VAZIO!",
                 "ERRO CADASTRO DE PEIXE",
                 0
            );
            
            return null;
        }
    } 
    
    //Singleton
    public InterfaceInsReptil geraInsReptil() {
        try {
            interRep = InterfaceInsReptil.geraInsReptil();
            boolean funcionou = interRep.setValores(getNome(), getIdade(), getPeso(), getAltura(), getEspecie(), getSexo(), getHerbivoro(), getCarnivoro(), getNomeHabitat(), getTemperatura(), getArea(), getSolo());
            
            if(funcionou){
                interRep.setVisible(true);
                return interRep;  
            }
            
            else{
                return null;
            }
        }
        
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "NAO PODE COLOCAR VALOR VAZIO!",
                 "ERRO CADASTRO DE REPTIL",
                 0
            );
            
            return null;
        }
    } 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        NomeTipo = new javax.swing.JLabel();
        TipoOpcao = new javax.swing.JComboBox<>();
        NomeTexto = new javax.swing.JLabel();
        NomeCampo = new javax.swing.JTextField();
        IdadeTexto = new javax.swing.JLabel();
        IdadeCampo = new javax.swing.JTextField();
        PesoTexto = new javax.swing.JLabel();
        PesoCampo = new javax.swing.JTextField();
        AlturaTexto = new javax.swing.JLabel();
        AlturaCampo = new javax.swing.JTextField();
        EspecieTexto = new javax.swing.JLabel();
        EspecieCampo = new javax.swing.JTextField();
        SexoTexto = new javax.swing.JLabel();
        SexoOpcao = new javax.swing.JComboBox<>();
        AlimentacaoTexto = new javax.swing.JLabel();
        AlimentacaoOpcao = new javax.swing.JComboBox<>();
        MenuBotao = new javax.swing.JButton();
        RegistrarBotao = new javax.swing.JButton();
        NomeHabitatTexto = new javax.swing.JLabel();
        NomeHabitatCampo = new javax.swing.JTextField();
        TemperaturaTexto = new javax.swing.JLabel();
        TemperaturaCampo = new javax.swing.JTextField();
        AreaTexto = new javax.swing.JLabel();
        AreaCampo = new javax.swing.JTextField();
        SoloTexto = new javax.swing.JLabel();
        SoloCampo = new javax.swing.JTextField();

        jButton2.setText("Registrar Animal");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        NomeTipo.setText("Tipo de Animal:");

        TipoOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anfibio", "Ave", "Mamifero", "Peixe", "Reptil" }));
        TipoOpcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoOpcaoActionPerformed(evt);
            }
        });

        NomeTexto.setText("Nome:");

        NomeCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeCampoActionPerformed(evt);
            }
        });

        IdadeTexto.setText("Idade:");

        IdadeCampo.setText(" ");
        IdadeCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdadeCampoActionPerformed(evt);
            }
        });

        PesoTexto.setText("Peso:");

        PesoCampo.setText(" ");
        PesoCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesoCampoActionPerformed(evt);
            }
        });

        AlturaTexto.setText("Altura:");

        AlturaCampo.setText(" ");
        AlturaCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlturaCampoActionPerformed(evt);
            }
        });

        EspecieTexto.setText("Especie:");

        EspecieCampo.setText(" ");
        EspecieCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EspecieCampoActionPerformed(evt);
            }
        });

        SexoTexto.setText("Sexo:");

        SexoOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));
        SexoOpcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexoOpcaoActionPerformed(evt);
            }
        });

        AlimentacaoTexto.setText("Alimentação:");

        AlimentacaoOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Herbivoro", "Carnivoro", "Onivoro" }));
        AlimentacaoOpcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlimentacaoOpcaoActionPerformed(evt);
            }
        });

        MenuBotao.setText("Voltar");
        MenuBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBotaoActionPerformed(evt);
            }
        });

        RegistrarBotao.setText("Registrar Animal");
        RegistrarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarBotaoActionPerformed(evt);
            }
        });

        NomeHabitatTexto.setText("Nome do Habitat");

        NomeHabitatCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeHabitatCampoActionPerformed(evt);
            }
        });

        TemperaturaTexto.setText("Temperatura do Habitat");

        TemperaturaCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TemperaturaCampoActionPerformed(evt);
            }
        });

        AreaTexto.setText("Area em M² do Habitat");

        AreaCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaCampoActionPerformed(evt);
            }
        });

        SoloTexto.setText("Solo do Habitat");

        SoloCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoloCampoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NomeTexto)
                            .addComponent(IdadeTexto)
                            .addComponent(PesoTexto)
                            .addComponent(AlturaTexto)
                            .addComponent(EspecieTexto)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AlimentacaoTexto)
                                    .addComponent(SexoTexto))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SexoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AlimentacaoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(575, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NomeTipo)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TipoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(AlturaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(SoloTexto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SoloCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(EspecieCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(IdadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PesoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(69, 69, 69)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(AreaTexto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(AreaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(TemperaturaTexto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(TemperaturaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(NomeHabitatTexto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(NomeHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MenuBotao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RegistrarBotao)))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeTipo)
                    .addComponent(TipoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeTexto)
                    .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeHabitatTexto)
                    .addComponent(NomeHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TemperaturaTexto)
                        .addComponent(TemperaturaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IdadeTexto)
                        .addComponent(IdadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AreaTexto)
                        .addComponent(AreaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PesoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PesoTexto)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SoloTexto)
                        .addComponent(SoloCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AlturaTexto)
                        .addComponent(AlturaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EspecieCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EspecieTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SexoTexto)
                    .addComponent(SexoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlimentacaoTexto)
                    .addComponent(AlimentacaoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuBotao)
                    .addComponent(RegistrarBotao))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SexoOpcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SexoOpcaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SexoOpcaoActionPerformed

    private void TipoOpcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoOpcaoActionPerformed

    }//GEN-LAST:event_TipoOpcaoActionPerformed

    private void NomeCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeCampoActionPerformed

    private void IdadeCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdadeCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdadeCampoActionPerformed

    private void PesoCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesoCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PesoCampoActionPerformed

    private void AlturaCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlturaCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlturaCampoActionPerformed

    private void EspecieCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EspecieCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EspecieCampoActionPerformed

    private void AlimentacaoOpcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlimentacaoOpcaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlimentacaoOpcaoActionPerformed

    private void MenuBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBotaoActionPerformed
        limpar();
        dispose();
    }//GEN-LAST:event_MenuBotaoActionPerformed

    private void RegistrarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarBotaoActionPerformed
        geraInterfaceTipo();
    }//GEN-LAST:event_RegistrarBotaoActionPerformed

    private void NomeHabitatCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeHabitatCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeHabitatCampoActionPerformed

    private void TemperaturaCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TemperaturaCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TemperaturaCampoActionPerformed

    private void AreaCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AreaCampoActionPerformed

    private void SoloCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoloCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoloCampoActionPerformed
    
        
    public String getNome() {
        return NomeCampo.getText();
    }
            
    public int getIdade() {
        return Integer.parseInt(IdadeCampo.getText().trim());
    }
    
    public double getPeso() {
        return Double.parseDouble(PesoCampo.getText().trim());
    }
                
    public double getAltura() {
        return Double.parseDouble(AlturaCampo.getText().trim());
    }

    public String getEspecie() {
        return EspecieCampo.getText();
    }
    
    public boolean getSexo() {
        String sexoSelecionado = SexoOpcao.getSelectedItem().toString();
        boolean sexo = false;
        
        switch (sexoSelecionado) {
            case "Feminino":   
                sexo = false;
                break;
                
            case "Masculino":   
                sexo = true;
                break;
        } 
        
        return sexo;
    }
        
    public boolean getHerbivoro() {
        String alimentacaoSelecionado = AlimentacaoOpcao.getSelectedItem().toString();
        boolean herbivoro = false;
        
        switch (alimentacaoSelecionado) {
            case "Carnivoro" -> herbivoro = false;
                
            case "Herbivoro" -> herbivoro = true;
                
            case "Onivoro" -> herbivoro = true;
        } 
        
        return herbivoro;
    }
    
    public boolean getCarnivoro() {
        String alimentacaoSelecionado = AlimentacaoOpcao.getSelectedItem().toString();
        boolean carnivoro = false;
        
        switch (alimentacaoSelecionado) {
            case "Carnivoro" -> carnivoro = true;
                
            case "Herbivoro" -> carnivoro = false;
                
            case "Onivoro" -> carnivoro = true;
        }    
        return carnivoro;
    }
    
    public String getNomeHabitat() {
        return NomeHabitatCampo.getText();
    }
    
    public int getTemperatura() {
        return Integer.parseInt(TemperaturaCampo.getText().trim());
    }
    
    public double getArea() {
        return Double.parseDouble(AreaCampo.getText().trim());
    }
    
    public String getSolo() {
        return SoloCampo.getText();
    }
    
    public void limpar(){
        NomeCampo.setText("");
        IdadeCampo.setText("");
        PesoCampo.setText("");
        AlturaCampo.setText("");
        EspecieCampo.setText("");
        NomeHabitatCampo.setText("");
        AreaCampo.setText("");
        TemperaturaCampo.setText("");
        SoloCampo.setText("");
     }
        
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceIns().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AlimentacaoOpcao;
    private javax.swing.JLabel AlimentacaoTexto;
    private javax.swing.JTextField AlturaCampo;
    private javax.swing.JLabel AlturaTexto;
    private javax.swing.JTextField AreaCampo;
    private javax.swing.JLabel AreaTexto;
    private javax.swing.JTextField EspecieCampo;
    private javax.swing.JLabel EspecieTexto;
    private javax.swing.JTextField IdadeCampo;
    private javax.swing.JLabel IdadeTexto;
    private javax.swing.JButton MenuBotao;
    private javax.swing.JTextField NomeCampo;
    private javax.swing.JTextField NomeHabitatCampo;
    private javax.swing.JLabel NomeHabitatTexto;
    private javax.swing.JLabel NomeTexto;
    private javax.swing.JLabel NomeTipo;
    private javax.swing.JTextField PesoCampo;
    private javax.swing.JLabel PesoTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JComboBox<String> SexoOpcao;
    private javax.swing.JLabel SexoTexto;
    private javax.swing.JTextField SoloCampo;
    private javax.swing.JLabel SoloTexto;
    private javax.swing.JTextField TemperaturaCampo;
    private javax.swing.JLabel TemperaturaTexto;
    private javax.swing.JComboBox<String> TipoOpcao;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
