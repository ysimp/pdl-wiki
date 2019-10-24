package utils;

import java.util.List;

public class Ligne {
	private int numeroLigne;
	private List<String> ligne;
	private List<Cellule> listCelluleLigne;
	
	public Ligne() {}
	
	public Ligne(List<String> ligneTableau) {
		super();
		this.ligne = ligneTableau;
	}
	
	
   

	public List<Cellule> getListCelluleLigne() {
		return listCelluleLigne;
	}

	public void setListCelluleLigne(List<Cellule> listCelluleLigne) {
		this.listCelluleLigne = listCelluleLigne;
	}

	public int getNumeroLigne() {
		return numeroLigne;
	}

	public void setNumeroLigne(int numeroLigne) {
		this.numeroLigne = numeroLigne;
	}

	public List<String> getLigneTableau() {
		return ligne;
	}

	public void setLigneTableau(List<String> ligneTableau) {
		this.ligne = ligneTableau;
	}
	
	

}
