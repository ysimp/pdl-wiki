package wikiText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	public void convertAllTablesToCsv(String url) throws IOException  {
		
		String fileName;
		FileWriter w=null;
		String tableauCSV;
		fileName= CSVUtils.assureFomatDosTab(url);		
		
		Page page=extractorWiki.extractTables(url);
		
		
		page.setNomPage(fileName);
		
		StatPrinter.printStatPage(page) ;
		
		for (Tableau tab : page.getListeTableau()) {
			
			//Forme le chemin du fichier, nomPage+numTab
			tableauCSV =Constant.CSV_WIKI_PATH + CSVUtils.mkCSVFileName(fileName, tab.getNumeroTableau());
			 w = new FileWriter(tableauCSV,false);
			
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
	
	public void convertAllPages() throws IOException{
		
		File file = new File(Constant.WIKI_URL_PATH);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String url="";
		
		while((url=br.readLine())!=null) {
			
			convertAllTablesToCsv(url);
		}
		br.close();
		
	}
	
	

}
