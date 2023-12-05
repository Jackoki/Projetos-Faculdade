
package Projeto;

import javax.swing.JOptionPane;

public class InterfacePeixe extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;
    public InterfacePeixe() {
        initComponents();
    }
    public static Peixe pei = new Peixe();
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
        InterfaceBD interfaceBD = new InterfaceBD();
        interfaceBD.setVisible(true);
    }
    
    public void insPei(){
        try{
            pei.setIdHabitat(habitatid);
            ani.setIdHabitat(habitatid);
            
            pei.setId(idanimal);
            ani.setId(idanimal);
            
            pei.setNome(nome);
            ani.setNome(nome);
            
            pei.setIdade(idade);
            ani.setIdade(idade);
            
            pei.setPeso(peso); 
            ani.setPeso(peso);
            
            pei.setAltura(altura);
            ani.setAltura(altura);
            
            pei.setEspecie(especie);
            ani.setEspecie(especie);

            String sexoSelecionado = sexo;
            String alimentacaoSelecionado = alimentacao;
            
        switch (sexoSelecionado) {
            case "Feminino":   
                pei.setSexo(false);
                ani.setSexo(false);
                break;
                
            case "Masculino":   
                pei.setSexo(true);
                ani.setSexo(true);
                break;
        }
        
        switch (alimentacaoSelecionado) {
            case "Herbivoro":   
                pei.setHerbivoro(true);
                pei.setCarnivoro(false);
                
                ani.setHerbivoro(true);
                ani.setCarnivoro(false);
                break;
                
            case "Carnivoro":   
                pei.setHerbivoro(false);
                pei.setCarnivoro(true);
                
                ani.setHerbivoro(false);
                ani.setCarnivoro(true);
                break;
                
            case "Onivoro":   
                pei.setHerbivoro(true);
                pei.setCarnivoro(true);
                
                ani.setHerbivoro(true);
                ani.setCarnivoro(true);
                break;
        }
        
        pei.setNadadeiras(Integer.parseInt(NadadeirasCampo.getText()));        
        pei.setProfundidadeMax(Integer.parseInt(ProfundidadeCampo.getText()));
        
        String nadaSelecionado = NadaOpcao.getSelectedItem().toString();
        
        switch (nadaSelecionado) {
            case "Não":   
                pei.setNada(false);
                break;
                
            case "Sim":   
                pei.setNada(true);
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

        NadaTexto = new javax.swing.JLabel();
        ProfundidadeTexto = new javax.swing.JLabel();
        NadadeirasTexto = new javax.swing.JLabel();
        NadaOpcao = new javax.swing.JComboBox<>();
        ProfundidadeCampo = new javax.swing.JTextField();
        NadadeirasCampo = new javax.swing.JTextField();
        VoltarBotao = new javax.swing.JButton();
        RegistrarBotao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NadaTexto.setText("O peixe nada?");

        ProfundidadeTexto.setText("Profundidade Máxma em Metros do Peixe");

        NadadeirasTexto.setText("Quantidade de Nadadeiras");

        NadaOpcao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VoltarBotao)
                        .addGap(34, 34, 34)
                        .addComponent(RegistrarBotao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NadaTexto)
                            .addComponent(ProfundidadeTexto)
                            .addComponent(NadadeirasTexto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NadadeirasCampo)
                            .addComponent(ProfundidadeCampo)
                            .addComponent(NadaOpcao, 0, 108, Short.MAX_VALUE))))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NadaTexto)
                    .addComponent(NadaOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfundidadeTexto)
                    .addComponent(ProfundidadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NadadeirasTexto)
                    .addComponent(NadadeirasCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VoltarBotao)
                    .addComponent(RegistrarBotao))
                .addGap(19, 19, 19))
        );

        pack();
    }

    private void VoltarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        voltar();
    }

    private void RegistrarBotaoActionPerformed(java.awt.event.ActionEvent evt) {
        insPei();
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
            java.util.logging.Logger.getLogger(InterfacePeixe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfacePeixe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfacePeixe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfacePeixe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfacePeixe().setVisible(true);
            }
        });
    }

    private javax.swing.JComboBox<String> NadaOpcao;
    private javax.swing.JLabel NadaTexto;
    private javax.swing.JTextField NadadeirasCampo;
    private javax.swing.JLabel NadadeirasTexto;
    private javax.swing.JTextField ProfundidadeCampo;
    private javax.swing.JLabel ProfundidadeTexto;
    private javax.swing.JButton RegistrarBotao;
    private javax.swing.JButton VoltarBotao;
}
