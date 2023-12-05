
import javax.swing.JOptionPane;

//Nome: Gabriel Kenji Inoue
//RA: 2504170

public class Reptil extends Animal {
	private int patas;

	//Atributo boolean determina se o animal tem veneno ou nao
	private boolean veneno;

	public Reptil(){
            super();
            this.patas = 0;
            this.veneno = false;
        }

    	public Reptil(String nome, int idade, double peso, double altura, String especie, boolean sexo, Habitat habitat, boolean carnivoro, boolean herbivoro, int patas, boolean veneno) {
            super(nome, idade, peso, altura, especie, sexo, habitat, carnivoro, herbivoro);
            this.patas = patas;
            this.veneno = veneno;
	}

	public int getPatas() {
            return this.patas; }

	public boolean getVeneno() {
            return this.veneno; }
	


	public void setPatas(int patas) throws ValorVazioException {
            if(patas == 0) {
		throw new ValorVazioException(); }

            else { 
        	this.patas = patas; }
	}


	public void setVeneno(boolean veneno) {
 		this.veneno = veneno;
	}

        public void mover(){
            JOptionPane.showMessageDialog(
            null,
            "O animal " + getNome() + " tem " + getPatas() + " patas",
            "ALIMENTAÇÃO",
            1 );
        }
        
	//Método realiza sobrescrita
	public void comer() {
                if(getCarnivoro() && getHerbivoro()) {
                        JOptionPane.showMessageDialog(
                        null,
                        "O animal " + getNome() + " é um animal onivoro e come algas ou vegetais ou frutas e carne animal ou peixes",
                        "ALIMENTAÇÃO",
                        1
                    ); 
                }
	
		else if(getCarnivoro()) {
                    JOptionPane.showMessageDialog(
                    null,
                    "O animal " + getNome() + " é um animal carnívoro e come carne animal ou peixes",
                    "ALIMENTAÇÃO",
                    1 );   
                }

		else {
                    JOptionPane.showMessageDialog(
                    null,
                    "O animal " + getNome() + " é um animal herbivoro e come algas ou vegetais ou frutas",
                    "ALIMENTAÇÃO",
                    1 );  
                    }
        } 

	//Método realiza sobrescrita
	public void veneno() {
            if(getVeneno()) {
                JOptionPane.showMessageDialog(
                null,
                "O reptil com " + getPatas() +" tem veneno, tome cuidado!",
                "VENENO",
                1 );  
            }
            
            else { 
                JOptionPane.showMessageDialog(
                null,
                "O reptil com " + getPatas() + " não tem veneno, pode ficar tranquilo!",
                "VENENO",
                1 
                );
            }
	}
}
