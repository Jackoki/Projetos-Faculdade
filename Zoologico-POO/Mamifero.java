//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Mamifero extends Animal {
	private int patas;
	private double tempoGestacao;

	//Atributo boolean determina se o animal caminha/anda ou nao, por exemplo, uma baleia nao caminha mas ela se locomove nadando
	private boolean caminha;

	public Mamifero(){}

    	public Mamifero(String nome, int idade, double peso, double altura, String especie, boolean sexo, Habitat habitat,  boolean carnivoro, boolean herbivoro, int patas, double tempoGestacao, boolean caminha) {
        	super(nome, idade, peso, altura, especie, sexo, habitat, carnivoro, herbivoro);
		this.patas = patas;
		this.caminha = caminha;
		
		if(sexo) {
			this.tempoGestacao = 0.0; } 

		else {
			this.tempoGestacao = tempoGestacao; }
	}

	public int getPatas() {
		return this.patas; }

	public double getTempoGestacao() {
		return this.tempoGestacao; }

	public boolean getCaminha() {
		return this.caminha; }

	


	public void setPatas(int patas) throws ValorVazio {
		if(patas == 0) {
			throw new ValorVazio(); }

		else { 
        		this.patas = patas; }
	}


	public void setTempoGestacao(double tempoGestacao) {
    			if (this.getSexo()) { 
        			this.tempoGestacao = 0; } 

			else {
        			this.tempoGestacao = tempoGestacao; }
	}


	public void setCaminha(boolean caminha) {
		this.caminha = caminha; }

	//Método realiza sobrescrita
	public void comer() {
		if(getCarnivoro() && getHerbivoro()) {
			System.out.println("O animal " + getNome() + " eh um animal onivoro e come vegetais e carne animal"); }
	
		else if(getCarnivoro()) {
			System.out.println("O animal " + getNome() + " eh um animal carnivoro e come carne animal"); }

		else {
			System.out.println("O animal " + getNome() + " eh um animal herbivoro e come vegetais"); }
		}


	//Método realiza sobrescrita
	public void mover() {
			if(getCaminha()) {
				System.out.println("O mamifero tem " + getPatas() + " patas, e consegue caminhar a andar"); }

			else { 
				System.out.println("O mamifero tem " + getPatas() + " patas, porem nao anda e nem caminha, provavelmente ele voa ou nada"); }
		}

	//Método realiza sobrecarga
	public void informarGestacao(double tempo){
		System.out.println("O mamifero eh feminino e consegue ter filhotes. Sua gestacao eh de " + tempo + " semanas");
	}

	//Método realiza sobrecarga
	public void informarGestacao(){
		System.out.println("O mamifero eh masculino, entao nao consegue ter gestacao"); 
	}
}
