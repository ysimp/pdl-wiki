package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hajar 
 * @author Jihad
 * @author yaya
 * @author El Mahjoub
 *
 */
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
		
	}

}
