package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.CSVUtils;
import utils.Constant;
import utils.filterTable;


public class TestFilterTable {

	
	private filterTable filterTable;
	private Document docHtml;
	private List<String> listeUrl;
	/**
	 * @throws Exception 
	 * 
	 */
	
	@BeforeEach
	public  void init() throws Exception
	{
		
		filterTable =new filterTable();
		listeUrl = CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		
		// recuperer le 1er article de wikipedia
		
		docHtml =  Jsoup.connect(Constant.BASE_WIKIPEDIA_URL+listeUrl.get(3)).get();
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void TestremoveTableByClass() throws Exception
	{
		docHtml =Jsoup.connect("https://en.wikipedia.org/wiki/Comparison_between_Ido_and_Interlingua").get();
		 Elements afterFilter=filterTable.removeTableByClass(docHtml);
		 //Comparison_between_Ido_and_Interlingua
		  int nbPertinentTable= 2;
		 assertEquals(afterFilter.size(), nbPertinentTable,"Le nombre de tableau pertinent apres Filtrage par class doit être egal "+nbPertinentTable);
		 
		 
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void TestremoveTableByAttribut() throws Exception
	{
		docHtml =Jsoup.connect("https://en.wikipedia.org/wiki/Comparison_between_Ido_and_Interlingua").get();
		 Objects.requireNonNull(docHtml,"Le document ne doit pas être null");
		 Elements afterFilter=filterTable.removeTableByAttribut(docHtml.select("table"));
		 
		 int nbPertinentTable= 8;
		 assertEquals(afterFilter.size(), nbPertinentTable,"Le nombre de tableau pertinent "
		 						+ "apres Filtrage par class doit être egal "+nbPertinentTable);
		 
		 
	}
	
	@Test
	public void TestremoveTableByAttribut2() throws Exception
	{
		docHtml =Jsoup.connect("https://en.wikipedia.org/wiki/Comparison_between_Esperanto_and_Ido").get();
		 Objects.requireNonNull(docHtml,"Le document ne doit pas être null");
		 
		 Elements afterFilter=filterTable.removeTableByAttribut(docHtml.select("table"));
		 
		 int nbPertinentTable= 9;
		 assertEquals(afterFilter.size(), nbPertinentTable,"Le nombre de tableau pertinent "
		 						+ "apres Filtrage par class doit être egal "+nbPertinentTable);
		 
		 
	}
	
	
	/**
	 * tester la method qui supprimer les tables qui ont moins de MinRows lignes ou
	 * moins de colonnes
	 * @throws IOException 
	 */
	@Test
	public void TestremoveTablesWithMinRowOrColum() throws IOException
	{
		docHtml =Jsoup.connect("https://en.wikipedia.org/wiki/Comparison_between_Ido_and_Interlingua").get();
		 Objects.requireNonNull(docHtml,"Le document ne doit pas être null");
		 Elements afterFilterRowOrCol=filterTable.removeTablesWithMinRowOrColum(docHtml.select("table"));
		 for(Element tab: docHtml.select("table")) {
		 Elements lignes= tab.select("tr");
		 if(lignes.size()<=Constant.MIN_ROW) {
			 assertFalse(afterFilterRowOrCol.contains(tab),"cette table ne doit pas être présente car elle ne repond pas aux critères");
		 }
		 else {
			 Elements cols= lignes.get(0).select("td");
			 if(cols.size()<=Constant.MIN_COLUM) {
				 assertFalse(afterFilterRowOrCol.contains(tab),"cette table ne doit pas être présente car elle ne repond pas aux critères"); 
			 }
		 }
		 }
	}
	
	
	/** 
	 * tester la method global qui vas tous filter 
	 * @throws Exception 
	 */

	@Test
	public void testfilterTables() throws Exception
	{
		
			
	 docHtml =Jsoup.connect("https://en.wikipedia.org/wiki/Comparison_between_Esperanto_and_Ido").get();
			
	 Objects.requireNonNull(docHtml,"Le document ne doit pas être null");
	 Elements afterFilter=filterTable.removeTableByClass(docHtml);
	 			afterFilter = filterTable.removeTableByAttribut(afterFilter);
	 			
	 int nbPertinentTable= 6;
	 
	 assertEquals(afterFilter.size(), nbPertinentTable,"Le nombre de tableau pertinent "
	 						+ "apres Filtrage doit être egal "+nbPertinentTable);
	}
	
		/** 
	 * tester la methode globale qui va tout filter 
	 * @throws Exception 
	 */

	@Test
	public void testfilterTables2() throws Exception{
		docHtml =Jsoup.connect("https://en.wikipedia.org/wiki/Comparison_between_Ido_and_Interlingua").get();
		Objects.requireNonNull(docHtml,"Le document ne doit pas être null");
		Elements tables= filterTable.filterTables(docHtml);
		List<String> listeClasses=CSVUtils.getListFromFile(Constant.CLASS_TO_REMOVE);
		List<String> listeattr=CSVUtils.getListFromFile(Constant.ATTRIBUT_TO_REMOVE);
		
		for(String classe: listeClasses) {
			assertTrue(docHtml.getElementsByClass(classe).isEmpty(),""+classe+"présent dans le document après le filtrage");
		}
		for(Element table: tables) {
			for(String attr: listeattr) {
				assertTrue(table.getElementsByAttribute(attr).isEmpty(),""+attr+"présent dans la table"+table+"du document après le filtrage");
			}
			Elements lignes= table.select("tr");
			assertTrue(lignes.size()>Constant.MIN_ROW,"le tableau"+table+"ne contient pas assez de lignes car <MIN ROW");
			if(lignes.size()>Constant.MIN_ROW) {
				assertTrue(lignes.get(0).select("td").size()>Constant.MIN_COLUM,"le tableau"+table+"ne contient pas assez de colonnes dans sa 1ère ligne car <MIN COL");
			}
		}
	}
	
	
}
