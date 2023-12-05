//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;

public class InterfaceInsPeixe extends javax.swing.JFrame {
    private Peixe pei = new Peixe();
    private GerAni ga = GerAni.geraGerAni();

    private static InterfaceInsPeixe insUnic;
    
    //Singleton
    public static InterfaceInsPeixe geraInsPeixe(){
        if(insUnic == null){
            insUnic = new InterfaceInsPeixe();
        }
        return insUnic;
    }
    
    public InterfaceInsPeixe() {
        initComponents();
    }
    
    public boolean setValores(String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean herbivoro, boolean carnivoro, String nomeHabitat, int temperatura, double area, String solo){
        try{
            pei.setNome(nome);
            
            pei.setIdade(idade);
            
            pei.setPeso(peso); 
            
            pei.setAltura(altura);
            
            pei.setEspecie(especie);
            
            pei.setSexo(sexo); 
            
            pei.setHerbivoro(herbivoro);
            
            pei.setCarnivoro(carnivoro);
            
            pei.setHabitatNomeHab(nomeHabitat);
                    
            pei.setHabitatTemperatura(temperatura);
                                        
            pei.setHabitatArea(area);
                                                            
            pei.setHabitatSolo(solo);
            
            return true;
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE PEIXE",
                 0
            );
            
            return false;
        }
        
        catch(ValorVazioException vv){
            vv.exibirMensagem();
            return false;
        }
        
        catch(InsercaoVaziaException iv){
            iv.exibirMensagem();
            return false;
        }
    }

    public void regPei(){
        try {
            pei.setNadadeiras(Integer.parseInt(NadadeirasCampo.getText().trim()));
            pei.setProfundidadeMax(Integer.parseInt(ProfundidadeCampo.getText().trim()));
            
            String nadaSelecionado = NadaOpcao.getSelectedItem().toString();
        
            switch (nadaSelecionado) {
                case "Não":   
                    pei.setNada(false);
                    break;
                
                case "Sim":   
                    pei.setNada(true);
                    break;
            }   
        
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE PEIXE",
                 0
            );
        }
        
    }
    
    public void insPei(){
        try{
            Peixe pei2 = new Peixe();
            pei2.setNome(pei.getNome()); 
            pei2.setIdade(pei.getIdade());
            pei2.setPeso(pei.getPeso()); 
            pei2.setAltura(pei.getAltura());
            pei2.setEspecie(pei.getEspecie());
            pei2.setSexo(pei.getSexo()); 
            pei2.setHerbivoro(pei.getHerbivoro());
            pei2.setCarnivoro(pei.getCarnivoro());
            pei2.setHabitatNomeHab(pei.getHabitatNomeHab());     
            pei2.setHabitatTemperatura(pei.getHabitatTemperatura());                        
            pei2.setHabitatArea(pei.getHabitatArea());                                               
            pei2.setHabitatSolo(pei.getHabitatSolo());
            
            pei2.setNadadeiras(pei.getNadadeiras());
            pei2.setProfundidadeMax(pei.getProfundidadeMax()); 
            pei2.setNada(pei.getNada());
            
            pei2 = ga.insPei(pei2);

            
            if(pei2 != null){
                JOptionPane.showMessageDialog(
                        null,
                        "Peixe cadastrado!",
                        "CADASTRO DE PEIXE",
                        1
                );
            }
            else{
                JOptionPane.showMessageDialog(
                null,
                "Peixe já existe!",
                 "CADASTRO DE PEIXE",
                 0
                );
            }
        }
        
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "ERRO AO CADASTRAR PEIXE!",
                 "ERRO CADASTRO DE PEIXE",
                 0
            );
        }  
        
        catch(ValorVazioException vv){
            vv.exibirMensagem();
        }    
                
        catch(InsercaoVaziaException iv){
            iv.exibirMensagem();
        } 
    }
    
    public void limpar(){
        NadadeirasCampo.setText("");
        ProfundidadeCampo.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VoltarBotao = new javax.swing.JButton();
        RegistrarBotao = new javax.swing.JButton();
        ProfundidadeTexto = new javax.swing.JLabel();
        NadadeirasTexto = new javax.swing.JLabel();
        NadaTexto = new javax.swing.JLabel();
        ProfundidadeCampo = new javax.swing.JTextField();
        NadadeirasCampo = new javax.swing.JTextField();
        NadaOpcao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        RegistrarBotao.setText("Registrar");
        RegistrarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarBotaoActionPerformed(evt);
            }
        });

        ProfundidadeTexto.setText("Profundidade Máxima do Nado");

        NadadeirasTexto.setText("Quantidade de Nadadeiras");

        NadaTexto.setText("Peixe Nada?");

        ProfundidadeCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfundidadeCampoActionPerformed(evt);
            }
        });

        NadaOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VoltarBotao)
                .addGap(18, 18, 18)
                .addComponent(RegistrarBotao)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NadaTexto)
                    .addComponent(NadadeirasTexto)
                    .addComponent(ProfundidadeTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NadaOpcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProfundidadeCampo)
                    .addComponent(NadadeirasCampo))
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfundidadeTexto)
                    .addComponent(ProfundidadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NadadeirasTexto)
                    .addComponent(NadadeirasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NadaTexto)
                    .addComponent(NadaOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(RegistrarBotao))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBotaoActionPerformed
        limpar();
        dispose();
    }//GEN-LAST:event_VoltarBotaoActionPerformed

    private void RegistrarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarBotaoActionPerformed
        regPei();
        insPei();
        limpar();
        dispose();
    }//GEN-LAST:event_RegistrarBotaoActionPerformed

    private void ProfundidadeCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfundidadeCampoActionPerformed

    }//GEN-LAST:event_ProfundidadeCampoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceInsAve().setVisible(true);
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> NadaOpcao;
    private javax.swing.JLabel NadaTexto;
    private javax.swing.JTextField NadadeirasCampo;
    private javax.swing.JLabel NadadeirasTexto;
    private javax.swing.JTextField ProfundidadeCampo;
    private javax.swing.JLabel ProfundidadeTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JButton VoltarBotao;
    // End of variables declaration//GEN-END:variables
}
