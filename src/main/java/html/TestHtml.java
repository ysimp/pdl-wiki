package html;

import utils.CSVUtils;

public class TestHtml {
	
	public static void main(String[] args) {
		
		try {
					CSVUtils.creatOutPutFolder();
					new ConverterHtmlImp().convertAllPages();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
