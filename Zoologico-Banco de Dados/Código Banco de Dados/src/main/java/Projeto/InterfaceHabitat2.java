
package Projeto;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class InterfaceHabitat2 extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;
    private static InterfaceHabitat2 interUnico;
    
     //Singleton
    public static InterfaceHabitat2 geraInterfaceBD(){
        if(interUnico == null){
            interUnico = new InterfaceHabitat2();
        }
        return interUnico;
    }
        

    public InterfaceHabitat2() {
        initComponents();
        conectarTabela();
    }
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent (this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public void conectarTabela(){
        String url = "jdbc:postgresql://localhost/postgres";
        String usuario = "administrador";
        String senha = "administrador";
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement st = conexao.createStatement();   
            
            String sql = "SELECT * FROM habitat";
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String habitatid = String.valueOf(rs.getInt("habitatid"));
                String habitatnome = rs.getString("habitatnome");
                String habitattemperatura = String.valueOf(rs.getInt("habitattemperatura"));
                String habitatarea = String.valueOf(rs.getDouble("habitatarea"));
                String habitatsolo = rs.getString("habitatsolo");
                
                String tbData2[] = {habitatid, habitatnome, habitattemperatura, habitatarea, habitatsolo};
                DefaultTableModel tblModel2 = (DefaultTableModel)jTable1.getModel();
                
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
        
            String sqlVerificacao = "SELECT COUNT(*) FROM Habitat WHERE HabitatId = ?";

            try (PreparedStatement stmntVerificacao = conexao.prepareStatement(sqlVerificacao)) {
                stmntVerificacao.setInt(1, Integer.parseInt(IDHabitatCampo.getText()));
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
        
        String sql = "DELETE FROM habitat " +
                     "WHERE habitatid = ? AND habitatid NOT IN (SELECT habitatid FROM animal)";
        
        try (PreparedStatement stmnt = conexao.prepareStatement(sql)) {
            int valor = Integer.parseInt(IDHabitatCampo.getText().trim());
            
            stmnt.setInt(1, valor);
            stmnt.executeUpdate();
        }
        
        JOptionPane.showMessageDialog(
            null,
            "ANIMAL DELETADO COM SUCESSO!",
            "SUCESSO AO DELETAR",
            1
        );
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            null,
            "ERRO AO DELETAR NA TABELA (Verifique se algum animal esteja usando ela)!",
            "ERRO AO DELETAR",
            0
        );
        e.printStackTrace();
    }
}
    private void initComponents() {

        IDHabitatTexto = new javax.swing.JLabel();
        IDHabitatCampo = new javax.swing.JTextField();
        TabelaHabitat = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BotaoVoltar = new javax.swing.JButton();
        BotaoDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        IDHabitatTexto.setText("ID do Habitat");

        IDHabitatCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDHabitatCampoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do Habitat", "Nome do Habitat", "Temperatura", "Area em M²", "Descrição do Solo"
            }
        ));
        TabelaHabitat.setViewportView(jTable1);

        BotaoVoltar.setText("Voltar");
        BotaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoVoltarActionPerformed(evt);
            }
        });

        BotaoDeletar.setText("Deletar Habitat");
        BotaoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BotaoVoltar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoDeletar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(IDHabitatTexto)
                            .addGap(89, 89, 89)
                            .addComponent(IDHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(TabelaHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDHabitatTexto)
                    .addComponent(IDHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(TabelaHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoDeletar)
                    .addComponent(BotaoVoltar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }

    private void BotaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        close();
        InterfaceBD2 ib2 = new InterfaceBD2();
        ib2.setVisible(true);
    }

    private void IDHabitatCampoActionPerformed(java.awt.event.ActionEvent evt) {
    }
    private void BotaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {
        deletarTabela();
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
            java.util.logging.Logger.getLogger(InterfaceHabitat2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceHabitat2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceHabitat2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceHabitat2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceHabitat2().setVisible(true);
            }
        });
    }

    private javax.swing.JButton BotaoDeletar;
    private javax.swing.JButton BotaoVoltar;
    private javax.swing.JTextField IDHabitatCampo;
    private javax.swing.JLabel IDHabitatTexto;
    private javax.swing.JScrollPane TabelaHabitat;
    private javax.swing.JTable jTable1;
}
