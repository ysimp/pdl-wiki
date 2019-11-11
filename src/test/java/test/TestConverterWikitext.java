package test;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
		converterWiki = new ConverterWikiTextImpl();
		listUrl= CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
	}
	
	@DisplayName("Tester si la  création des fichier")
	@ParameterizedTest
	@ValueSource(ints = {0})
	public void testConvertAllTablesToCsv(int indice) throws Exception {
		
		String fileName= CSVUtils.constructFileName(listUrl.get(indice));
		
		int nbtables = CSVUtils.nbreTableauBliki(listUrl.get(indice));
		
		converterWiki.convertAllTablesToCsv(listUrl.get(indice));
		
		for(int i=1 ; i<= nbtables; i++) {
			String tableauCSV =Constant.CSV_WIKI_PATH + CSVUtils.mkCSVFileName(fileName, i);
				
			File file =new File(tableauCSV);
			
			 assertTrue("Le fichier "+i+" devrait etre créer",file.exists());
			
		}
		
		
	}
	
	@DisplayName("Tester si les fichiers sont vides ou pas")
	@ParameterizedTest
	@ValueSource(ints = {0})
	public void testConvertAllTablesToCsv2(int indice) throws Exception {
		
		String fileName= CSVUtils.constructFileName(listUrl.get(indice));
		
		int nbtables = CSVUtils.nbreTableauBliki(listUrl.get(indice));
		
		converterWiki.convertAllTablesToCsv(listUrl.get(indice));
		
		for(int i=1 ; i<= nbtables; i++) {
			
			String tableauCSV =Constant.CSV_WIKI_PATH + CSVUtils.mkCSVFileName(fileName, i);
			 
			 assertTrue("Le fichier "+i+" ne doit pas etre vide ",CSVUtils.testerFileCsvIsEmpty(tableauCSV));
			
		}
		
		
	}
	
	
	
	
}
