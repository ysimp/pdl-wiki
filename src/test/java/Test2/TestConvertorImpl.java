package Test2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import convertor.Converter;
import convertor.ConverterImp;
import convertor.ConverterUtil;
import utils.CSVUtils;
import utils.Constant;

class TestConvertorImpl {

	static Converter converter;
	static List<String> listUrl;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 listUrl = CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		 converter=new ConverterImp();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@DisplayName("HTML Tester si la  création des fichier")
	@ParameterizedTest
	@ValueSource(ints = {0})
	public void testConvertAllTablesToCsv(int indice) throws Exception {
		
		
		String fileName= CSVUtils.constructFileName(listUrl.get(indice));
		
		int nbtables = CSVUtils.nbreTableauJsoup(listUrl.get(indice));
		Document dochtml= ConverterUtil.getDocumentJsoup(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indice));
		
		assertNotNull(dochtml,"doc ne doit pas etre null");
		
		converter.convertAllTablesToCsv(dochtml,listUrl.get(indice),Constant.CSV_HTML_PATH);
		
		for(int i=1 ; i<= nbtables; i++) {
			String tableauCSV =Constant.CSV_HTML_PATH + CSVUtils.mkCSVFileName(fileName, i);
				
			File file =new File(tableauCSV);
			
			assertNotNull(file,"file ne doit pas etre null");
			
			 assertTrue("Le fichier "+i+" devrait etre créer",file.exists());
			
		}
		
	}
	
	@DisplayName("Bliki Tester si la  création des fichier")
	@ParameterizedTest
	@ValueSource(ints = {0})
	public void testConvertAllTablesToCsv2(int indice) throws Exception {
		
		
		String fileName= CSVUtils.constructFileName(listUrl.get(indice));
		
		int nbtables = CSVUtils.nbreTableauBliki(listUrl.get(indice));
		Document dochtml= ConverterUtil.getDocumentWiki(listUrl.get(indice));
		
		assertNotNull(dochtml,"doc ne doit pas etre null");
		
		converter.convertAllTablesToCsv(dochtml,listUrl.get(indice),Constant.CSV_WIKI_PATH);
		
		for(int i=1 ; i<= nbtables; i++) {
			String tableauCSV =Constant.CSV_WIKI_PATH + CSVUtils.mkCSVFileName(fileName, i);
				
			File file =new File(tableauCSV);
			
			assertNotNull(file,"file ne doit pas etre null");
			
			 assertTrue("Le fichier "+i+" devrait etre créer",file.exists());
			
		}
		
	}

}
