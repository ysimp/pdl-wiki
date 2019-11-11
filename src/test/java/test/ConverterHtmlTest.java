package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import html.ConverterHtml;
import html.ConverterHtmlImp;
import utils.CSVUtils;
import utils.Constant;

class ConverterHtmlTest {

	public ConverterHtml converterHtml;
	public List<String> listUrl ;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.converterHtml = new ConverterHtmlImp();
		listUrl= CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
	}
	
	@DisplayName("Teste la creation du fichier")
	@ParameterizedTest
	@ValueSource(ints = {0})
	public void testConvertAllTablesToCsv(int indice) throws Exception {
		
		String fileName= CSVUtils.constructFileName(listUrl.get(indice));
		
		int nbtables = CSVUtils.nbreTableau(listUrl.get(indice));
		
		converterHtml.convertAllTablesToCsv(listUrl.get(indice));
		
		for(int i=1 ; i<= nbtables; i++) {
			String tableauCSV =Constant.CSV_HTML_PATH + CSVUtils.mkCSVFileName(fileName, i);	
			File out =new File(tableauCSV);
			 assertTrue(out.exists());
		}
	
	}
	
	@DisplayName("Tester si le fichier est vide")
	@ParameterizedTest
	@ValueSource(ints = {0})
	public void testConvertAllTables(int indice) throws Exception {
		
		String fileName= CSVUtils.constructFileName(listUrl.get(indice));
		
		int nbtables = CSVUtils.nbreTableauBliki(listUrl.get(indice));
		
		converterHtml.convertAllTablesToCsv(listUrl.get(indice));
		
		for(int i=1 ; i<= nbtables; i++) {
			
			String tableauCSV =Constant.CSV_HTML_PATH + CSVUtils.mkCSVFileName(fileName, i);
			 
			 assertTrue(CSVUtils.testerFileCsvIsEmpty(tableauCSV));
			
		}
		
		
	}
	
	
	
	
}
