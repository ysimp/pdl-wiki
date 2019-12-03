package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hajar 
 * @author Jihad
 * @author yaya
 * @author El Mahjoub
 *
 */
public class Tableau {
	
	private int numeroTableau;
	private List<Ligne> listeLignes;
	
	public Tableau(){
		listeLignes=new ArrayList<Ligne>();
		
	}

	
	
	
	public int getNumeroTableau() {
		return numeroTableau;
	}

	public void setNumeroTableau(int numeroTableau) {
		this.numeroTableau = numeroTableau;
	}

	public List<Ligne> getlisteLignes() {
		return listeLignes;
	}

	public void setlisteLignes(List<Ligne> tableau) {
		this.listeLignes = tableau;
	}
	
	public void addLine(Ligne line) {
		
		listeLignes.add(line);
	}


}
