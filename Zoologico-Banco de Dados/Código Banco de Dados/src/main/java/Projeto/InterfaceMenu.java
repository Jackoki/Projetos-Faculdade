
package Projeto;

public class InterfaceMenu extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;

    public InterfaceMenu() {
        initComponents();
    }

    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        VisitanteBotao = new javax.swing.JButton();
        FuncionarioBotao = new javax.swing.JButton();
        AdministradorBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo.setText("Qual usuário logar?");

        VisitanteBotao.setText("Visitante");
        VisitanteBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisitanteBotaoActionPerformed(evt);
            }
        });

        FuncionarioBotao.setText("Funcionário");
        FuncionarioBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuncionarioBotaoActionPerformed(evt);
            }
        });

        AdministradorBotao.setText("Administrador/Dono");
        AdministradorBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministradorBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(VisitanteBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdministradorBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FuncionarioBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(Titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Titulo)
                .addGap(63, 63, 63)
                .addComponent(VisitanteBotao)
                .addGap(18, 18, 18)
                .addComponent(FuncionarioBotao)
                .addGap(18, 18, 18)
                .addComponent(AdministradorBotao)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }

    private void VisitanteBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        entrarVisitante();
    }

    private void FuncionarioBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        entrarFuncionario();
    }

    private void AdministradorBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        entrarAdministrador();
    }

    public void entrarAdministrador(){
        this.setVisible(false);
        InterfaceLoginAdm interfaceLA = new InterfaceLoginAdm();
        interfaceLA.setVisible(true);
    }
    
    public void entrarFuncionario(){
        this.setVisible(false);
        InterfaceLoginFun interfaceFun = new InterfaceLoginFun();
        interfaceFun.setVisible(true);
    }
    
    public void entrarVisitante(){
        this.setVisible(false);
        InterfaceVisitante interfaceVis = new InterfaceVisitante();
        interfaceVis.setVisible(true);
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
            java.util.logging.Logger.getLogger(InterfaceMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceMenu().setVisible(true);
            }
        });
    }

    private javax.swing.JButton AdministradorBotao;
    private javax.swing.JButton FuncionarioBotao;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton VisitanteBotao;
}
