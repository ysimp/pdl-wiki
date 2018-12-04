package testJsoup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.CSVUtils;
import utils.Cellule;
import utils.Ligne;
import utils.Page;
import utils.Tableau;

public class TestExtraTableJsoup {
	Document doc = null;
	@DisplayName("TransTableCSV_Jsoup")
	@Tag("TransTableCSV_Jsoup")
	@Test

	public  Boolean extractionTableJsoup(String url) throws IOException {
		
	    List<String> donnees = new ArrayList<String>();
	    List<List<String>> listLigneTableau = new ArrayList<List<String>>() ;
	    List<List<List<String>>> listLigneChaqTableau = new ArrayList<List<List<String>>>() ;
	    String csvFileRacine ="output" + File.separator + "html" + File.separator;
	    int numTab = 0;
	    Document doc = null;
	    Element table = null;
	    Elements rows = null;
	    Elements td = null;
	    Elements tables = null;
	    Boolean testAccessDOM = false;
	    String BASE_WIKIPEDIA_URL = "https://en.wikipedia.org/wiki/";
	    String wurl = BASE_WIKIPEDIA_URL+url;
	    
	    /*
	    List<String> listNomPageZeroTable = new ArrayList<String>();
	    List<String> listNomPageEtudeValidees = new ArrayList<String>();
	    List<String> listNomPageEtudeNonValidees = new ArrayList<String>();
	    List<Page> listPageEtudeValidees = new ArrayList<Page>();
	    */
	    
	    try {
	           doc = Jsoup.connect(wurl).get();
	           if (doc!=null) {
	        	   testAccessDOM = true;
			}
	           
	           
	       } catch (IOException e) {
	    	   System.out.println("Erreur de connexion, vous vous êtes sans doute trompé dans la saisie de l'url");
	       }

	    
	    if (testAccessDOM==true) {
	    	tables = doc.select("table"); 	
			if (tables.size() == 0) {
				System.out.println(" Attention !!! La page à l'étude n'a pas de tableau ...");
			}
			
			Page page = new Page();
			page.setNomPage(wurl);
			List<Tableau> listTableau = new ArrayList<Tableau>();
	
			for (int t = 0; t < (tables.size() - 1); t++){
				
				Tableau tableau = new Tableau();
				numTab++;
				String helpFileName;
				helpFileName= CSVUtils.assureFomatDosTab(url);
				// File dir = new File(csvFileRacine +helpFileName );
				//dir.mkdirs();
				String tableauCSV =csvFileRacine+CSVUtils.mkCSVFileName(helpFileName, numTab);
			    FileWriter w = new FileWriter(tableauCSV);
	            table = tables.get(t);          
	            rows = table.select("tr"); 
	            List<Ligne> ligneTableau = new ArrayList<Ligne>();
	            Ligne ligne = new Ligne();
	         
	         for (int i = 1; i < rows.size(); i++){
	         	td = rows.get(i).select("td");
	         	
                    List<Cellule> listCellule = new ArrayList<Cellule>();
	             for (int k = 0; k < td.size(); k++){
	                 System.out.println(" | " +td.get(k).text() + " | ");
                      Cellule cellule = new Cellule(k,CSVUtils.assureFomatCSV(td.get(k).text()));
                      listCellule.add(cellule);
	                 donnees.add( CSVUtils.assureFomatCSV(td.get(k).text())  );
	             }
	          
	             ligne.setLigneTableau(donnees);
	             ligne.setNumeroLigne(i);
	             ligne.setListCelluleLigne(listCellule);
	            
	             CSVUtils.writeLine(w, donnees);
	             listLigneTableau.add(donnees);
	             ligneTableau.add(ligne);
	             donnees.clear();
	         }
	         	         
	         listLigneChaqTableau.add(listLigneTableau);
	         tableau.setLigneTableau(ligneTableau);
	         listLigneTableau.clear();
	         listTableau.add(tableau);
	         ligneTableau.clear();
	         
	         w.flush();
	         w.close();
	         System.out.println("fin de la création N° "+ numTab+ " ) "+tableau+" \n");
	        
	         
			}
			 page.setPage(listTableau);
	
		}
	
		return testAccessDOM;
		
		
	}

}
