//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfaceConAnfibio extends javax.swing.JFrame {
    private Anfibio anf = new Anfibio();
    
    private GerAni ga = GerAni.geraGerAni();
    private static InterfaceConAnfibio insUnic;
    
    //Singleton
    public static InterfaceConAnfibio geraConAnfibio(){
        if(insUnic == null){
            insUnic = new InterfaceConAnfibio();
        }
        
        insUnic.limparTabela();
        return insUnic;
    }
    
    public InterfaceConAnfibio() {
        initComponents();
    }
    
    public void setValores(String nome){
        try{
            anf.setNome(nome);
            insUnic.consultar();
        }
        
        catch(InsercaoVaziaException iv){
            iv.exibirMensagem();
        }
    }
    
    public void consultar(){
        Anfibio anf2 = new Anfibio();
        anf2 = ga.consAnf(anf);
        
        if(anf2 == null){
                JOptionPane.showMessageDialog(
                null,
                "NAO EXISTE ESSE NOME!",
                 "ERRO CONSULTA DE ANFIBIO",
                 0
            );
          insUnic.dispose();
                
        }
        
        else{
            insUnic.setVisible(true);
            
            DefaultTableModel modelTabela = (DefaultTableModel) jTable1.getModel();
        
            Object coluna[] = new Object[14];
        
            coluna[0] = anf2.getNome();
            coluna[1] = anf2.getIdade();
            coluna[2] = anf2.getPeso();
            coluna[3] = anf2.getAltura();
            coluna[4] = anf2.getEspecie();
            coluna[5] = anf2.getSexo();
            coluna[6] = anf2.getHerbivoro();
            coluna[7] = anf2.getCarnivoro();
            coluna[8] = anf2.getHabitatNomeHab();
            coluna[9] = anf2.getHabitatTemperatura();
            coluna[10] = anf2.getHabitatArea();
            coluna[11] = anf2.getHabitatSolo();
            coluna[12] = anf2.getPatas();
            coluna[13] = anf2.getMetamorfose();
            
            modelTabela.addRow(coluna);
            
            anf.setHerbivoro(anf2.getHerbivoro());
            anf.setCarnivoro(anf2.getCarnivoro());
            
            try {
                anf.setPatas(anf2.getPatas()); 
                anf.setMetamorfose(anf2.getMetamorfose());
            }
            
            catch (ValorVazioException vv){
                vv.exibirMensagem();
            }
        }
    }
    
    
    public void limparTabela() {
        DefaultTableModel modelTabela = (DefaultTableModel) jTable1.getModel();
        modelTabela.setRowCount(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AnimalTabela = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        VoltarBotao = new javax.swing.JButton();
        ComerBotao = new javax.swing.JButton();
        MovimentarBotao = new javax.swing.JButton();
        MetamorfoseBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Idade", "Peso", "Altura", "Especie", "Sexo", "Herbivoro", "Carnivoro", "Nome do Habitat", "Temperatura do Habitat", "Area do Habitat", "Solo do Habitat", "Patas", "Metamorfose"
            }
        ));
        AnimalTabela.setViewportView(jTable1);

        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        ComerBotao.setText("Comer");
        ComerBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComerBotaoActionPerformed(evt);
            }
        });

        MovimentarBotao.setText("Movimentar");
        MovimentarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MovimentarBotaoActionPerformed(evt);
            }
        });

        MetamorfoseBotao.setText("Metamorfose");
        MetamorfoseBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MetamorfoseBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(753, Short.MAX_VALUE)
                .addComponent(MetamorfoseBotao)
                .addGap(18, 18, 18)
                .addComponent(MovimentarBotao)
                .addGap(18, 18, 18)
                .addComponent(ComerBotao)
                .addGap(18, 18, 18)
                .addComponent(VoltarBotao)
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AnimalTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(ComerBotao)
                    .addComponent(MovimentarBotao)
                    .addComponent(MetamorfoseBotao))
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AnimalTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(79, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBotaoActionPerformed
        dispose();
    }//GEN-LAST:event_VoltarBotaoActionPerformed

    private void ComerBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComerBotaoActionPerformed
        anf.comer();
    }//GEN-LAST:event_ComerBotaoActionPerformed

    private void MovimentarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MovimentarBotaoActionPerformed
        anf.mover();
    }//GEN-LAST:event_MovimentarBotaoActionPerformed

    private void MetamorfoseBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MetamorfoseBotaoActionPerformed
        anf.transmutar();
    }//GEN-LAST:event_MetamorfoseBotaoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceInsAve().setVisible(true);
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane AnimalTabela;
    private javax.swing.JButton ComerBotao;
    private javax.swing.JButton MetamorfoseBotao;
    private javax.swing.JButton MovimentarBotao;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
