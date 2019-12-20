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
	
	/*
	 * Verité terrain HTML
	 */

	
	// Fchier différent à cause de certains caractère speciaux
	 @DisplayName("Jsoup 1: Verité terrain 1 les fichiers Jsoup  générés")
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
	
	
	@DisplayName("JSoup 2: Verité terrain les fichiers Jsoup  générés")
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
	
	@DisplayName("Jsoup 3 :Verité terrain e certains fichiers Biliki  générés")
	 @ParameterizedTest
	 @CsvSource({"Comparison_between_Esperanto_and_Ido-1.csv,Comparison_between_Esperanto_and_Ido-1.mine.csv",
		 		"Comparison_between_Esperanto_and_Ido-2.csv,Comparison_between_Esperanto_and_Ido-2.mine.csv",
		 		"Comparison_between_Esperanto_and_Ido-3.csv,Comparison_between_Esperanto_and_Ido-3.mine.csv",
		 		"Comparison_between_Esperanto_and_Ido-4.csv,Comparison_between_Esperanto_and_Ido-4.mine.csv",
		 		"Comparison_between_Esperanto_and_Ido-5.csv,Comparison_between_Esperanto_and_Ido-5.mine.csv",
		 		"Comparison_between_Esperanto_and_Novial-1.csv,Comparison_between_Esperanto_and_Novial-1.mine.csv",
		 		"Comparison_between_Esperanto_and_Novial-2.csv,Comparison_between_Esperanto_and_Novial-2.mine.csv",
		 		"Comparison_between_Esperanto_and_Novial-3.csv,Comparison_between_Esperanto_and_Novial-3.mine.csv",
		 		"Comparison_between_Esperanto_and_Novial-4.csv,Comparison_between_Esperanto_and_Novial-4.mine.csv"})
	 void test4(String nomArticle, String mine ) throws IOException {
			//Comparison_between_Ido_and_Interlingua-2.csv;
			File file1 = new File (Constant.CSV_WIKI_PATH + nomArticle);
			File file2 = new File (Constant.TRUE_PATH + mine);
			
			assertTrue(file1.exists(),"Le fichier doit exister");
			assertTrue(file2.exists(),"Le fichier doit exister");
			
			assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
		}
	
	/*
	 * Verité terrain Bliki
	 */
	
	// Fchier différent à cause de certains caractère speciaux
		 @DisplayName(" Bliki 1: Verité terrain  de certains fichiers Biliki  générés")
		 @ParameterizedTest
		 @CsvSource({
			         "Comparison_between_Ido_and_Interlingua-2.csv,Comparison_between_Ido_and_Interlingua-2.mine.csv"})
		 void testBliki1(String nomArticle, String mine ) throws IOException {
				//Comparison_between_Ido_and_Interlingua-2.csv;
				File file1 = new File (Constant.CSV_WIKI_PATH + nomArticle);
				File file2 = new File (Constant.TRUE_PATH + mine);
				
				assertTrue(file1.exists(),"Le fichier doit exister");
				assertTrue(file2.exists(),"Le fichier doit exister");
				
				assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
			}
		 
		 @DisplayName("Bliki 2 :Verité terrain e certains fichiers Biliki  générés")
		 @ParameterizedTest
		 @CsvSource({"Comparison_of_ALGOL_68_and_C++-2.csv,Comparison_of_ALGOL_68_and_C++-1.csv",
			         "Comparison_of_Android_e-book_reader_software-2.csv,Comparison_of_Android_e-book_reader_software-1.csv",
			         "Comparison_of_Android_e-book_reader_software-3.csv,Comparison_of_Android_e-book_reader_software-2.csv",
			         "Comparison_of_Android_e-book_reader_software-4.csv,Comparison_of_Android_e-book_reader_software-3.csv",
			         "Comparison_of_Android_e-book_reader_software-5.csv,Comparison_of_Android_e-book_reader_software-4.csv",
			         "Comparison_of_Chernobyl_and_other_radioactivity_releases-2.csv,Comparison_of_Chernobyl_and_other_radioactivity_releases-2.csv",
			         "Comparison_of_Linux_distributions-2.csv,Comparison_of_Linux_distributions-1.csv",
			         "Comparison_of_Linux_distributions-3.csv,Comparison_of_Linux_distributions-2.csv",
			         "Comparison_of_Linux_distributions-4.csv,Comparison_of_Linux_distributions-3.csv",
			         "Comparison_of_Linux_distributions-5.csv,Comparison_of_Linux_distributions-4.csv",
			         "Comparison_of_Symbian_devices-1.csv,Comparison_of_Symbian_devices-1.csv"
			         })
		 void testBiliki2(String nomArticle, String mine ) throws IOException {
				//Comparison_between_Ido_and_Interlingua-2.csv;
				File file1 = new File (Constant.CSV_WIKI_PATH + nomArticle);
				File file2 = new File (Constant.TRUE_PATH + mine);
				
				assertTrue(file1.exists(),"Le fichier doit exister");
				assertTrue(file2.exists(),"Le fichier doit exister");
				
				assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
			}
		 
		 @DisplayName("Bliki 3 :Verité terrain e certains fichiers Biliki  générés")
		 @ParameterizedTest
		 @CsvSource({"Comparison_between_Esperanto_and_Ido-2.csv,Comparison_between_Esperanto_and_Ido-1.mine.csv",
			 		"Comparison_between_Esperanto_and_Ido-3.csv,Comparison_between_Esperanto_and_Ido-2.mine.csv",
			 		"Comparison_between_Esperanto_and_Ido-4.csv,Comparison_between_Esperanto_and_Ido-3.mine.csv",
			 		"Comparison_between_Esperanto_and_Ido-5.csv,Comparison_between_Esperanto_and_Ido-4.mine.csv",
			 		"Comparison_between_Esperanto_and_Ido-6.csv,Comparison_between_Esperanto_and_Ido-5.mine.csv",
			 		"Comparison_between_Esperanto_and_Novial-2.csv,Comparison_between_Esperanto_and_Novial-1.mine.csv",
			 		"Comparison_between_Esperanto_and_Novial-3.csv,Comparison_between_Esperanto_and_Novial-2.mine.csv",
			 		"Comparison_between_Esperanto_and_Novial-4.csv,Comparison_between_Esperanto_and_Novial-3.mine.csv",
			 		"Comparison_between_Esperanto_and_Novial-5.csv,Comparison_between_Esperanto_and_Novial-4.mine.csv"})
		 void testBiliki3(String nomArticle, String mine ) throws IOException {
				//Comparison_between_Ido_and_Interlingua-2.csv;
				File file1 = new File (Constant.CSV_WIKI_PATH + nomArticle);
				File file2 = new File (Constant.TRUE_PATH + mine);
				
				assertTrue(file1.exists(),"Le fichier doit exister");
				assertTrue(file2.exists(),"Le fichier doit exister");
				
				assertTrue(CSVUtils.CompareTwoFile(file1,file2),"Les deux fichiers doivent être pareil" );
			}

}