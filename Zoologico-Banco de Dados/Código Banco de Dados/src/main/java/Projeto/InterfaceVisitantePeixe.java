
package Projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class InterfaceVisitantePeixe extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;

    public InterfaceVisitantePeixe() {
        initComponents();
        conectarTabela();
    }

    private void initComponents() {

        ViewTabela = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        VoltarBotao = new javax.swing.JButton();
        AnfibiosTexto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID do Animal", "Nome", "Idade", "Peso", "Altura", "Especie", "Sexo", "Carnivoro", "Herbivoro", "ID do Habitat", "Nadadeiras", "Profundidade Máxima", "Nada"
            }
        ));
        ViewTabela.setViewportView(jTable1);

        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        AnfibiosTexto.setFont(new java.awt.Font("Segoe UI", 1, 48));
        AnfibiosTexto.setText("Peixes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(ViewTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(458, 458, 458)
                        .addComponent(VoltarBotao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addComponent(AnfibiosTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AnfibiosTexto)
                .addGap(18, 18, 18)
                .addComponent(ViewTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VoltarBotao)
                .addGap(19, 19, 19))
        );

        pack();
    }

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    public void voltar(){
        this.setVisible(false);
        InterfaceVisitante iv = new InterfaceVisitante();
        iv.setVisible(true);
    }
    
    public void conectarTabela(){
        String url = "jdbc:postgresql://localhost/postgres";
        String usuario = "visitante";
        String senha = "visitante";
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            Statement st = conexao.createStatement();
            
            //Consulta com JOIN
            String sql = "SELECT Animal.AnimalId, "
                    + "Animal.AnimalNome, "
                    + "Animal.AnimalIdade, "
                    + "Animal.AnimalPeso, "
                    + "Animal.AnimalAltura, "
                    + "Animal.AnimalEspecie, "
                    + "Animal.AnimalSexo, "
                    + "Animal.AnimalCarnivoro, "
                    + "Animal.AnimalHerbivoro, "
                    + "Animal.HabitatId, "
                    + "Peixe.PeixeNadadeiras, "
                    + "Peixe.peixeprofundidamax, "
                    + "Peixe.PeixeNada "
                    + "FROM Animal "
                    + "INNER JOIN Peixe ON Animal.AnimalId = Peixe.AnimalId AND Animal.HabitatId = Peixe.HabitatId";
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
                String nadadeiras = String.valueOf(rs.getInt("peixenadadeiras"));
                String profundidademax = String.valueOf(rs.getInt("peixeprofundidamax"));
                String nada = String.valueOf(rs.getBoolean("peixenada"));
                
                String tbData[] = {id, nome, idade, peso, altura, especie, sexo, carnivoro, herbivoro, habitatid, nadadeiras, profundidademax, nada};
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
            java.util.logging.Logger.getLogger(InterfaceVisitantePeixe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceVisitantePeixe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceVisitantePeixe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceVisitantePeixe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceVisitantePeixe().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel AnfibiosTexto;
    private javax.swing.JScrollPane ViewTabela;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JTable jTable1;
}
