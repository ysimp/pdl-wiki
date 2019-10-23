package wikiText;

import java.io.FileWriter;
import java.util.List;

import org.jsoup.nodes.Element;

import model.Page;
import model.Tableau;
import utils.CSVUtils;
import utils.Constant;
import utils.StatPrinter;

public class ConverterWikiTextImpl implements ConverterWikitext{
	
	private ExtractorWikitext extractorWiki;
	
	
	public ConverterWikiTextImpl()
	{
		extractorWiki=new ExtractorWikiTextImpl();
	}
	

	public void convertTableToCsv(Element table) {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * */
	public void convertAllTablesToCsv(String url) throws Exception  {
		
		String fileName;
		FileWriter w=null;
		String tableauCSV;
		fileName= CSVUtils.constructFileName(url);		
		
		Page page=extractorWiki.extractTables(url);
		
		page.setNomPage(fileName);
		
		StatPrinter.printStatPage(page) ;
		
		for (Tableau tab : page.getListeTableau()) {
			
			//Forme le chemin du fichier, nomPage+numTab
			tableauCSV =Constant.CSV_WIKI_PATH + CSVUtils.mkCSVFileName(fileName, tab.getNumeroTableau());
			 w = new FileWriter(tableauCSV);
			
			CSVUtils.writeTable(w, tab);//
			
		}
		
		if(w!=null)
		{
			w.flush();
			w.close();
		}
		
		
	}
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * */
	
	public void convertAllPages() throws Exception{
		
		
		List<String> listUrls=CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		
		for (String url : listUrls) {
			
			convertAllTablesToCsv(url);
		}
		
		
		
	}
	
	

}
