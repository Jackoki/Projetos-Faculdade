//Nome: Gabriel Kenji Inoue
//RA: 2504170

public abstract class Animal {
	private String nome;
	private int idade;
	private double peso;
	private double altura;
	private String especie;
	private boolean sexo;

	private Habitat habitat = new Habitat();

	private boolean carnivoro;
	private boolean herbivoro;

	public Animal(){
            this.nome = "";
            this.idade = 0;
            this.peso = 0;
            this.altura = 0;
            this.especie = "";
            this.sexo = false;
            this.carnivoro = false;
            this.herbivoro = false;
        }

    	public Animal(String nome, int idade, double peso, double altura, String especie, boolean sexo, Habitat habitat, boolean carnivoro, boolean herbivoro) {
        	this.nome = nome;
        	this.idade = idade;
        	this.peso = peso;
        	this.altura = altura;
        	this.especie = especie;
        	this.sexo = sexo;
        	this.habitat = habitat; }

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

    	public Habitat getHabitat() {
        	return this.habitat; }




	public String getHabitatNomeHab(){
		return habitat.getNomeHab(); }

	public int getHabitatTemperatura(){
		return habitat.getTemperatura(); }

	public double getHabitatArea(){
		return habitat.getArea(); }

	public String getHabitatSolo(){
		return habitat.getSolo(); }



    	public void setNome(String nome) throws InsercaoVaziaException {
		if(nome == null || nome.isEmpty()) {
			throw new InsercaoVaziaException(); }

		else { 
        		this.nome = nome; }
	}

	public void setIdade(int idade) throws ValorVazioException {
		if(idade == 0) {
			throw new ValorVazioException(); }

		else { 
        		this.idade = idade; }
	}

    	public void setPeso(double peso) throws ValorVazioException {
		if(peso == 0.0) {
			throw new ValorVazioException(); }

		else { 
        		this.peso = peso; }
	}

    	public void setAltura(double altura) throws ValorVazioException {
		if(altura == 0.0) {
			throw new ValorVazioException(); }

		else { 
        		this.altura = altura; }
	}

    	public void setEspecie(String especie) throws InsercaoVaziaException {
		if(especie == null || especie.isEmpty()) {
			throw new InsercaoVaziaException(); }

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

    	public void setHabitat(Habitat habitat) throws InsercaoVaziaException {
		if(habitat == null) {
			throw new InsercaoVaziaException(); }

		else { 
        		this.habitat = habitat; }
	}



	//Metodo que usa reflexividade
	public void setHabitatNomeHab(String nomeHab) throws InsercaoVaziaException {
		if(nomeHab == null || nomeHab.isEmpty()) {
			throw new InsercaoVaziaException(); }

		else { 
        		getHabitat().setNomeHab(nomeHab); }
	 }

	//Metodo que usa reflexividade
	public void setHabitatTemperatura(int temperatura) throws ValorVazioException {
		if(temperatura == 0) {
			throw new ValorVazioException(); }

		else { 
        		getHabitat().setTemperatura(temperatura); }
	 }

	//Metodo que usa reflexividade
	public void setHabitatArea(double area) throws ValorVazioException {
		if(area == 0.0) {
			throw new ValorVazioException(); }

		else { 
        		getHabitat().setArea(area); }
	 }

	//Metodo que usa reflexividade
	public void setHabitatSolo(String solo) throws InsercaoVaziaException {
		if(solo == null || solo.isEmpty()) {
			throw new InsercaoVaziaException(); }

		else { 
        		getHabitat().setSolo(solo); }
	 }


	public abstract void comer();

	public abstract void mover();
}
