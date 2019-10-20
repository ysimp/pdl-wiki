package wikiText;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import info.bliki.wiki.model.WikiModel;
import model.Ligne;
import model.Page;
import model.Tableau;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;
import utils.CSVUtils;
import utils.Constant;

public class ExtractorWikiTextImpl implements ExtractorWikitext {

	/**
	 * {@inheritDoc}
	 */
	public Page extractTables(String url) throws IOException {
		
		// recupere document correspond au url 
		Document docHtml = getDocumentFromUrl(url);
	    Elements rows = null;
	    Elements tds = null;
	    Elements tables = null;
	    Page page =new Page();
	    String cell;
	    Ligne line;
	    Tableau tab;
	    int numTab=1;
	    	
		if (docHtml != null) {
	    	
	    	tables = docHtml.select("table"); // recupere les tableau dans la page 
	    	
			//Parcours du tableau
			for (Element t : tables) {
				tab = new Tableau();
				tab.setNumeroTableau(numTab);
				numTab++;
				
				rows = t.select("tr");
				 
				 //Parcours toutes les lignes 
				for (Element row : rows) {
					 line = new Ligne();
					 
					tds = row.select("th,td");
					
					//Pour chaque Colonne de la ligne on recupère le contenu
					for (Element td : tds) {
						
						cell =  td.text().toString();
						cell= CSVUtils.assureFomatCSV(cell);
						line.addCellule(cell);
					}
					
					tab.addLine(line);
				}
				
				 page.addTableau(tab);
			}
		
		}

		return page;
	}

	public Elements filterTables(Elements tables) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	/**
	 * Permet de recuperer une page et le tranforme en html
	 * @param WikiUrl : le nom de l'article lit depuis le fichier 
	 * */
	
	public Document getDocumentFromUrl(String url) {
		
		
			MediaWikiBot wikiBot = new MediaWikiBot(Constant.BASE_WIKIPEDIA_URL_wikiTest);
		    Article article = wikiBot.getArticle(url);
		    
		    String html =  WikiModel.toHtml(article.getText());
		    Document docHtml = Jsoup.parse(html);
		    
		    return docHtml;
	}

}
