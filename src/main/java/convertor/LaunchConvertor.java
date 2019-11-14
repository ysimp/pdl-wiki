package convertor;

import java.util.List;

import org.jsoup.nodes.Document;

import utils.CSVUtils;
import utils.Constant;

public class LaunchConvertor {

	public void convertAllPages() throws Exception{
		
	  ConverterImp convert=new ConverterImp();
	  
	List<String> listUrls=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
	 
	
	 // create dossier output wikitext
	 CSVUtils.creatOutPutFolder();
	
	 
	for (String url : listUrls) {
		
		Document html=ConverterUtil.getDocumentJsoup(Constant.BASE_WIKIPEDIA_URL+url);
		Document wiki=ConverterUtil.getDocumentWiki(url);
		
		convert.convertAllTablesToCsv(html, url,Constant.CSV_HTML_PATH);
		
		convert.convertAllTablesToCsv(wiki, url,Constant.CSV_WIKI_PATH);
	}
		
		
		
		
	}




public static void main(String[] args) {
	
	try {
		new LaunchConvertor().convertAllPages();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
