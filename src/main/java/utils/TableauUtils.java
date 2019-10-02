package utils;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TableauUtils {
	
// le nombre de tableau dans un document
int nbreTables(Document document) {
		
	    Elements tables = null;
		tables = document.select("table"); 
		if (tables.size() == 0) {
			System.out.println(" Attention !!! La page à l'étude n'a pas de tableau ...");
		}
		System.out.println("le nombre de tableau de la page à l'étude est : "+ tables.size());
		return tables.size();	
	}

}
