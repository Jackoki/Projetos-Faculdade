
package Projeto;

import javax.swing.JOptionPane;


public class InterfaceReptil extends javax.swing.JFrame {
    private static final long serialVersionUID = 2L;
    public InterfaceReptil() {
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
        InterfaceBD interfaceBD = new InterfaceBD();
        interfaceBD.setVisible(true);
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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(VenenoTexto)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(73, 73, 73)
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
        voltar();
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceReptil().setVisible(true);
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
