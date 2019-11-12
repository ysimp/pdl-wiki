package utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class NonUtils {
	
	/*Nombre de ligne*/
	void nombreDeLigne() {
		//test 1
		String url = "https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras";
	    List<String> donnees = new ArrayList<String>();
	    List<List<String>> listLigneTableau = new ArrayList<List<String>>() ;
	    List<List<List<String>>> listLigneChaqTableau = new ArrayList<List<List<String>>>() ;
	    Document doc = null;
	    Element table = null;
	    Elements rows = null;
	    Elements td = null;
	    Elements tables = null;

	    try {
			
	           doc = Jsoup.connect(url).get();
	           assertNotNull(url); 
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
		
		tables = doc.select("table"); 
		
		if (tables.size() == 0) {
			System.out.println(" Attention !!! La page � l'�tude n'a pas de tableau ...");
		}
		System.out.println("le nombre de tableau de la page � l'�tude est : "+ tables.size());

		for (int t = 0; t < (tables.size() - 1); t++){
            table = tables.get(t);          
            rows = table.select("tr"); 
            
            System.out.println("le nombre de ligne sur le tableau num�ro "+t+" de la page � l'�tude est : "+ rows.size());
            
            for (int i = 1; i < rows.size(); i++){
            	td = rows.get(i).select("td");
            	
            	System.out.println("le nombre de colonne de la ligne num�ro "+ i
            			+ " sur le tableau num�ro "+t+" de la page � l'�tude est : "+ rows.get(i).select("td").size());
            	
            	System.out.println("d�but de la ligne N� "+i+" \n");
                
                
                for (int k = 0; k < td.size(); k++){
                    System.out.println(" | " +td.get(k).text() + " | ");
                    donnees.add(td.get(k).text());
                    System.out.println("Cell_N_"+ k +" \n");
                }
                System.out.println("fin de la ligne N� "+i+" \n");
       
                listLigneTableau.add(donnees);
                donnees.clear();
            }

            listLigneChaqTableau.add(listLigneTableau);
            listLigneTableau.clear();

            System.out.println("le nombre de ligne du tableau num�ro " + t + " est de : "+ listLigneTableau.size() );
           
            
		}
	
	}

	
	
	/*Nombre de Table*/
	void nbreTables() {
		

		String url = "https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras";
		Document doc = null;
	    Elements tables = null;
		
	    try {
			
	           doc = Jsoup.connect(url).get(); 
	           assertNotNull(url);   
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
		
		tables = doc.select("table"); 
		
		if (tables.size() == 0) {
			System.out.println(" Attention !!! La page � l'�tude n'a pas de tableau ...");
		}
		System.out.println("le nombre de tableau de la page � l'�tude est : "+ tables.size());
		
		
	}
	
	
	
	/*Connexion � JSoup*/
	void connexion() {
		System.out.println(">>Connecter vous � http://en.wikipedia.org...");

		try {
	            @SuppressWarnings("unused")
				Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras").get();

	        } catch (IOException ex) {
	        	System.out.println("Erreur de connexion, vous vous �tes sans doute tromp� dans la saisie de l'url");
	        	
	        }
	        System.out.println(">> Connexion �tablie, vous avez acc�s au dom ...");
	     
	}

	
	
	
	Document connexion(String url) {
		System.out.println(">>Connecter vous � http://en.wikipedia.org...");
	   
		Document doc =null;
	        try {
	           
				 doc = Jsoup.connect(url).get();
	        
	        } catch (IOException ex) {
	        	System.out.println("Erreur de connexion, vous vous �tes sans doute tromp� dans la saisie de l'url");
	        	
	        }
	        System.out.println(">> Connexion �tablie, vous avez acc�s au dom ...");
	        return doc;
	}
	
	/***********************************Contenu du test JSoup**************************************************************/

	public void tentativeConnexion() {
	
		System.out.println(">>Connecter vous � http://en.wikipedia.org...");
        try {
            @SuppressWarnings("unused")
			Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras").get(); 
        } catch (IOException ex) {
        	System.out.println("Erreur de connexion, vous vous �tes sans doute tromp� dans la saisie de l'url");
        	
        }
        System.out.println(">> Connexion �tablie, vous avez acc�s au dom ...");
     
    }
	
	
	void testExtraction() throws IOException {
		    String url = "https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras";
		    List<String> donnees = new ArrayList<String>();
		    List<List<String>> listLigneTableau = new ArrayList<List<String>>() ;
		    List<List<List<String>>> listLigneChaqTableau = new ArrayList<List<List<String>>>() ;
		    String csvFileRacine = "outputApp" + File.separator;
		    int numTab = 0;
		    Document doc = null;
		    Element table = null;
		    Elements rows = null;
		    Elements td = null;
		    Elements tables = null;
		    
		    try {
				
		           doc = Jsoup.connect(url).get();
		           assertNotNull(url);		           
		       } catch (IOException e) { 
		    	   System.out.println("Erreur de connexion, vous vous �tes sans doute tromp� dans la saisie de l'url");
		       }
			assertNotNull(doc);
			tables = doc.select("table"); 
			if (tables.size() == 0) {
				System.out.println(" Attention !!! La page � l'�tude n'a pas de tableau ...");
			}
			
			for (int t = 0; t < (tables.size() - 1); t++){
				
				numTab++;
	        	String tableau =csvFileRacine +"tableau_N_"+numTab+".csv";
	        	System.out.println("d�but de la cr�ation N� "+ numTab+ " ) "+tableau+" \n");
	        	FileWriter w = new FileWriter(tableau);        	
	            table = tables.get(t);          
	            rows = table.select("tr"); 
	            for (int i = 1; i < rows.size(); i++){
	            	td = rows.get(i).select("td");
	            	System.out.println("d�but de la ligne N� "+i+" \n");
	                for (int k = 0; k < td.size(); k++){
	                    System.out.println(" | " +td.get(k).text() + " | ");
	                    donnees.add( CSVUtils.assureFomatCSV(td.get(k).text())  );
	                    System.out.println("Cell_N_"+ k +" \n");
	                }
	                System.out.println("fin de la ligne N� "+i+" \n");
	                CSVUtils.writeLine(w, donnees);
	                listLigneTableau.add(donnees);
	                donnees.clear();
	            }
	            listLigneChaqTableau.add(listLigneTableau);
	            listLigneTableau.clear();
	            w.flush();
	            w.close();
	            System.out.println("fin de la cr�ation N� "+ numTab+ " ) "+tableau+" \n");
	           
	            
			}
	}


	void testBenchExtraction(String url) throws IOException {
		    
		    List<String> donnees = new ArrayList<String>();
		    List<List<String>> listLigneTableau = new ArrayList<List<String>>() ;
		    List<List<List<String>>> listLigneChaqTableau = new ArrayList<List<List<String>>>() ;
		    int numTab = 0;
		    Document doc = null;
		    Element table = null;
		    Elements rows = null;
		    Elements td = null;
		    Elements tables = null;
		    String csvFileRacine = "outputApp" + File.separator;
		    
		    try {
				
		           doc = Jsoup.connect(url).get();
		           
		       } catch (IOException e) {
		            
		    	   System.out.println("Erreur de connexion, vous vous �tes sans doute tromp� dans la saisie de l'url");
		          // e.printStackTrace();
		    	  
		       }

			tables = doc.select("table"); 
			
			if (tables.size() == 0) {
				System.out.println(" Attention !!! La page � l'�tude n'a pas de tableau ...");
			}
			
			
			for (int t = 0; t < (tables.size() - 1); t++){
				
				numTab++;
	        	String tableau =csvFileRacine +"tableau_N_"+numTab+".csv";
	        	System.out.println("d�but de la cr�ation N� "+ numTab+ " ) "+tableau+" \n");
	        	FileWriter w = new FileWriter(tableau);
	            table = tables.get(t);          
	            rows = table.select("tr"); 
	            
	            for (int i = 1; i < rows.size(); i++){
	            	td = rows.get(i).select("td");
	            	System.out.println("d�but de la ligne N� "+i+" \n");
	            	
	                for (int k = 0; k < td.size(); k++){
	                    System.out.println(" | " +td.get(k).text() + " | ");
	                    donnees.add( CSVUtils.assureFomatCSV(td.get(k).text())  );
	                    System.out.println("Cell_N_"+ k +" \n");
	                }
	                
	                System.out.println("fin de la ligne N� "+i+" \n");
	                CSVUtils.writeLine(w, donnees);
	                listLigneTableau.add(donnees);
	                donnees.clear();
	            }
	            listLigneChaqTableau.add(listLigneTableau);
	            listLigneTableau.clear();
	            w.flush();
	            w.close();
	            System.out.println("fin de la cr�ation N� "+ numTab+ " ) "+tableau+" \n");
			}

	}
}
