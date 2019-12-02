package implementation;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;

import utils.CSVUtils;
import utils.Constant;
import utils.ConverterUtil;
import utils.StatistiqueUtils;
import utils.filterTable;

/**
 * @author Hajar 
 * @author Jihad
 * @author yaya
 * @author El Mahjoub
 *
 */
public class LaunchConvertor {

	private ConverterImp convert;
	private List<String> listUrls;
	private Document html;
	private Document wiki;
	private filterTable filter;
	Map<String,String> stats;
	FileWriter writerStats ;
	
	public  LaunchConvertor()
	{
		
		filter=new filterTable();	
		convert=new ConverterImp(filter);
	}
	public void convertAllPages() throws Exception{
		
		//lire fichier input ( tous les urls ) 
		listUrls=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		
		// cree le fichier qui contient les statistique
		writerStats= new FileWriter("rappport.csv",false);
		StatistiqueUtils.writeHeaderFileStatistique(writerStats);
		
		 // create dossier output 
		 CSVUtils.creatOutPutFolder();
		
		for (String url : listUrls) {
			
			// html document 
		    html=ConverterUtil.getDocumentJsoup(Constant.BASE_WIKIPEDIA_URL+url);
		    
			convert.convertAllTablesToCsv(html, url,Constant.CSV_HTML_PATH);
			
			stats=filter.getStatistique();
			
			StatistiqueUtils.writeStatByArticle(stats, writerStats);
			
			// wikitext 
		   
			wiki=ConverterUtil.getDocumentWiki(url);
			convert.convertAllTablesToCsv(wiki, url,Constant.CSV_WIKI_PATH);
			
			stats=filter.getStatistique();
			
			StatistiqueUtils.writeStatByArticle(stats, writerStats);
		}
			

		//fermer le fichier de stats
		writerStats.flush();
		writerStats.close();
		
	}

public static void main(String[] args) {
	
	try {
		
		new LaunchConvertor().convertAllPages();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
