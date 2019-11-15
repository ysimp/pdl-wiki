package utils;

import java.util.List;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import info.bliki.wiki.model.WikiModel;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;

public class ConverterUtil {

	static Logger logger = Logger.getLogger("WikiLoger2");

    
    /**
     * 
     * @param url
     * @return
     * @throws Exception
     */
    public static int nbreTableauJsoup(String url) throws Exception {
    	
    	Document doc =null;
    	Elements tables =null;
    	
    	String urlpage = Constant.BASE_WIKIPEDIA_URL + url;
    	
    	
			doc = Jsoup.connect(urlpage).get();
			
			if(doc!=null) {
				
				tables =doc.select("table");
				return tables.size();
			}
	
    	return -1;
    }
    
    /**
     * 
     * @param url
     * @return
     * @throws Exception
     */
    public static int nbreTableauBliki(String url) throws Exception {
    	
    	Document docHtml =null;
    	MediaWikiBot wikiBot = new MediaWikiBot(Constant.BASE_WIKIPEDIA_URL_wikiTest);
	    Article article = wikiBot.getArticle(url);
	    if(article.getText().isEmpty()) {
	    	return -1;
	    }
	    else {
	    String html =  WikiModel.toHtml(article.getText());
	     docHtml = Jsoup.parse(html);
	    return docHtml.select("table").size();
	    }
    }
    
    /**
     * 
     * @return
     * @throws Exception
     */
    
    public static int nbreTableauBlikiTotal() throws Exception {
    	
    	
	    List<String> listUrls=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
	    
	    int somme=0;
	    for (String url : listUrls) {
			somme+=nbreTableauBliki(url);
		}
	    
	    return somme;
    }
    
    /**
     * 
     * @return
     * @throws Exception
     */
    
    public static int nbreTableauJsoupTotal() throws Exception {
    	
    	
	    List<String> listUrls=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
	    
	    int somme=0;
	    for (String url : listUrls) {
			somme+=nbreTableauJsoup(Constant.BASE_WIKIPEDIA_URL+url);
		}
	    
	    return somme;
    }
    /**
     * url du article wikipedia 
     * @param url
     * @return
     */
	public static Document getDocumentWiki(String url) {
		
		
		MediaWikiBot wikiBot = new MediaWikiBot(Constant.BASE_WIKIPEDIA_URL_wikiTest);
	    Article article = wikiBot.getArticle(url);
	    if(article.getText().isEmpty()) {
	    	
	    	return null;
	    }
	    else {
	    String html =  WikiModel.toHtml(article.getText());
	    Document docHtml = Jsoup.parse(html);
	    return docHtml;
	    }
	}
	
	/**
	 * 
	 * @param url complet avec la base 
	 * @return
	 */
	public  static Document getDocumentJsoup(String url) {
		

		Document doc;
		try {
			
			 doc =Jsoup.connect( url).get();

			return doc;
		} catch (Exception e) {
			
			logger.info("Erreur de connexion, vous vous êtes sans doute trompé dans la saisie de l'url"+" "+url);
			
			return null;
		}
		
	}
}
