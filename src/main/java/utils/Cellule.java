package utils;

public class Cellule {
	private int numeroCellule;
	private String donneeCellule;
	
	public Cellule(int numeroCellule, String donneeCellule) {
		super();
		this.numeroCellule = numeroCellule;
		this.donneeCellule = donneeCellule;
	}
	
	public int getNumeroCellule() {
		return numeroCellule;
	}
	public void setNumeroCellule(int numeroCellule) {
		this.numeroCellule = numeroCellule;
	}
	public String getDonneeCellule() {
		return donneeCellule;
	}
	public void setDonneeCellule(String donneeCellule) {
		this.donneeCellule = donneeCellule;
	}
	
	

}
