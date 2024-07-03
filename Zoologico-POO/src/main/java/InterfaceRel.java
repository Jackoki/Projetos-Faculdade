//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class InterfaceRel extends javax.swing.JFrame {

    private GerAni ga = GerAni.geraGerAni();
    private static InterfaceRel insUnic;
    
    public InterfaceRel() {
        initComponents();
    }

    //Singleton
    public static InterfaceRel geraIntRel(){
        if(insUnic == null){
            insUnic = new InterfaceRel();
        }
        insUnic.limparTabela();
        insUnic.adicionarTabela();
        return insUnic;
    }
    
    public void limparTabela() {
        DefaultTableModel modelTabela = (DefaultTableModel) jTable1.getModel();
        modelTabela.setRowCount(0);
    }
    
    public void adicionarTabela(){
        DefaultTableModel modelTabela = (DefaultTableModel) jTable1.getModel();
        
        List<Anfibio> anfLista = ga.getBdAnf();
        List<Ave> aveLista = ga.getBdAve();
        List<Mamifero> mamLista = ga.getBdMam();
        List<Peixe> peiLista = ga.getBdPeixe();
        List<Reptil> repLista = ga.getBdRep();
        
        Object coluna[] = new Object[12];
        
        for(int i = 0; i < anfLista.size(); i++){
            coluna[0] = anfLista.get(i).getNome();
            coluna[1] = anfLista.get(i).getIdade();
            coluna[2] = anfLista.get(i).getPeso();
            coluna[3] = anfLista.get(i).getAltura();
            coluna[4] = anfLista.get(i).getEspecie();
            coluna[5] = anfLista.get(i).getSexo();
            coluna[6] = anfLista.get(i).getHerbivoro();
            coluna[7] = anfLista.get(i).getCarnivoro();
            coluna[8] = anfLista.get(i).getHabitatNomeHab();
            coluna[9] = anfLista.get(i).getHabitatTemperatura();
            coluna[10] = anfLista.get(i).getHabitatArea();
            coluna[11] = anfLista.get(i).getHabitatSolo();
            
            modelTabela.addRow(coluna);
        }
        
        for(int i = 0; i < aveLista.size(); i++){
            coluna[0] = aveLista.get(i).getNome();
            coluna[1] = aveLista.get(i).getIdade();
            coluna[2] = aveLista.get(i).getPeso();
            coluna[3] = aveLista.get(i).getAltura();
            coluna[4] = aveLista.get(i).getEspecie();
            coluna[5] = aveLista.get(i).getSexo();
            coluna[6] = aveLista.get(i).getHerbivoro();
            coluna[7] = aveLista.get(i).getCarnivoro();
            coluna[8] = aveLista.get(i).getHabitatNomeHab();
            coluna[9] = aveLista.get(i).getHabitatTemperatura();
            coluna[10] = aveLista.get(i).getHabitatArea();
            coluna[11] = aveLista.get(i).getHabitatSolo();
            
            modelTabela.addRow(coluna);
        }
        
        for(int i = 0; i < mamLista.size(); i++){
            coluna[0] = mamLista.get(i).getNome();
            coluna[1] = mamLista.get(i).getIdade();
            coluna[2] = mamLista.get(i).getPeso();
            coluna[3] = mamLista.get(i).getAltura();
            coluna[4] = mamLista.get(i).getEspecie();
            coluna[5] = mamLista.get(i).getSexo();
            coluna[6] = mamLista.get(i).getHerbivoro();
            coluna[7] = mamLista.get(i).getCarnivoro();
            coluna[8] = mamLista.get(i).getHabitatNomeHab();
            coluna[9] = mamLista.get(i).getHabitatTemperatura();
            coluna[10] = mamLista.get(i).getHabitatArea();
            coluna[11] = mamLista.get(i).getHabitatSolo();
            
            modelTabela.addRow(coluna);
        }
        
        for(int i = 0; i < peiLista.size(); i++){
            coluna[0] = peiLista.get(i).getNome();
            coluna[1] = peiLista.get(i).getIdade();
            coluna[2] = peiLista.get(i).getPeso();
            coluna[3] = peiLista.get(i).getAltura();
            coluna[4] = peiLista.get(i).getEspecie();
            coluna[5] = peiLista.get(i).getSexo();
            coluna[6] = peiLista.get(i).getHerbivoro();
            coluna[7] = peiLista.get(i).getCarnivoro();
            coluna[8] = peiLista.get(i).getHabitatNomeHab();
            coluna[9] = peiLista.get(i).getHabitatTemperatura();
            coluna[10] = peiLista.get(i).getHabitatArea();
            coluna[11] = peiLista.get(i).getHabitatSolo();
            
            modelTabela.addRow(coluna);
        }
        
        for(int i = 0; i < repLista.size(); i++){
            coluna[0] = repLista.get(i).getNome();
            coluna[1] = repLista.get(i).getIdade();
            coluna[2] = repLista.get(i).getPeso();
            coluna[3] = repLista.get(i).getAltura();
            coluna[4] = repLista.get(i).getEspecie();
            coluna[5] = repLista.get(i).getSexo();
            coluna[6] = repLista.get(i).getHerbivoro();
            coluna[7] = repLista.get(i).getCarnivoro();
            coluna[8] = repLista.get(i).getHabitatNomeHab();
            coluna[9] = repLista.get(i).getHabitatTemperatura();
            coluna[10] = repLista.get(i).getHabitatArea();
            coluna[11] = repLista.get(i).getHabitatSolo();
            
            modelTabela.addRow(coluna);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AnimalTabela = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AnimalTexto = new javax.swing.JLabel();
        VoltarBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Idade", "Peso", "Altura", "Especie", "Sexo", "Herbivoro", "Carnivoro", "Nome do Habitat", "Temperatura do Habitat", "Area do Habitat", "Solo do Habitat"
            }
        ));
        AnimalTabela.setViewportView(jTable1);

        AnimalTexto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AnimalTexto.setText("Todos os Animais");

        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addComponent(AnimalTexto)
                .addContainerGap(484, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AnimalTabela)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(VoltarBotao)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(AnimalTexto)
                .addGap(27, 27, 27)
                .addComponent(AnimalTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(VoltarBotao)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarBotaoActionPerformed
        dispose();
    }//GEN-LAST:event_VoltarBotaoActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceRel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane AnimalTabela;
    private javax.swing.JLabel AnimalTexto;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
