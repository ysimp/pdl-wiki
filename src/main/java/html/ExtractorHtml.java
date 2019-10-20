package html;

import org.jsoup.select.Elements;
public interface ExtractorHtml {

/**
 * Permet d'extraire les tableaux dans une page (url)
 * @parm url du page wikipedia
 * @return les tableaux extrait de la page
 * @throws
 * @throws
 *
 * */
	
	public Elements  extractTables(String url) ;
	
	
	/**
	 * Permet de filtrer les tableaux (url) : supprimer les tableaux qui ne repondent pas aux critère de pertinence
	 * @parm url du page wikipedia
	 * @return les tableaux après filtrage
	 * @throws
	 * @throws
	 * 
	 * */
	public Elements filterTables(Elements tables);
	
	
}
