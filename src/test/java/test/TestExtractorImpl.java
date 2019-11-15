package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import Interface.Extractor;
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

	@DisplayName("Test NbreDeTableauJsoup sans le filtre")
    @ParameterizedTest
    @CsvSource(
            {"0, 13",
             "1, 9"
            })
    public void testNbreDeTableauJsoup(int indiceUrls,int nbTableTotal) throws Exception {
    
		Document dochtml= ConverterUtil.getDocumentJsoup(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indiceUrls));
		
        Page page = extractor.extractTables(dochtml, false);
        
        assertEquals(nbTableTotal, page.getTotalTableau(), "le nombre total de tableau devrait être egal à "+ nbTableTotal);
    
    }
	
	@DisplayName("Test NbreDeTableauBliki sans le filtre")
    @ParameterizedTest
    @CsvSource(
            {"0, 13",
             "1, 9"
            })
    public void testNbreDeTableauBliki(int indiceUrls,int nbTableTotal) throws Exception {
    
		Document dochtml= ConverterUtil.getDocumentWiki(listUrl.get(indiceUrls));
		
        Page page = extractor.extractTables(dochtml, false);
        
        assertEquals(nbTableTotal, page.getTotalTableau(), "le nombre total de tableau devrait être egal à "+ nbTableTotal);
    
    }
	
	@DisplayName("test NbreDeTableauJsoup2 avec le filtre")
    @ParameterizedTest
    @CsvSource(
            {"0, 13",
             "1, 9"
            })
    public void testNbreDeTableauJsoup2(int indiceUrls,int nbTableTotal) throws Exception {
    
		Document dochtml= ConverterUtil.getDocumentJsoup(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indiceUrls));
		
        Page page = extractor.extractTables(dochtml, true);
        
        assertEquals(nbTableTotal, page.getTotalTableau(), "le nombre total de tableau devrait être egal à "+ nbTableTotal);
    
    }
	
	@DisplayName("test NbreDeTableauBliki2 avec le filtre")
    @ParameterizedTest
    @CsvSource(
            {"0, 13",
             "1, 9"
            })
    public void testNbreDeTableauBliki2(int indiceUrls,int nbTableTotal) throws Exception {
    
		Document dochtml= ConverterUtil.getDocumentWiki(listUrl.get(indiceUrls));
		
        Page page = extractor.extractTables(dochtml, true);
        
        assertEquals(nbTableTotal, page.getTotalTableau(), "le nombre total de tableau devrait être egal à "+ nbTableTotal);
    
    }
	
	@DisplayName("test NombreLigneTableau Html")
	@ParameterizedTest
	@CsvSource(
			{"0, 0, 0",
			 "0 ,1, 15"
			})
	public void testNombreLigneTableauHtml(int indiceUrls,int NUMtableau,int nbLigne) throws Exception {
	
		Document dochtml= ConverterUtil.getDocumentJsoup(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indiceUrls));
		
		Page page = extractor.extractTables(dochtml,false);
		
		assertEquals(nbLigne, page.getListeTableau().get(NUMtableau).getlisteLignes().size(),
				"le nombre de lignes  doit etre "+ nbLigne);
	
	}

	@DisplayName(" test NombreLigneTableau Bliki")
	@ParameterizedTest
	@CsvSource(
			{"0, 0, 6",
			 "0 ,1,  2"
			})
	public void testNombreLigneTableauBliki(int indiceUrls,int NUMtableau,int nbLigne) throws Exception {
	
		Document dochtml= ConverterUtil.getDocumentWiki(listUrl.get(indiceUrls));
		
		Page page = extractor.extractTables(dochtml,false);
		
		assertEquals(nbLigne, page.getListeTableau().get(NUMtableau).getlisteLignes().size(),
				"le nombre de lignes  doit etre "+ nbLigne);
	
	}
	@DisplayName(" test NombreColonneTableau Html")
	@ParameterizedTest
	@CsvSource(
			{"0, 0, 6",
			 "0 ,1,  2"
			})
	public void testNombreColonneTableauHtml(int indiceUrls,int NUMtableau,int nbColonne) throws Exception {
	
		Document dochtml= ConverterUtil.getDocumentJsoup(Constant.BASE_WIKIPEDIA_URL+listUrl.get(indiceUrls));
		
		Page page = extractor.extractTables(dochtml,false);
		
		assertEquals(nbColonne, page.getListeTableau().get(NUMtableau).getlisteLignes().get(0).getListCelluleLigne().size(),
				"le nombre de colonnes doit etre "+ nbColonne);
	
	}
	
	@DisplayName("test NombreColonneTableau bliki ")
	@ParameterizedTest
	@CsvSource(
			{"0, 0, 6",
			 "0 ,1,  2"
			})
	public void testNombreColonneTableauBliki(int indiceUrls,int NUMtableau,int nbColonne) throws Exception {
	
		Document dochtml= ConverterUtil.getDocumentWiki(listUrl.get(indiceUrls));
		
		Page page = extractor.extractTables(dochtml,false);
		
		assertEquals(nbColonne, page.getListeTableau().get(NUMtableau).getlisteLignes().get(0).getListCelluleLigne().size(),
				"le nombre de colonnes doit etre "+ nbColonne);
	
	}
	
}
