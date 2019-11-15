package Interface;

import org.jsoup.nodes.Document;

import model.Page;

/**
 * @author Hajar 
 * @author Jihad
 * @author yaya
 * @author El Mahjoub
 * @author kONATE
 */
public interface Extractor {
	
	/**
	 * Permet d'extraire les tableaux dans une page (url)
	 * @parm url du page wikipedia
	 * @return les tableaux extrait de la page
	 * @throws IOException
	 * @throws
	 *
	 * */
	public Page  extractTables(Document doc, boolean filte) throws Exception ;
	

	
}
