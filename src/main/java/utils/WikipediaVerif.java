package utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WikipediaVerif {

	/**
	 * Permet de verifier si url existe
	 * @param url
	 * @return boolean
	 * @throws IOException 
	 * */
	public static boolean urlExist(String url) throws IOException {
		try {
			Document doc=Jsoup.connect(url).get();
			return doc!=null;
		} catch (IOException e) {
			return false;
		}
	}
	
	
	/**
	 * Permet de verifier si url correspond à un article
	 * @param url
	 * @return boolean
	 * @throws IOException 
	 * */
	public static boolean isArticleWikipedia(String url) throws IOException {
		return (urlExist(url)&&url.toLowerCase().contains("wikipedia"));
	}
	
	
}