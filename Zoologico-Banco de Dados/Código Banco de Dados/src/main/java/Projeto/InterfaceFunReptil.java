
package Projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InterfaceFunReptil extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;
    public InterfaceFunReptil() {
        initComponents();
    }
    
    public static Reptil rep = new Reptil();
    public static Animal ani = new Animal();

    
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
    
    
    public void voltar(){
        this.setVisible(false);
        InterfaceFuncionario interfaceFun = new InterfaceFuncionario();
        interfaceFun.setVisible(true);
    }
    
    public void insRep(){
        try{
            rep.setIdHabitat(habitatid);
            ani.setIdHabitat(habitatid);
            
            rep.setId(idanimal);
            ani.setId(idanimal);
            
            rep.setNome(nome);
            ani.setNome(nome);
            
            rep.setIdade(idade);
            ani.setIdade(idade);
            
            rep.setPeso(peso); 
            ani.setPeso(peso);
            
            rep.setAltura(altura);
            ani.setAltura(altura);
            
            rep.setEspecie(especie);
            ani.setEspecie(especie);

            String sexoSelecionado = sexo;
            String alimentacaoSelecionado = alimentacao;
            
        switch (sexoSelecionado) {
            case "Feminino":   
                rep.setSexo(false);
                ani.setSexo(false);
                break;
                
            case "Masculino":   
                rep.setSexo(true);
                ani.setSexo(true);
                break;
        }
        
        switch (alimentacaoSelecionado) {
            case "Herbivoro":   
                rep.setHerbivoro(true);
                rep.setCarnivoro(false);
                
                ani.setHerbivoro(true);
                ani.setCarnivoro(false);
                break;
                
            case "Carnivoro":   
                rep.setHerbivoro(false);
                rep.setCarnivoro(true);
                
                ani.setHerbivoro(false);
                ani.setCarnivoro(true);
                break;
                
            case "Onivoro":   
                rep.setHerbivoro(true);
                rep.setCarnivoro(true);
                
                ani.setHerbivoro(true);
                ani.setCarnivoro(true);
                break;
        }
        
        rep.setPatas(Integer.parseInt(PatasCampo.getText()));        
        
        String venenoSelecionado = VenenoOpcao.getSelectedItem().toString();
        
        switch (venenoSelecionado) {
            case "Não":   
                rep.setVeneno(false);
                break;
                
            case "Sim":   
                rep.setVeneno(true);
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
        }
        
        catch(ValorVazio vv){
            JOptionPane.showMessageDialog(
                null,
                "VALOR NÃO PODE SER 0!",
                 "ERRO CADASTRO DE ANFIBIO",
                 0
            );
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
    
    public void inserirTabela() {
    try {
        String url = "jdbc:postgresql://localhost/postgres";
        String usuario = "funcionario";
        String senha = "funcionario";
        Connection conexao = DriverManager.getConnection(url, usuario, senha);
        
        String sqlVerificacao = "SELECT COUNT(*) FROM Animal WHERE AnimalId = ?";
        
        try (PreparedStatement stmntVerificacao = conexao.prepareStatement(sqlVerificacao)) {
            stmntVerificacao.setInt(1, rep.getId());
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
        
        String sql2 = "INSERT INTO Reptil (ReptilPatas, ReptilVeneno, AnimalId, HabitatId) " +
                     "VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement stmnt = conexao.prepareStatement(sql)) {
            stmnt.setInt(1, rep.getId());
            stmnt.setString(2, rep.getNome());
            stmnt.setInt(3, rep.getIdade());
            stmnt.setDouble(4, rep.getPeso());
            stmnt.setDouble(5, rep.getAltura());
            stmnt.setString(6, rep.getEspecie());
            stmnt.setBoolean(7, rep.getSexo());
            stmnt.setBoolean(8, rep.getCarnivoro());
            stmnt.setBoolean(9, rep.getHerbivoro());
            stmnt.setInt(10, rep.getIdHabitat());
            
            stmnt.executeUpdate();
        }
        
        try (PreparedStatement stmnt = conexao.prepareStatement(sql2)) {
            stmnt.setInt(1, rep.getPatas());
            stmnt.setBoolean(2, rep.getVeneno());
            stmnt.setInt(3, rep.getId());
            stmnt.setInt(4, rep.getIdHabitat());
            
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

    private void initComponents() {

        PatasTexto = new javax.swing.JLabel();
        VenenoTexto = new javax.swing.JLabel();
        PatasCampo = new javax.swing.JTextField();
        VenenoOpcao = new javax.swing.JComboBox<>();
        VoltarBotao = new javax.swing.JButton();
        RegistrarBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PatasTexto.setText("Quantidade de Patas");

        VenenoTexto.setText("O reptil tem veneno?");

        VenenoOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        VoltarBotao.setText("Voltar");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PatasTexto)
                            .addComponent(VenenoTexto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(VenenoOpcao, 0, 103, Short.MAX_VALUE)
                            .addComponent(PatasCampo)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VoltarBotao)
                        .addGap(18, 18, 18)
                        .addComponent(RegistrarBotao)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatasTexto)
                    .addComponent(PatasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VenenoTexto)
                    .addComponent(VenenoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(RegistrarBotao))
                .addGap(22, 22, 22))
        );

        pack();
    }

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    private void RegistrarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        insRep();
        inserirTabela();
        voltar();
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceFunReptil().setVisible(true);
            }
        });
    }


    private javax.swing.JTextField PatasCampo;
    private javax.swing.JLabel PatasTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JComboBox<String> VenenoOpcao;
    private javax.swing.JLabel VenenoTexto;
    private javax.swing.JButton VoltarBotao;

}
