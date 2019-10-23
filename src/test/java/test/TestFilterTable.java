package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Objects;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeAll;
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
		
		docHtml =  Jsoup.connect(Constant.BASE_WIKIPEDIA_URL_JSOUP+listeUrl.get(3)).get();
	}
	/**
	 * @throws Exception 
	 * 
	 */
	@Test
	public void TestremoveTableByClass() throws Exception
	{
		docHtml =Jsoup.connect("https://en.wikipedia.org/wiki/Comparison_between_Ido_and_Interlingua").get();
		 Objects.requireNonNull(docHtml,"Le document ne doit pas être null");
		 Elements depart=docHtml.select("table");
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
	
	/**
	 * tester la method qui supprimer les tables qui ont moins de MinRows lignes ou
	 * moins de colonnes
	 */
	@Test
	public void TestremoveTablesWithMinRowOrColum()
	{
		
	}
	
	
	/** 
	 * tester la method global qui vas tous filter 
	 */

	@Test
	public void testfilterTables()
	{
		
	}
	
	
}
