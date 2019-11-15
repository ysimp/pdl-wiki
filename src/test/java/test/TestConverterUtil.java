package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import utils.CSVUtils;
import utils.Constant;
import utils.ConverterUtil;

/**
 * @author Hajar 
 * @author Jihad
 * @author yaya
 * @author El Mahjoub
 *
 */
class TestConverterUtil {

	static List<String> listUrl ;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		CSVUtils.creatOutPutFolder();// create dossier output 
		
		listUrl= CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
	}

	@BeforeEach
	void setUp() throws Exception {
		
	}

	
	@DisplayName("Test avec les bons urls")
	  @ParameterizedTest
	  @ValueSource(ints = {0,1,2,3,4,5})
	  public void testGetDocument1(int indice) {
	  
	  Document docHtml = ConverterUtil.getDocumentJsoup(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indice));
	 
	  assertNotNull(docHtml,"Le document ne doit pas être null car cet article existe");
	  
	  }
	
	@DisplayName("Test avec les bons urls")
	  @ParameterizedTest
	  @ValueSource(ints = {0,1,2,3,4,5})
	  public void testGetDocument2(int indice) {
	  
	  Document docHtml = ConverterUtil.getDocumentWiki(listUrl.get(indice));
	  assertNotNull(docHtml,"Le document ne doit pas être null car cet article existe");
	  
	  }
	
	@DisplayName("Test avec un mauvais url")
	@Test
	public void testGetDocument3() {
		
		Document docHtml = ConverterUtil.getDocumentWiki("urlnexistepas;blablanla");

		assertNull(docHtml, "Le document  doit être null pour ce article");
		
	}
	
	@DisplayName("Test avec un mauvais url")
	@Test
	public void testGetDocument4() {
		
		Document docHtml = ConverterUtil.getDocumentJsoup("urlnexistepas;blablanla");

		assertNull(docHtml, "Le document  doit être null pour ce article");
		
	}
	
	@DisplayName("Nombre de tableau url Jsoup 1")
	@Test
	public void testnbreTableauJsoup1() throws Exception {
		
		int nbTab = ConverterUtil.nbreTableauJsoup("sffsfsfsfqffqfqfqfq");

		assertEquals(-1, nbTab,"Le nombre de tableau doit être -1");
	}
	
	@DisplayName("Nombre de tableau url Jsoup 2")
	@Test
	public void testnbreTableauJsoup2() throws Exception {
		
		int nbTab = ConverterUtil.nbreTableauJsoup(listUrl.get(0));

		assertEquals(19, nbTab,"Le nombre de tableau doit être 19");
	}

	@DisplayName("Nombre de tableau url Bliki 1")
	@Test
	public void testnbreTableauBliki1() throws Exception {
		
		int nbTab = ConverterUtil.nbreTableauBliki("sffsfsfsfqffqfqfqfq");

		assertEquals(-1, nbTab,"Le nombre de tableau doit être -1");
	}
	
	@DisplayName("Nombre de tableau url Bliki 2")
	@Test
	public void testnbreTableauBliki2() throws Exception {
		
		int nbTab = ConverterUtil.nbreTableauBliki(listUrl.get(0));
		//Bliki retourne 10 tableau
		assertEquals(15, nbTab,"Le nombre de tableau doit être -1");
	}
}
