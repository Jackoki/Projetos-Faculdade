
package Projeto;

import java.util.List;
import java.util.ArrayList;

public class Habitat_BD2 {
    private List<Habitat> bdHabitat;
    
    private static Habitat_BD2 ProjetoUnic;

    Habitat_BD2(){
        bdHabitat = new ArrayList<Habitat>();
    }
        
    //Singleton
    public static Habitat_BD2 geraHabitat_BD2(){
        if(ProjetoUnic == null){
            ProjetoUnic = new Habitat_BD2();
        }
        return ProjetoUnic;
    }
    
    public List<Habitat> getBdHabitat(){
        return bdHabitat;
    }
    
    public Habitat insHabitat(Habitat habitat){
	if(consHabitat(habitat)== null){
            bdHabitat.add(habitat);
            return habitat;
	}
		
        else{
            return null;
	}
    }

    public Habitat consHabitat(Habitat habitat){
	for(int i = 0; i < bdHabitat.size(); i++){
            if(habitat.getIdHab() == bdHabitat.get(i).getIdHab()){
		return bdHabitat.get(i);
            }
	}
	return null;
    }
    
    
}
