//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Principal{
	static Leitura leitura = new Leitura();

	public static void main(String[] args) {
		int opcao = 0;


		do{
			opcao = (Integer.parseInt(leitura.entDados("\nDigite qual animal queira registrar:\n1- ANFIBIO\n2- AVE\n3- MAMIFERO\n4- PEIXE\n5- REPTIL ")));
				switch (opcao) {
					case 1: 
						registraAnfibio();
						break;

					case 2:
						registraAve();
						break;

					case 3:		
						registraMamifero();
						break;

					case 4:
						registraPeixe();
						break;

					case 5:
						registraReptil();
						break;

					default:
						System.out.println("Opcao invalida"); } 
		
		}
		while(opcao < 1 || opcao > 5);	}


	public static void registraAnfibio() {
		try {
			Anfibio anfibio = new Anfibio();
			System.out.println("\nInsira as informacoes do animal Anfibio: \n");
	
			anfibio.setNome(leitura.entDados("Nome do Anfibio..: "));
			anfibio.setIdade(Integer.parseInt(leitura.entDados("Idade do Anfibio em anos..: ")));
			anfibio.setPeso(Double.parseDouble(leitura.entDados("Peso do Anfibio em quilos..: ")));
			anfibio.setAltura(Double.parseDouble(leitura.entDados("Altura do Anfibio em centimetros..: ")));
			anfibio.setEspecie(leitura.entDados("Especie do Anfibio..: "));
			anfibio.setSexo(Boolean.parseBoolean(leitura.entDados("Digite 'true' para o sexo masculino e 'false' para o sexo feminino do Anfibio..: ")));
			anfibio.setCarnivoro(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o Anfibio coma carne ou 'false' caso ele nao coma..: ")));
			anfibio.setHerbivoro(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o Anfibio coma algo de origem vegetal ou 'false' caso ele nao coma..: ")));
	
			anfibio.setHabitatNomeHab(leitura.entDados("Digite o nome do habitat do anfibio: "));
			anfibio.setHabitatTemperatura(Integer.parseInt(leitura.entDados("Digite a temperatura media em graus do habitat do anfibio..: ")));
			anfibio.setHabitatArea(Double.parseDouble(leitura.entDados("Digite a area quadrada em metros do habitat do anfibio..: ")));
			anfibio.setHabitatSolo(leitura.entDados("Digite como eh o solo do habitat anfibio..: "));

			anfibio.setPatas(Integer.parseInt(leitura.entDados("Digite quantas patas o Anfibio contem..: ")));
			anfibio.setMetamorfose(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o animal ja fez metamorfose e 'false' para caso nao tenha ocorrido..: ")));

			System.out.println("\n\n\n=================================================\n");
		
			System.out.println("\n\nNome do anfibio: " + anfibio.getNome());
			System.out.println("Idade em anos do anfibio: " + anfibio.getIdade());
			System.out.println("Peso em quilos do anfibio: " + anfibio.getPeso());
			System.out.println("Altura em centimetros do anfibio: " + anfibio.getAltura());
			System.out.println("Especie do anfibio: " + anfibio.getEspecie());

			if(anfibio.getSexo()) { 
				System.out.println("O anfibio eh masculino "); }
			else {
				System.out.println("O anfibio eh feminino"); }
			
			anfibio.comer();
			System.out.println("Habitat do anfibio: " + anfibio.getHabitatNomeHab());
			System.out.println("Temperatura media em graus do habitat: " + anfibio.getHabitatTemperatura());
			System.out.println("Area do habitat: " + anfibio.getHabitatArea());
			System.out.println("Como eh o solo do habitat: " + anfibio.getHabitatSolo());

			anfibio.mover();
	 		anfibio.transmutar(); }

		catch(InsercaoVazia iv){
			iv.InsercaoVazia(); }

		catch(ValorVazio vv){
			vv.ValorVazio(); }

		finally { 
			System.out.println("\nPrograma finalizado"); }
	}


	public static void registraAve() {
		try {
			Ave ave = new Ave();

			System.out.println("\n\n\nInsira as informacoes do animal Ave: \n");
			ave.setNome(leitura.entDados("Nome da Ave..: "));
			ave.setIdade(Integer.parseInt(leitura.entDados("Idade da Ave em anos..: ")));
			ave.setPeso(Double.parseDouble(leitura.entDados("Peso da Ave em quilos..: ")));
			ave.setAltura(Double.parseDouble(leitura.entDados("Altura da Ave em centimetros..: ")));
			ave.setEspecie(leitura.entDados("Especie da Ave..: "));
			ave.setSexo(Boolean.parseBoolean(leitura.entDados("Digite 'true' para o sexo masculino e 'false' para o sexo feminino da Ave..: ")));
			ave.setCarnivoro(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso a Ave coma carne ou 'false' caso ele nao coma..: ")));
			ave.setHerbivoro(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso a Ave coma algo de origem vegetal ou 'false' caso ele nao coma..: ")));

			ave.setHabitatNomeHab(leitura.entDados("Digite o nome do habitat da ave: "));
			ave.setHabitatTemperatura(Integer.parseInt(leitura.entDados("Digite a temperatura media em graus do habitat da ave..: ")));
			ave.setHabitatArea(Double.parseDouble(leitura.entDados("Digite a area quadrada em metros do habitat da ave..: ")));
			ave.setHabitatSolo(leitura.entDados("Digite como eh o solo do habitat da ave..: "));

			ave.setPatas(Integer.parseInt(leitura.entDados("Digite quantas patas a Ave contem..: ")));
			ave.setAsas(Integer.parseInt(leitura.entDados("Digite quantas asas a Ave contem..: ")));
			ave.setVoo(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o animal voa e 'false' para caso nao voe..: ")));
	
			if(ave.getVoo()) {
				ave.setVooMax(Integer.parseInt(leitura.entDados("Digite a altura maxima que a Ave pode voar..: "))); }

			System.out.println("\n=================================================\n");
		
			System.out.println("\n\nNome da ave: " + ave.getNome());
			System.out.println("Idade em anos da ave: " + ave.getIdade());
			System.out.println("Peso em quilos da ave: " + ave.getPeso());
			System.out.println("Altura em centimetros da ave: " + ave.getAltura());
			System.out.println("Especie da ave: " + ave.getEspecie());
	
			if(ave.getSexo()) { 
				System.out.println("A ave eh masculino "); }
			else {
				System.out.println("A ave eh feminino"); }
			
			ave.comer();
	
			System.out.println("Habitat da ave: " + ave.getHabitatNomeHab());
			System.out.println("Temperatura media em graus do habitat: " + ave.getHabitatTemperatura());
			System.out.println("Area do habitat: " + ave.getHabitatArea());
			System.out.println("Como eh o solo do habitat: " + ave.getHabitatSolo());

			ave.mover(); }

		catch(InsercaoVazia iv){
			iv.InsercaoVazia(); }

		catch(ValorVazio vv){
			vv.ValorVazio(); }

		finally { 
			System.out.println("\nPrograma finalizado"); }
	}

	public static void registraMamifero() {
		try {
			Mamifero mamifero = new Mamifero();

			System.out.println("\n\n\nInsira as informacoes do animal Mamifero: \n");
			mamifero.setNome(leitura.entDados("Nome do Mamifero..: "));
			mamifero.setIdade(Integer.parseInt(leitura.entDados("Idade do Mamifero em anos..: ")));
			mamifero.setPeso(Double.parseDouble(leitura.entDados("Peso do Mamifero em quilos..: ")));
			mamifero.setAltura(Double.parseDouble(leitura.entDados("Altura do Mamifero em centimetros..: ")));
			mamifero.setEspecie(leitura.entDados("Especie do Mamifero..: "));
			mamifero.setSexo(Boolean.parseBoolean(leitura.entDados("Digite 'true' para o sexo masculino e 'false' para o sexo feminino do Mamifero..: ")));
			mamifero.setCarnivoro(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o Mamifero coma carne ou 'false' caso ele nao coma..: ")));
			mamifero.setHerbivoro(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o Mamifero coma algo de origem vegetal ou 'false' caso ele nao coma..: ")));

			mamifero.setHabitatNomeHab(leitura.entDados("Digite o nome do habitat do Mamifero: "));
			mamifero.setHabitatTemperatura(Integer.parseInt(leitura.entDados("Digite a temperatura media em graus do habitat do Mamifero..: ")));
			mamifero.setHabitatArea(Double.parseDouble(leitura.entDados("Digite a area quadrada em metros do habitat do Mamifero..: ")));
			mamifero.setHabitatSolo(leitura.entDados("Digite como eh o solo do habitat Mamifero..: "));

			mamifero.setPatas(Integer.parseInt(leitura.entDados("Digite quantas patas o Mamifero contem..: ")));

			if(!mamifero.getSexo()) {
				mamifero.setTempoGestacao(Integer.parseInt(leitura.entDados("Digite o tempo em semanas dura a gestacao do animal..: "))); }

			mamifero.setCaminha(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o animal ande/caminhe e 'false' para caso nao ande/caminhe..: ")));

			System.out.println("\n=================================================\n");
			System.out.println("\n\nNome do mamifero: " + mamifero.getNome());
			System.out.println("Idade em anos do mamifero: " + mamifero.getIdade());
			System.out.println("Peso em quilos do mamifero: " + mamifero.getPeso());
			System.out.println("Altura em centimetros do mamifero: " + mamifero.getAltura());
			System.out.println("Especie do mamifero: " + mamifero.getEspecie());

			if(mamifero.getSexo()) { 
				mamifero.informarGestacao(); }
			else {
				mamifero.informarGestacao(mamifero.getTempoGestacao()); }
			
			mamifero.comer();

			System.out.println("Habitat do mamifero: " + mamifero.getHabitatNomeHab());
			System.out.println("Temperatura media em graus do habitat: " + mamifero.getHabitatTemperatura());
			System.out.println("Area do habitat: " + mamifero.getHabitatArea());
			System.out.println("Como eh o solo do habitat: " + mamifero.getHabitatSolo());
			mamifero.mover(); }

		catch(InsercaoVazia iv){
			iv.InsercaoVazia(); }

		catch(ValorVazio vv){
			vv.ValorVazio(); }

		finally { 
			System.out.println("\nPrograma finalizado"); }
	}

	public static void registraPeixe() {
		try {
			Peixe peixe = new Peixe();
			System.out.println("\n\n\nInsira as informacoes do animal Peixe: \n");

			peixe.setNome(leitura.entDados("Nome do Peixe..: "));
			peixe.setIdade(Integer.parseInt(leitura.entDados("Idade do Peixe em anos..: ")));
			peixe.setPeso(Double.parseDouble(leitura.entDados("Peso do Peixe em quilos..: ")));
			peixe.setAltura(Double.parseDouble(leitura.entDados("Altura do Peixe em centimetros..: ")));
			peixe.setEspecie(leitura.entDados("Especie do Peixe..: "));
			peixe.setSexo(Boolean.parseBoolean(leitura.entDados("Digite 'true' para o sexo masculino e 'false' para o sexo feminino do Peixe..: ")));
			peixe.setCarnivoro(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o Peixe coma carne ou 'false' caso ele nao coma..: ")));
			peixe.setHerbivoro(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o Peixe coma algo de origem vegetal ou 'false' caso ele nao coma..: ")));

			peixe.setHabitatNomeHab(leitura.entDados("Digite o nome do habitat do Peixe: "));
			peixe.setHabitatTemperatura(Integer.parseInt(leitura.entDados("Digite a temperatura media em graus do habitat do Peixe..: ")));
			peixe.setHabitatArea(Double.parseDouble(leitura.entDados("Digite a area quadrada em metros do habitat do Peixe..: ")));
			peixe.setHabitatSolo(leitura.entDados("Digite como eh o solo do aquario do habitat Peixe..: "));

			peixe.setNadadeiras(Integer.parseInt(leitura.entDados("Digite quantas nadadeiras o Peixe contem..: ")));
			peixe.setNada(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o peixe consiga nadar e 'false' para caso ele nao consiga..: ")));

			if(peixe.getNada()) {
				peixe.setProfundidadeMax(Integer.parseInt(leitura.entDados("Digite a profundidade maxima que o peixe consegue nadar..: "))); }
		
			System.out.println("\n=================================================\n");

			System.out.println("\n\nNome do peixe: " + peixe.getNome());
			System.out.println("Idade em anos do peixe: " + peixe.getIdade());
			System.out.println("Peso em quilos do peixe: " + peixe.getPeso());
			System.out.println("Altura em centimetros do peixe: " + peixe.getAltura());
			System.out.println("Especie do peixe: " + peixe.getEspecie());

			if(peixe.getSexo()) { 
				System.out.println("O peixe eh masculino "); }
			else {
				System.out.println("O peixe eh feminino "); }
			
			peixe.comer();

			System.out.println("Habitat do peixe: " + peixe.getHabitatNomeHab());
			System.out.println("Temperatura media em graus do habitat: " + peixe.getHabitatTemperatura());
			System.out.println("Area do habitat: " + peixe.getHabitatArea());
			System.out.println("O solo do habitat do aquario eh : " + peixe.getHabitatSolo());

			peixe.mover(); }

		catch(InsercaoVazia iv){
			iv.InsercaoVazia(); }

		catch(ValorVazio vv){
			vv.ValorVazio(); }

		finally { 
			System.out.println("\nPrograma finalizado"); }
	}

	public static void registraReptil() {
		try { 
			Reptil reptil = new Reptil();
			System.out.println("\n\n\nInsira as informacoes do animal Reptil: \n");

			reptil.setNome(leitura.entDados("Nome do Reptil..: "));
			reptil.setIdade(Integer.parseInt(leitura.entDados("Idade do Reptil em anos..: ")));
			reptil.setPeso(Double.parseDouble(leitura.entDados("Peso do Reptil em quilos..: ")));
			reptil.setAltura(Double.parseDouble(leitura.entDados("Altura do Reptil em centimetros..: ")));
			reptil.setEspecie(leitura.entDados("Especie do Reptil..: "));
			reptil.setSexo(Boolean.parseBoolean(leitura.entDados("Digite 'true' para o sexo masculino e 'false' para o sexo feminino do Reptil..: ")));
			reptil.setCarnivoro(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o Reptil coma carne ou 'false' caso ele nao coma..: ")));
			reptil.setHerbivoro(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o Reptil coma algo de origem vegetal ou 'false' caso ele nao coma..: ")));

			reptil.setHabitatNomeHab(leitura.entDados("Digite o nome do habitat do Reptil: "));
			reptil.setHabitatTemperatura(Integer.parseInt(leitura.entDados("Digite a temperatura media em graus do habitat do Reptil..: ")));
			reptil.setHabitatArea(Double.parseDouble(leitura.entDados("Digite a area quadrada em metros do habitat do Reptil..: ")));
			reptil.setHabitatSolo(leitura.entDados("Digite como eh o solo habitat Reptil..: "));

			reptil.setPatas(Integer.parseInt(leitura.entDados("Digite quantas patas o Reptil contem..: ")));
			reptil.setVeneno(Boolean.parseBoolean(leitura.entDados("Digite 'true' caso o Reptil tenha veneno e 'false' caso ele nao tenha..: ")));

			System.out.println("\n=================================================\n");
			System.out.println("\n\nNome do reptil: " + reptil.getNome());
			System.out.println("Idade em anos do reptil: " + reptil.getIdade());
			System.out.println("Peso em quilos do reptil: " + reptil.getPeso());
			System.out.println("Altura em centimetros do reptil: " + reptil.getAltura());
			System.out.println("Especie do reptil: " + reptil.getEspecie());

			if(reptil.getSexo()) { 
				System.out.println("O reptil eh masculino "); }
			else {
				System.out.println("O reptil eh feminino "); }
			
			reptil.comer();
	
			System.out.println("Habitat do reptil: " + reptil.getHabitatNomeHab());
			System.out.println("Temperatura media em graus do habitat: " + reptil.getHabitatTemperatura());
			System.out.println("Area do habitat: " + reptil.getHabitatArea());
			System.out.println("O solo do habitat eh : " + reptil.getHabitatSolo());

			reptil.mover(); }

		catch(InsercaoVazia iv){
			iv.InsercaoVazia(); }

		catch(ValorVazio vv){
			vv.ValorVazio(); }

		finally { 
			System.out.println("\nPrograma finalizado"); }
	}

} 

	

	

	

	

	
