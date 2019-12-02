package utils;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**

 * @author yaya
 * @author El Mahjoub
 *
 */
public class StatistiqueUtils {
	
	

	/**
	 * ecrire les stats d'un article donne 
	 * @param stats ( cle valeur )
	 * par example le nom de l'extratctor , le nombre  de page total dans l'article, 
	 * @throws IOException 
	 */
	
	public  static void writeStatByArticle(Map<String,String> stats, Writer writer) throws IOException
	{
		
		for (String valeurs : stats.values()) {
			
			writer.append(valeurs +" ,");
		}
		
		writer.append("\n");
			
		
	}
	
	/**
	 *  preparer le fichier (rapport) de statistique
	 *  ecrire les entete des colonnes
	 * @param writer fichier statistique
	 * @throws IOException 
	 */
	public static void writeHeaderFileStatistique(Writer writer) throws Exception
	{
		List<String> colonnes=new ArrayList<String>();
		
		// lire la liste des classe css (infobox ,colapse) 
		List<String> listeClasses=CSVUtils.getListFromFile(Constant.CLASS_TO_REMOVE);
		
		 //lire la liste des attributs html ( colspane , rowspane) 
		List<String>  listeattr=CSVUtils.getListFromFile(Constant.ATTRIBUT_TO_REMOVE);
		
		// format du rapport
		
		colonnes.add("Extractor");
		colonnes.add("Article");
		colonnes.addAll(listeClasses);
		colonnes.addAll(listeattr);
		colonnes.add("nbreTable");
		colonnes.add("nbreTableAFterFilter");
		
		for (String colonne : colonnes) {
			
			writer.append(colonne +" ,");
		}
		
		writer.append("\n");
		
	}
}
