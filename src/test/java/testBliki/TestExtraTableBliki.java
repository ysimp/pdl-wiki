package testBliki;

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

import info.bliki.wiki.model.WikiModel;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;
import utils.CSVUtils;
import utils.Cellule;
import utils.Ligne;
import utils.Page;
import utils.Tableau;

public class TestExtraTableBliki {
	@DisplayName("TransTableCSV_Bliki")
	@Tag("TransTableCSV_Bliki")
	@Test

	public Boolean extractionTableJsoup(String url) throws IOException {
		List<String> donneesLigneTableau = new ArrayList<String>();
		List<List<String>> donneesTableau = new ArrayList<List<String>>();
		List<List<List<String>>> donneesPage = new ArrayList<List<List<String>>>();
		String csvFileRacine = "output" + File.separator + "wikitext" + File.separator;
		int numTab = 0;
		Element table = null;
		Elements rows = null;
		Elements td = null;
		Elements tables = null;
		Boolean testAccessDOM = false;
		String BASE_WIKIPEDIA_URL_wikiTest = "https://en.wikipedia.org/w/";
		MediaWikiBot wikiBot = new MediaWikiBot(BASE_WIKIPEDIA_URL_wikiTest);
<<<<<<< HEAD
		Article article = wikiBot.getArticle(url);
		String html = WikiModel.toHtml(article.getText());
		Document docHtml = Jsoup.parse(html);
		if (docHtml != null) {
			testAccessDOM = true;
=======
	    Article article = wikiBot.getArticle(url);
	   // System.out.println(article.getText());
	    
	    String html =  WikiModel.toHtml(article.getText());
	    Document docHtml = Jsoup.parse(html);
	//    String wurl = BASE_WIKIPEDIA_URL+url;
	    
	    
	    /*
	    
	    try {
	    	docHtml = Jsoup.connect(url).get();
	           if (doc!=null) {
	        	   testAccessDOM = true;
			}
	           
	           
	       } catch (IOException e) {
	    	   System.out.println("Erreur de connexion, vous vous êtes sans doute trompé dans la saisie de l'url");
	       }
*/
	    
	    if (docHtml != null || docHtml == null) {
	    	testAccessDOM = true;
>>>>>>> 4c3c0a10241affab817eb7d4975192f54bfc61f7
		}
		if (testAccessDOM == true) {
			tables = docHtml.select("table");
			if (tables.size() == 0) {
				System.out.println(" Attention !!! La page à l'étude n'a pas de tableau ...");
			}
			Page page = new Page();
			page.setNomPage(BASE_WIKIPEDIA_URL_wikiTest + url);
			List<Tableau> listTableau = new ArrayList<Tableau>();
			for (int t = 0; t < (tables.size() - 1); t++) {
				Tableau tableau = new Tableau();
				numTab++;
				String helpFileName;
				helpFileName = CSVUtils.assureFomatDosTab(url);
				String tableauCSV = csvFileRacine + CSVUtils.mkCSVFileName(helpFileName, numTab);
				FileWriter w = new FileWriter(tableauCSV);
				table = tables.get(t);
				rows = table.select("tr");
				List<Ligne> ligneTableau = new ArrayList<Ligne>();
				Ligne ligne = new Ligne();
				for (int i = 1; i < rows.size(); i++) {
					td = rows.get(i).select("td");
					List<Cellule> listCellule = new ArrayList<Cellule>();
					for (int k = 0; k < td.size(); k++) {
						System.out.println(" | " + td.get(k).text() + " | ");
						Cellule cellule = new Cellule(k, CSVUtils.assureFomatCSV(td.get(k).text()));
						listCellule.add(cellule);
						donneesLigneTableau.add(CSVUtils.assureFomatCSV(td.get(k).text()));
					}

					ligne.setLigneTableau(donneesLigneTableau);
					ligne.setNumeroLigne(i);
					ligne.setListCelluleLigne(listCellule);

					CSVUtils.writeLine(w, donneesLigneTableau);
					donneesTableau.add(donneesLigneTableau);
					ligneTableau.add(ligne);
					donneesLigneTableau.clear();
				}
				donneesPage.add(donneesTableau);
				tableau.setLigneTableau(ligneTableau);
				donneesTableau.clear();
				listTableau.add(tableau);
				ligneTableau.clear();
				w.flush();
				w.close();
				System.out.println("fin de la création N° " + numTab + " )  de la page" + page.getNomPage() + " \n");
			}
			page.setPage(listTableau);

		}

		return testAccessDOM;
	}

}
