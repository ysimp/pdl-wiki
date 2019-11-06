/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


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
  @ParameterizedTest
	 	@CsvSource(
	 			{
	 				"0 ,13",
	 				"1, 8"
	 			})
	 	void test(int indiceUrl, int NombreTable) throws Exception{
	 		listUrl=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
			this.extractorHtml = new ExtractorHtmlImp();
			
			Page page=extractorHtml.extractTables(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indiceUrl),false);
			assertEquals(NombreTable,page.getNombreTable());
			
		} 
	 	
	

}
