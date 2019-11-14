package convertor;

import java.io.FileWriter;
import java.util.logging.Logger;

import org.jsoup.nodes.Document;

import model.Page;
import model.Tableau;
import utils.CSVUtils;

public class ConverterImp implements Converter {

	Logger logger = Logger.getLogger("WikiLoger2");
	private Extractor extractor=new ExtractorImpl();
	
	public void convertAllTablesToCsv(Document doc,String url,String output) throws Exception {
		
		String fileName;
		FileWriter w=null;
		String tableauCSV;
		fileName= CSVUtils.constructFileName(url);	
		
		Page page=extractor.extractTables(doc,false);
		
		page.setNomPage(fileName);
			
		//StatPrinter.printStatPage(page) ;
		
		for (Tableau tab : page.getListeTableau()) {
			
			//Forme le chemin du fichier, nomPage+numTab
			tableauCSV =output + CSVUtils.mkCSVFileName(fileName, tab.getNumeroTableau());
			 w = new FileWriter(tableauCSV,false);
			
			CSVUtils.writeTable(w, tab);
			w.flush();
			w.close();
			
		}
	}



}
