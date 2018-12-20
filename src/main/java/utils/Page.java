package utils;

import java.util.List;

public class Page {
	private String nomPage;
	private List<Tableau> page;
	
	public Page() {}

	public Page(List<Tableau> page) {
		super();
		this.page = page;
	}
	
	

	public String getNomPage() {
		return nomPage;
	}

	public void setNomPage(String nomPage) {
		this.nomPage = nomPage;
	}

	public List<Tableau> getPage() {
		return page;
	}

	public void setPage(List<Tableau> page) {
		this.page = page;
	}
	
	

}
