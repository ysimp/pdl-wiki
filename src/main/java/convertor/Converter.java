package convertor;

import org.jsoup.nodes.Document;

public interface Converter {

	/**
	 * Ecrit sous format CSV tous les tableaux d'une page donnée
	 * @param url
	 * appelle la methode convertTableToCsv
	 * */
	public void convertAllTablesToCsv(Document doc,String url,String output) throws Exception;

	
}
