//Nome: Gabriel Kenji Inoue
//RA: 2504170
import javax.swing.JOptionPane;

public class InterfaceInsAnfibio extends javax.swing.JFrame {
    private Anfibio anf = new Anfibio();
    private GerAni ga = GerAni.geraGerAni();

    private static InterfaceInsAnfibio insUnic;
    
    //Singleton
    public static InterfaceInsAnfibio geraInsAnfibio(){
        if(insUnic == null){
            insUnic = new InterfaceInsAnfibio();
        }
        
        return insUnic;
    }
    
    public InterfaceInsAnfibio() {
        initComponents();
    }
    
    public boolean setValores(String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean herbivoro, boolean carnivoro, String nomeHabitat, int temperatura, double area, String solo){
        try{
            anf.setNome(nome);
            
            anf.setIdade(idade);
            
            anf.setPeso(peso); 
            
            anf.setAltura(altura);
            
            anf.setEspecie(especie);
            
            anf.setSexo(sexo); 
            
            anf.setHerbivoro(herbivoro);
            
            anf.setCarnivoro(carnivoro);
            
            anf.setHabitatNomeHab(nomeHabitat);
                    
            anf.setHabitatTemperatura(temperatura);
                                        
            anf.setHabitatArea(area);
                                                            
            anf.setHabitatSolo(solo);
            
            return true;
        }
        
        catch(NumberFormatException nfe){ 
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE ANFIBIO",
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

    public void regAnfibio(){
        try {
            anf.setPatas(Integer.parseInt(PatasCampo.getText().trim()));
            
            String tipoSelecionado = MetamorfoseOpcao.getSelectedItem().toString();

            switch (tipoSelecionado) {
                case "Não":  
                    anf.setMetamorfose(false);
                    break;
                
                case "Sim":
                    anf.setMetamorfose(true);
                    break;
                
                default:
                    break;
            }
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE ANFIBIO",
                 0
            );
        }
        
        catch(ValorVazioException vv){
            vv.exibirMensagem();
        }
        
    }
    
    public void insAnfibio(){
        try{
            Anfibio anf2 = new Anfibio();
            anf2.setNome(anf.getNome()); 
            anf2.setIdade(anf.getIdade());
            anf2.setPeso(anf.getPeso()); 
            anf2.setAltura(anf.getAltura());
            anf2.setEspecie(anf.getEspecie());
            anf2.setSexo(anf.getSexo()); 
            anf2.setHerbivoro(anf.getHerbivoro());
            anf2.setCarnivoro(anf.getCarnivoro());
            anf2.setHabitatNomeHab(anf.getHabitatNomeHab());     
            anf2.setHabitatTemperatura(anf.getHabitatTemperatura());                        
            anf2.setHabitatArea(anf.getHabitatArea());                                               
            anf2.setHabitatSolo(anf.getHabitatSolo());
            anf2.setPatas(anf.getPatas());
            anf2.setMetamorfose(anf.getMetamorfose()); 
            
            anf2 = ga.insAnf(anf2);

            
            if(anf2 != null){
                JOptionPane.showMessageDialog(
                        null,
                        "Anfibio cadastrado!",
                        "CADASTRO DE ANFIBIO",
                        1
                );
            }
            else{
                JOptionPane.showMessageDialog(
                null,
                "Anfibio já existe!",
                 "CADASTRO DE ANFIBIO",
                 0
                );
            }
        }
        
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "ERRO AO CADASTRAR ANFIBIO!",
                 "ERRO CADASTRO DE ANFIBIO",
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
        MetamorfoseTexto = new javax.swing.JLabel();
        PatasCampo = new javax.swing.JTextField();
        MetamorfoseOpcao = new javax.swing.JComboBox<>();

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

        MetamorfoseTexto.setText("O anfibio tem metamorfose?");

        MetamorfoseOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

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
                    .addComponent(MetamorfoseTexto)
                    .addComponent(PatasTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MetamorfoseOpcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(MetamorfoseTexto)
                    .addComponent(MetamorfoseOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        regAnfibio();
        insAnfibio();
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
    private javax.swing.JComboBox<String> MetamorfoseOpcao;
    private javax.swing.JLabel MetamorfoseTexto;
    private javax.swing.JTextField PatasCampo;
    private javax.swing.JLabel PatasTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JButton VoltarBotao;
    // End of variables declaration//GEN-END:variables
}
