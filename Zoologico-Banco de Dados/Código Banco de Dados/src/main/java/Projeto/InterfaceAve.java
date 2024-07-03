
package Projeto;

import javax.swing.JOptionPane;

public class InterfaceAve extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;
    public static Ave ave = new Ave();
    public static Animal ani = new Animal();


    public InterfaceAve() {
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
    
    
    public void voltar(){
        this.setVisible(false);
        InterfaceBD interfaceBD = new InterfaceBD();
        interfaceBD.setVisible(true);
    }
    
    public void insAve(){
        try{
            ave.setIdHabitat(habitatid);
            ani.setIdHabitat(habitatid);
            
            ave.setId(idanimal);
            ani.setId(idanimal);
            
            ave.setNome(nome);
            ani.setNome(nome);
            
            ave.setIdade(idade);
            ani.setIdade(idade);
            
            ave.setPeso(peso); 
            ani.setPeso(peso);
            
            ave.setAltura(altura);
            ani.setAltura(altura);
            
            ave.setEspecie(especie);
            ani.setEspecie(especie);

            String sexoSelecionado = sexo;
            String alimentacaoSelecionado = alimentacao;
            
        switch (sexoSelecionado) {
            case "Feminino":   
                ave.setSexo(false);
                ani.setSexo(false);
                break;
                
            case "Masculino":   
                ave.setSexo(true);
                ani.setSexo(true);
                break;
        }
        
        switch (alimentacaoSelecionado) {
            case "Herbivoro":   
                ave.setHerbivoro(true);
                ave.setCarnivoro(false);
                
                ani.setHerbivoro(true);
                ani.setCarnivoro(false);
                break;
                
            case "Carnivoro":   
                ave.setHerbivoro(false);
                ave.setCarnivoro(true);
                
                ani.setHerbivoro(false);
                ani.setCarnivoro(true);
                break;
                
            case "Onivoro":   
                ave.setHerbivoro(true);
                ave.setCarnivoro(true);
                
                ani.setHerbivoro(true);
                ani.setCarnivoro(true);
                break;
        }
        
        ave.setAsas(Integer.parseInt(AsasCampo.getText()));
        ave.setPatas(Integer.parseInt(PatasCampo.getText()));
        
        String vooSelecionado = VooOpcao.getSelectedItem().toString();
        
        switch (vooSelecionado) {
            case "Não":   
                ave.setVoo(false);
                break;
                
            case "Sim":   
                ave.setVoo(true);
                break;
        }   
        
        ave.setVooMax(Integer.parseInt(VooMaxCampo.getText()));
        
        JOptionPane.showMessageDialog(
                null,
                "CADASTRO FEITO COM SUCESSO!",
                 "SUCESSO CADASTRO DE ANFIBIO",
                 1
        );
        
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

    private void initComponents() {

        VoltarBotao = new javax.swing.JButton();
        RegistrarBotao = new javax.swing.JButton();
        AsasTexto = new javax.swing.JLabel();
        PatasTexto = new javax.swing.JLabel();
        VooTexto = new javax.swing.JLabel();
        VooMaxTexto = new javax.swing.JLabel();
        AsasCampo = new javax.swing.JTextField();
        PatasCampo = new javax.swing.JTextField();
        VooOpcao = new javax.swing.JComboBox<>();
        VooMaxCampo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        AsasTexto.setText("Quantidade de Asas");

        PatasTexto.setText("Quantidade de Patas");

        VooTexto.setText("A ave voa?");

        VooMaxTexto.setText("Qual o voo máximo se ela voa?");

        VooOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VoltarBotao)
                .addGap(18, 18, 18)
                .addComponent(RegistrarBotao)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VooTexto)
                    .addComponent(VooMaxTexto)
                    .addComponent(PatasTexto)
                    .addComponent(AsasTexto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VooOpcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AsasCampo)
                    .addComponent(VooMaxCampo)
                    .addComponent(PatasCampo))
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AsasTexto)
                    .addComponent(AsasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PatasTexto)
                    .addComponent(PatasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VooTexto)
                    .addComponent(VooOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VooMaxTexto)
                    .addComponent(VooMaxCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(RegistrarBotao))
                .addGap(17, 17, 17))
        );

        pack();
    }

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    private void RegistrarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        insAve();
        voltar();
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
            java.util.logging.Logger.getLogger(InterfaceAve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceAve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceAve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceAve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceAve().setVisible(true);
            }
        });
    }

 
    private javax.swing.JTextField AsasCampo;
    private javax.swing.JLabel AsasTexto;
    private javax.swing.JTextField PatasCampo;
    private javax.swing.JLabel PatasTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JButton VoltarBotao;
    private javax.swing.JTextField VooMaxCampo;
    private javax.swing.JLabel VooMaxTexto;
    private javax.swing.JComboBox<String> VooOpcao;
    private javax.swing.JLabel VooTexto;
 
}
