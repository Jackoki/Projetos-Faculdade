//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;

public class InterfaceInsAve extends javax.swing.JFrame {
    private Ave ave = new Ave();
    private GerAni ga = GerAni.geraGerAni();

    private static InterfaceInsAve insUnic;
    
    //Singleton
    public static InterfaceInsAve geraInsAve(){
        if(insUnic == null){
            insUnic = new InterfaceInsAve();
        }
        return insUnic;
    }
    
    public InterfaceInsAve() {
        initComponents();
    }
    
    public boolean setValores(String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean herbivoro, boolean carnivoro, String nomeHabitat, int temperatura, double area, String solo){
        try{
            ave.setNome(nome);
            
            ave.setIdade(idade);
            
            ave.setPeso(peso); 
            
            ave.setAltura(altura);
            
            ave.setEspecie(especie);
            
            ave.setSexo(sexo); 
            
            ave.setHerbivoro(herbivoro);
            
            ave.setCarnivoro(carnivoro);
            
            ave.setHabitatNomeHab(nomeHabitat);
                    
            ave.setHabitatTemperatura(temperatura);
                                        
            ave.setHabitatArea(area);
                                                            
            ave.setHabitatSolo(solo);
            return true;
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE AVE",
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

    public void regAve(){
        try {
            ave.setAsas(Integer.parseInt(AsasCampo.getText().trim()));
            ave.setPatas(Integer.parseInt(PatasCampo.getText().trim()));
        
            String vooSelecionado = VooOpcao.getSelectedItem().toString();
        
            switch (vooSelecionado) {
                case "Não":   
                    ave.setVoo(false);
                    break;
                
                case "Sim":   
                    ave.setVoo(true);
                    break;
            }   
        
            ave.setVooMax(Integer.parseInt(VooMaxCampo.getText().trim()));
        
        }//fim try
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE AVE",
                 0
            );
        }
        
        catch(ValorVazioException vv){
            vv.exibirMensagem();
        }
        
    }
    
    public void insAve(){
        try{
            Ave ave2 = new Ave();
            ave2.setNome(ave.getNome()); 
            ave2.setIdade(ave.getIdade());
            ave2.setPeso(ave.getPeso()); 
            ave2.setAltura(ave.getAltura());
            ave2.setEspecie(ave.getEspecie());
            ave2.setSexo(ave.getSexo()); 
            ave2.setHerbivoro(ave.getHerbivoro());
            ave2.setCarnivoro(ave.getCarnivoro());
            ave2.setHabitatNomeHab(ave.getHabitatNomeHab());     
            ave2.setHabitatTemperatura(ave.getHabitatTemperatura());                        
            ave2.setHabitatArea(ave.getHabitatArea());                                               
            ave2.setHabitatSolo(ave.getHabitatSolo());
            
            ave2.setPatas(ave.getPatas());
            ave2.setAsas(ave.getAsas()); 
            ave2.setVoo(ave.getVoo());
            ave2.setVooMax(ave.getVooMax()); 
            
            ave2 = ga.insAve(ave2);

            
            if(ave2 != null){
                JOptionPane.showMessageDialog(
                        null,
                        "Ave cadastrada!",
                        "CADASTRO DE AVE",
                        1
                );
            }
            else{
                JOptionPane.showMessageDialog(
                null,
                "Ave já existe!",
                 "CADASTRO DE AVE",
                 0
                );
            }
        }
        
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "ERRO AO CADASTRAR AVE!",
                 "ERRO CADASTRO DE AVE",
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
        AsasCampo.setText("");
        PatasCampo.setText("");
        VooMaxCampo.setText("");
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VoltarBotao = new javax.swing.JButton();
        RegistrarBotao = new javax.swing.JButton();
        AsasTexto = new javax.swing.JLabel();
        PatasTexto = new javax.swing.JLabel();
        VooTexto = new javax.swing.JLabel();
        VooMaxTexto = new javax.swing.JLabel();
        AsasCampo = new javax.swing.JTextField();
        PatasCampo = new javax.swing.JTextField();
        VooOpcao = new javax.swing.JComboBox<>();
        VooMaxCampo = new javax.swing.JTextField();

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

        AsasTexto.setText("Quantidade de Asas");

        PatasTexto.setText("Quantidade de Patas");

        VooTexto.setText("A ave voa?");

        VooMaxTexto.setText("Qual o voo máximo se ela voa?");

        AsasCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsasCampoActionPerformed(evt);
            }
        });

        VooOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

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
                    .addComponent(VooMaxTexto)
                    .addComponent(PatasTexto)
                    .addComponent(AsasTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VooOpcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AsasCampo)
                    .addComponent(VooMaxCampo)
                    .addComponent(PatasCampo))
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AsasTexto)
                    .addComponent(AsasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PatasTexto)
                    .addComponent(PatasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VooTexto)
                    .addComponent(VooOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VooMaxTexto)
                    .addComponent(VooMaxCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
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
        regAve();
        insAve();
        limpar();
        dispose();
    }//GEN-LAST:event_RegistrarBotaoActionPerformed

    private void AsasCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsasCampoActionPerformed

    }//GEN-LAST:event_AsasCampoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceInsAve().setVisible(true);
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AsasCampo;
    private javax.swing.JLabel AsasTexto;
    private javax.swing.JTextField PatasCampo;
    private javax.swing.JLabel PatasTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JTextField VooMaxCampo;
    private javax.swing.JLabel VooMaxTexto;
    private javax.swing.JComboBox<String> VooOpcao;
    private javax.swing.JLabel VooTexto;
    // End of variables declaration//GEN-END:variables
}
