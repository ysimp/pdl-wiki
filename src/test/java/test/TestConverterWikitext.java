package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import utils.CSVUtils;
import utils.Constant;
import wikiText.ConverterWikiTextImpl;
import wikiText.ConverterWikitext;

public class TestConverterWikitext {

	ConverterWikitext converterWiki;
	List<String> listUrl ;
	
	@BeforeEach
	public void setUp() throws Exception {
		converterWiki = new ConverterWikiTextImpl(false);
		listUrl= CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
	}
	
	@DisplayName("Tester si la  cr�ation des fichier")
	@ParameterizedTest
	@ValueSource(ints = {0})
	@Disabled
	public void testConvertAllTablesToCsv(int indice) throws Exception {
		
		String fileName= CSVUtils.constructFileName(listUrl.get(indice));
		
		int nbtables = CSVUtils.nbreTableauBliki(listUrl.get(indice));
		
		converterWiki.convertAllTablesToCsv(listUrl.get(indice));
		
		for(int i=1 ; i<= nbtables; i++) {
			String tableauCSV =Constant.CSV_WIKI_PATH + CSVUtils.mkCSVFileName(fileName, i);
				
			File file =new File(tableauCSV);
			
			 assertTrue("Le fichier "+i+" devrait etre cr�er",file.exists());
			
		}
		
		
	}
	
	@DisplayName("Tester si les fichiers sont vides ou pas")
	@ParameterizedTest
	@ValueSource(ints = {0})
	@Disabled
	public void testConvertAllTablesToCsv2(int indice) throws Exception {
		
		String fileName= CSVUtils.constructFileName(listUrl.get(indice));
		
		int nbtables = CSVUtils.nbreTableauBliki(listUrl.get(indice));
		
		converterWiki.convertAllTablesToCsv(listUrl.get(indice));
		
		for(int i=1 ; i<= nbtables; i++) {
			
			String tableauCSV =Constant.CSV_WIKI_PATH + CSVUtils.mkCSVFileName(fileName, i);
			 
			 assertTrue("Le fichier "+i+" ne doit pas etre vide ",CSVUtils.testerFileCsvIsEmpty(tableauCSV));
			
		}
		
		
	}
	
	/**
	 * nombre de fichiers g�n�r�s 1315
	 * nombre de tableau total 1289
	 **/
	@DisplayName("Tester si les fichiers extraits ot �t� g�n�rer ou pas")
	@Test
	@Disabled
	public void testConvertAllPages() throws Exception {
		
		converterWiki.convertAllPages();
		int numberOfFile = new File(Constant.CSV_WIKI_PATH).listFiles().length;
		assertEquals(numberOfFile, CSVUtils.nbreTableauBlikiTotal(), "Les le nombre de fichiers g�n�r�s devrait �tre egal au nombre de tableau total");

	}
	
	@DisplayName("Tester si les fichiers generes ne sont pas vide ")
	@Test
	@Disabled
	public void testConvertAllPages2() throws Exception {
		
		converterWiki.convertAllPages();
		File f= new File(Constant.CSV_WIKI_PATH);
		
		File[] entries = f.listFiles();
        
        for(File currentFile: entries){
     	   
        	boolean test=CSVUtils.testerFileCsvIsEmpty(Constant.CSV_WIKI_PATH+File.separator+currentFile.getName());
        	assertTrue(test,"le fichier ne doit pas etre vide ");
        	
        }
		
	}
	
	
	@DisplayName("Tester que le convertor ne leve pas une exception ")
	@Test
	@Disabled
	public void testConvertAllPages3() {
		
		try {
			converterWiki.convertAllPages();
			assertTrue(true,"fin ");
			
		} catch (Exception e) {
			
			assertTrue(false," convertor ne doit pas lever une exception");
			e.printStackTrace();
		}
		
	}
	
}
