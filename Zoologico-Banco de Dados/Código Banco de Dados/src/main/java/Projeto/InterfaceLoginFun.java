
package Projeto;

import javax.swing.JOptionPane;


public class InterfaceLoginFun extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;
    public InterfaceLoginFun() {
        initComponents();
    }

    private void initComponents() {

        VoltarBotao = new javax.swing.JButton();
        LogarBotao = new javax.swing.JButton();
        LoginTexto = new javax.swing.JLabel();
        SenhaTexto = new javax.swing.JLabel();
        LoginCampo = new javax.swing.JTextField();
        SenhaCampo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        LogarBotao.setText("Logar");
        LogarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogarBotaoActionPerformed(evt);
            }
        });

        LoginTexto.setText("Nome do Funcionario");

        SenhaTexto.setText("Senha do Funcionario");

        LoginCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginCampoActionPerformed(evt);
            }
        });

        SenhaCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhaCampoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SenhaTexto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LoginTexto)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(SenhaCampo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                    .addComponent(LoginCampo, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(VoltarBotao)
                                .addGap(30, 30, 30)))
                        .addComponent(LogarBotao)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LoginTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(SenhaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SenhaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(LogarBotao))
                .addGap(21, 21, 21))
        );

        pack();
    }

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    private void LogarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        logar();
    }

    private void LoginCampoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void SenhaCampoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public void voltar(){
        this.setVisible(false);
        InterfaceMenu interfaceMenu = new InterfaceMenu();
        interfaceMenu.setVisible(true);
    }
    
    public void fechar(){
        this.setVisible(false);
        InterfaceFuncionario interfaceFuncionario = new InterfaceFuncionario();
        interfaceFuncionario.setVisible(true);
    }
    
    public void logar(){
        String nome = LoginCampo.getText();
        String senha = SenhaCampo.getText();
        
        if (nome.equals("funcionario") && senha.equals("funcionario")) {
            fechar();
        } 
        
        else {
            JOptionPane.showMessageDialog(
                null,
                "LOGIN OU SENHA ERRADA!",
                "LOGIN FUNCIONARIO",
                0);
        }
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
            java.util.logging.Logger.getLogger(InterfaceLoginFun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceLoginFun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceLoginFun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceLoginFun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceLoginFun().setVisible(true);
            }
        });
    }

    private javax.swing.JButton LogarBotao;
    private javax.swing.JTextField LoginCampo;
    private javax.swing.JLabel LoginTexto;
    private javax.swing.JTextField SenhaCampo;
    private javax.swing.JLabel SenhaTexto;
    private javax.swing.JButton VoltarBotao;
}
