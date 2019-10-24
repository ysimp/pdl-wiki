package html;
import org.jsoup.nodes.Element;

public interface ConverterHtml {

	/***
	 * Prend un tableau et l'ecrit dans un fichier CSV
	 * @param tableau
	 * @return void
	 **/
	public void convertTableToCsv(Element table ) ;
	
	/**
	 * Ecrit sous format CSV tous les tableaux d'une page donnée
	 * @param url
	 * appelle la methode convertTableToCsv
	 * */
	public void convertAllTablesToCsv(String url) throws Exception;
	
	/**
	 * Lit le fichier input et pour chaque url convertit les tableaux
	 * appelle la methode convertAllTablesToCsv
	 * 
	 * */
	public void convertAllPages() throws Exception;
	
	
}
