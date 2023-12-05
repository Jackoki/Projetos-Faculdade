
package Projeto;

public class Reptil extends Animal {
	private int patas;

	//Atributo boolean determina se o animal tem veneno ou nao
	private boolean veneno;

	public Reptil(){}

    	public Reptil(int id, String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean carnivoro, boolean herbivoro, int idhabitat, int patas, boolean veneno) {
        	super(id, nome, idade, peso, altura, especie, sexo, carnivoro, herbivoro, idhabitat);
		this.patas = patas;
		this.veneno = veneno;
	}

	public int getPatas() {
		return this.patas; }

	public boolean getVeneno() {
		return this.veneno; }
	


	public void setPatas(int patas) throws ValorVazio {
		if(patas == 0) {
			throw new ValorVazio(); }

		else { 
        		this.patas = patas; }
	}


	public void setVeneno(boolean veneno) {
 		this.veneno = veneno;
	}

}
