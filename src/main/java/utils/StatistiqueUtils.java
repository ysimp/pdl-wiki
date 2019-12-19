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
		
		// ecrire le nom de l'article puis le nom de l'extractor
		writer.append(stats.get("Article") +" ,");
		writer.append(stats.get("Extractor") +" ,");
		
		writer.append(stats.get("nbreTable") +" ,");
		writer.append(stats.get("nbreTableAFterFilter") +" ,");
		
		stats.remove("Article");
		stats.remove("Extractor");
		
		stats.remove("nbreTable");
		stats.remove("nbreTableAFterFilter");
		
		//ecrire les autres valeurs 
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
		
		
		colonnes.add("Article");
		colonnes.add("Extractor");
		colonnes.add("nbreTable");
		colonnes.add("nbreTableAFilter");
		
		colonnes.addAll(listeClasses);
		colonnes.addAll(listeattr);
	
		
		for (String colonne : colonnes) {
			
			writer.append(colonne +" ,");
		}
		
		writer.append("\n");
		
	}
}
