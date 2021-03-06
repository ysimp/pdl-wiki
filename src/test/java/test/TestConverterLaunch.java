package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import implementation.LaunchConvertor;
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

class TestConverterLaunch {

	static LaunchConvertor launchConvertor;
	static List<String> listUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		
		 listUrl = CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		 launchConvertor=new LaunchConvertor();
		 launchConvertor.convertAllPages();
		 
			
	}

	@Test
	@DisplayName("Bliki folder no empty")
	@Disabled
	void TestFichierNonVide() throws Exception {
		
		File f= new File(Constant.CSV_WIKI_PATH);
		
		File[] entries = f.listFiles();
        
        for(File currentFile: entries){
     	   
        	boolean test=CSVUtils.testerFileCsvIsEmpty(Constant.CSV_WIKI_PATH+File.separator+currentFile.getName());
        	assertTrue(test,"le fichier ne doit pas etre vide ");
        	
        }
	}
	
	@Test
	@DisplayName("HTML folder no empty")
	@Disabled
	void TestFichierNonVide2() throws Exception {
		
		File f= new File(Constant.CSV_HTML_PATH);
		
		File[] entries = f.listFiles();
        
		
        for(File currentFile: entries){
     	   
        	boolean test=CSVUtils.testerFileCsvIsEmpty(Constant.CSV_HTML_PATH+File.separator+currentFile.getName());
        	assertTrue(test,"le fichier ne doit pas etre vide ");
        	
        }
        
	}

	@DisplayName("HTML nb de fichier generer")
	@Test
	@Disabled
	void testConvertAllPages() throws Exception {
		
		
		int numberOfFileHtml = new File(Constant.CSV_HTML_PATH).listFiles().length;
		assertEquals(numberOfFileHtml, ConverterUtil.nbreTableauJsoupTotal(), "Les le nombre de fichiers g�n�r�s devrait �tre egal au nombre de tableau total");

	}
	
	@DisplayName("Bliki nb de fichier generer")
	@Test
	@Disabled
	void testNbreDePageGenerer() throws Exception {
		
		int numberOfFilebliki = new File(Constant.CSV_WIKI_PATH).listFiles().length;
		assertEquals(numberOfFilebliki, ConverterUtil.nbreTableauBlikiTotal(), "Les le nombre de fichiers g�n�r�s devrait �tre egal au nombre de tableau total");

		
	}
	
	@Test
	@DisplayName("Html : Fichier valid")
	@Disabled
	void TestFichierValid() throws Exception {
		
		File f= new File(Constant.CSV_HTML_PATH);
		
		File[] entries = f.listFiles();
        
        for(File currentFile: entries){
     	   
        	boolean test=CSVUtils.isCsvFileValid(Constant.CSV_HTML_PATH+File.separator+currentFile.getName());
        	assertTrue(test,"le fichier doit etre Valide");
        	
        }
	}
	
	@Test
	@DisplayName("Bliki : Fichier valid")
	@Disabled
	void TestFichierValidBliki() throws Exception {
		
		File f= new File(Constant.CSV_WIKI_PATH);
		
		File[] entries = f.listFiles();
        
        for(File currentFile: entries){
     	   
        	boolean test=CSVUtils.isCsvFileValid(Constant.CSV_WIKI_PATH+File.separator+currentFile.getName());
        	assertTrue(test,"le fichier doit etre Valide");
        	
        }
	}

}
