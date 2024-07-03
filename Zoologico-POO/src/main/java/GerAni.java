//Nome: Gabriel Kenji Inoue
//RA: 2504170

import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerAni{
    private Anfibio anf;
    private Ave ave;
    private Mamifero mam;
    private Peixe pei;
    private Reptil rep;
    
    private List<Anfibio> bdAnf;
    private List<Ave> bdAve;
    private List<Mamifero> bdMam;
    private List<Peixe> bdPei;
    private List<Reptil> bdRep;
    
    private static GerAni gpUnic;
    
    private GerAni(){
        bdAnf = new ArrayList<Anfibio>();
        bdAve = new ArrayList<Ave>();
        bdMam = new ArrayList<Mamifero>();
        bdPei = new ArrayList<Peixe>();
        bdRep = new ArrayList<Reptil>();
    }
        
    //Singleton
    public static GerAni geraGerAni(){
        if(gpUnic == null){
            gpUnic = new GerAni();
        }
        return gpUnic;
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
    
    public List<Peixe> getBdPeixe(){
        return bdPei;
    }
    
    public List<Reptil> getBdRep(){
        return bdRep;
    }
        
    public Anfibio insAnf(Anfibio anf){
	if(consAnf(anf)== null){
            bdAnf.add(anf);
            return anf;
	}
        
	else{
            return null;
	}
    }

    public Anfibio consAnf(Anfibio anf){
	for(int i = 0; i < bdAnf.size(); i++){
            if(anf.getNome().equals(bdAnf.get(i).getNome())){
		return bdAnf.get(i);
            }    
	}
        
	return null;
    }

    public Anfibio delAnf(Anfibio anf){
        Anfibio anf2 = consAnf(anf);
            if(anf2 != null){
                bdAnf.remove(anf2);
                return null;
            }
            
            else{
                return anf;
            }	
    }

    public void atualizaAnf(Anfibio anf){
        for(int i = 0; i < bdAnf.size(); i++){
            if(anf.getNome().equals(bdAnf.get(i).getNome())){
                bdAnf.set(i, anf);
                
                JOptionPane.showMessageDialog(
                null,
                "SUCESSO AO ATUALIZAR!",
                "ATUALIZAÇÃO DE ANFIBIO",
                1
                );
                
                break;
            }
        }
    }
    
    
    
    
    public Ave insAve(Ave ave){
	if(consAve(ave)== null){
            bdAve.add(ave);
            return ave;
	}
        
	else{
            return null;
	}
    }

    public Ave consAve(Ave ave){
	for(int i = 0; i < bdAve.size(); i++){
            if(ave.getNome().equals(bdAve.get(i).getNome())){
		return bdAve.get(i);
            }    
	}
        
	return null;
    }

    public Ave delAve(Ave ave){
        Ave ave2 = consAve(ave);
            if(ave2 != null){
                bdAve.remove(ave2);
                return null;
            }
            
            else{
                return ave;
            }	
    }

    public void atualizaAve(Ave ave){
        for(int i = 0; i < bdAve.size(); i++){
            if(ave.getNome().equals(bdAve.get(i).getNome())){
                bdAve.set(i, ave);
                
                JOptionPane.showMessageDialog(
                null,
                "SUCESSO AO ATUALIZAR!",
                "ATUALIZAÇÃO DE AVE",
                1
                );
                
                break;
            }
        }
    }

    
    
    public Mamifero insMam(Mamifero mam){
	if(consMam(mam)== null){
            bdMam.add(mam);
            return mam;
	}
        
	else{
            return null;
	}
    }

    public Mamifero consMam(Mamifero mam){
	for(int i = 0; i < bdMam.size(); i++){
            if(mam.getNome().equals(bdMam.get(i).getNome())){
		return bdMam.get(i);
            }    
	}
        
	return null;
    }

    public Mamifero delMam(Mamifero mam){
        Mamifero mam2 = consMam(mam);
            if(mam2 != null){
                bdMam.remove(mam2);
                return null;
            }
            
            else{
                return mam;
            }	
    }

    public void atualizaMam(Mamifero mam){
        for(int i = 0; i < bdMam.size(); i++){
            if(mam.getNome().equals(bdMam.get(i).getNome())){
                bdMam.set(i, mam);
                
                JOptionPane.showMessageDialog(
                null,
                "SUCESSO AO ATUALIZAR!",
                "ATUALIZAÇÃO DE MAMIFERO",
                1
                );
                
                break;
            }
        }
    }
    
    
    
    
    public Peixe insPei(Peixe pei){
	if(consPei(pei)== null){
            bdPei.add(pei);
            return pei;
	}
        
	else{
            return null;
	}
    }

    public Peixe consPei(Peixe pei){
	for(int i = 0; i < bdPei.size(); i++){
            if(pei.getNome().equals(bdPei.get(i).getNome())){
		return bdPei.get(i);
            }    
	}
        
	return null;
    }

    public Peixe delPei(Peixe pei){
        Peixe pei2 = consPei(pei);
            if(pei2 != null){
                bdPei.remove(pei2);
                return null;
            }
            
            else{
                return pei;
            }	
    }

    public void atualizaPei(Peixe pei){
        for(int i = 0; i < bdPei.size(); i++){
            if(pei.getNome().equals(bdPei.get(i).getNome())){
                bdPei.set(i, pei);
                
                JOptionPane.showMessageDialog(
                null,
                "SUCESSO AO ATUALIZAR!",
                "ATUALIZAÇÃO DE PEIXE",
                1
                );
                
                break;
            }
        }
    }
    
    
    
    public Reptil insRep(Reptil rep){
	if(consRep(rep)== null){
            bdRep.add(rep);
            return rep;
	}
        
	else{
            return null;
	}
    }

    public Reptil consRep(Reptil pei){
	for(int i = 0; i < bdRep.size(); i++){
            if(pei.getNome().equals(bdRep.get(i).getNome())){
		return bdRep.get(i);
            }    
	}
        
	return null;
    }

    public Reptil delRep(Reptil rep){
        Reptil rep2 = consRep(rep);
            if(rep2 != null){
                bdRep.remove(rep2);
                return null;
            }
            
            else{
                return rep;
            }	
    }

    public void atualizaRep(Reptil rep){
        for(int i = 0; i < bdRep.size(); i++){
            if(rep.getNome().equals(bdRep.get(i).getNome())){
                bdRep.set(i, rep);
                
                JOptionPane.showMessageDialog(
                null,
                "SUCESSO AO ATUALIZAR!",
                "ATUALIZAÇÃO DE REPTIL",
                1
                );
                
                break;
            }
        }
    }
}