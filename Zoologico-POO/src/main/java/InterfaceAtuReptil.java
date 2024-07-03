//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;

public class InterfaceAtuReptil extends javax.swing.JFrame {
    private Reptil rep = new Reptil();
    private static InterfaceAtuReptil insUnic;
    
    private GerAni ga = GerAni.geraGerAni();
    
    public InterfaceAtuReptil() {
        initComponents();
    }
    
    //Singleton
    public static InterfaceAtuReptil geraAtuReptil(){
        if(insUnic == null){
            insUnic = new InterfaceAtuReptil();
        }
        return insUnic;
    }
    
    public void atualizar(){   
        try {
            rep.setIdade(getIdade());
            
            rep.setPeso(getPeso()); 
            
            rep.setAltura(getAltura());
            
            rep.setEspecie(getEspecie());
            
            rep.setSexo(getSexo()); 
            
            rep.setHerbivoro(getHerbivoro());
            
            rep.setCarnivoro(getCarnivoro());
            
            rep.setHabitatNomeHab(getNomeHabitat());
                    
            rep.setHabitatTemperatura(getTemperatura());
                                        
            rep.setHabitatArea(getArea());
                                                            
            rep.setHabitatSolo(getSolo());
            
            rep.setVeneno(getVeneno());
            
            rep.setPatas(getPatas());
            
            ga.atualizaRep(rep);
        }
        
        catch(ValorVazioException vv){
            vv.exibirMensagem();
        }
        
        catch(InsercaoVaziaException iv){
            iv.exibirMensagem();
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO ATUALIZAÇÃO DE REPTIL",
                 0
            );
        }
    }
    
    public void setValores(String nome){   
        try{
            rep.setNome(nome);
            Reptil rep2 = new Reptil();
            
            rep2 = ga.consRep(rep);
            
            if(rep2 != null){
                insUnic.setVisible(true);
            } 
            
            else{
                JOptionPane.showMessageDialog(
                null,
                "NOME NÃO EXISTE NA TABELA!",
                 "ERRO ATUALIZAÇÃO DE REPTIL",
                 0
            );
            }
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO ATUALIZAÇÃO DE REPTIL",
                 0
            );
        }
        
        catch(InsercaoVaziaException iv){
            iv.exibirMensagem();
        }
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
    
    public int getPatas() {
        return Integer.parseInt(PatasCampo.getText().trim());
    }
    
    public boolean getVeneno() {
        String venenoSelecionado = VenenoOpcao.getSelectedItem().toString();
        boolean veneno = false;
        
        switch (venenoSelecionado) {
            case "Sim" -> veneno = true;
                
            case "Não" -> veneno = false;
        }    
        return veneno;
    }
    
    public void limpar(){
        IdadeCampo.setText("");
        PesoCampo.setText("");
        AlturaCampo.setText("");
        EspecieCampo.setText("");
        NomeHabitatCampo.setText("");
        TemperaturaCampo.setText("");
        AreaCampo.setText("");
        SoloCampo.setText("");
        PatasCampo.setText("");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuBotao = new javax.swing.JButton();
        ConsultarBotao = new javax.swing.JButton();
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
        NomeHabitatTexto = new javax.swing.JLabel();
        NomeHabitatCampo = new javax.swing.JTextField();
        TemperaturaTexto = new javax.swing.JLabel();
        TemperaturaCampo = new javax.swing.JTextField();
        AreaTexto = new javax.swing.JLabel();
        AreaCampo = new javax.swing.JTextField();
        SoloTexto = new javax.swing.JLabel();
        SoloCampo = new javax.swing.JTextField();
        PatasTexto = new javax.swing.JLabel();
        PatasCampo = new javax.swing.JTextField();
        VenenoTexto = new javax.swing.JLabel();
        VenenoOpcao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        MenuBotao.setText("Voltar");
        MenuBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBotaoActionPerformed(evt);
            }
        });

        ConsultarBotao.setText("Atualizar Animal");
        ConsultarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarBotaoActionPerformed(evt);
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

        PatasTexto.setText("Quantidade de Patas");

        PatasCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatasCampoActionPerformed(evt);
            }
        });

        VenenoTexto.setText("Tem Veneno?");

        VenenoOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        VenenoOpcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VenenoOpcaoActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AlturaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EspecieCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IdadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PesoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PatasTexto)
                            .addComponent(AreaTexto)
                            .addComponent(TemperaturaTexto)
                            .addComponent(NomeHabitatTexto)
                            .addComponent(SoloTexto)
                            .addComponent(VenenoTexto))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(VenenoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(NomeHabitatCampo, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(TemperaturaCampo)
                            .addComponent(AreaCampo)
                            .addComponent(PatasCampo)
                            .addComponent(SoloCampo)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MenuBotao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ConsultarBotao)
                        .addGap(50, 50, 50)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdadeTexto)
                            .addComponent(IdadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PesoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PesoTexto))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AlturaTexto)
                            .addComponent(AlturaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EspecieCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EspecieTexto)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomeHabitatTexto)
                            .addComponent(NomeHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TemperaturaTexto)
                            .addComponent(TemperaturaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AreaTexto)
                            .addComponent(AreaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SoloCampo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SoloTexto))
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SexoTexto)
                            .addComponent(SexoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AlimentacaoTexto)
                            .addComponent(AlimentacaoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PatasTexto)
                            .addComponent(PatasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VenenoTexto)
                            .addComponent(VenenoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuBotao)
                    .addComponent(ConsultarBotao))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBotaoActionPerformed
        limpar();
        dispose();
    }//GEN-LAST:event_MenuBotaoActionPerformed

    private void ConsultarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarBotaoActionPerformed
        atualizar();
        limpar();
        dispose();
    }//GEN-LAST:event_ConsultarBotaoActionPerformed

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

    private void SexoOpcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SexoOpcaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SexoOpcaoActionPerformed

    private void AlimentacaoOpcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlimentacaoOpcaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlimentacaoOpcaoActionPerformed

    private void SoloCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SoloCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SoloCampoActionPerformed

    private void AreaCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AreaCampoActionPerformed

    private void TemperaturaCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TemperaturaCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TemperaturaCampoActionPerformed

    private void NomeHabitatCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeHabitatCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeHabitatCampoActionPerformed

    private void VenenoOpcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenenoOpcaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VenenoOpcaoActionPerformed

    private void PatasCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatasCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatasCampoActionPerformed

        
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
    private javax.swing.JButton ConsultarBotao;
    private javax.swing.JTextField EspecieCampo;
    private javax.swing.JLabel EspecieTexto;
    private javax.swing.JTextField IdadeCampo;
    private javax.swing.JLabel IdadeTexto;
    private javax.swing.JButton MenuBotao;
    private javax.swing.JTextField NomeHabitatCampo;
    private javax.swing.JLabel NomeHabitatTexto;
    private javax.swing.JTextField PatasCampo;
    private javax.swing.JLabel PatasTexto;
    private javax.swing.JTextField PesoCampo;
    private javax.swing.JLabel PesoTexto;
    private javax.swing.JComboBox<String> SexoOpcao;
    private javax.swing.JLabel SexoTexto;
    private javax.swing.JTextField SoloCampo;
    private javax.swing.JLabel SoloTexto;
    private javax.swing.JTextField TemperaturaCampo;
    private javax.swing.JLabel TemperaturaTexto;
    private javax.swing.JComboBox<String> VenenoOpcao;
    private javax.swing.JLabel VenenoTexto;
    // End of variables declaration//GEN-END:variables
}
