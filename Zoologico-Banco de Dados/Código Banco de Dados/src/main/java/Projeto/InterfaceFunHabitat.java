
package Projeto;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InterfaceFunHabitat extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;

    private Habitat h1 = new Habitat();
    
    private Habitat_BD2 hbd = Habitat_BD2.geraHabitat_BD2();
    private static InterfaceFunHabitat interUnico;
    
     //Singleton
    public static InterfaceFunHabitat geraInterfaceBD(){
        if(interUnico == null){
            interUnico = new InterfaceFunHabitat();
        }
        return interUnico;
    }
        

    public InterfaceFunHabitat() {
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
    
public void inserirTabela() {
    try {
        String url = "jdbc:postgresql://localhost/postgres";
        String usuario = "administrador";
        String senha = "administrador";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        
        String sqlVerificacao = "SELECT COUNT(*) FROM HABITAT WHERE HABITATID = ?";
        
        try (PreparedStatement stmntVerificacao = conexao.prepareStatement(sqlVerificacao)) {
            stmntVerificacao.setInt(1, h1.getIdHab());
            try (ResultSet resultado = stmntVerificacao.executeQuery()) {
                resultado.next();
                int count = resultado.getInt(1);
                
                if (count > 0) {
                    JOptionPane.showMessageDialog(
                        null,
                        "ID já existe na tabela!",
                        "ERRO CADASTRO DE HABITAT",
                        0
                    );
                    return;
                }
            }
        }
        
        String sql = "INSERT INTO Habitat (HabitatId, HabitatNome, HabitatTemperatura, HabitatArea, HabitatSolo) " +
                     "VALUES (?, ?, ?, ?, ?)";
        
        
    try (PreparedStatement stmnt = conexao.prepareStatement(sql)) {
            stmnt.setInt(1, h1.getIdHab());
            stmnt.setString(2, h1.getNomeHab());
            stmnt.setInt(3, h1.getTemperatura());
            stmnt.setDouble(4, h1.getArea());
            stmnt.setString(5, h1.getSolo());
            
            stmnt.executeUpdate();
        }   
    } 
    catch (SQLException e) {
        JOptionPane.showMessageDialog(
            null,
            "ERRO AO INSERIR NA TABELA!",
            "ERRO CADASTRO DE HABITAT",
            0
        );
    }
}


public void chamarCall(){
    try {
        String url = "jdbc:postgresql://localhost/postgres";
        String usuario = "administrador";
        String senha = "administrador";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        
        String sqlVerificacao = "SELECT COUNT(*) FROM HABITAT WHERE HABITATID = ?";
        
        try (PreparedStatement stmntVerificacao = conexao.prepareStatement(sqlVerificacao)) {
            stmntVerificacao.setInt(1, h1.getIdHab());
            try (ResultSet resultado = stmntVerificacao.executeQuery()) {
                resultado.next();
                int count = resultado.getInt(1);
                
                if (count > 0) {
                    JOptionPane.showMessageDialog(
                        null,
                        "ID já existe na tabela!",
                        "ERRO CADASTRO DE HABITAT",
                        0
                    );
                    return;
                }
            }
        }
        String callFunction = "CALL habitatERRO(?, ?, ?, ?, ?)";
        
        try (CallableStatement callableStatement = conexao.prepareCall(callFunction)) {
            callableStatement.setBigDecimal(1, new BigDecimal(h1.getIdHab()));
            callableStatement.setString(2, h1.getNomeHab());
            callableStatement.setBigDecimal(3, new BigDecimal(h1.getTemperatura()));
            callableStatement.setBigDecimal(4, new BigDecimal(h1.getArea()));
            callableStatement.setString(5, h1.getSolo());

            // Execute a chamada da função
            callableStatement.execute();
        }
    } 
    catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(
            null,
            "ERRO AO INSERIR NA TABELA!",
            "ERRO CADASTRO DE HABITAT",
            0
        );
    }
}

    public void voltar(){
        this.setVisible(false);
        InterfaceFuncionario interfaceFun = new InterfaceFuncionario();
        interfaceFun.setVisible(true);
    }

    private void initComponents() {

        IDHabitatTexto = new javax.swing.JLabel();
        IDHabitatCampo = new javax.swing.JTextField();
        NomeHabitatTexto = new javax.swing.JLabel();
        NomeHabitatCampo = new javax.swing.JTextField();
        TemperaturaHabitatTexto = new javax.swing.JLabel();
        TemperaturaHabitatCampo = new javax.swing.JTextField();
        AreaHabitatTexto = new javax.swing.JLabel();
        AreaHabitatCampo = new javax.swing.JTextField();
        SoloHabitatTexto = new javax.swing.JLabel();
        SoloHabitatCampo = new javax.swing.JTextField();
        TabelaHabitat = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BotaoVoltar = new javax.swing.JButton();
        BotaoRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        IDHabitatTexto.setText("ID do Habitat");

        IDHabitatCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDHabitatCampoActionPerformed(evt);
            }
        });

        NomeHabitatTexto.setText("Nome do Habitat");

        NomeHabitatCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeHabitatCampoActionPerformed(evt);
            }
        });

        TemperaturaHabitatTexto.setText("Temperatura do Habitat");

        TemperaturaHabitatCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TemperaturaHabitatCampoActionPerformed(evt);
            }
        });

        AreaHabitatTexto.setText("Area do Habitat");

        AreaHabitatCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaHabitatCampoActionPerformed(evt);
            }
        });

        SoloHabitatTexto.setText("Solo do Habitat");

        SoloHabitatCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SoloHabitatCampoActionPerformed(evt);
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

        BotaoRegistrar.setText("Registrar Habitat");
        BotaoRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(IDHabitatTexto)
                                .addGap(89, 89, 89)
                                .addComponent(IDHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomeHabitatTexto)
                                    .addComponent(TemperaturaHabitatTexto)
                                    .addComponent(AreaHabitatTexto)
                                    .addComponent(SoloHabitatTexto))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomeHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TemperaturaHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AreaHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SoloHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(230, 230, 230)
                                .addComponent(BotaoVoltar)
                                .addGap(32, 32, 32)
                                .addComponent(BotaoRegistrar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(TabelaHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDHabitatTexto)
                    .addComponent(IDHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeHabitatTexto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TemperaturaHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TemperaturaHabitatTexto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AreaHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AreaHabitatTexto))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SoloHabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SoloHabitatTexto))
                .addGap(18, 18, 18)
                .addComponent(TabelaHabitat, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoVoltar)
                    .addComponent(BotaoRegistrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void BotaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    private void IDHabitatCampoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void NomeHabitatCampoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void TemperaturaHabitatCampoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void AreaHabitatCampoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void SoloHabitatCampoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void BotaoRegistrarActionPerformed(java.awt.event.ActionEvent evt) {
        insHab();
        
        if(h1.getIdHab() > 1000){
            chamarCall();
        }
        
        else{
            inserirTabela();   
        }
        
        voltar();
    }

    public void insHab(){
        try{
            h1 = new Habitat();
            
            if (!IDHabitatCampo.getText().isEmpty()) {
                h1.setIdHab(Integer.parseInt(IDHabitatCampo.getText()));
            } 
            else {
                JOptionPane.showMessageDialog(
                null,
                "O campo de ID não pode estar vazio!",
                "ERRO CADASTRO DE HABITAT",
                JOptionPane.ERROR_MESSAGE
            );
            
            return;
            }
            
            if (!NomeHabitatCampo.getText().isEmpty()) {
                h1.setNomeHab(NomeHabitatCampo.getText());
            } 
            else {
                JOptionPane.showMessageDialog(
                null,
                "O campo de Nome não pode estar vazio!",
                "ERRO CADASTRO DE HABITAT",
                JOptionPane.ERROR_MESSAGE
            );            
            return;
            }
            
            if (!TemperaturaHabitatCampo.getText().isEmpty()) {
                h1.setTemperatura(Integer.parseInt(TemperaturaHabitatCampo.getText()));
            } 
            
            else {
                JOptionPane.showMessageDialog(
                null,
                "O campo de Temperatura não pode estar vazio!",
                "ERRO CADASTRO DE HABITAT",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
            
            
            if (!AreaHabitatCampo.getText().isEmpty()) {
                h1.setArea(Double.parseDouble(AreaHabitatCampo.getText()));
            } 
            
            else {
            JOptionPane.showMessageDialog(
                null,
                "O campo de Area não pode estar vazio!",
                "ERRO CADASTRO DE HABITAT",
                JOptionPane.ERROR_MESSAGE
            );
            return; 
        }
            
            
        if (!SoloHabitatCampo.getText().isEmpty()) {
            h1.setSolo(SoloHabitatCampo.getText());
        } 
            
        else {
                JOptionPane.showMessageDialog(
                null,
                "O campo de Solo não pode estar vazio!",
                "ERRO CADASTRO DE HABITAT",
                JOptionPane.ERROR_MESSAGE
            );            
            return;
        }


        h1 = hbd.insHabitat(h1);

        if(h1 == null){
            JOptionPane.showMessageDialog(
            null,
            "Erro no cadastro!",
            "CADASTRO DE HABITAT",
            0
            );
        }
            
        }
        catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(
                null,
                "ID, TEMPERATURA OU AREA DEVE SER UM NUMERO!",
                 "ERRO CADASTRO DE HABITAT",
                 0
            );
            
            IDHabitatCampo.requestFocus();
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
            java.util.logging.Logger.getLogger(InterfaceFunHabitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceFunHabitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceFunHabitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceFunHabitat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceFunHabitat().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField AreaHabitatCampo;
    private javax.swing.JLabel AreaHabitatTexto;
    private javax.swing.JButton BotaoRegistrar;
    private javax.swing.JButton BotaoVoltar;
    private javax.swing.JTextField IDHabitatCampo;
    private javax.swing.JLabel IDHabitatTexto;
    private javax.swing.JTextField NomeHabitatCampo;
    private javax.swing.JLabel NomeHabitatTexto;
    private javax.swing.JTextField SoloHabitatCampo;
    private javax.swing.JLabel SoloHabitatTexto;
    private javax.swing.JScrollPane TabelaHabitat;
    private javax.swing.JTextField TemperaturaHabitatCampo;
    private javax.swing.JLabel TemperaturaHabitatTexto;
    private javax.swing.JTable jTable1;
}
