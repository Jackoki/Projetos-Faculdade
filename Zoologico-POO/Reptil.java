//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Reptil extends Animal {
	private int patas;

	//Atributo boolean determina se o animal tem veneno ou nao
	private boolean veneno;

	public Reptil(){}

    	public Reptil(String nome, int idade, double peso, double altura, String especie, boolean sexo, Habitat habitat, boolean carnivoro, boolean herbivoro, int patas, boolean veneno) {
        	super(nome, idade, peso, altura, especie, sexo, habitat, carnivoro, herbivoro);
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

	//Método realiza sobrescrita
	public void comer() {
		if(getCarnivoro() && getHerbivoro()) {
			System.out.println("O animal " + getNome() + " eh um animal onivoro e come algas ou vegetais ou frutas e carne animal ou peixes"); }
	
		else if(getCarnivoro()) {
			System.out.println("O animal " + getNome() + " eh um animal carnivoro e come carne animal ou peixes"); }

		else {
			System.out.println("O animal " + getNome() + " eh um animal herbivoro e come algas ou vegetais ou frutas"); }
		}

	//Método realiza sobrescrita
	public void mover() {
			if(getVeneno()) {
				System.out.println("O reptil tem " + getPatas() + " patas, tem veneno e anda, rasteja, nada ou escava"); }

			else { 
				System.out.println("O reptil tem " + getPatas() + " patas, nao tem veneno e anda, rasteja, nada ou escava"); }
		}
}
