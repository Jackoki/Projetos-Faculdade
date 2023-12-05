
package Projeto;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class InterfaceBD2 extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;
    
    public void conectarTabela(){
        String url = "jdbc:postgresql://localhost/postgres";
        String usuario = "administrador";
        String senha = "administrador";
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement st = conexao.createStatement();
            
            String sql = "SELECT * FROM animal ORDER BY animalid";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String id = String.valueOf(rs.getInt("animalid"));
                String nome = rs.getString("animalnome");
                String idade = String.valueOf(rs.getInt("animalidade"));
                String peso = String.valueOf(rs.getDouble("animalpeso"));
                String altura = String.valueOf(rs.getDouble("animalaltura"));
                String especie = rs.getString("animalespecie");
                String sexo = String.valueOf(rs.getBoolean("animalsexo"));
                String carnivoro = String.valueOf(rs.getBoolean("animalcarnivoro"));
                String herbivoro = String.valueOf(rs.getBoolean("animalherbivoro"));
                String habitatid = String.valueOf(rs.getInt("habitatid"));
                
                String tbData[] = {id, nome, idade, peso, altura, especie, sexo, carnivoro, herbivoro, habitatid};
                DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
                
                tblModel.addRow(tbData);
            }
            
            String sql2 = "SELECT * FROM habitat ORDER BY habitatid";
            ResultSet rs2 = st.executeQuery(sql2);
            
            while(rs2.next()){
                String habitatid = String.valueOf(rs2.getInt("habitatid"));
                String habitatnome = rs2.getString("habitatnome");
                String habitattemperatura = String.valueOf(rs2.getInt("habitattemperatura"));
                String habitatarea = String.valueOf(rs2.getDouble("habitatarea"));
                String habitatsolo = rs2.getString("habitatsolo");
                
                String tbData2[] = {habitatid, habitatnome, habitattemperatura, habitatarea, habitatsolo};
                DefaultTableModel tblModel2 = (DefaultTableModel)jTable2.getModel();
                
                tblModel2.addRow(tbData2);
            }
            
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "ERRO AO CONECTAR NO BANCO DE DADOS!",
                "LOGIN ADMINISTRADOR",
                0);
            e.printStackTrace();
        } 
    }
    
    public void deletarTabela() {
        try {
            String url = "jdbc:postgresql://localhost/postgres";
            String usuario = "administrador";
            String senha = "administrador";
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
        
            String sqlVerificacao = "SELECT COUNT(*) FROM Animal WHERE AnimalId = ?";

            try (PreparedStatement stmntVerificacao = conexao.prepareStatement(sqlVerificacao)) {
                stmntVerificacao.setInt(1, Integer.parseInt(getAnimalId().trim()));
                try (ResultSet resultado = stmntVerificacao.executeQuery()) {
                    resultado.next();
                    int count = resultado.getInt(1);
                
                if (count == 0) {
                    JOptionPane.showMessageDialog(
                        null,
                        "ID não existe na tabela!",
                        "ERRO DELETAR ANIMAL",
                        1
                    );
                    return;
                }
            }
        }
        
        String sql = "DELETE FROM animal WHERE animalid = ?";
        
        try (PreparedStatement stmnt = conexao.prepareStatement(sql)) {
            int valor = Integer.parseInt(getAnimalId().trim());
            
            stmnt.setInt(1, valor);
            stmnt.executeUpdate();
        }
        
        JOptionPane.showMessageDialog(
            null,
            "ANIMAL DELETADO COM SUCESSO!",
            "SUCESSO AO DELETAR",
            0
        );
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            null,
            "ERRO AO DELETAR NA TABELA!",
            "ERRO AO DELETAR",
            0
        );
        e.printStackTrace();
    }
}
    
    
    public InterfaceBD2() {
        initComponents();
        conectarTabela();
    }
    
    

    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        IDAnimalCampo = new javax.swing.JTextField();
        IDAnimalTexto = new javax.swing.JLabel();
        MenuBotao = new javax.swing.JButton();
        DeletarBotao = new javax.swing.JButton();
        HabitatTabela = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        HabitatBotao = new javax.swing.JButton();

        jButton2.setText("Registrar Animal");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        IDAnimalCampo.setText(" ");
        IDAnimalCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDAnimalCampoActionPerformed(evt);
            }
        });

        IDAnimalTexto.setFont(new java.awt.Font("Segoe UI", 1, 24));
        IDAnimalTexto.setText("ID Animal");

        MenuBotao.setText("Voltar para o Menu");
        MenuBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBotaoActionPerformed(evt);
            }
        });

        DeletarBotao.setText("Deletar Animal");
        DeletarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarBotaoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Animal", "Nome do Animal", "Idade", "Peso", "Altura", "Especie", "Sexo", "Carnivoro", "Herbivoro", "Habitat ID"
            }
        ));
        HabitatTabela.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do Habitat", "Nome do Habitat", "Temperatura", "Area em M²", "Descrição do Solo"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        HabitatBotao.setText("Deletar Habitat");
        HabitatBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HabitatBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HabitatTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(IDAnimalTexto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(IDAnimalCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(HabitatBotao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(MenuBotao)
                        .addGap(44, 44, 44)
                        .addComponent(DeletarBotao)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IDAnimalTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IDAnimalCampo))
                        .addGap(34, 34, 34)
                        .addComponent(HabitatBotao)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(HabitatTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuBotao)
                    .addComponent(DeletarBotao))
                .addContainerGap())
        );

        pack();
    }

    private void IDAnimalCampoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void MenuBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    private void DeletarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        deletarTabela();  
        conectarTabela();
    }

    private void HabitatBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        InterfaceHabitat2 ih2 = new InterfaceHabitat2();
        ih2.setVisible(true);  
    }

    
    public String getAnimalId() {
        return IDAnimalCampo.getText();
    }
      
            
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent (this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    public void voltar(){
        this.setVisible(false);
        InterfaceOpcaoAdm ipa = new InterfaceOpcaoAdm();
        ipa.setVisible(true);
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
            java.util.logging.Logger.getLogger(InterfaceBD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceBD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceBD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceBD2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceBD2().setVisible(true);
            }
        });
    }


    private javax.swing.JButton DeletarBotao;
    private javax.swing.JButton HabitatBotao;
    private javax.swing.JScrollPane HabitatTabela;
    private javax.swing.JTextField IDAnimalCampo;
    private javax.swing.JLabel IDAnimalTexto;
    private javax.swing.JButton MenuBotao;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;

}
