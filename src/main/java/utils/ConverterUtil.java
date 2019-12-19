package utils;

import java.util.List;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import info.bliki.wiki.model.WikiModel;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;

/**
 * @author Hajar 
 * @author Jihad
 * @author yaya
 * @author El Mahjoub
 *
 */
public class ConverterUtil {

	static Logger logger = Logger.getLogger("Loger");

	
    /**
     * recuper document sous forme wikitext qui correspond au url 
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
	 * recuper document sous forme html qui correspond au url 
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
    	
    	try {
    		doc = Jsoup.connect(urlpage).get();
    		
    		if(doc!=null) {
				tables =doc.select("table");
				return tables.size();
			}
    		
    		return -1;
    		
		} catch (Exception e) {
			return -1;
		}

    	
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
     * return nombre de tableau total extrait par l'extractor bliki
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
     *  return nombre de tableau total extrait par l'extractor jsoup
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

}
