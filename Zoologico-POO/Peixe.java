//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Peixe extends Animal {
	private int nadadeiras;
	private int profundidadeMax;

	//Atributo boolean determina se o animal nada ou nao, por exemplo, o peixe-bolha eh uma peixe que nao nada
	private boolean nada;

	public Peixe (){}

    	public Peixe (String nome, int idade, double peso, double altura, String especie, boolean sexo, Habitat habitat,  boolean carnivoro, boolean herbivoro, int nadadeiras, int profundidadeMax, boolean nada){
        	super(nome, idade, peso, altura, especie, sexo, habitat, carnivoro, herbivoro);
		this.nadadeiras = nadadeiras;
		this.nada = nada;
		
		if(nada == true) {
			this.profundidadeMax = profundidadeMax; } 

		else {
			this.profundidadeMax = 0; }
	}

	public int getNadadeiras() {
		return this.nadadeiras; }

	public int getProfundidadeMax() {
		return this.profundidadeMax; }

	public boolean getNada() {
		return this.nada; }


	public void setNadadeiras(int nadadeiras) {
        	this.nadadeiras = nadadeiras; 
	}

	public void setProfundidadeMax (int profundidadeMax) {
		if(this.getNada()) {
			this.profundidadeMax = profundidadeMax; }

		else {
			this.profundidadeMax = 0; } }

	public void setNada(boolean nada) {
		this.nada = nada; 
		if(!nada) {
			this.profundidadeMax = 0; } } 

	//Método realiza sobrescrita
	public void comer() {
		if(getCarnivoro() && getHerbivoro()) {
			System.out.println("O animal " + getNome() + " eh um animal onivoro e come algas marinhas e peixes"); }
	
		else if(getCarnivoro()) {
			System.out.println("O animal " + getNome() + " eh um animal carnivoro e come peixes"); }

		else {
			System.out.println("O animal " + getNome() + " eh um animal herbivoro e come algas marinhas"); }
		}


	//Método realiza sobrescrita
	public void mover() {
			if(getNada()) {
				System.out.println("O peixe tem " + getNadadeiras() + " nadadeiras, e consegue nadar ate " + getProfundidadeMax() + " metros"); }

			else { 
				System.out.println("O peixe tem " + getNadadeiras() + " nadadeiras porem nao nada"); }
		}

}
