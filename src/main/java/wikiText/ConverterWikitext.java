package wikiText;

import org.jsoup.nodes.Element;

public interface ConverterWikitext {
	
	/***
	 * Prend un tableau et l'ecrit dans un fichier CSV
	 * @param tableau
	 * @return void
	 **/
	public void convertTableToCsv(Element table ) ;
	
	/**
	 * Ecrit sous format CSV tous les tableaux d'une page donnée
	 * @param url
	 * */
	public void convertAllTablesToCsv(String url)  throws Exception ;
	
	/**
	 * Lit le fchier input et pour chaque url convertit les tableaux
	 * appelle la methode convertAllTablesToCsv
	 * 
	 * */
	public void convertAllPages() throws Exception;

}
