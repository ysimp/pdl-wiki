package wikiText;

import java.io.IOException;

import org.jsoup.select.Elements;

import model.Page;

public interface ExtractorWikitext {

	
		/**
		 * Permet d'extraire les tableaux dans une page (url)
		 * @parm url du page wikipedia
		 * @return les tableaux extrait de la page
		 * @throws IOException
		 * @throws
		 *
		 * */
		
		public Page  extractTables(String url) throws IOException  ;
		
		
		/**
		 * Permet de filtrer les tableaux (url) : supprimer les tableaux qui ne repondent pas aux critère de pertinence
		 * @parm url du page wikipedia
		 * @return les tableaux après filtrage
		 * @throws
		 * @throws
		 * 
		 * */
		public Elements filterTables(Elements tables) throws Exception;
}
