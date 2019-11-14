/**
 * 
 */
package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import html.ExtractorHtml;
import html.ExtractorHtmlImp;
import model.Page;
import utils.CSVUtils;
import utils.Constant;

/**
 * @author Jahoui
 *
 */
public class ExtractorHtmlTest {
	private ExtractorHtml extractorHtml;
	
  private List<String> listUrl;
  
/*	@BeforeEach
	 	public void init() {
		listUrl=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		this.extractorHtml = new ExtractorHtmlImp();
	}
	 */
  
 /* @DisplayName("Tester La connection ")
  @ParameterizedTest
  @CsvSource(
	 			{
	 				"0",
	 				"1",
	 				"2"
	 			})
   void testConnection(int indiceUrl)throws Exception{
		listUrl=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		this.extractorHtml = new ExtractorHtmlImp();
		Boolean bl=extractorHtml.Connection(listUrl.get(indiceUrl));
		System.out.println("connection "+ bl);
	   assertTrue(bl);
   }*/
  
  @DisplayName("Tester nbre de tableau ")
  @ParameterizedTest
  @CsvSource(
	 			{
	 				"0 ,13",
	 				"1, 9"
	 			})
	 	void testNombreTable(int indiceUrl, int NombreTable) throws Exception{
	 		listUrl=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
			this.extractorHtml = new ExtractorHtmlImp();
			
			Page page=extractorHtml.extractTables(listUrl.get(indiceUrl),false);
			assertEquals(NombreTable,page.getNombreTable());
			
			
		} 
  
  @DisplayName("Tester nbre de ligne d'un tableau ")
  @ParameterizedTest
  @CsvSource(
			{
				"0 , 0,0",
				"0,1,15 "
			})
  	 void testNombredeligne(int indiceUrl, int indiceTable,int nbrLigne) throws Exception{
		listUrl=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		this.extractorHtml = new ExtractorHtmlImp();
	//	Page page=extractorHtml.extractTables(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indiceUrl),false);
		Page page=extractorHtml.extractTables(listUrl.get(indiceUrl),false);
		System.out.println("nbre de ligne d'un tableau "+page.getListeTableau().get(0).getlisteLignes().size());
		assertEquals(nbrLigne,page.getListeTableau().get(0).getlisteLignes().size());

  		}
	 	
  @DisplayName("Tester nbre de ligne d'un tableau ")
  @ParameterizedTest
  @CsvSource(
			{
				"0 , 0,0",
				"0,1,15 "
			})
  	 void testNombredeColonne(int indiceUrl, int indiceTable,int nbrLigne) throws Exception{
		listUrl=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		this.extractorHtml = new ExtractorHtmlImp();
	//	Page page=extractorHtml.extractTables(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indiceUrl),false);
		Page page=extractorHtml.extractTables(listUrl.get(indiceUrl),false);
		
  		}
         
}
