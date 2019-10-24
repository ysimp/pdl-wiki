package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Page {
	private String nomPage;
	private List<Tableau> listeTableau;
	private int TotalTableau;
	
	



	public Page() {
		
		listeTableau=new ArrayList<Tableau>();
	}


	
	public List<Tableau> getListeTableau() {
		return listeTableau;
	}

	public void setListeTableau(List<Tableau> listeTableau) {
		this.listeTableau = listeTableau;
	}

	public String getNomPage() {
		return nomPage;
	}

	public void setNomPage(String nomPage) {
		this.nomPage = nomPage;
	}


	
	public void addTableau(Tableau table) {
		Objects.requireNonNull(table, "Impossible d'ajouter null dans le tableau");
		listeTableau.add(table);
	}
	
	public int getNombreTable()
	{
		return listeTableau.size();
	}
	
	public int getTotalTableau() {
		return TotalTableau;
	}



	public void setTotalTableau(int totalTableau) {
		TotalTableau = totalTableau;
	}
	
	public int getNbIgnoredTables() {
		return getTotalTableau() - getNombreTable();
	}

}
