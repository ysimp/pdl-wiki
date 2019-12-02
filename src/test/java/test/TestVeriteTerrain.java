package test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
	void CompareTwoFile1() throws IOException {
	
		assertTrue(CSVUtils.CompareTwoFile("test1.txt","test2.txt"),"Devarit etre pareil");
	}

	@Test
	@DisplayName("Verité terrain 1 : Comparison_between_Ido_and_Interlingua-2.csv")
	void test1() throws IOException {
		//Comparison_between_Ido_and_Interlingua-2.csv;
		File file1 = new File (Constant.CSV_HTML_PATH + "Comparison_between_Ido_and_Interlingua-2.csv");
		File file2 = new File (Constant.TRUE_PATH + "Comparison_between_Ido_and_Interlingua-2.mine.csv");
		
		assertTrue(file1.exists(),"Le fichier doit exister");
		assertTrue(file2.exists(),"Le fichier doit exister");
		
		assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
	}
	
	 @ParameterizedTest
	 @CsvSource({"Comparison_between_Ido_and_Interlingua-2.csv,Comparison_between_Ido_and_Interlingua-2.csv",
		         "Comparison_between_Ido_and_Interlingua-2.csv,Comparison_between_Ido_and_Interlingua-2.mine.csv"})
	 
	 void test2(String nomArticle, String mine ) throws IOException {
			//Comparison_between_Ido_and_Interlingua-2.csv;
			File file1 = new File (Constant.CSV_HTML_PATH + nomArticle);
			File file2 = new File (Constant.TRUE_PATH + mine);
			
			assertTrue(file1.exists(),"Le fichier doit exister");
			assertTrue(file2.exists(),"Le fichier doit exister");
			
			assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
		}

}