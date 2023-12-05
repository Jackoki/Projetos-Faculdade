package Projeto;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class InterfaceBD extends javax.swing.JFrame {
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
    
    public InterfaceBD() {
        initComponents();
        conectarTabela();
    }
    
    private InterfaceAnfibio interAnfibio;
    private InterfaceAve interAve;
    private InterfaceMamifero interMamifero;
    private InterfacePeixe interPeixe;
    private InterfaceReptil interReptil;
            
    
    public InterfaceAnfibio geraInterfaceAnfibio(String habitatid, String idanimal, String nome, String idade, String peso, String altura, String especie, String sexo, String alimentacao) {
        interAnfibio = new InterfaceAnfibio();
        interAnfibio.setValores(habitatid, idanimal, nome, idade, peso, altura, especie, sexo, alimentacao);
        return interAnfibio;
    }
    
    public InterfaceAve geraInterfaceAve(String habitatid, String idanimal, String nome, String idade, String peso, String altura, String especie, String sexo, String alimentacao){
        interAve = new InterfaceAve();
        interAve.setValores(habitatid, idanimal, nome, idade, peso, altura, especie, sexo, alimentacao);
        return interAve;
    }
    
    public InterfaceMamifero geraInterfaceMamifero(String habitatid, String idanimal, String nome, String idade, String peso, String altura, String especie, String sexo, String alimentacao){
        interMamifero = new InterfaceMamifero();
        interMamifero.setValores(habitatid, idanimal, nome, idade, peso, altura, especie, sexo, alimentacao);
        return interMamifero;
    }
    
    public InterfacePeixe geraInterfacePeixe(String habitatid, String idanimal, String nome, String idade, String peso, String altura, String especie, String sexo, String alimentacao){
        interPeixe = new InterfacePeixe();
        interPeixe.setValores(habitatid, idanimal, nome, idade, peso, altura, especie, sexo, alimentacao);
        return interPeixe;
    }
    
    public InterfaceReptil geraInterfaceReptil(String habitatid, String idanimal, String nome, String idade, String peso, String altura, String especie, String sexo, String alimentacao){
        interReptil = new InterfaceReptil();
        interReptil.setValores(habitatid, idanimal, nome, idade, peso, altura, especie, sexo, alimentacao);
        return interReptil;
    }
    

    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        HabitatTexto = new javax.swing.JLabel();
        HabitatCampo = new javax.swing.JTextField();
        HabitatBotao = new javax.swing.JButton();
        NomeTipo = new javax.swing.JLabel();
        TipoOpcao = new javax.swing.JComboBox<>();
        IDAnimalTexto = new javax.swing.JLabel();
        IDAnimalCampo = new javax.swing.JTextField();
        NomeTexto = new javax.swing.JLabel();
        NomeCampo = new javax.swing.JTextField();
        IdadeTexto = new javax.swing.JLabel();
        IdadeCampo = new javax.swing.JTextField();
        PesoTexto = new javax.swing.JLabel();
        PesoCampo = new javax.swing.JTextField();
        AlturaTexto = new javax.swing.JLabel();
        AlturaCampo = new javax.swing.JTextField();
        EspecieTexto = new javax.swing.JLabel();
        EspecieCampo = new javax.swing.JTextField();
        SexoTexto = new javax.swing.JLabel();
        SexoOpcao = new javax.swing.JComboBox<>();
        AlimentacaoTexto = new javax.swing.JLabel();
        AlimentacaoOpcao = new javax.swing.JComboBox<>();
        MenuBotao = new javax.swing.JButton();
        RegistrarBotao = new javax.swing.JButton();
        HabitatTabela = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jButton2.setText("Registrar Animal");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        HabitatTexto.setText("ID do Habitat");

        HabitatCampo.setText(" ");
        HabitatCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HabitatCampoActionPerformed(evt);
            }
        });

        HabitatBotao.setText("Registrar Novo Habitat");
        HabitatBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HabitatBotaoActionPerformed(evt);
            }
        });

        NomeTipo.setText("Tipo de Animal:");

        TipoOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anfibio", "Ave", "Mamifero", "Peixe", "Reptil" }));
        TipoOpcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoOpcaoActionPerformed(evt);
            }
        });

        IDAnimalTexto.setText("ID Animal");

        IDAnimalCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDAnimalCampoActionPerformed(evt);
            }
        });

        NomeTexto.setText("Nome:");

        NomeCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeCampoActionPerformed(evt);
            }
        });

        IdadeTexto.setText("Idade:");

        IdadeCampo.setText(" ");
        IdadeCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdadeCampoActionPerformed(evt);
            }
        });

        PesoTexto.setText("Peso:");

        PesoCampo.setText(" ");
        PesoCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesoCampoActionPerformed(evt);
            }
        });

        AlturaTexto.setText("Altura:");

        AlturaCampo.setText(" ");
        AlturaCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlturaCampoActionPerformed(evt);
            }
        });

        EspecieTexto.setText("Especie:");

        EspecieCampo.setText(" ");
        EspecieCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EspecieCampoActionPerformed(evt);
            }
        });

        SexoTexto.setText("Sexo:");

        SexoOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));
        SexoOpcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexoOpcaoActionPerformed(evt);
            }
        });

        AlimentacaoTexto.setText("Alimentação:");

        AlimentacaoOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Herbivoro", "Carnivoro", "Onivoro" }));
        AlimentacaoOpcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlimentacaoOpcaoActionPerformed(evt);
            }
        });

        MenuBotao.setText("Voltar para o Menu");
        MenuBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBotaoActionPerformed(evt);
            }
        });

        RegistrarBotao.setText("Registrar Animal");
        RegistrarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarBotaoActionPerformed(evt);
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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(IDAnimalTexto)
                                            .addComponent(NomeTipo)
                                            .addComponent(HabitatTexto))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(HabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(IDAnimalCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(IdadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(PesoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(AlturaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(EspecieCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(39, 39, 39)
                                                .addComponent(HabitatBotao))
                                            .addComponent(TipoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(NomeTexto)
                                    .addComponent(IdadeTexto)
                                    .addComponent(PesoTexto)
                                    .addComponent(AlturaTexto)
                                    .addComponent(EspecieTexto)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AlimentacaoTexto)
                                            .addComponent(SexoTexto))
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SexoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AlimentacaoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(MenuBotao)
                        .addGap(44, 44, 44)
                        .addComponent(RegistrarBotao)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HabitatTexto)
                    .addComponent(HabitatCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HabitatBotao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomeTipo)
                            .addComponent(TipoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDAnimalTexto)
                            .addComponent(IDAnimalCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomeTexto)
                            .addComponent(NomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdadeTexto)
                            .addComponent(IdadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PesoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PesoTexto))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AlturaTexto)
                            .addComponent(AlturaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EspecieCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EspecieTexto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SexoTexto)
                            .addComponent(SexoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AlimentacaoTexto)
                            .addComponent(AlimentacaoOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(HabitatTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuBotao)
                    .addComponent(RegistrarBotao))
                .addContainerGap())
        );

        pack();
    }

    private void SexoOpcaoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void TipoOpcaoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void NomeCampoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void IdadeCampoActionPerformed(java.awt.event.ActionEvent evt) {
    	
    }

    private void PesoCampoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void AlturaCampoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void EspecieCampoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void AlimentacaoOpcaoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void HabitatCampoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void HabitatBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        close();
        InterfaceHabitat ih = new InterfaceHabitat();
        ih.setVisible(true);
    }

    private void IDAnimalCampoActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void MenuBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    private void RegistrarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String tipoSelecionado = TipoOpcao.getSelectedItem().toString();
        
        
            switch (tipoSelecionado) {
                case "Anfibio":  
                    this.setVisible(false);
                    InterfaceAnfibio interfaceAnfibio = geraInterfaceAnfibio(
                        getHabitatId(), getAnimalId(), getNome(), getIdade(), getPeso(), getAltura(), getEspecie(), getSexo(), getAlimentacao()
                    );
                    interfaceAnfibio.setVisible(true);
                    break;
                
                case "Ave":
                    this.setVisible(false);
                    InterfaceAve interfaceAve = geraInterfaceAve(
                        getHabitatId(), getAnimalId(), getNome(), getIdade(), getPeso(), getAltura(), getEspecie(), getSexo(), getAlimentacao()
                    );
                    interfaceAve.setVisible(true);
                    break;
                
                case "Mamifero":
                    this.setVisible(false);
                    InterfaceMamifero interfaceMamifero = geraInterfaceMamifero(
                        getHabitatId(), getAnimalId(), getNome(), getIdade(), getPeso(), getAltura(), getEspecie(), getSexo(), getAlimentacao()
                    );
                    interfaceMamifero.setVisible(true);
                    break;
                
                case "Peixe":
                    this.setVisible(false);
                    InterfacePeixe interfacePeixe = geraInterfacePeixe(
                        getHabitatId(), getAnimalId(), getNome(), getIdade(), getPeso(), getAltura(), getEspecie(), getSexo(), getAlimentacao()
                    );
                    interfacePeixe.setVisible(true); 
                    break;
                
                case "Reptil":
                    this.setVisible(false);
                    InterfaceReptil interfaceReptil = geraInterfaceReptil(
                        getHabitatId(), getAnimalId(), getNome(), getIdade(), getPeso(), getAltura(), getEspecie(), getSexo(), getAlimentacao()
                    );
                    interfaceReptil.setVisible(true);
                    break; 
                
                default:
                    break;
            }
        }
        
        catch(NumberFormatException nfe){      
            JOptionPane.showMessageDialog(
                null,
                "VALORES ERRADOS OU VAZIOS!",
                 "ERRO CADASTRO DE ANFIBIO",
                 0
            );
            
        }
    }
    
    public String getHabitatId() {
        return HabitatCampo.getText();
    }
    
    public String getAnimalId() {
        return IDAnimalCampo.getText();
    }
        
    public String getNome() {
        return NomeCampo.getText();
    }
            
    public String getIdade() {
        return IdadeCampo.getText();
    }
    
    public String getPeso() {
        return PesoCampo.getText();
    }
                
    public String getAltura() {
        return AlturaCampo.getText();
    }

    public String getEspecie() {
        return EspecieCampo.getText();
    }
    
    public String getSexo() {
        String sexoSelecionado = SexoOpcao.getSelectedItem().toString();
        
        return sexoSelecionado;
    }
        
    public String getAlimentacao() {
        String alimentacaoSelecionado = AlimentacaoOpcao.getSelectedItem().toString();
        
        return alimentacaoSelecionado;
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
            java.util.logging.Logger.getLogger(InterfaceBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceBD().setVisible(true);
            }
        });
    }


    private javax.swing.JComboBox<String> AlimentacaoOpcao;
    private javax.swing.JLabel AlimentacaoTexto;
    private javax.swing.JTextField AlturaCampo;
    private javax.swing.JLabel AlturaTexto;
    private javax.swing.JTextField EspecieCampo;
    private javax.swing.JLabel EspecieTexto;
    private javax.swing.JButton HabitatBotao;
    private javax.swing.JTextField HabitatCampo;
    private javax.swing.JScrollPane HabitatTabela;
    private javax.swing.JLabel HabitatTexto;
    private javax.swing.JTextField IDAnimalCampo;
    private javax.swing.JLabel IDAnimalTexto;
    private javax.swing.JTextField IdadeCampo;
    private javax.swing.JLabel IdadeTexto;
    private javax.swing.JButton MenuBotao;
    private javax.swing.JTextField NomeCampo;
    private javax.swing.JLabel NomeTexto;
    private javax.swing.JLabel NomeTipo;
    private javax.swing.JTextField PesoCampo;
    private javax.swing.JLabel PesoTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JComboBox<String> SexoOpcao;
    private javax.swing.JLabel SexoTexto;
    private javax.swing.JComboBox<String> TipoOpcao;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;

}
