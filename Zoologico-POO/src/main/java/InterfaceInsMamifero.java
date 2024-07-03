//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;

public class InterfaceInsMamifero extends javax.swing.JFrame {
    private Mamifero mam = new Mamifero();
    private GerAni ga = GerAni.geraGerAni();

    private static InterfaceInsMamifero insUnic;
    
    //Singleton
    public static InterfaceInsMamifero geraInsMamifero(){
        if(insUnic == null){
            insUnic = new InterfaceInsMamifero();
        }
        return insUnic;
    }
    
    public InterfaceInsMamifero() {
        initComponents();
    }
    
    public boolean setValores(String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean herbivoro, boolean carnivoro, String nomeHabitat, int temperatura, double area, String solo){
        try{
            mam.setNome(nome);
            
            mam.setIdade(idade);
            
            mam.setPeso(peso); 
            
            mam.setAltura(altura);
            
            mam.setEspecie(especie);
            
            mam.setSexo(sexo); 
            
            mam.setHerbivoro(herbivoro);
            
            mam.setCarnivoro(carnivoro);
            
            mam.setHabitatNomeHab(nomeHabitat);
                    
            mam.setHabitatTemperatura(temperatura);
                                        
            mam.setHabitatArea(area);
                                                            
            mam.setHabitatSolo(solo);
            
            return true;
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE MAMIFERO",
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

    public void regMam(){
        try {
            mam.setPatas(Integer.parseInt(PatasCampo.getText().trim()));
            mam.setTempoGestacao(Double.parseDouble(TempoGestacaoCampo.getText().trim()));
            
            String caminhaSelecionado = CaminhaOpcao.getSelectedItem().toString();
        
            switch (caminhaSelecionado) {
                case "Não":   
                    mam.setCaminha(false);
                    break;
                
                case "Sim":   
                    mam.setCaminha(true);
                    break;
            }   
        
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE MAMIFERO",
                 0
            );
        }
        
    }
    
    public void insMam(){
        try{
            Mamifero mam2 = new Mamifero();
            mam2.setNome(mam.getNome()); 
            mam2.setIdade(mam.getIdade());
            mam2.setPeso(mam.getPeso()); 
            mam2.setAltura(mam.getAltura());
            mam2.setEspecie(mam.getEspecie());
            mam2.setSexo(mam.getSexo()); 
            mam2.setHerbivoro(mam.getHerbivoro());
            mam2.setCarnivoro(mam.getCarnivoro());
            mam2.setHabitatNomeHab(mam.getHabitatNomeHab());     
            mam2.setHabitatTemperatura(mam.getHabitatTemperatura());                        
            mam2.setHabitatArea(mam.getHabitatArea());                                               
            mam2.setHabitatSolo(mam.getHabitatSolo());
            
            mam2.setPatas(mam.getPatas());
            mam2.setTempoGestacao(mam.getTempoGestacao()); 
            mam2.setCaminha(mam.getCaminha());
            
            mam2 = ga.insMam(mam2);

            
            if(mam2 != null){
                JOptionPane.showMessageDialog(
                        null,
                        "Mamifero cadastrada!",
                        "CADASTRO DE MAMIFERO",
                        1
                );
            }
            else{
                JOptionPane.showMessageDialog(
                null,
                "Mamifero já existe!",
                 "CADASTRO DE MAMIFERO",
                 0
                );
            }
        }
        
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "ERRO AO CADASTRAR MAMIFERO!",
                 "ERRO CADASTRO DE MAMIFERO",
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
        TempoGestacaoCampo.setText("");
        PatasCampo.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VoltarBotao = new javax.swing.JButton();
        RegistrarBotao = new javax.swing.JButton();
        TempoGestacaoTexto = new javax.swing.JLabel();
        PatasTexto = new javax.swing.JLabel();
        VooTexto = new javax.swing.JLabel();
        TempoGestacaoCampo = new javax.swing.JTextField();
        PatasCampo = new javax.swing.JTextField();
        CaminhaOpcao = new javax.swing.JComboBox<>();

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

        TempoGestacaoTexto.setText("Tempo Gestação em Semanas");

        PatasTexto.setText("Quantidade de Patas");

        VooTexto.setText("O mamifero caminha?");

        TempoGestacaoCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TempoGestacaoCampoActionPerformed(evt);
            }
        });

        CaminhaOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

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
                    .addComponent(VooTexto)
                    .addComponent(PatasTexto)
                    .addComponent(TempoGestacaoTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CaminhaOpcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TempoGestacaoCampo)
                    .addComponent(PatasCampo))
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TempoGestacaoTexto)
                    .addComponent(TempoGestacaoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PatasTexto)
                    .addComponent(PatasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VooTexto)
                    .addComponent(CaminhaOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        regMam();
        insMam();
        limpar();
        dispose();
    }//GEN-LAST:event_RegistrarBotaoActionPerformed

    private void TempoGestacaoCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempoGestacaoCampoActionPerformed

    }//GEN-LAST:event_TempoGestacaoCampoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceInsAve().setVisible(true);
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CaminhaOpcao;
    private javax.swing.JTextField PatasCampo;
    private javax.swing.JLabel PatasTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JTextField TempoGestacaoCampo;
    private javax.swing.JLabel TempoGestacaoTexto;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JLabel VooTexto;
    // End of variables declaration//GEN-END:variables
}
