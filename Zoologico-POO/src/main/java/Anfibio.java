
import javax.swing.JOptionPane;

//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Anfibio extends Animal implements Metamorfose {
	private int patas;

	//Atributo boolean determina se o animal ja fez metamorfose ou nao
	private boolean metamorfose;

	public Anfibio(){
            super();
            this.patas = 0;
            this.metamorfose = false;
        }

    	public Anfibio(String nome, int idade, double peso, double altura, String especie, boolean sexo, Habitat habitat, boolean carnivoro, boolean herbivoro, int patas, boolean metamorfose) {
        	super(nome, idade, peso, altura, especie, sexo, habitat, carnivoro, herbivoro);
		this.patas = patas;
		this.metamorfose = metamorfose;
	}

	public int getPatas() {
		return this.patas; }

	public boolean getMetamorfose() {
		return this.metamorfose; }
	


	public void setPatas(int patas) throws ValorVazioException {
		if(patas == 0) {
			throw new ValorVazioException(); }

		else { 
        		this.patas = patas; }
	}


	public void setMetamorfose(boolean metamorfose) {
    		this.metamorfose = metamorfose;
	}

	//Método realiza sobrescrita
	public void comer() {
		if(getCarnivoro() && getHerbivoro()) {
                    JOptionPane.showMessageDialog(
                    null,
                    "O animal " + getNome() + " é um animal onívoro e come pequenos animais e vegetais",
                    "ALIMENTAÇÃO",
                    1
                    );        
                }
	
		else if(getCarnivoro()) {
                    JOptionPane.showMessageDialog(
                    null,
                    "O animal " + getNome() + " é um animal carnívoro e come pequenos animais",
                    "ALIMENTAÇÃO",
                    1
                    );
                }

		else {
                    JOptionPane.showMessageDialog(
                    null,
                    "O animal " + getNome() + " é um animal herbivoro e come vegetais",
                    "ALIMENTAÇÃO",
                    1
                    );
                    }
		}


	//Método realiza sobrescrita
	public void mover() {
                JOptionPane.showMessageDialog(
                    null,
                    "O animal " + getNome() + " tem " + getPatas() + " patas, anda ou rasteja e nada",
                    "MOVIMENTAÇÃO",
                    1
                );
	}

	public void transmutar(){
		if(getMetamorfose()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "O animal " + getNome() + " tem metamorfose",
                            "METAMORFOSE",
                            1
                ); }

		else {
                    JOptionPane.showMessageDialog(
                            null,
                            "O animal " + getNome() + " não tem metamorfose",
                            "METAMORFOSE",
                            1
                    );
                }
	}

}
