package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;

/**
 * @author yaya
 * @author El Mahjoub
 *
 */

public class FilterTable {

	List<String> listeClasses;
	List<String> listeattr;
	
	private Map<String,String> stats;
	
	
	/**
	 * constructor
	 */
	public FilterTable()
	{
		try {
			
			//lire la liste des attributs html ( colspane , rowspane)
			 listeattr=CSVUtils.getListFromFile(Constant.ATTRIBUT_TO_REMOVE);
			
			// lire la liste des classe css (infobox ,colapse) 
			 listeClasses=CSVUtils.getListFromFile(Constant.CLASS_TO_REMOVE);
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Permet de filtrer les tableaux (url) : supprimer les tableaux qui ne repondent pas aux critère de pertinence
	 * @parm url du page wikipedia
	 * @return les tableaux après filtrage
	 * @throws
	 * @throws
	 * 
	 * */
	public Elements filterTables(Document doc ) throws Exception {
		
		Elements tables;
		
		stats=new HashMap<String, String>();
		
		// avant filtrage
		String nbreTable=String.valueOf(doc.select("table").size());
		stats.put("nbreTable",nbreTable );
		
		// application du filtre 
		
		tables = removeTableByClass(doc);
		
		tables = removeTableByAttribut(tables);
		
		// apres filtrage
		String nbreTable2=String.valueOf(tables.size());
		stats.put("nbreTableAFterFilter",nbreTable2 );
		
		return tables;
		
		
	}
	
	/**
	 * Supprime tous les tableaux contenant les class definis dans le fichier classtoremove
	 * 
	 * */
	public  Elements removeTableByClass(Document doc) throws Exception {
		
		
		Elements tables = doc.select("table");
		Elements tablesToRemove;
				
		for(String classe:listeClasses)
		{  	
			//Recupère tous les elements dans les elements se trouvant dans le doc ayant la class passée en param
			//Ensuite selectionne que les tableaux qui seront supprimés
			tablesToRemove = Collector.collect(new Evaluator.Class(classe), doc).select("table");		
			
			stats.put(classe, String.valueOf(tablesToRemove.size()));
			
			tables.removeAll(tablesToRemove);
	
		}
		
			
		return tables;

	}
	
	/**
	 * Supprime tous les tableaux contenant les attributs definis dans le fichier attributstoremove
	 * 
	 * */
	public  Elements removeTableByAttribut(Elements tables) throws Exception {

		
		List<Element> listTablesToRemove = new ArrayList<Element>();

		for(String attr:listeattr)
		{
			int nb=0;
			for (Element table : tables) {
				
				Elements trToRemoves =Collector.collect(new Evaluator.Attribute(attr), table);
				
				if(!trToRemoves.isEmpty())
				{ 
					listTablesToRemove.add(table);
					nb++;
				}
				
			}
			stats.put(attr, String.valueOf(nb));
		}
	
		tables.removeAll(listTablesToRemove);
		
		return tables;

	}
	
	/**
	 * return les statistique sur l'article filter
	 * @return
	 */
	public Map<String, String> getStatistique()
	{
		return this.stats;
	}
	
	/**
	 * Supprime les tables ayant moins de ligne
	 * */
	public Elements removeTablesWithMinRowOrColum(Elements tables) {
		
		List<Element> listTablesToRemove =new ArrayList<Element>();
		
		for (Element table : tables) {
			
			Elements trs = table.select("tr");

			if(trs.size() <= Constant.MIN_ROW ) {
				
				listTablesToRemove.add(table);
				
			}else
			{
				Elements tds = trs.get(0).select("td");
		
				if(tds.size() <= Constant.MIN_COLUM) {
					
					listTablesToRemove.add(table);	
				}
				
			}
			
		}
		
		tables.removeAll(listTablesToRemove);
		
		return tables;
	}
	
	
	
	

		
}