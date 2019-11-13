package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import model.Page;
import utils.CSVUtils;
import utils.Constant;
import wikiText.ExtractorWikiTextImpl;
import wikiText.ExtractorWikitext;

public class TestExtractorWikiText {
	
	ExtractorWikitext extractWiki;
	List<String> listUrl ;
	
	@BeforeEach
	public void setUp() throws Exception {
		extractWiki = new ExtractorWikiTextImpl();
		listUrl= CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
	}
	

	  @DisplayName("Test avec les bons urls")
	  @ParameterizedTest
	  @ValueSource(ints = {0,1,2,3,4,5})
	  public void testGetDocument1(int indice) {
	  
	  Document docHtml = extractWiki.getDocumentFromUrl(listUrl.get(indice));
	  assertNotNull(docHtml,"Le document ne doit pas être null car cet article existe");
	  
	  }
	  
	 
	@DisplayName("Test avec un mauvais url")
	@Test
	public void testGetDocument3() {
		
		Document docHtml = extractWiki.getDocumentFromUrl("urlnexistepas;blablanla");
		//System.out.println(docHtml.toString());

		assertNull(docHtml, "Le document  doit être null pour ce article");
		
	}
	
	@DisplayName("Test l'extracteur sans le filtre")
	@ParameterizedTest
	@CsvSource(
			{"0, 13",
			 "1, 9"
			})
	public void testExtractTable(int indiceUrls,int nbTableTotal) throws Exception {
	
		Page page = extractWiki.extractTables(listUrl.get(indiceUrls), false);
		
		assertEquals(nbTableTotal, page.getTotalTableau(), "le nombre total de tableau devrait être egal à "+ nbTableTotal);
	
	}
	
	
	@DisplayName("Test l'extracteur avec le filtre")
	@ParameterizedTest
	@CsvSource(
			{"0, 6",
			 "1, 2"
			})
	public void testExtractTablewithFilter(int indiceUrls,int nbTableTotal) throws Exception {
	
		Page page = extractWiki.extractTables(listUrl.get(indiceUrls), true);
		
		assertEquals(nbTableTotal, page.getTotalTableau(), "le nombre de tableau après filtrage doit etre "+ nbTableTotal);
	
	}

	/*Verifier les valeurs**/
	@DisplayName("Test l'extracteur : tester le nombre de lignes d'un tableau ")
	@ParameterizedTest
	@CsvSource(
			{"0, 0, 6",
			 "0 ,1,  2"
			})
	public void testNombreLigneTableau(int indiceUrls,int NUMtableau,int nbLigne) throws Exception {
	
		Page page = extractWiki.extractTables(listUrl.get(indiceUrls), false);
		
		assertEquals(nbLigne, page.getListeTableau().get(NUMtableau).getlisteLignes().size(),
				"le nombre de lignes  doit etre "+ nbLigne);
	
	}
	
	@DisplayName("Test l'extracteur : tester le nombre de colonnes d'un tableau ")
	@ParameterizedTest
	@CsvSource(
			{"0, 0, 6",
			 "0 ,1,  2"
			})
	public void testNombreColonneTableau(int indiceUrls,int NUMtableau,int nbColonne) throws Exception {
	
		Page page = extractWiki.extractTables(listUrl.get(indiceUrls), false);
		
		assertEquals(nbColonne, page.getListeTableau().get(NUMtableau).getlisteLignes().get(0).getListCelluleLigne().size(),
				"le nombre de colonnes doit etre "+ nbColonne);
	
	}
}