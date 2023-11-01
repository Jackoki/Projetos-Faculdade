//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Anfibio extends Animal implements Metamorfose {
	private int patas;

	//Atributo boolean determina se o animal ja fez metamorfose ou nao
	private boolean metamorfose;

	public Anfibio(){}

    	public Anfibio(String nome, int idade, double peso, double altura, String especie, boolean sexo, Habitat habitat, boolean carnivoro, boolean herbivoro, int patas, boolean metamorfose) {
        	super(nome, idade, peso, altura, especie, sexo, habitat, carnivoro, herbivoro);
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

	//Método realiza sobrescrita
	public void comer() {
		if(getCarnivoro() && getHerbivoro()) {
			System.out.println("O animal " + getNome() + " eh um animal onivoro e come vegetais e pequenos animais"); }
	
		else if(getCarnivoro()) {
			System.out.println("O animal " + getNome() + " eh um animal carnivoro e come pequenos animais"); }

		else {
			System.out.println("O animal " + getNome() + " eh um animal herbivoro e come vegetais"); }
		}


	//Método realiza sobrescrita
	public void mover() {
			System.out.println("O anfibio tem " + getPatas() + " patas, anda ou rasteja e nada");
		}

	public void transmutar(){
		if(getMetamorfose()) { 
			System.out.println("O anfibio ja realizou a metamorfose "); }

		else {
			System.out.println("O anfibio nao fez ou nao tem metamorfose"); }
		}

}
