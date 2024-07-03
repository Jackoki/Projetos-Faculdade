//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfaceConPeixe extends javax.swing.JFrame {
    private Peixe pei = new Peixe();
    
    private GerAni ga = GerAni.geraGerAni();
    private static InterfaceConPeixe insUnic;
    
    //Singleton
    public static InterfaceConPeixe geraConPeixe(){
        if(insUnic == null){
            insUnic = new InterfaceConPeixe();
        }
        
        insUnic.limparTabela();
        return insUnic;
    }
    
    public InterfaceConPeixe() {
        initComponents();
    }
    
    public void setValores(String nome){
        try{
            pei.setNome(nome);
            insUnic.consultar();
        }
        
        catch(InsercaoVaziaException iv){
            iv.exibirMensagem();
        }
    }
    
    public void consultar(){
        Peixe pei2 = new Peixe();
        pei2 = ga.consPei(pei);
        
        if(pei2 == null){
                JOptionPane.showMessageDialog(
                null,
                "NAO EXISTE ESSE NOME!",
                 "ERRO CONSULTA DE PEIXE",
                 0
            );
          insUnic.dispose();
                
        }
        
        else{
            insUnic.setVisible(true);
            
            DefaultTableModel modelTabela = (DefaultTableModel) jTable1.getModel();
        
            Object coluna[] = new Object[15];
        
            coluna[0] = pei2.getNome();
            coluna[1] = pei2.getIdade();
            coluna[2] = pei2.getPeso();
            coluna[3] = pei2.getAltura();
            coluna[4] = pei2.getEspecie();
            coluna[5] = pei2.getSexo();
            coluna[6] = pei2.getHerbivoro();
            coluna[7] = pei2.getCarnivoro();
            coluna[8] = pei2.getHabitatNomeHab();
            coluna[9] = pei2.getHabitatTemperatura();
            coluna[10] = pei2.getHabitatArea();
            coluna[11] = pei2.getHabitatSolo();
            coluna[12] = pei2.getNadadeiras();
            coluna[13] = pei2.getProfundidadeMax();
            coluna[14] = pei2.getNada();
            
            modelTabela.addRow(coluna);
            
            pei.setHerbivoro(pei2.getHerbivoro());
            pei.setCarnivoro(pei2.getCarnivoro());
            
            pei.setNadadeiras(pei2.getNadadeiras()); 
            pei.setNada(pei2.getNada());
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
        NadarBotao = new javax.swing.JButton();
        ComerBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Idade", "Peso", "Altura", "Especie", "Sexo", "Herbivoro", "Carnivoro", "Nome do Habitat", "Temperatura do Habitat", "Area do Habitat", "Solo do Habitat", "Nadadeiras", "Profundidade Máxima", "Nada"
            }
        ));
        AnimalTabela.setViewportView(jTable1);

        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        NadarBotao.setText("Nadar");
        NadarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NadarBotaoActionPerformed(evt);
            }
        });

        ComerBotao.setText("Comer");
        ComerBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComerBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(910, Short.MAX_VALUE)
                .addComponent(NadarBotao)
                .addGap(18, 18, 18)
                .addComponent(ComerBotao)
                .addGap(18, 18, 18)
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
                    .addComponent(NadarBotao)
                    .addComponent(ComerBotao))
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
        pei.comer();
    }//GEN-LAST:event_ComerBotaoActionPerformed

    private void NadarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NadarBotaoActionPerformed
        pei.mover();
    }//GEN-LAST:event_NadarBotaoActionPerformed

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
    private javax.swing.JButton NadarBotao;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
