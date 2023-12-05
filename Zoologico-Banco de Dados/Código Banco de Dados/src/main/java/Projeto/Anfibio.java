
package Projeto;


public class Anfibio extends Animal {
	private int patas;

	//Atributo boolean determina se o animal ja fez metamorfose ou nao
	private boolean metamorfose;

	public Anfibio(){}

    	public Anfibio(int id, String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean carnivoro, boolean herbivoro, int idhabitat, int patas, boolean metamorfose) {
        	super(id, nome, idade, peso, altura, especie, sexo, carnivoro, herbivoro, idhabitat);
		this.patas = patas;
		this.metamorfose = metamorfose;
	}
        
	public int getPatas() {
		return this.patas; }

	public boolean getMetamorfose() {
		return this.metamorfose; }


	public void setPatas(int patas) throws ValorVazio {
		if(patas == 0) {
			throw new ValorVazio(); }

		else { 
        		this.patas = patas; }
	}


	public void setMetamorfose(boolean metamorfose) {
    		this.metamorfose = metamorfose;
	}

}

