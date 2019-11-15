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
	 * Ecrit sous format CSV tous les tableaux d'une page donnée
	 * @param url
	 * appelle la methode convertTableToCsv
	 * */
	public void convertAllTablesToCsv(Document doc,String url,String output) throws Exception;

	
}
