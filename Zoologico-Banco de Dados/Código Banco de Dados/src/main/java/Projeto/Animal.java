
package Projeto;

public class Animal {
    	private int id;
	private String nome;
	private int idade;
	private double peso;
	private double altura;
	private String especie;
	private boolean sexo;

	private boolean carnivoro;
	private boolean herbivoro;
        
        private int idhabitat;

	public Animal(){}

    	public Animal(int id, String nome, int idade, double peso, double altura, String especie, boolean sexo, boolean carnivoro, boolean herbivoro, int idhabitat) {
            this.id = id;
            this.nome = nome;
            this.idade = idade;
            this.peso = peso;
            this.altura = altura;
            this.especie = especie;
            this.sexo = sexo;
            this.carnivoro = carnivoro;
            this.herbivoro = herbivoro;
            this.idhabitat = idhabitat;
        }
        
        public int getId() {
            return this.id; }

    	public String getNome() {
            return this.nome; }

    	public int getIdade() {
            return this.idade; }

    	public double getPeso() {
            return this.peso; }

    	public double getAltura() {
            return this.altura; }

    	public String getEspecie() {
            return this.especie; }

    	public boolean getSexo() {
            return this.sexo; }

    	public boolean getCarnivoro() {
            return this.carnivoro; }

    	public boolean getHerbivoro() {
            return this.herbivoro; }
        
        public int getIdHabitat() {
            return this.idhabitat;
        }

	public void setId(int id) throws ValorVazio {
            if(id == 0) {
			throw new ValorVazio(); }

		else { 
        		this.id = id; }
	}

    	public void setNome(String nome) {		
            this.nome = nome; 
	}

	public void setIdade(int idade) throws ValorVazio {
            if(idade == 0) {
                throw new ValorVazio(); }

            else { 
        	this.idade = idade; }
	}

    	public void setPeso(double peso) throws ValorVazio {
            if(peso == 0.0) {
		throw new ValorVazio(); }

            else { 
        	this.peso = peso; }
	}

    	public void setAltura(double altura) throws ValorVazio {
            if(altura == 0.0) {
		throw new ValorVazio(); }

            else { 
        	this.altura = altura; }
	}

    	public void setEspecie(String especie) throws InsercaoVazia {
            if(especie == null || especie.isEmpty()) {
		throw new InsercaoVazia(); }

            else { 
        	this.especie = especie; }
	}

    	public void setSexo(boolean sexo){
            this.sexo = sexo;
	}

    	public void setCarnivoro(boolean carnivoro) {
            this.carnivoro = carnivoro;
	}

    	public void setHerbivoro(boolean herbivoro) {
            this.herbivoro = herbivoro;
	}

        public void setIdHabitat(int idhabitat) {
            this.idhabitat = idhabitat;
        }

	public void comer() {};

	public void mover() {};
}
