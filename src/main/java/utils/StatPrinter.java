package utils;

import java.util.logging.Logger;

import org.luaj.vm2.ast.Stat;

import model.Page;

public class StatPrinter {
	
	static Logger  logger = Logger.getLogger(Stat.class.getName());
	
	public static void printStatPage(Page page) {
		
		logger.info("*******************************************************************************");
		logger.info("*****"+    page.getNomPage()+                              "********************");
		logger.info("******* : Nombre totale de tableau        :"+  page.getNombreTable()+"   *******");
		logger.info("******* : Nombre totale de tableau ignoré :"+  page.getNbIgnoredTables()+"******");
		logger.info("********************************************************************************");
	}
	
	

}
