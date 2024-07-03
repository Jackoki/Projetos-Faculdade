//Nome: Gabriel Kenji Inoue
//RA: 2504170

import javax.swing.JOptionPane;

public class InterfaceDel extends javax.swing.JFrame {
    
    private static InterfaceDel insUnic;
     
    private GerAni ga = GerAni.geraGerAni();
    
    public InterfaceDel() {
        initComponents();
    }
    
    //Singleton
    public static InterfaceDel geraIntDel(){
        if(insUnic == null){
            insUnic = new InterfaceDel();
        }
        return insUnic;
    }
    
    public void excluiDado(){
        try {
                String tipoSelecionado = TipoOpcao.getSelectedItem().toString();
            
                switch (tipoSelecionado) {
                    case "Anfibio":
                        Anfibio anf = new Anfibio();
                        
                        anf.setNome(this.getNome());
                        
                        anf = ga.delAnf(anf);
                        
                        if(anf == null){
                            JOptionPane.showMessageDialog(
                                 null,
                                 "DELETE FEITO COM SUCESSO!",
                                 "RETIRADO COM SUCESSO",
                                 1
                            );
                        }
                        
                        else{
                            JOptionPane.showMessageDialog(
                                null,
                                "VALOR NAO ENCONTRADO!",
                                "ERRO AO DELETAR",
                                0
                            );
                        }
                        
                        break;
                    
                    case "Ave":
                        Ave ave = new Ave();
                        
                        ave.setNome(this.getNome());
                        
                        ave = ga.delAve(ave);
                        
                        if(ave == null){
                            JOptionPane.showMessageDialog(
                                 null,
                                 "DELETE FEITO COM SUCESSO!",
                                 "RETIRADO COM SUCESSO",
                                 1
                            );
                        }
                        
                        else{
                            JOptionPane.showMessageDialog(
                                null,
                                "VALOR NAO ENCONTRADO!",
                                "ERRO AO DELETAR",
                                0
                            );
                        }
                        break;
                    
                    case "Mamifero":
                        Mamifero mam = new Mamifero();
                        
                        mam.setNome(this.getNome());
                        
                        mam = ga.delMam(mam);
                        
                        if(mam == null){
                            JOptionPane.showMessageDialog(
                                 null,
                                 "DELETE FEITO COM SUCESSO!",
                                 "RETIRADO COM SUCESSO",
                                 1
                            );
                        }
                        
                        else{
                            JOptionPane.showMessageDialog(
                                null,
                                "VALOR NAO ENCONTRADO!",
                                "ERRO AO DELETAR",
                                0
                            );
                        }
                        break;
                    
                    case "Peixe":
                        Peixe pei = new Peixe();
                        
                        pei.setNome(this.getNome());
                        
                        pei = ga.delPei(pei);
                        
                        if(pei == null){
                            JOptionPane.showMessageDialog(
                                 null,
                                 "DELETE FEITO COM SUCESSO!",
                                 "RETIRADO COM SUCESSO",
                                 1
                            );
                        }
                        
                        else{
                            JOptionPane.showMessageDialog(
                                null,
                                "VALOR NAO ENCONTRADO!",
                                "ERRO AO DELETAR",
                                0
                            );
                        }
                        break;
                    
                    case "Reptil":
                        Reptil rep = new Reptil();
                        
                        rep.setNome(this.getNome());
                        
                        rep = ga.delRep(rep);
                        
                        if(rep == null){
                            JOptionPane.showMessageDialog(
                                 null,
                                 "DELETE FEITO COM SUCESSO!",
                                 "RETIRADO COM SUCESSO",
                                 1
                            );
                        }
                        
                        else{
                            JOptionPane.showMessageDialog(
                                null,
                                "VALOR NAO ENCONTRADO!",
                                "ERRO AO DELETAR",
                                0
                            );
                        }
                        break;
                    
                    default:
                        break;
            }
        }
        
        catch (InsercaoVaziaException iv){
            iv.exibirMensagem();
        }
    }

    public void limpar(){
        NomeCampo.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        NomeTipo = new javax.swing.JLabel();
        TipoOpcao = new javax.swing.JComboBox<>();
        NomeTexto = new javax.swing.JLabel();
        NomeCampo = new javax.swing.JTextField();
        MenuBotao = new javax.swing.JButton();
        ConsultarBotao = new javax.swing.JButton();

        jButton2.setText("Registrar Animal");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        NomeTipo.setText("Tipo de Animal:");

        TipoOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anfibio", "Ave", "Mamifero", "Peixe", "Reptil" }));
        TipoOpcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoOpcaoActionPerformed(evt);
            }
        });

        NomeTexto.setText("Nome:");

        NomeCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeCampoActionPerformed(evt);
            }
        });

        MenuBotao.setText("Voltar");
        MenuBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBotaoActionPerformed(evt);
            }
        });

        ConsultarBotao.setText("Consultar Animal");
        ConsultarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MenuBotao)
                        .addGap(145, 145, 145)
                        .addComponent(ConsultarBotao))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NomeTipo)
                            .addComponent(NomeTexto))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TipoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeTipo)
                    .addComponent(TipoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeTexto)
                    .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuBotao)
                    .addComponent(ConsultarBotao))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TipoOpcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoOpcaoActionPerformed

    }//GEN-LAST:event_TipoOpcaoActionPerformed

    private void NomeCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeCampoActionPerformed

    private void MenuBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBotaoActionPerformed
        limpar();
        dispose();
    }//GEN-LAST:event_MenuBotaoActionPerformed

    private void ConsultarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarBotaoActionPerformed
        excluiDado();
        limpar();
    }//GEN-LAST:event_ConsultarBotaoActionPerformed

    public String getNome() {
        return NomeCampo.getText();
    }
        
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceIns().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConsultarBotao;
    private javax.swing.JButton MenuBotao;
    private javax.swing.JTextField NomeCampo;
    private javax.swing.JLabel NomeTexto;
    private javax.swing.JLabel NomeTipo;
    private javax.swing.JComboBox<String> TipoOpcao;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
