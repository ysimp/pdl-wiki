package html;

import utils.CSVUtils;
import utils.Constant;

public class testHtml {
	
	public static void main(String[] args) {
		
		try {
					CSVUtils.creatOutPutFolder(Constant.CSV_HTML_PATH);
					new ConverterHtmlImp().convertAllPages();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
