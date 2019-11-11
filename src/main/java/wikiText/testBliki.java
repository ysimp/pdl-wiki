package wikiText;

import java.io.File;

import utils.Constant;

public class testBliki {

	public static void main(String[] args) {
		

		try {
		
			new ConverterWikiTextImpl(false).convertAllPages();
			
			System.out.println( new File(Constant.CSV_WIKI_PATH).listFiles().length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
