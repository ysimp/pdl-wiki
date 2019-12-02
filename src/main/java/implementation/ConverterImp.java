package implementation;

import java.io.FileWriter;
import java.util.logging.Logger;

import org.jsoup.nodes.Document;

import Interface.Converter;
import Interface.Extractor;
import model.Page;
import model.Tableau;
import utils.CSVUtils;
import utils.filterTable;

/**
 * 
 * @author Hajar 
 * @author Jihad
 *
 */
public class ConverterImp implements Converter {

	 Logger logger;
	 Extractor extractor;
	 filterTable filter;
	
	public ConverterImp()
	{
		extractor=new ExtractorImpl();
		logger = Logger.getLogger("Logger");
	}
	public ConverterImp(filterTable filter)
	{
		extractor=new ExtractorImpl(filter);
		logger = Logger.getLogger("Logger");
	}
	public void convertAllTablesToCsv(Document doc,String url,String output) throws Exception {
		
		String fileName;
		FileWriter w=null;
		String tableauCSV;
		fileName= CSVUtils.constructFileName(url);	
		
		Page page=extractor.extractTables(doc,true);
		
		page.setNomPage(fileName);
			
		for (Tableau tab : page.getListeTableau()) {
			
			//Forme le chemin du fichier, nomPage+numTab
			tableauCSV =output + CSVUtils.mkCSVFileName(fileName, tab.getNumeroTableau());
			 w = new FileWriter(tableauCSV,false);
			
			 CSVUtils.writeTable(w, tab);
			
			
		}
	}

}
