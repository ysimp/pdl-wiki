package jsoup;

import org.jsoup.select.Elements;

import utils.Page;
public interface ExtractorHtml {

/**
 * Permet d'extraire les tableaux dans une page (url)
 * @parm url du page wikipedia
 * @return les tableaux extrait de la page
 * @throws Exception 
 * @throws
 * @throws
 *
 * */
	
	public Page  extractTables(String url) throws Exception ;
	
	
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