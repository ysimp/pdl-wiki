package utils;

import java.util.List;

public class Tableau {
	private int numeroTableau;
	private List<Ligne> tableau;
	
	public Tableau(){}

	public Tableau(List<Ligne> tableau) {
		super();
		this.tableau = tableau;
	}
	
	

	public int getNumeroTableau() {
		return numeroTableau;
	}

	public void setNumeroTableau(int numeroTableau) {
		this.numeroTableau = numeroTableau;
	}

	public List<Ligne> getTableau() {
		return tableau;
	}

	public void setLigneTableau(List<Ligne> tableau) {
		this.tableau = tableau;
	}


	
	

}

