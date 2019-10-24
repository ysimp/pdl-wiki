package jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import utils.Ligne;
import utils.Page;
import utils.Tableau;


public class ExtractorHtmlImp implements ExtractorHtml{
	
	public boolean Connection(String url) {
		try {
			Jsoup.connect(url).get();
			return true;
		} catch (IOException e) {
			System.out.println("Erreur de connexion, vous vous êtes sans doute trompé dans la saisie de l'url");
			return false;
		}
	}

	public Page extractTables(String url) throws Exception{
		
		Elements rows = null;
	    Elements tds = null;
	    Elements tables = null;
	    Page page =new Page();
	    String cellule;
	    Ligne line;
	    Tableau tab;
	    int numTab=1;
	    
		if (Connection(Constant.EN_BASE_WIKIPEDIA_URL + url)){
		Document doc = Jsoup.connect(Constant.EN_BASE_WIKIPEDIA_URL + url).get();
		tables = doc.select("table");
    	//page.setTotalTableau(tables.size());
		
		//Parcours du tableau
		for (Element t : tables) {
			tab = new Tableau();
			tab.setNumeroTableau(numTab);
			numTab++;
			rows = t.select("tr");
			 
			 //Parcours toutes les lignes 
			for (Element row : rows) {
				 line = new Ligne();
				 
				tds = row.select("th,td");
				
				//Pour chaque Colonne de la ligne on recupère le contenu
				for (Element td : tds) {
					
					cellule =  td.text().toString();
					cellule= CSVUtils.assureFomatCSV(cellule);
					line.addCellule(cellule);
				}
				
				tab.addLine(line);
			}
			
			 page.addTableau(tab);
		}
	
		}
		return page;
	}

	public Elements filterTables(Elements tables) {
		// TODO Auto-generated method stub
		return null;
	}

}
