
package Projeto;

public class Peixe extends Animal {
	private int nadadeiras;
	private int profundidadeMax;

	//Atributo boolean determina se o animal nada ou nao, por exemplo, o peixe-bolha eh uma peixe que nao nada
	private boolean nada;

	public Peixe (){}

    	public Peixe (int id, String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean carnivoro, boolean herbivoro, int idhabitat, int nadadeiras, int profundidadeMax, boolean nada){
        	super(id, nome, idade, peso, altura, especie, sexo, carnivoro, herbivoro, idhabitat);
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


}
