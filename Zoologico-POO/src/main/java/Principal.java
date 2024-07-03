//Apache NetBeans IDE 19
//Gabriel Kenji Inoue

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuTexto = new javax.swing.JLabel();
        BotaoInserir = new javax.swing.JButton();
        BotaoConsultar = new javax.swing.JButton();
        BotaoAtualizar = new javax.swing.JButton();
        BotaoDeletar = new javax.swing.JButton();
        BotaoTodos = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        Consultas = new javax.swing.JMenu();
        Consultar = new javax.swing.JMenuItem();
        ConsultarAnimal = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Inserir = new javax.swing.JMenuItem();
        Atualizar = new javax.swing.JMenuItem();
        Deletar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuTexto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        MenuTexto.setText("Menu Principal");

        BotaoInserir.setText("Inserir");
        BotaoInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoInserirActionPerformed(evt);
            }
        });

        BotaoConsultar.setText("Consultar");
        BotaoConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConsultarActionPerformed(evt);
            }
        });

        BotaoAtualizar.setText("Atualizar");
        BotaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAtualizarActionPerformed(evt);
            }
        });

        BotaoDeletar.setText("Deletar");
        BotaoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDeletarActionPerformed(evt);
            }
        });

        BotaoTodos.setText("Consultar Todos Animais");
        BotaoTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoTodosActionPerformed(evt);
            }
        });

        Consultas.setText("Consultas");

        Consultar.setText("Consultar Tudo");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });
        Consultas.add(Consultar);

        ConsultarAnimal.setText("Consultar Animal");
        ConsultarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarAnimalActionPerformed(evt);
            }
        });
        Consultas.add(ConsultarAnimal);

        MenuBar.add(Consultas);

        jMenu1.setText("Ações");

        Inserir.setText("Inserir");
        Inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirActionPerformed(evt);
            }
        });
        jMenu1.add(Inserir);

        Atualizar.setText("Atualizar");
        Atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarActionPerformed(evt);
            }
        });
        jMenu1.add(Atualizar);

        Deletar.setText("Deletar");
        Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarActionPerformed(evt);
            }
        });
        jMenu1.add(Deletar);

        MenuBar.add(jMenu1);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(MenuTexto))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(BotaoInserir)
                                .addGap(18, 18, 18)
                                .addComponent(BotaoConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotaoAtualizar)))
                        .addGap(18, 18, 18)
                        .addComponent(BotaoDeletar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(BotaoTodos)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuTexto)
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoInserir)
                    .addComponent(BotaoConsultar)
                    .addComponent(BotaoAtualizar)
                    .addComponent(BotaoDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(BotaoTodos)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoInserirActionPerformed
        InterfaceIns.geraIntIns().setVisible(true);
    }//GEN-LAST:event_BotaoInserirActionPerformed

    private void BotaoConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConsultarActionPerformed
        InterfaceCon.geraIntCon().setVisible(true);
    }//GEN-LAST:event_BotaoConsultarActionPerformed

    private void BotaoTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoTodosActionPerformed
        InterfaceRel.geraIntRel().setVisible(true);
    }//GEN-LAST:event_BotaoTodosActionPerformed

    private void BotaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDeletarActionPerformed
        InterfaceDel.geraIntDel().setVisible(true);
    }//GEN-LAST:event_BotaoDeletarActionPerformed

    private void BotaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtualizarActionPerformed
        InterfaceAtu.geraIntAtu().setVisible(true);
    }//GEN-LAST:event_BotaoAtualizarActionPerformed

    private void InserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserirActionPerformed
        InterfaceIns.geraIntIns().setVisible(true);
    }//GEN-LAST:event_InserirActionPerformed

    private void AtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarActionPerformed
        InterfaceAtu.geraIntAtu().setVisible(true);
    }//GEN-LAST:event_AtualizarActionPerformed

    private void DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarActionPerformed
        InterfaceDel.geraIntDel().setVisible(true);
    }//GEN-LAST:event_DeletarActionPerformed

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        InterfaceRel.geraIntRel().setVisible(true);
    }//GEN-LAST:event_ConsultarActionPerformed

    private void ConsultarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarAnimalActionPerformed
        InterfaceCon.geraIntCon().setVisible(true);
    }//GEN-LAST:event_ConsultarAnimalActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Atualizar;
    private javax.swing.JButton BotaoAtualizar;
    private javax.swing.JButton BotaoConsultar;
    private javax.swing.JButton BotaoDeletar;
    private javax.swing.JButton BotaoInserir;
    private javax.swing.JButton BotaoTodos;
    private javax.swing.JMenuItem Consultar;
    private javax.swing.JMenuItem ConsultarAnimal;
    private javax.swing.JMenu Consultas;
    private javax.swing.JMenuItem Deletar;
    private javax.swing.JMenuItem Inserir;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel MenuTexto;
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables
}
