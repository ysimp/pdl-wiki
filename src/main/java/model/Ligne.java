package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ligne {
	
	private int numeroLigne;

	private List<String> listCelluleLigne;
	
	public Ligne() {
		this.listCelluleLigne=new ArrayList<String>();
	}
	
	
	public int getNumeroLigne() {
		return numeroLigne;
	}

	public void setNumeroLigne(int numeroLigne) {
		this.numeroLigne = numeroLigne;
	}

	public List<String> getListCelluleLigne() {
		return listCelluleLigne;
	}

	public void setListCelluleLigne(List<String> listCelluleLigne) {
		this.listCelluleLigne = listCelluleLigne;
	}

	public void addCellule(String cell) {
		listCelluleLigne.add(cell);
	}
	
	public String toString() {
		
		return this.listCelluleLigne.stream().collect(Collectors.joining(", "));
		
		/*
		 * for (int i=0; i< this.listCelluleLigne.size(); i++) {
		 * sb.append(listCelluleLigne.get(i)); if(i<this.listCelluleLigne.size()-1) {
		 * 
		 * } }
		 */
	}

}
