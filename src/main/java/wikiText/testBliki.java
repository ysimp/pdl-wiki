package wikiText;

import java.io.File;

import utils.CSVUtils;
import utils.Constant;

public class testBliki {

	public static void main(String[] args) {
		

		try {
		
			new ConverterWikiTextImpl(false).convertAllPages();
			
			System.out.println("nombre de fichier générés"+ new File(Constant.CSV_WIKI_PATH).listFiles().length);
			System.out.println("nombre total de tableau "+CSVUtils.nbreTableauBlikiTotal());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
