package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import implementation.Extractor;
import implementation.ExtractorImpl;
import model.Page;
import utils.CSVUtils;
import utils.Constant;
import utils.ConverterUtil;

class TestExtractorImpl {

	static Extractor extractor;
	static List<String> listUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		 listUrl = CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		 extractor=new ExtractorImpl();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		
	}
	
	@DisplayName("HTML Test l'extracteur : tester le nombre de lignes d'un tableau ")
	@ParameterizedTest
	@CsvSource(
			{"0, 0, 6",
			 "0 ,1,  2"
			})
	public void testNombreLigneTableau(int indiceUrls,int NUMtableau,int nbLigne) throws Exception {
	
		Document dochtml= ConverterUtil.getDocumentJsoup(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indiceUrls));
		
		Page page = extractor.extractTables(dochtml,false);
		
		assertEquals(nbLigne, page.getListeTableau().get(NUMtableau).getlisteLignes().size(),
				"le nombre de lignes  doit etre "+ nbLigne);
	
	}

	@DisplayName("Bliki Test l'extracteur : tester le nombre de lignes d'un tableau ")
	@ParameterizedTest
	@CsvSource(
			{"0, 0, 6",
			 "0 ,1,  2"
			})
	public void testNombreLigneTableau2(int indiceUrls,int NUMtableau,int nbLigne) throws Exception {
	
		Document dochtml= ConverterUtil.getDocumentWiki(listUrl.get(indiceUrls));
		
		Page page = extractor.extractTables(dochtml,false);
		
		assertEquals(nbLigne, page.getListeTableau().get(NUMtableau).getlisteLignes().size(),
				"le nombre de lignes  doit etre "+ nbLigne);
	
	}
	@DisplayName("HTML Test l'extracteur : tester le nombre de colonne d'un tableau ")
	@ParameterizedTest
	@CsvSource(
			{"0, 0, 6",
			 "0 ,1,  2"
			})
	public void testNombreColonneTableau(int indiceUrls,int NUMtableau,int nbColonne) throws Exception {
	
		Document dochtml= ConverterUtil.getDocumentJsoup(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indiceUrls));
		
		Page page = extractor.extractTables(dochtml,false);
		
		assertEquals(nbColonne, page.getListeTableau().get(NUMtableau).getlisteLignes().get(0).getListCelluleLigne().size(),
				"le nombre de colonnes doit etre "+ nbColonne);
	
	}
	
	@DisplayName("Bliki Test l'extracteur : tester le nombre de colonne d'un tableau ")
	@ParameterizedTest
	@CsvSource(
			{"0, 0, 6",
			 "0 ,1,  2"
			})
	public void testNombreColonneTableau2(int indiceUrls,int NUMtableau,int nbColonne) throws Exception {
	
		Document dochtml= ConverterUtil.getDocumentWiki(listUrl.get(indiceUrls));
		
		Page page = extractor.extractTables(dochtml,false);
		
		assertEquals(nbColonne, page.getListeTableau().get(NUMtableau).getlisteLignes().get(0).getListCelluleLigne().size(),
				"le nombre de colonnes doit etre "+ nbColonne);
	
	}
}
