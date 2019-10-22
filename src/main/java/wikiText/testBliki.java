package wikiText;

import utils.CSVUtils;

public class testBliki {

	public static void main(String[] args) {
		
		

		try {
			CSVUtils.creatOutPutFolder();
			new ConverterWikiTextImpl().convertAllPages();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
