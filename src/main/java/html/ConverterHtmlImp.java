package html;


import java.io.FileWriter;
import java.util.List;

import model.Page;
import model.Tableau;
import utils.CSVUtils;
import utils.Constant;

public class ConverterHtmlImp implements ConverterHtml{
	private ExtractorHtml extractorHtml;
	
	public ConverterHtmlImp() {
		this.extractorHtml = new ExtractorHtmlImp();
	}



	public void convertAllTablesToCsv(String url) throws Exception {
		String tableauCSV;
		String fileName;
		fileName = CSVUtils.constructFileName(url);	
		FileWriter out=null;
		
		Page page = extractorHtml.extractTables(url,false);
		page.setNomPage(fileName);
		
	
			
			for (Tableau tab : page.getListeTableau()) {
				tableauCSV =Constant.CSV_HTML_PATH + CSVUtils.mkCSVFileName(fileName, tab.getNumeroTableau());
				out = new FileWriter(tableauCSV,false);
				CSVUtils.writeTableJsoup(out, tab);
				out.flush();
				out.close();
					
			}	
		
	
		
		
	}

	public void convertAllPages() throws Exception {
		
		List<String> liste = CSVUtils.getListFromFile(Constant.WIKI_URL_PATH);
		for (String urL : liste) {
			
			convertAllTablesToCsv(urL);
		}
			
		
	}

}

