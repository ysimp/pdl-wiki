package html;

import org.jsoup.select.Elements;

import model.Page;
public interface ExtractorHtml {

/**
 * Permet d'extraire les tableaux dans une page (url)
 * @parm url du page wikipedia
 * @return les tableaux extrait de la page
 * @throws
 * @throws
 *
 * */
	
	public Page  extractTables(String url, boolean filter ) throws Exception ;
	
	
	
	
	
	
}
