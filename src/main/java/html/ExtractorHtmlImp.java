package html;

import java.io.IOException;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.Ligne;
import model.Page;
import model.Tableau;
import utils.CSVUtils;
import utils.Constant;
import utils.filterTable;


public class ExtractorHtmlImp implements ExtractorHtml{
	
	Logger loggerHTML = Logger.getLogger("WikiLoger");

	 private filterTable  filter= new filterTable();
	
	public Document Connection(String url) {
		try {
			Document doc=Jsoup.connect(url).get();
			return doc;
		} catch (IOException e) {
			loggerHTML.info("Erreur de connexion, vous vous êtes sans doute trompé dans la saisie de l'url"+" "+url);
			return null;
		}
	}

	public Page extractTables(String url,boolean filte) throws Exception{
		
		Elements rows = null;
	    Elements tds = null;
	    Elements tables = null;
	    Page page =new Page();
	    String cellule;
	    Ligne line;
	    Tableau tab;
	    int numTab=1;
	    Document doc= Connection(Constant.BASE_WIKIPEDIA_URL + url);

			if(doc!=null)
		
		tables = doc.select("table");
		
    	page.setTotalTableau(tables.size());
    	if(filte)
    	tables =filter.filterTables(doc);

		
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

	

}
