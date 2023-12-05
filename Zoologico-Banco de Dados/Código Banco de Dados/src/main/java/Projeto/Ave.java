
package Projeto;


public class Ave extends Animal {
	private int asas;
	private int patas;
	private int vooMax;

	//Atributo boolean determina se o animal voa ou nao, por exemplo, uma galinha eh uma ave que tem asas mas nao voa
	private boolean voo;

	public Ave(){}

    	public Ave(int id, String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean carnivoro, boolean herbivoro, int idhabitat, int asas, int patas, int vooMax, boolean voo){
        	super(id, nome, idade, peso, altura, especie, sexo, carnivoro, herbivoro, idhabitat);
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


	


	public void setPatas(int patas) throws ValorVazio {
		if(patas == 0) {
			throw new ValorVazio(); }

		else { 
        		this.patas = patas; }
	}

	public void setAsas (int asas) throws ValorVazio {
		if(asas == 0) {
			throw new ValorVazio(); }

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

}
