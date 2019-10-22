package wikiText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;

import com.google.common.base.Optional;

import info.bliki.wiki.model.WikiModel;
import model.Ligne;
import model.Page;
import model.Tableau;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;
import utils.CSVUtils;
import utils.Constant;

public class ExtractorWikiTextImpl implements ExtractorWikitext {


	Logger loggerWiki = Logger.getLogger("WikiLoger");
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
	    	
	    	page.setTotalTableau(tables.size());
	    	
	    	//tables = filterTables(tables);
	    	
	    	
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

	public Elements filterTables(Elements tables) throws Exception {
		
		tables = removeTableByClass(tables);
		
		return tables;
		
		
	}
	
	/**
	 * Supprime tous les tableaux contenant les class definis dans le fichier classtoremove
	 * 
	 * */
	private Elements removeTableByClass(Elements tables) throws Exception {

		List<String> listeClasses=getListOfClassOrAttrubitToRemove(Constant.CLASS_TO_REMOVE);
		List<Element> listTableToRemove=new ArrayList<Element>();
		Element elem;
		
		for (Element table : tables) {
			
			Set<String> set = table.classNames();
			
			for (String classe : set) {
				
						
			}
				
			
		}

		for(String classe:listeClasses)
		{
			
			tables = tables.not("."+classe);
		}
		
		return tables;

	}
	
	/**
	 * Supprime tous les tableaux contenant les attributs definis dans le fichier attributstoremove
	 * 
	 * */
	private Elements removeTableByAttribut(Elements tables) throws Exception {

		List<String> listeattr=getListOfClassOrAttrubitToRemove(Constant.ATTRIBUT_TO_REMOVE);

		for(String attr:listeattr)
		{
			
			tables = tables.not("["+attr+"]");
		}
		
		return tables;

	}
	
	// lire le fichier class_to_romve et return sous forme d'un arrayliste 
	private List<String> getListOfClassOrAttrubitToRemove(String fileName) throws Exception
	{
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		List<String> liste=new ArrayList<String>();
		String classe="";
		
		while((classe=br.readLine())!=null) {
			
			liste.add(classe);
		}
		
		br.close();
		
		return liste;
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
