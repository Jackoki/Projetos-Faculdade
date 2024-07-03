package Projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class InterfaceFunAnfibio extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;
    
    public static Anfibio anf = new Anfibio();
    public static Animal ani = new Animal();
    
    public InterfaceFunAnfibio() {
        initComponents();
    }
    
    public void setValores(String habitatid, String idanimal, String nome, String idade, String peso, String altura, String especie, String sexo, String alimentacao){
            this.habitatid = Integer.parseInt(habitatid.replace(" ", "")); 
            this.idanimal = Integer.parseInt(idanimal.replace(" ", ""));
            this.nome = nome;
            this.idade = Integer.parseInt(idade.replace(" ", ""));
            this.peso = Double.parseDouble(peso.replace(" ", ""));
            this.altura = Double.parseDouble(altura.replace(" ", ""));
            this.especie = especie;
            this.sexo = sexo;
            this.alimentacao = alimentacao;
    }
    
    int idanimal;
    String nome;
    int idade;
    double peso;
    double altura;
    String especie;
    String sexo;
    String alimentacao;
    int habitatid;


    private void initComponents() {

        QuantPatasTexto = new javax.swing.JLabel();
        QuantPatasCampo = new javax.swing.JTextField();
        MetamorfoseTexto = new javax.swing.JLabel();
        MetamorfoseOpcao = new javax.swing.JComboBox<>();
        VoltarBotao = new javax.swing.JButton();
        RegistrarBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        QuantPatasTexto.setText("Quantidade de Patas");

        QuantPatasCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantPatasCampoActionPerformed(evt);
            }
        });

        MetamorfoseTexto.setText("O animal tem metamorfose?");

        MetamorfoseOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));

        VoltarBotao.setText("Voltar");
        VoltarBotao.setToolTipText("");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        RegistrarBotao.setText("Registrar");
        RegistrarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(QuantPatasTexto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(MetamorfoseTexto)
                                .addGap(26, 26, 26)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MetamorfoseOpcao, 0, 113, Short.MAX_VALUE)
                            .addComponent(QuantPatasCampo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VoltarBotao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegistrarBotao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantPatasTexto)
                    .addComponent(QuantPatasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MetamorfoseTexto)
                    .addComponent(MetamorfoseOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(RegistrarBotao))
                .addGap(16, 16, 16))
        );

        pack();
    }

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    private void RegistrarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        insAnf();
        inserirTabela();
        voltar();
    }

    private void QuantPatasCampoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    public void voltar(){
        this.setVisible(false);
        InterfaceFuncionario interfaceFun = new InterfaceFuncionario();
        interfaceFun.setVisible(true);
    }
    
public void inserirTabela() {
    try {
        String url = "jdbc:postgresql://localhost/postgres";
        String usuario = "funcionario";
        String senha = "funcionario";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        
        String sqlVerificacao = "SELECT COUNT(*) FROM Animal WHERE AnimalId = ?";
        
        try (PreparedStatement stmntVerificacao = conexao.prepareStatement(sqlVerificacao)) {
            stmntVerificacao.setInt(1, anf.getId());
            try (ResultSet resultado = stmntVerificacao.executeQuery()) {
                resultado.next();
                int count = resultado.getInt(1);
                
                if (count > 0) {
                    JOptionPane.showMessageDialog(
                        null,
                        "ID já existe na tabela!",
                        "ERRO CADASTRO DE ANFIBIO",
                        0
                    );
                    return;
                }
            }
        }
        
        String sql = "INSERT INTO Animal (AnimalId, AnimalNome, AnimalIdade, AnimalPeso, AnimalAltura, AnimalEspecie, AnimalSexo, AnimalCarnivoro, AnimalHerbivoro, HabitatId) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        String sql2 = "INSERT INTO Anfibio (AnfibioPatas, AnfibioMetamorfose, AnimalId, HabitatId) " +
                     "VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmnt = conexao.prepareStatement(sql)) {
            stmnt.setInt(1, anf.getId());
            stmnt.setString(2, anf.getNome());
            stmnt.setInt(3, anf.getIdade());
            stmnt.setDouble(4, anf.getPeso());
            stmnt.setDouble(5, anf.getAltura());
            stmnt.setString(6, anf.getEspecie());
            stmnt.setBoolean(7, anf.getSexo());
            stmnt.setBoolean(8, anf.getCarnivoro());
            stmnt.setBoolean(9, anf.getHerbivoro());
            stmnt.setInt(10, anf.getIdHabitat());
            
            stmnt.executeUpdate();
        }
        
        try (PreparedStatement stmnt = conexao.prepareStatement(sql2)) {
            stmnt.setInt(1, anf.getPatas());
            stmnt.setBoolean(2, anf.getMetamorfose());
            stmnt.setInt(3, anf.getId());
            stmnt.setDouble(4, anf.getIdHabitat());
            
            stmnt.executeUpdate();
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            null,
            "ERRO AO INSERIR NA TABELA!",
            "ERRO CADASTRO DE ANFIBIO",
            0
        );
        e.printStackTrace();
    }
}
    
    public void insAnf(){
        try{
            anf.setIdHabitat(habitatid);
            ani.setIdHabitat(habitatid);
            
            anf.setId(idanimal);
            ani.setId(idanimal);
            
            anf.setNome(nome);
            ani.setNome(nome);
            
            anf.setIdade(idade);
            ani.setIdade(idade);
            
            anf.setPeso(peso); 
            ani.setPeso(peso);
            
            anf.setAltura(altura);
            ani.setAltura(altura);
            
            anf.setEspecie(especie);
            ani.setEspecie(especie);

            String sexoSelecionado = sexo;
            String alimentacaoSelecionado = alimentacao;
            
        switch (sexoSelecionado) {
            case "Feminino":   
                anf.setSexo(false);
                ani.setSexo(false);
                break;
                
            case "Masculino":   
                anf.setSexo(true);
                ani.setSexo(true);
                break;
        }
        
        switch (alimentacaoSelecionado) {
            case "Herbivoro":   
                anf.setHerbivoro(true);
                anf.setCarnivoro(false);
                
                ani.setHerbivoro(true);
                ani.setCarnivoro(false);
                break;
                
            case "Carnivoro":   
                anf.setHerbivoro(false);
                anf.setCarnivoro(true);
                
                ani.setHerbivoro(false);
                ani.setCarnivoro(true);
                break;
                
            case "Onivoro":   
                anf.setHerbivoro(true);
                anf.setCarnivoro(true);
                
                ani.setHerbivoro(true);
                ani.setCarnivoro(true);
                break;
        }
        
        
        anf.setPatas(Integer.parseInt(QuantPatasCampo.getText()));
        
        String metamorfoseSelecionado = MetamorfoseOpcao.getSelectedItem().toString();
        
        switch (metamorfoseSelecionado) {
            case "Sim":   
                anf.setMetamorfose(true);
                break;
                
            case "Não":   
                anf.setMetamorfose(false);
                break;
        }   
        
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "COLOQUE UM FORMATO VALIDO!",
                 "ERRO CADASTRO DE ANFIBIO",
                 0
            );
            QuantPatasCampo.requestFocus();
        }
        
        catch(ValorVazio vv){
            JOptionPane.showMessageDialog(
                null,
                "VALOR NÃO PODE SER 0!",
                 "ERRO CADASTRO DE ANFIBIO",
                 0
            );
            QuantPatasCampo.requestFocus();
        }
        
        catch(InsercaoVazia iv){
            JOptionPane.showMessageDialog(
                null,
                "TEXTO NÃO PODE SER VAZIO!",
                 "ERRO CADASTRO DE ANFIBIO",
                 0
            );
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
            java.util.logging.Logger.getLogger(InterfaceFunAnfibio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceFunAnfibio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceFunAnfibio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceFunAnfibio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceFunAnfibio().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> MetamorfoseOpcao;
    private javax.swing.JLabel MetamorfoseTexto;
    private javax.swing.JTextField QuantPatasCampo;
    private javax.swing.JLabel QuantPatasTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JButton VoltarBotao;
}
