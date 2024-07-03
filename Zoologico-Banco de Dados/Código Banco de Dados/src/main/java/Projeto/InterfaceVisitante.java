
package Projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class InterfaceVisitante extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;
    public InterfaceVisitante() {
        initComponents();
        conectarTabela();
    }

    private void initComponents() {

        ViewTabela = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        VoltarBotao = new javax.swing.JButton();
        BotaoAnfibios = new javax.swing.JButton();
        BotaoAves = new javax.swing.JButton();
        BotaoMamiferos = new javax.swing.JButton();
        BotaoPeixes = new javax.swing.JButton();
        BotaoRepteis = new javax.swing.JButton();
        AnimaisTexto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do Animal", "Nome do Animal", "Idade do Animal", "Peso do Animal", "Altura do Animal", "Especie do Animal", "ID do Habitat", "Nome do Habitat"
            }
        ));
        ViewTabela.setViewportView(jTable1);

        VoltarBotao.setText("Voltar ao Menu");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        BotaoAnfibios.setText("Ver Anfíbios");
        BotaoAnfibios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAnfibiosActionPerformed(evt);
            }
        });

        BotaoAves.setText("Ver Aves");
        BotaoAves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAvesActionPerformed(evt);
            }
        });

        BotaoMamiferos.setText("Ver Mamiferos");
        BotaoMamiferos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoMamiferosActionPerformed(evt);
            }
        });

        BotaoPeixes.setText("Ver Peixes");
        BotaoPeixes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPeixesActionPerformed(evt);
            }
        });

        BotaoRepteis.setText("Ver Reptéis");
        BotaoRepteis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRepteisActionPerformed(evt);
            }
        });

        AnimaisTexto.setFont(new java.awt.Font("Segoe UI", 1, 36));
        AnimaisTexto.setText("Animais");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ViewTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BotaoAnfibios, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72)
                            .addComponent(BotaoAves, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(79, 79, 79)
                            .addComponent(BotaoMamiferos, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotaoPeixes, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72)
                            .addComponent(BotaoRepteis, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(VoltarBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(AnimaisTexto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(AnimaisTexto)
                .addGap(18, 18, 18)
                .addComponent(ViewTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoMamiferos)
                    .addComponent(BotaoRepteis)
                    .addComponent(BotaoPeixes)
                    .addComponent(BotaoAnfibios)
                    .addComponent(BotaoAves))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VoltarBotao)
                .addGap(17, 17, 17))
        );

        pack();
    }

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    private void BotaoAnfibiosActionPerformed(java.awt.event.ActionEvent evt) {
        abrirIVAnf();
    }

    private void BotaoAvesActionPerformed(java.awt.event.ActionEvent evt) {
        abrirIVAve();
    }

    private void BotaoMamiferosActionPerformed(java.awt.event.ActionEvent evt) {
        abrirIVMam();
    }

    private void BotaoPeixesActionPerformed(java.awt.event.ActionEvent evt) {
        abrirIVPei();
    }

    private void BotaoRepteisActionPerformed(java.awt.event.ActionEvent evt) {
        abrirIVRep();
    }

    public void voltar(){
        this.setVisible(false);
        InterfaceMenu interfaceMenu = new InterfaceMenu();
        interfaceMenu.setVisible(true);
    }
    
    public void abrirIVAnf(){
        this.setVisible(false);
        InterfaceVisitanteAnfibio interfaceVAnf = new InterfaceVisitanteAnfibio();
        interfaceVAnf.setVisible(true);
    }
    
    public void abrirIVAve(){
        this.setVisible(false);
        InterfaceVisitanteAve interfaceVAve = new InterfaceVisitanteAve();
        interfaceVAve.setVisible(true);
    }
    
    public void abrirIVMam(){
        this.setVisible(false);
        InterfaceVisitanteMamifero interfaceVMam = new InterfaceVisitanteMamifero();
        interfaceVMam.setVisible(true);
    }
    
    public void abrirIVPei(){
        this.setVisible(false);
        InterfaceVisitantePeixe interfaceVPei = new InterfaceVisitantePeixe();
        interfaceVPei.setVisible(true);
    }
    
    public void abrirIVRep(){
        this.setVisible(false);
        InterfaceVisitanteReptil interfaceVRep = new InterfaceVisitanteReptil();
        interfaceVRep.setVisible(true);
    }
    
    public void conectarTabela(){
        String url = "jdbc:postgresql://localhost/postgres";
        String usuario = "visitante";
        String senha = "visitante";
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement st = conexao.createStatement();
            
            String sql = "SELECT * FROM Info_Animal";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String id = String.valueOf(rs.getInt("id_animal"));
                String nome = rs.getString("nome_animal");
                String idade = String.valueOf(rs.getInt("idade_animal"));
                String peso = String.valueOf(rs.getDouble("peso_animal"));
                String altura = String.valueOf(rs.getDouble("altura_animal"));
                String especie = rs.getString("especie_animal");
                String habitatid = String.valueOf(rs.getInt("id_habitat"));
                String habitatnome = rs.getString("nome_habitat");
                
                String tbData[] = {id, nome, idade, peso, altura, especie, habitatid, habitatnome};
                DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
                
                tblModel.addRow(tbData);
            }
        } 
        
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "ERRO AO CONECTAR NO BANCO DE DADOS!",
                "LOGIN VISITANTE",
                0);
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(InterfaceVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceVisitante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceVisitante().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel AnimaisTexto;
    private javax.swing.JButton BotaoAnfibios;
    private javax.swing.JButton BotaoAves;
    private javax.swing.JButton BotaoMamiferos;
    private javax.swing.JButton BotaoPeixes;
    private javax.swing.JButton BotaoRepteis;
    private javax.swing.JScrollPane ViewTabela;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JTable jTable1;
}
