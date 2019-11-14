package Test2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import convertor.ConverterUtil;
import utils.CSVUtils;
import utils.Constant;
import wikiText.ExtractorWikitext;

class TestConverterUtil {

	List<String> listUrl ;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		listUrl= CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
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

}
