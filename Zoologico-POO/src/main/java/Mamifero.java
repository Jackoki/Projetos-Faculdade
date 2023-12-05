
import javax.swing.JOptionPane;

//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Mamifero extends Animal {
	private int patas;
	private double tempoGestacao;

	//Atributo boolean determina se o animal caminha/anda ou nao, por exemplo, uma baleia nao caminha mas ela se locomove nadando
	private boolean caminha;

	public Mamifero(){
            super();
            this.patas = 0;
            this.tempoGestacao = 0;
            this.caminha = false;
        }

    	public Mamifero(String nome, int idade, double peso, double altura, String especie, boolean sexo, Habitat habitat,  boolean carnivoro, boolean herbivoro, int patas, double tempoGestacao, boolean caminha) {
        	super(nome, idade, peso, altura, especie, sexo, habitat, carnivoro, herbivoro);
		this.patas = patas;
		this.caminha = caminha;
		
		if(sexo) {
			this.tempoGestacao = 0.0; } 

		else {
			this.tempoGestacao = tempoGestacao; }
	}

	public int getPatas() {
		return this.patas; }

	public double getTempoGestacao() {
		return this.tempoGestacao; }

	public boolean getCaminha() {
		return this.caminha; }

	


	public void setPatas(int patas){
            this.patas = patas; 
	}


	public void setTempoGestacao(double tempoGestacao) {
    			if (this.getSexo()) { 
        			this.tempoGestacao = 0; } 

			else {
        			this.tempoGestacao = tempoGestacao; }
	}


	public void setCaminha(boolean caminha) {
		this.caminha = caminha; }

	//Método realiza sobrescrita
	public void comer() {
		if(getCarnivoro() && getHerbivoro()) {
                    JOptionPane.showMessageDialog(
                    null,
                    "O animal " + getNome() + " é um animal onívoro e come carne animal e vegetais",
                    "ALIMENTAÇÃO",
                    1
                    );     
                }
	
		else if(getCarnivoro()) {
                    JOptionPane.showMessageDialog(
                    null,
                    "O animal " + getNome() + " é um animal carnívoro e come carne animal",
                    "ALIMENTAÇÃO",
                    1
                    );   
                }

		else {
                    JOptionPane.showMessageDialog(
                    null,
                    "O animal " + getNome() + " é um animal herbívoro e vegetais",
                    "ALIMENTAÇÃO",
                    1
                    );  
                }
	}


	//Método realiza sobrescrita
	public void mover() {
			if(getCaminha()) {
                            JOptionPane.showMessageDialog(
                            null,
                            "O animal " + getNome() + " é um mamífero que anda ou caminha",
                            "MOVER",
                            1
                            );  
                        }

			else { 
                            JOptionPane.showMessageDialog(
                            null,
                            "O mamifero tem " + getPatas() + " patas, porem nao anda e nem caminha, provavelmente ele voa ou nada",
                            "MOVER",
                            1
                            );  
                        }
		}

	//Método realiza sobrecarga
	public void informarGestacao(double tempo){
                            JOptionPane.showMessageDialog(
                            null,
                            "O mamifero " + getNome() + " tem um tempo de " + tempo + "semanas de gestação",
                            "GESTAÇÃO",
                            1
                            ); 
	}

	//Método realiza sobrecarga
	public void informarGestacao(){
                            JOptionPane.showMessageDialog(
                            null,
                            "O mamifero é masculino, logo, não consegue ter gestação",
                            "GESTAÇÃO",
                            1
                            ); 
	}
}
