//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfaceConReptil extends javax.swing.JFrame {
    private Reptil rep = new Reptil();
    
    private GerAni ga = GerAni.geraGerAni();
    private static InterfaceConReptil insUnic;
    
    //Singleton
    public static InterfaceConReptil geraConReptil(){
        if(insUnic == null){
            insUnic = new InterfaceConReptil();
        }
        
        insUnic.limparTabela();
        return insUnic;
    }
    
    public InterfaceConReptil() {
        initComponents();
    }
    
    public void setValores(String nome){
        try{
            rep.setNome(nome);
            insUnic.consultar();
        }
        
        catch(InsercaoVaziaException iv){
            iv.exibirMensagem();
        }
    }
    
    public void consultar(){
        Reptil rep2 = new Reptil();
        rep2 = ga.consRep(rep);
        
        if(rep2 == null){
                JOptionPane.showMessageDialog(
                null,
                "NAO EXISTE ESSE NOME!",
                 "ERRO CONSULTA DE REPTIL",
                 0
            );
          insUnic.dispose();
                
        }
        
        else{
            insUnic.setVisible(true);
            
            DefaultTableModel modelTabela = (DefaultTableModel) jTable1.getModel();
        
            Object coluna[] = new Object[14];
        
            coluna[0] = rep2.getNome();
            coluna[1] = rep2.getIdade();
            coluna[2] = rep2.getPeso();
            coluna[3] = rep2.getAltura();
            coluna[4] = rep2.getEspecie();
            coluna[5] = rep2.getSexo();
            coluna[6] = rep2.getHerbivoro();
            coluna[7] = rep2.getCarnivoro();
            coluna[8] = rep2.getHabitatNomeHab();
            coluna[9] = rep2.getHabitatTemperatura();
            coluna[10] = rep2.getHabitatArea();
            coluna[11] = rep2.getHabitatSolo();
            coluna[12] = rep2.getPatas();
            coluna[13] = rep2.getVeneno();
            
            modelTabela.addRow(coluna);
            
            rep.setHerbivoro(rep2.getHerbivoro());
            rep.setCarnivoro(rep2.getCarnivoro());
            
            try {
                rep.setPatas(rep2.getPatas()); 
                rep.setVeneno(rep2.getVeneno());
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
        MoverBotao = new javax.swing.JButton();
        VenenoBotao = new javax.swing.JButton();
        ComerBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Idade", "Peso", "Altura", "Especie", "Sexo", "Herbivoro", "Carnivoro", "Nome do Habitat", "Temperatura do Habitat", "Area do Habitat", "Solo do Habitat", "Patas", "Tem Veneno"
            }
        ));
        AnimalTabela.setViewportView(jTable1);

        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        MoverBotao.setText("Mover");
        MoverBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoverBotaoActionPerformed(evt);
            }
        });

        VenenoBotao.setText("Veneno");
        VenenoBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VenenoBotaoActionPerformed(evt);
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
                .addContainerGap(833, Short.MAX_VALUE)
                .addComponent(VenenoBotao)
                .addGap(16, 16, 16)
                .addComponent(MoverBotao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComerBotao)
                .addGap(13, 13, 13)
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
                    .addComponent(MoverBotao)
                    .addComponent(VenenoBotao)
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
        rep.comer();
    }//GEN-LAST:event_ComerBotaoActionPerformed

    private void MoverBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoverBotaoActionPerformed
        rep.mover();
    }//GEN-LAST:event_MoverBotaoActionPerformed

    private void VenenoBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenenoBotaoActionPerformed
        rep.veneno();
    }//GEN-LAST:event_VenenoBotaoActionPerformed

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
    private javax.swing.JButton MoverBotao;
    private javax.swing.JButton VenenoBotao;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
