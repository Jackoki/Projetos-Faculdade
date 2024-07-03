//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfaceConMamifero extends javax.swing.JFrame {
    private Mamifero mam = new Mamifero();
    
    private GerAni ga = GerAni.geraGerAni();
    private static InterfaceConMamifero insUnic;
    
    //Singleton
    public static InterfaceConMamifero geraConMamifero(){
        if(insUnic == null){
            insUnic = new InterfaceConMamifero();
        }
        
        insUnic.limparTabela();
        return insUnic;
    }
    
    public InterfaceConMamifero() {
        initComponents();
    }
    
    public void setValores(String nome){
        try{
            mam.setNome(nome);
            insUnic.consultar();
        }
        
        catch(InsercaoVaziaException iv){
            iv.exibirMensagem();
        }
    }
    
    public void consultar(){
        Mamifero mam2 = new Mamifero();
        mam2 = ga.consMam(mam);
        
        if(mam2 == null){
                JOptionPane.showMessageDialog(
                null,
                "NAO EXISTE ESSE NOME!",
                 "ERRO CONSULTA DE MAMIFERO",
                 0
            );
          insUnic.dispose();
                
        }
        
        else{
            insUnic.setVisible(true);
            
            DefaultTableModel modelTabela = (DefaultTableModel) jTable1.getModel();
        
            Object coluna[] = new Object[15];
        
            coluna[0] = mam2.getNome();
            coluna[1] = mam2.getIdade();
            coluna[2] = mam2.getPeso();
            coluna[3] = mam2.getAltura();
            coluna[4] = mam2.getEspecie();
            coluna[5] = mam2.getSexo();
            coluna[6] = mam2.getHerbivoro();
            coluna[7] = mam2.getCarnivoro();
            coluna[8] = mam2.getHabitatNomeHab();
            coluna[9] = mam2.getHabitatTemperatura();
            coluna[10] = mam2.getHabitatArea();
            coluna[11] = mam2.getHabitatSolo();
            coluna[12] = mam2.getPatas();
            coluna[13] = mam2.getTempoGestacao();
            coluna[14] = mam2.getCaminha();
            
            modelTabela.addRow(coluna);
            
                mam.setHerbivoro(mam2.getHerbivoro());
                mam.setCarnivoro(mam2.getCarnivoro());
                mam.setSexo(mam2.getSexo());
                mam.setPatas(mam2.getPatas());
                mam.setCaminha(mam2.getCaminha());
            
                if(mam.getSexo()){
                    mam.informarGestacao();
                }
            
                else{
                    mam.setTempoGestacao(mam2.getTempoGestacao());
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
        GestacaoBotao = new javax.swing.JButton();
        MoverBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Idade", "Peso", "Altura", "Especie", "Sexo", "Herbivoro", "Carnivoro", "Nome do Habitat", "Temperatura do Habitat", "Area do Habitat", "Solo do Habitat", "Patas", "Tempo Gestacao", "Caminha"
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

        GestacaoBotao.setText("Gestação");
        GestacaoBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestacaoBotaoActionPerformed(evt);
            }
        });

        MoverBotao.setText("Mover");
        MoverBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoverBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(783, Short.MAX_VALUE)
                .addComponent(MoverBotao)
                .addGap(29, 29, 29)
                .addComponent(GestacaoBotao)
                .addGap(29, 29, 29)
                .addComponent(ComerBotao)
                .addGap(27, 27, 27)
                .addComponent(VoltarBotao)
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AnimalTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 1177, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(ComerBotao)
                    .addComponent(GestacaoBotao)
                    .addComponent(MoverBotao))
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
        mam.comer();
    }//GEN-LAST:event_ComerBotaoActionPerformed

    private void GestacaoBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestacaoBotaoActionPerformed
        if(mam.getSexo()){
            mam.informarGestacao();
        }
        
        else{
            mam.informarGestacao(mam.getTempoGestacao());
        }
    }//GEN-LAST:event_GestacaoBotaoActionPerformed

    private void MoverBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoverBotaoActionPerformed
        mam.mover();
    }//GEN-LAST:event_MoverBotaoActionPerformed

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
    private javax.swing.JButton GestacaoBotao;
    private javax.swing.JButton MoverBotao;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
