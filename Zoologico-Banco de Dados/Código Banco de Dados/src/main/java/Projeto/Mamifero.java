
package Projeto;

public class Mamifero extends Animal {
	private int patas;
	private int tempoGestacao;

	//Atributo boolean determina se o animal caminha/anda ou nao, por exemplo, uma baleia nao caminha mas ela se locomove nadando
	private boolean caminha;

	public Mamifero(){}

    	public Mamifero(int id, String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean carnivoro, boolean herbivoro, int idhabitat, int patas, int tempoGestacao, boolean caminha) {
        	super(id, nome, idade, peso, altura, especie, sexo, carnivoro, herbivoro, idhabitat);
		this.patas = patas;
		this.caminha = caminha;
		
		if(sexo) {
			this.tempoGestacao = 0; } 

		else {
			this.tempoGestacao = tempoGestacao; }
	}

	public int getPatas() {
		return this.patas; }

	public int getTempoGestacao() {
		return this.tempoGestacao; }

	public boolean getCaminha() {
		return this.caminha; }


	public void setPatas(int patas) throws ValorVazio {
		if(patas == 0) {
			throw new ValorVazio(); }

		else { 
        		this.patas = patas; }
	}


	public void setTempoGestacao(int tempoGestacao) {
    			if (this.getSexo()) { 
        			this.tempoGestacao = 0; } 

			else {
        			this.tempoGestacao = tempoGestacao; }
	}


	public void setCaminha(boolean caminha) {
		this.caminha = caminha; }
}
