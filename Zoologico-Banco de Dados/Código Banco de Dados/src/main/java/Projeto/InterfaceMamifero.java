
package Projeto;

import javax.swing.JOptionPane;

public class InterfaceMamifero extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;
    public static Mamifero mam = new Mamifero();
    public static Animal ani = new Animal();

    public InterfaceMamifero() {
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
    
    public void insMamifero(){
        try{
            mam.setIdHabitat(habitatid);
            ani.setIdHabitat(habitatid);
            
            mam.setId(idanimal);
            ani.setId(idanimal);
            
            mam.setNome(nome);
            ani.setNome(nome);
            
            mam.setIdade(idade);
            ani.setIdade(idade);
            
            mam.setPeso(peso); 
            ani.setPeso(peso);
            
            mam.setAltura(altura);
            ani.setAltura(altura);
            
            mam.setEspecie(especie);
            ani.setEspecie(especie);

            String sexoSelecionado = sexo;
            String alimentacaoSelecionado = alimentacao;
            
        switch (sexoSelecionado) {
            case "Feminino":   
                mam.setSexo(false);
                ani.setSexo(false);
                break;
                
            case "Masculino":   
                mam.setSexo(true);
                ani.setSexo(true);
                break;
        }
        
        switch (alimentacaoSelecionado) {
            case "Herbivoro":   
                mam.setHerbivoro(true);
                mam.setCarnivoro(false);
                
                ani.setHerbivoro(true);
                ani.setCarnivoro(false);
                break;
                
            case "Carnivoro":   
                mam.setHerbivoro(false);
                mam.setCarnivoro(true);
                
                ani.setHerbivoro(false);
                ani.setCarnivoro(true);
                break;
                
            case "Onivoro":   
                mam.setHerbivoro(true);
                mam.setCarnivoro(true);
                
                ani.setHerbivoro(true);
                ani.setCarnivoro(true);
                break;
        }
        
        mam.setPatas(Integer.parseInt(PatasCampo.getText()));
        mam.setTempoGestacao(Integer.parseInt(GestacaoCampo.getText()));    
        
        String caminhaSelecionado = CaminhaOpcao.getSelectedItem().toString();
        
        switch (caminhaSelecionado) {
            case "Não":   
                mam.setCaminha(false);
                break;
                
            case "Sim":   
                mam.setCaminha(true);
                break;
        }   
        
        JOptionPane.showMessageDialog(
                null,
                "CADASTRO FEITO COM SUCESSO!",
                 "SUCESSO CADASTRO DE ANFIBIO",
                 1
        );
        
        }//fim try
        
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

        PatasTexto = new javax.swing.JLabel();
        GestacaoTexto = new javax.swing.JLabel();
        CaminhaTexto = new javax.swing.JLabel();
        PatasCampo = new javax.swing.JTextField();
        GestacaoCampo = new javax.swing.JTextField();
        CaminhaOpcao = new javax.swing.JComboBox<>();
        VoltarBotao = new javax.swing.JButton();
        RegistarBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PatasTexto.setText("Quantidade de Patas");

        GestacaoTexto.setText("Tempo de Gestação em Semanas");

        CaminhaTexto.setText("O animal caminha?");

        CaminhaOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

        VoltarBotao.setText("Voltar");
        VoltarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarBotaoActionPerformed(evt);
            }
        });

        RegistarBotao.setText("Registrar");
        RegistarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistarBotaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PatasTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PatasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GestacaoTexto)
                            .addComponent(CaminhaTexto))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(GestacaoCampo, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(CaminhaOpcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VoltarBotao)
                .addGap(18, 18, 18)
                .addComponent(RegistarBotao)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatasTexto)
                    .addComponent(PatasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GestacaoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GestacaoTexto))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CaminhaTexto)
                    .addComponent(CaminhaOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(RegistarBotao))
                .addGap(20, 20, 20))
        );

        pack();
    }

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    private void RegistarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        insMamifero();
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
            java.util.logging.Logger.getLogger(InterfaceMamifero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceMamifero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceMamifero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceMamifero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceMamifero().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> CaminhaOpcao;
    private javax.swing.JLabel CaminhaTexto;
    private javax.swing.JTextField GestacaoCampo;
    private javax.swing.JLabel GestacaoTexto;
    private javax.swing.JTextField PatasCampo;
    private javax.swing.JLabel PatasTexto;
    private javax.swing.JButton RegistarBotao;
    private javax.swing.JButton VoltarBotao;

}
