package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import utils.CSVUtils;
import utils.Constant;

class TestVeriteTerrain {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	@DisplayName("Comparer deux fichiers CSV")
	@Disabled
	void CompareTwoFile1() throws IOException {
	
		assertTrue(CSVUtils.CompareTwoFile("test1.txt","test2.txt"),"Devarit etre pareil");
	}

	@Test
	@DisplayName("Verité terrain 0 : Comparison_between_Ido_and_Interlingua-1.csv")
	void test1() throws IOException {
		//Comparison_between_Ido_and_Interlingua-2.csv;
		File file1 = new File (Constant.CSV_HTML_PATH + "Comparison_between_Ido_and_Interlingua-1.csv");
		File file2 = new File (Constant.TRUE_PATH + "Comparison_between_Ido_and_Interlingua-1.mine.csv");
		
		assertTrue(file1.exists(),"Le fichier doit exister");
		assertTrue(file2.exists(),"Le fichier doit exister");
		
		assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
	}
	
	@DisplayName("Verité terrain 1 :")
	 @ParameterizedTest
	 @CsvSource({"Comparison_between_Ido_and_Interlingua-1.csv,Comparison_between_Ido_and_Interlingua-1.csv",
		         "Comparison_between_Ido_and_Interlingua-1.csv,Comparison_between_Ido_and_Interlingua-1.mine.csv"})
	 void test2(String nomArticle, String mine ) throws IOException {
			//Comparison_between_Ido_and_Interlingua-2.csv;
			File file1 = new File (Constant.CSV_HTML_PATH + nomArticle);
			File file2 = new File (Constant.TRUE_PATH + mine);
			
			assertTrue(file1.exists(),"Le fichier doit exister");
			assertTrue(file2.exists(),"Le fichier doit exister");
			
			assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
		}
	 
	 /*** Test permettant de dire si le mme tableau générer par Jsoup et Bliki sont pareil
	 * 
	 * @throws IOException **/
	 
	 @ParameterizedTest
	 @CsvSource({
		 "Comparison_between_Ido_and_Interlingua-1.csv,Comparison_between_Ido_and_Interlingua-2.csv",
		 "Comparison_(grammar)-1.csv,Comparison_(grammar)-2.csv",
		 "Comparison_between_Esperanto_and_Ido-1,Comparison_between_Esperanto_and_Ido-2",
		 "Comparison_between_Esperanto_and_Interlingua-1.csv,Comparison_between_Esperanto_and_Interlingua-2.csv",
		 "Comparison_between_Argentine_provinces_and_countries_by_GDP_(PPP)_per_capita-1.csv,Comparison_between_Argentine_provinces_and_countries_by_GDP_(PPP)_per_capita-1.csv",
		 "Comparison_between_Esperanto_and_Interlingua-1.csv,Comparison_between_Esperanto_and_Interlingua-2.csv",
		 "Comparison_between_U.S._states_and_countries_by_GDP_(nominal)_per_capita-2,Comparison_between_U.S._states_and_countries_by_GDP_(nominal)_per_capita-1",
		  "Comparison_between_Esperanto_and_Novial-1.csv,Comparison_between_Esperanto_and_Novial-2.csv"})
	 
	 @DisplayName("Verifier Html et Jsoup 1")
	 void verifTableauJsoupBliki(String fileHtmlName, String fileBlikiName) throws IOException {
		 
		 File fileHtml = new File (Constant.CSV_HTML_PATH + fileHtmlName);
		 File fileBliki = new File (Constant.CSV_WIKI_PATH + fileBlikiName);
			
			assertTrue(fileHtml.exists(), "Le fichier doit exister");
			assertTrue(fileBliki.exists(), "Le fichier doit exister");
			
			assertTrue(CSVUtils.CompareTwoFile(fileHtml,fileBliki),"Les fichiers HTML et Bliki doivent être pareils" );
			
	 }
}