package Projeto;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Animal_BD2 {
    
    private List<Animal> bdAnimal;
    private List<Anfibio> bdAnf;
    private List<Ave> bdAve;
    private List<Mamifero> bdMam;
    private List<Peixe> bdPei;
    private List<Reptil> bdRep;
    
    private static Animal_BD2 ProjetoUnic;

    Animal_BD2(){
        bdAnimal = new ArrayList<Animal>();
        bdAnf = new ArrayList<Anfibio>();
        bdAve = new ArrayList<Ave>();
        bdMam = new ArrayList<Mamifero>();
        bdPei = new ArrayList<Peixe>();
        bdRep = new ArrayList<Reptil>();
    }
        
    //Singleton
    public static Animal_BD2 geraAnimal_BD2(){
        if(ProjetoUnic == null){
            ProjetoUnic = new Animal_BD2();
        }
        return ProjetoUnic;
    }
    
    public List<Animal> getBdAnimal(){
        return bdAnimal;
    }
    
    public List<Anfibio> getBdAnf(){
        return bdAnf;
    }
    
    public List<Ave> getBdAve(){
        return bdAve;
    }
    
    public List<Mamifero> getBdMam(){
        return bdMam;
    }
    
    public List<Peixe> getBdPei(){
        return bdPei;
    }
        
    public List<Reptil> getBdRep(){
        return bdRep;
    }
    
    public Animal insAnimal(Animal animal){
	if(consAnimal(animal)== null){
            bdAnimal.add(animal);
            return animal;
	}
		
        else{
            return null;
	}
    }

    public Animal consAnimal(Animal animal){
	for(int i = 0; i < bdAnimal.size(); i++){
            if(animal.getId() == bdAnimal.get(i).getId()){
		return bdAnimal.get(i);
            }
	}
	return null;
    }

    public Animal delAnimal(Animal animal){
        Animal animal1 = consAnimal(animal);
            if(animal1 != null){
                bdAnimal.remove(animal1);
                return null;
            }
            else{
                return animal;
            }	
    }

    public Animal atuAnimal(Animal animal){
	for(int i = 0; i < bdAnimal.size(); i++){
		if(animal.getId() == bdAnimal.get(i).getId()){
                    animal = bdAnimal.get(i);
                    String nome = JOptionPane.showInputDialog(null, "Informe o NOVO nome", "NOVO NOME",3);
                    animal.setNome(nome);
                    bdAnimal.set(i, animal);  
                    return bdAnimal.get(i);
		}
	}
        return null;
    }  
    
    
    
}
