package Interface;

import org.jsoup.nodes.Document;

/**
 * @author Hajar 
 * @author Jihad
 * @author yaya
 * @author El Mahjoub
 * @author kONATE
 */
public interface Converter {

	/**
	 * 
	 * genere des fichiers CSV a partir des tableaux d'une page donnée
	 * elle fait appel au extractor pour extraire la page 
	 * @param url lien wikipedia
	 * @param doc document a extraire ( soit document html ou wikitext )
	 * @param output  ou sera stocke le fichier generer 
	 * appelle la methode convertTableToCsv
	 * */
	public void convertAllTablesToCsv(Document doc,String url,String output) throws Exception;

	
}
