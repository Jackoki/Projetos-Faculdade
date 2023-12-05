
import javax.swing.JOptionPane;

//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Ave extends Animal {
	private int asas;
	private int patas;
	private int vooMax;

	//Atributo boolean determina se o animal voa ou nao, por exemplo, uma galinha eh uma ave que tem asas mas nao voa
	private boolean voo;

	public Ave(){
            super();
            this.asas = 0;
            this.patas = 0;
            this.vooMax = 0;
            this.voo = false;
        }

    	public Ave(String nome, int idade, double peso, double altura, String especie, boolean sexo, Habitat habitat, boolean carnivoro, boolean herbivoro, int asas, int patas, int vooMax, boolean voo){
        	super(nome, idade, peso, altura, especie, sexo, habitat, carnivoro, herbivoro);
		this.asas = asas;
		this.patas = patas;
		this.voo = voo;

		
		if(voo == true) {
			this.vooMax = vooMax; } 

		else {
			this.vooMax = 0; }
	}

	public int getAsas() {
		return this.asas; }

	public int getPatas() {
		return this.patas; }

	public boolean getVoo() {
		return this.voo; }

	public int getVooMax() {
		return this.vooMax; }


	


	public void setPatas(int patas) throws ValorVazioException {
		if(patas == 0) {
			throw new ValorVazioException(); }

		else { 
        		this.patas = patas; }
	}

	public void setAsas (int asas) throws ValorVazioException {
		if(asas == 0) {
			throw new ValorVazioException(); }

		else { 
        		this.asas = asas; }
	}

	public void setVoo (boolean voo) {
		this.voo = voo;
		if(!voo) {
			this.vooMax = 0;
		} }

	public void setVooMax(int vooMax) {
    		if (this.getVoo()) { 
        		this.vooMax = vooMax; } 

		else {
        		this.vooMax = 0; } }

	//Método realiza sobrescrita
	public void comer() {
		if(getCarnivoro() && getHerbivoro()) {
                    JOptionPane.showMessageDialog(
                        null,
                        "O animal " + getNome() + " é um animal onívoro e come carne animal, frutas e sementes",
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
                        "O animal " + getNome() + " é um animal herbívoro e come frutas e sementes",
                        "ALIMENTAÇÃO",
                        1
                    );  
                }
	}

	//Método realiza sobrescrita
	public void mover() {
			if(getVoo()) {
                            JOptionPane.showMessageDialog(
                            null,
                            "O animal " + getNome() + " consegue voar numa altura de " + getVooMax() + " metros",
                            "VOO",
                            1
                    );  
                        }

			else { 
                            JOptionPane.showMessageDialog(
                            null,
                            "O animal " + getNome() + " é uma ave que não consegue voar",
                            "VOO",
                            1
                        );
                    }
		}


}
