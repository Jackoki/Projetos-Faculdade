//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Ave extends Animal {
	private int asas;
	private int patas;
	private int vooMax;

	//Atributo boolean determina se o animal voa ou nao, por exemplo, uma galinha eh uma ave que tem asas mas nao voa
	private boolean voo;

	public Ave(){}

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

	public double getPatas() {
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

	//Método realiza sobrescrita
	public void comer() {
		if(getCarnivoro() && getHerbivoro()) {
			System.out.println("O animal " + getNome() + " eh um animal onivoro e come frutas, sementes e carne animal"); }
	
		else if(getCarnivoro()) {
			System.out.println("O animal " + getNome() + " eh um animal carnivoro e come carne animal"); }

		else {
			System.out.println("O animal " + getNome() + " eh um animal herbivoro e come frutas, sementes"); }
		}

	//Método realiza sobrescrita
	public void mover() {
			if(getVoo()) {
				System.out.println("A ave tem " + getPatas() + " patas, " + getAsas() + " asas e ela consegue voar ate " + getVooMax() + " metros"); }

			else { 
				System.out.println("A ave tem " + getPatas() + " patas, " + getAsas() + " asas, porem nao consegue voar ");}
		}


}
