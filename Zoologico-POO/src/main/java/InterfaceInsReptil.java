//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;

public class InterfaceInsReptil extends javax.swing.JFrame {
    private Reptil rep = new Reptil();
    private GerAni ga = GerAni.geraGerAni();

    private static InterfaceInsReptil insUnic;
    
    //Singleton
    public static InterfaceInsReptil geraInsReptil(){
        if(insUnic == null){
            insUnic = new InterfaceInsReptil();
        }
        return insUnic;
    }
    
    public InterfaceInsReptil() {
        initComponents();
    }
    
    public boolean setValores(String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean herbivoro, boolean carnivoro, String nomeHabitat, int temperatura, double area, String solo){
        try{
            rep.setNome(nome);
            
            rep.setIdade(idade);
            
            rep.setPeso(peso); 
            
            rep.setAltura(altura);
            
            rep.setEspecie(especie);
            
            rep.setSexo(sexo); 
            
            rep.setHerbivoro(herbivoro);
            
            rep.setCarnivoro(carnivoro);
            
            rep.setHabitatNomeHab(nomeHabitat);
                    
            rep.setHabitatTemperatura(temperatura);
                                        
            rep.setHabitatArea(area);
                                                            
            rep.setHabitatSolo(solo);
            
            return true;
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE REPTIL",
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

    public void regRep(){
        try {
            rep.setPatas(Integer.parseInt(PatasCampo.getText().trim()));
            
            String venenoSelecionado = VenenoOpcao.getSelectedItem().toString();
        
            switch (venenoSelecionado) {
                case "Não":   
                    rep.setVeneno(false);
                    break;
                
                case "Sim":
                    rep.setVeneno(true);
                    break;
            }    
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE REPTIL",
                 0
            );
        }
        
        catch(ValorVazioException vv){      
            vv.exibirMensagem();
        }
        
    }
    
    public void insRep(){
        try{
            Reptil rep2 = new Reptil();
            rep2.setNome(rep.getNome()); 
            rep2.setIdade(rep.getIdade());
            rep2.setPeso(rep.getPeso()); 
            rep2.setAltura(rep.getAltura());
            rep2.setEspecie(rep.getEspecie());
            rep2.setSexo(rep.getSexo()); 
            rep2.setHerbivoro(rep.getHerbivoro());
            rep2.setCarnivoro(rep.getCarnivoro());
            rep2.setHabitatNomeHab(rep.getHabitatNomeHab());     
            rep2.setHabitatTemperatura(rep.getHabitatTemperatura());                        
            rep2.setHabitatArea(rep.getHabitatArea());                                               
            rep2.setHabitatSolo(rep.getHabitatSolo());
            
            rep2.setPatas(rep.getPatas());
            rep2.setVeneno(rep.getVeneno());
            
            rep2 = ga.insRep(rep2);

            
            if(rep2 != null){
                JOptionPane.showMessageDialog(
                        null,
                        "Reptil cadastrado!",
                        "CADASTRO DE REPTIL",
                        1
                );
            }
            else{
                JOptionPane.showMessageDialog(
                null,
                "Reptil já existe!",
                 "CADASTRO DE REPTIL",
                 0
                );
            }
        }
        
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "ERRO AO CADASTRAR REPTIL!",
                 "ERRO CADASTRO DE REPTIL",
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
        PatasCampo.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VoltarBotao = new javax.swing.JButton();
        RegistrarBotao = new javax.swing.JButton();
        PatasTexto = new javax.swing.JLabel();
        VenenoTexto = new javax.swing.JLabel();
        PatasCampo = new javax.swing.JTextField();
        VenenoOpcao = new javax.swing.JComboBox<>();

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

        PatasTexto.setText("Quantidade de Patas");

        VenenoTexto.setText("Reptil tem Veneno?");

        VenenoOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

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
                    .addComponent(VenenoTexto)
                    .addComponent(PatasTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VenenoOpcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PatasCampo))
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PatasTexto)
                    .addComponent(PatasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VenenoTexto)
                    .addComponent(VenenoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        regRep();
        insRep();
        limpar();
        dispose();
    }//GEN-LAST:event_RegistrarBotaoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceInsAve().setVisible(true);
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PatasCampo;
    private javax.swing.JLabel PatasTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JComboBox<String> VenenoOpcao;
    private javax.swing.JLabel VenenoTexto;
    private javax.swing.JButton VoltarBotao;
    // End of variables declaration//GEN-END:variables
}
