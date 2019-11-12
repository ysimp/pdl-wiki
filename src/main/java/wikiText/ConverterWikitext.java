package wikiText;

public interface ConverterWikitext {
	
	
	
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
