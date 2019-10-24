package jsoup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.jsoup.nodes.Element;

import utils.Tableau;

public class ConverterHtmlImp implements ConverterHtml{
	private ExtractorHtml extractorHtml;
	
	public ConverterHtmlImp() {
		this.extractorHtml = new ExtractorHtmlImp();
	}

	public void convertTableToCsv(Element table) {
		// TODO Auto-generated method stub
		
	}

	public void convertAllTablesToCsv(String url) {
		String tableauCSV;
		String fileName;
		FileWriter out=null;
		File file = new File(Constant.WIKI_URLS_FILE_PATH);
		FileReader reader = new FileReader(file);
		BufferedReader buff =  new BufferedReader(reader);
		String title = null;

		while ((title = buff.readLine()) != null) {
			for (Tableau tab : page.getListeTableau()) {
				tableauCSV =Constant.CSV_WIKI_PATH + CSVUtils.mkCSVFileName(fileName, tab.getNumeroTableau());
				out = new FileWriter(tableauCSV,false);
				CSVUtils.writeTable(out, tab);//
			}	
		}
		if(out!=null)
		{
			out.flush();
			out.close();
		}
		
	}

	public void convertAllPages() {
		// TODO Auto-generated method stub
		
	}

}
