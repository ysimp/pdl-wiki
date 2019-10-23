package wikiText;

import java.util.logging.Logger;

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
import utils.filterTable;

public class ExtractorWikiTextImpl implements ExtractorWikitext {


	Logger loggerWiki = Logger.getLogger("WikiLoger");
	
	private filterTable filter=new filterTable(); 
	
	/**
	 * {@inheritDoc}
	 */
	public Page extractTables(String url) throws Exception {
		
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
	    	
	    	page.setTotalTableau(tables.size());
	    	
	    	tables =filter.filterTables(docHtml);
	    	
	    	
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

	
	
	/**
	 * Permet de recuperer une page et le tranforme en html
	 * @param WikiUrl : le nom de l'article lit depuis le fichier 
	 * */
	
	public Document getDocumentFromUrl(String url) {
		
		
			MediaWikiBot wikiBot = new MediaWikiBot(Constant.BASE_WIKIPEDIA_URL_wikiTest);
		    Article article = wikiBot.getArticle(url);
		    if(article==null) {
		    	loggerWiki.warning(url+" n'existe pas");
		    	return null;
		    }
		    else {
		    String html =  WikiModel.toHtml(article.getText());
		    Document docHtml = Jsoup.parse(html);
		    
		    return docHtml;
		    }
	}
	


}
