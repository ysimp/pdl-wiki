package utils;

import java.io.File;

/**
 * @author Simpara Yaya
 * @author Hajar Jahoui
 * @author Mahjoub Mohamed
 * @author Jihad Jahoui
 * */

/**
 * Definition des
 * */
public class Constant {

	public static String BASE_WIKIPEDIA_URL_wikiTest = "https://en.wikipedia.org/w/";
	
	public static String BASE_WIKIPEDIA_URL = "https://en.wikipedia.org/";
	
	public static String OUTPUT_PATH = "output" + File.separator ;
	
	public static String CSV_HTML_PATH = "output" + File.separator + "html" + File.separator;
	
	public static String CSV_WIKI_PATH = "output" + File.separator + "wikitext" + File.separator;
	
	public static String WIKI_URL_PATH = "inputdata" + File.separator + "wikiurls.txt";
	
	public static String CLASS_TO_REMOVE = "inputdata" + File.separator + "classToRemove.txt";
	
	public static String ATTRIBUT_TO_REMOVE = "inputdata" + File.separator + "attributToRemove.txt";
}