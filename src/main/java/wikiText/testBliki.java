package wikiText;

import java.io.IOException;

public class testBliki {

	public static void main(String[] args) {
		
		

		try {
			new ConverterWikiTextImpl().convertAllPages();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
