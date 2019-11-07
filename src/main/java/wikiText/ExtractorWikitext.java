package wikiText;

import org.jsoup.nodes.Document;

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
		
		public Page  extractTables(String url, boolean withFilter) throws Exception  ;
		
		/**
		 * Permet de recuperer une page et le tranforme en html
		 * @param WikiUrl : le nom de l'article lit depuis le fichier 
		 * */
		
		public Document getDocumentFromUrl(String url);
}
