package convertor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import info.bliki.wiki.model.WikiModel;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;
import utils.Constant;

public class ConverterUtil {

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
	
	public  static Document getDocumentJsoup(String url) {
		

		Document doc;
		try {
			
			 doc =Jsoup.connect( url).get();

			return doc;
		} catch (Exception e) {
			
			//logger.info("Erreur de connexion, vous vous êtes sans doute trompé dans la saisie de l'url"+" "+url);
			return null;
		}
		
	}
}
