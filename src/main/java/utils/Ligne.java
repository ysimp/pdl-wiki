package utils;

import java.util.List;

public class Ligne {
	private int numeroLigne;
	private List<String> ligneTableau;
	private List<Cellule> listCelluleLigne;
	
	public Ligne() {}
	
	public Ligne(List<String> ligneTableau) {
		super();
		this.ligneTableau = ligneTableau;
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
		return ligneTableau;
	}

	public void setLigneTableau(List<String> ligneTableau) {
		this.ligneTableau = ligneTableau;
	}
	
	

}
