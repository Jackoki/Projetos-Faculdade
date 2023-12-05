//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfaceConAve extends javax.swing.JFrame {
    private Ave ave = new Ave();
    
    private GerAni ga = GerAni.geraGerAni();
    private static InterfaceConAve insUnic;
    
    //Singleton
    public static InterfaceConAve geraConAve(){
        if(insUnic == null){
            insUnic = new InterfaceConAve();
        }
        
        insUnic.limparTabela();
        return insUnic;
    }
    
    public InterfaceConAve() {
        initComponents();
    }
    
    public void setValores(String nome){
        try{
            ave.setNome(nome);
            insUnic.consultar();
        }
        
        catch(InsercaoVaziaException iv){
            iv.exibirMensagem();
        }
    }
    
    public void consultar(){
        Ave ave2 = new Ave();
        ave2 = ga.consAve(ave);
        
        if(ave2 == null){
                JOptionPane.showMessageDialog(
                null,
                "NAO EXISTE ESSE NOME!",
                 "ERRO CONSULTA DE AVE",
                 0
            );
          insUnic.dispose();
                
        }
        
        else{
            insUnic.setVisible(true);
            
            DefaultTableModel modelTabela = (DefaultTableModel) jTable1.getModel();
        
            Object coluna[] = new Object[16];
        
            coluna[0] = ave2.getNome();
            coluna[1] = ave2.getIdade();
            coluna[2] = ave2.getPeso();
            coluna[3] = ave2.getAltura();
            coluna[4] = ave2.getEspecie();
            coluna[5] = ave2.getSexo();
            coluna[6] = ave2.getHerbivoro();
            coluna[7] = ave2.getCarnivoro();
            coluna[8] = ave2.getHabitatNomeHab();
            coluna[9] = ave2.getHabitatTemperatura();
            coluna[10] = ave2.getHabitatArea();
            coluna[11] = ave2.getHabitatSolo();
            coluna[12] = ave2.getAsas();
            coluna[13] = ave2.getPatas();
            coluna[14] = ave2.getVoo();
            coluna[15] = ave2.getVooMax();
            
            modelTabela.addRow(coluna);
            
            ave.setHerbivoro(ave2.getHerbivoro());
            ave.setCarnivoro(ave2.getCarnivoro());
            
            try {
                ave.setAsas(ave2.getAsas()); 
                ave.setVoo(ave2.getVoo());
                ave.setVooMax(ave2.getVooMax()); 
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
        VooBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Idade", "Peso", "Altura", "Especie", "Sexo", "Herbivoro", "Carnivoro", "Nome do Habitat", "Temperatura do Habitat", "Area do Habitat", "Solo do Habitat", "Asas", "Patas", "Voo", "VooMax"
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

        VooBotao.setText("Voo");
        VooBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VooBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(886, Short.MAX_VALUE)
                .addComponent(VooBotao)
                .addGap(18, 18, 18)
                .addComponent(ComerBotao)
                .addGap(18, 18, 18)
                .addComponent(VoltarBotao)
                .addGap(27, 27, 27))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(AnimalTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(ComerBotao)
                    .addComponent(VooBotao))
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
        ave.comer();
    }//GEN-LAST:event_ComerBotaoActionPerformed

    private void VooBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VooBotaoActionPerformed
        ave.mover();
    }//GEN-LAST:event_VooBotaoActionPerformed

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
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JButton VooBotao;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
