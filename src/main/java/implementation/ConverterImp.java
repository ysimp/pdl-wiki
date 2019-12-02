package implementation;

import java.io.FileWriter;
import java.util.logging.Logger;

import org.jsoup.nodes.Document;

import Interface.Converter;
import Interface.Extractor;
import model.Page;
import model.Tableau;
import utils.CSVUtils;
import utils.FilterTable;

/**
 * 
 * @author Hajar 
 * @author Jihad
 *
 */
public class ConverterImp implements Converter {

	 Logger logger;
	 Extractor extractor;
	 FilterTable filter;
	
	 public ConverterImp(FilterTable filter)
	{
			extractor=new ExtractorImpl(filter);
			logger = Logger.getLogger("Logger");
	}
	 
	public ConverterImp()
	{
		extractor=new ExtractorImpl();
		logger = Logger.getLogger("Logger");
	}
	
	
	
	public void convertAllTablesToCsv(Document doc,String url,String output) throws Exception {
		
		String fileName;
		FileWriter w=null;
		String tableauCSV;
		fileName= CSVUtils.constructFileName(url);	
		
		// extraire l'article
		Page page=extractor.extractTables(doc,true);
		
		page.setNomPage(fileName);
			
		//pour chaque tableau dans l'article 
		for (Tableau tab : page.getListeTableau()) {
			
			//Forme le chemin du fichier, nomPage+numTab
			tableauCSV =output + CSVUtils.mkCSVFileName(fileName, tab.getNumeroTableau());
			 w = new FileWriter(tableauCSV,false);
			
			 CSVUtils.writeTable(w, tab);	
		}
	}

}
