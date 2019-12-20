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
		File file2 = new File (Constant.TRUE_PATH + "Comparison_between_Ido_and_Interlingua-2.mine.csv");
		
		assertTrue(file1.exists(),"Le fichier doit exister");
		assertTrue(file2.exists(),"Le fichier doit exister");
		
		assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
	}
	
	// Fchier différent à cause de certains caractère speciaux
	@DisplayName("Verité terrain 1 :")
	 @ParameterizedTest
	 @CsvSource({
		         "Comparison_between_Ido_and_Interlingua-1.csv,Comparison_between_Ido_and_Interlingua-2.mine.csv"})
	 void test2(String nomArticle, String mine ) throws IOException {
			//Comparison_between_Ido_and_Interlingua-2.csv;
			File file1 = new File (Constant.CSV_HTML_PATH + nomArticle);
			File file2 = new File (Constant.TRUE_PATH + mine);
			
			assertTrue(file1.exists(),"Le fichier doit exister");
			assertTrue(file2.exists(),"Le fichier doit exister");
			
			assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
		}
	
	
	@DisplayName("Verité terrain 2 With generate file Jsoup")
	 @ParameterizedTest
	 @CsvSource({"Comparison_of_ALGOL_68_and_C++-1.csv,Comparison_of_ALGOL_68_and_C++-1.csv",
		         "Comparison_of_Android_e-book_reader_software-1.csv,Comparison_of_Android_e-book_reader_software-1.csv",
		         "Comparison_of_Android_e-book_reader_software-2.csv,Comparison_of_Android_e-book_reader_software-2.csv",
		         "Comparison_of_Android_e-book_reader_software-3.csv,Comparison_of_Android_e-book_reader_software-3.csv",
		         "Comparison_of_Android_e-book_reader_software-4.csv,Comparison_of_Android_e-book_reader_software-4.csv",
		         "Comparison_of_Chernobyl_and_other_radioactivity_releases-2.csv,Comparison_of_Chernobyl_and_other_radioactivity_releases-2.csv",
		         "Comparison_of_Linux_distributions-1.csv,Comparison_of_Linux_distributions-1.csv",
		         "Comparison_of_Linux_distributions-2.csv,Comparison_of_Linux_distributions-2.csv",
		         "Comparison_of_Linux_distributions-3.csv,Comparison_of_Linux_distributions-3.csv",
		         "Comparison_of_Linux_distributions-4.csv,Comparison_of_Linux_distributions-4.csv",
		         "Comparison_of_Symbian_devices-1.csv,Comparison_of_Symbian_devices-1.csv",
		         "Comparison_of_United_States_presidential_candidates,_2008-1.csv,Comparison_of_United_States_presidential_candidates,_2008-1.csv",
		         "Comparison_of_United_States_presidential_candidates,_2008-2.csv,Comparison_of_United_States_presidential_candidates,_2008-2.csv"
		         })
	 void test3(String nomArticle, String mine ) throws IOException {
			//Comparison_between_Ido_and_Interlingua-2.csv;
			File file1 = new File (Constant.CSV_HTML_PATH + nomArticle);
			File file2 = new File (Constant.TRUE_PATH + mine);
			
			assertTrue(file1.exists(),"Le fichier doit exister");
			assertTrue(file2.exists(),"Le fichier doit exister");
			
			assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
		}

}