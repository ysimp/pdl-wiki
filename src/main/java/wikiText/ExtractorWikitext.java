package wikiText;

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
		
		public Page  extractTables(String url) throws Exception  ;
		
		
}
