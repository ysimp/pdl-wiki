package html;

import utils.CSVUtils;

public class testHtml {
	
	public static void main(String[] args) {
		
		try {
					CSVUtils.creatOutPutFolder();
					new ConverterHtmlImp().convertAllPages();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
