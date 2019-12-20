package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import utils.CSVUtils;
import utils.Constant;

class TestFilesJsoupVSBliki {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	 /*** Test permettant de dire si le meme tableau générer par Jsoup et Bliki sont pareils
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
