package jsoup;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import utils.CSVUtils;


public class API_JsoupImp {
	
	String url = "https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras";
    List<String> donnees = new ArrayList<String>();
    List<List<String>> listLigneTableau = new ArrayList<List<String>>() ;
    List<List<List<String>>> listLigneChaqTableau = new ArrayList<List<List<String>>>() ;
    String csvFileRacine = "D:\\ABDOUL\\";
    int numTab = 0;
    

    Document doc = null;
    Element table = null;
    Elements rows = null;
    Elements td = null;
    Elements tables = null;
    
    
    
   
	
    
    
    
	public API_JsoupImp(String url, Document doc, Element table, Elements rows, Elements td, Elements tables,
			List<String> donnees, List<List<String>> listLigneTableau, List<List<List<String>>> listLigneChaqTableau,
			String csvFileRacine, int numTab) {
		super();
		this.url = url;
		this.doc = doc;
		this.table = table;
		this.rows = rows;
		this.td = td;
		this.tables = tables;
		this.donnees = donnees;
		this.listLigneTableau = listLigneTableau;
		this.listLigneChaqTableau = listLigneChaqTableau;
		this.csvFileRacine = csvFileRacine;
		this.numTab = numTab;
	}





	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public Document getDoc() {
		return doc;
	}
	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	
	public Element getTable() {
		return table;
	}
	public void setTable(Element table) {
		this.table = table;
	}
	
	
	public Elements getRows() {
		return rows;
	}
	public void setRows(Elements rows) {
		this.rows = rows;
	}
	
	
	public Elements getTables() {
		return tables;
	}
	public void setTables(Elements tables) {
		this.tables = tables;
	}
	
	
	public List<String> getDonnees() {
		return donnees;
	}
	public void setDonnees(List<String> donnees) {
		this.donnees = donnees;
	}
	
	
	public List<List<String>> getListLigneTableau() {
		return listLigneTableau;
	}
	public void setListLigneTableau(List<List<String>> listLigneTableau) {
		this.listLigneTableau = listLigneTableau;
	}
	
	
	public List<List<List<String>>> getListLigneChaqTableau() {
		return listLigneChaqTableau;
	}
	public void setListLigneChaqTableau(List<List<List<String>>> listLigneChaqTableau) {
		this.listLigneChaqTableau = listLigneChaqTableau;
	}
	
	
	public String getCsvFileRacine() {
		return csvFileRacine;
	}
	public void setCsvFileRacine(String csvFileRacine) {
		this.csvFileRacine = csvFileRacine;
	}
	
	
	public int getNumTab() {
		return numTab;
	}
	public void setNumTab(int numTab) {
		this.numTab = numTab;
	}
	
	
	public Elements getTd() {
		return td;
	}
	public void setTd(Elements td) {
		this.td = td;
	}

	
	//1
	public Document connexion(String url) {
		
		 /*
         * Faire une méthode qui permet d'avoir accès au dom de wikipédia; la méthode aura pour paramètre l'url
         * 1-vérifier si l'url existe
         * 2-Vérifier qu'il sagit d'une page wikipedia
         * 3-Retourner le dom de la page
         */
		
		try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		return doc;
	}
    
	
	
    //2
	public Elements getAllTableaux(Document doc) {
		return tables = doc.select("table");
	}
	
	
	//3
	public String createNameTable(String nameBaseTableau, int numTable) {
		return nameBaseTableau+"_"+numTable ;
	}
	
	
	//4
	public String createNameRootFile(String racineFile, String nameTable) {
		return racineFile + nameTable + ".csv" ;
	}
	
	
	//5
	public Element getOnetable(Elements tables , int t) {
		return table = tables.get(t);
	}
	
	
	//6
	public Elements getAllRowsTable(Element table) {
		return rows = table.select("tr"); 
	}
	
	
	//7
	public Elements getAllTdRow(Elements rows, int i) {
		return td = rows.get(i).select("td"); 
	}
	
	
	//8
	public List<String> getAllDataRow (Elements td){
	
		for (int k = 0; k < td.size(); k++){
            System.out.println(" | " +td.get(k).text() + " | ");
            donnees.add(td.get(k).text());
            System.out.println("Cell_N_"+ k +" \n");
        }
		
		return donnees;
	}
	
	
	
	
	public void transformeTableauxCSV(Document doc) throws IOException {
		tables = doc.select("table"); 

        for (int t = 0; t < (tables.size() - 1); t++){
        	numTab++;
        	String tableau =csvFileRacine +"tableau_N_"+numTab+".csv";
        	 System.out.println("début de la création N° "+ numTab+ " ) "+tableau+" \n");
        	FileWriter w = new FileWriter(tableau);
        	
            table = tables.get(t);          
            rows = table.select("tr"); 
 
            
            for (int i = 1; i < rows.size(); i++){
            	td = rows.get(i).select("td");
 
                System.out.println("début de la ligne N° "+i+" \n");
                
                for (int k = 0; k < td.size(); k++){
                    System.out.println(" | " +td.get(k).text() + " | ");
                    donnees.add(td.get(k).text());
                    System.out.println("Cell_N_"+ k +" \n");
                }
                System.out.println("fin de la ligne N° "+i+" \n");
                
                CSVUtils.writeLine(w, donnees);
                listLigneTableau.add(donnees);
                donnees.clear();
            }
            
            listLigneChaqTableau.add(listLigneTableau);
            listLigneTableau.clear();
            
            w.flush();
            w.close();
            
            System.out.println("fin de la création N° "+ numTab+ " ) "+tableau+" \n");
        
        
        }	
	} 
    
  
	
	

}
