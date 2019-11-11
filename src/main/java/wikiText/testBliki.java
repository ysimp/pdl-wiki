package wikiText;

public class testBliki {

	public static void main(String[] args) {
		

		try {
		
			new ConverterWikiTextImpl(false).convertAllPages();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
