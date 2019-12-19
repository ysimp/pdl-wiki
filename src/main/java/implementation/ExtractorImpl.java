package implementation;

import java.util.logging.Logger;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Interface.Extractor;
import model.Ligne;
import model.Page;
import model.Tableau;
import utils.CSVUtils;
import utils.FilterTable;

/**
 * @author Hajar 
 * @author Jihad
 * @author yaya
 * @author El Mahjoub
 *
 */

public class ExtractorImpl implements Extractor {

 Logger logger ;
	
 FilterTable filter;

public ExtractorImpl()
{
	filter=new FilterTable();
	logger = Logger.getLogger("Logger");
}

public ExtractorImpl(FilterTable filter)
{
	this.filter=filter;
	logger = Logger.getLogger("Logger");
}

/**
 * {@inheritDoc}
 */
public Page extractTables(Document docHtml,boolean withfilter) throws Exception {
		
		
	    Elements rows = null;
	    Elements tds = null;
	    Elements tables = null;
	    Page page =new Page();
	    String cell;
	    Ligne line;
	    Tableau tab;
	    int numTab=1;
	    	
		if (docHtml != null) {
	   
	    	tables = docHtml.select("table"); // recupere les tableau dans la page 
	    	
	    	page.setTotalTableau(tables.size());
	    	
	    	// application du filter si c'est demande
	    	if(withfilter)
	    	tables =filter.filterTables(docHtml);
	    	
	    	
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
						
						cell =  td.text().toString();
						cell= CSVUtils.assureFomatCSV(cell);
						line.addCellule(cell);
					}
					
					tab.addLine(line);
				}
				
				 page.addTableau(tab);
			}
		
		}

		return page;
	}
}
