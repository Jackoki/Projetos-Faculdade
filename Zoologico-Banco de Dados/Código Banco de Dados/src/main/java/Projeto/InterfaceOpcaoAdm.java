
package Projeto;



public class InterfaceOpcaoAdm extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;

    public InterfaceOpcaoAdm() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        InserirBotao = new javax.swing.JButton();
        DeletarBotao = new javax.swing.JButton();
        VoltarBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setText("O que deseja realizar?");

        InserirBotao.setText("Inserir Animal");
        InserirBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserirBotaoActionPerformed(evt);
            }
        });

        DeletarBotao.setText("Deletar Animal");
        DeletarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarBotaoActionPerformed(evt);
            }
        });

        VoltarBotao.setText("Voltar ao Menu");
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
                .addGap(29, 29, 29)
                .addComponent(InserirBotao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeletarBotao)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(VoltarBotao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InserirBotao)
                    .addComponent(DeletarBotao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(VoltarBotao)
                .addGap(17, 17, 17))
        );

        pack();
    }

    private void InserirBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        InterfaceBD ib = new InterfaceBD();
        ib.setVisible(true);
    }

    private void DeletarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        InterfaceBD2 ib2 = new InterfaceBD2();
        ib2.setVisible(true);
    }

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        InterfaceMenu im = new InterfaceMenu();
        im.setVisible(true);
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceOpcaoAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceOpcaoAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceOpcaoAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceOpcaoAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceOpcaoAdm().setVisible(true);
            }
        });
    }

    private javax.swing.JButton DeletarBotao;
    private javax.swing.JButton InserirBotao;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JLabel jLabel1;
}
