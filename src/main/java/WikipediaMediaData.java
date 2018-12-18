import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import info.bliki.wiki.model.WikiModel;
import net.sourceforge.jwbf.core.contentRep.Article;
import net.sourceforge.jwbf.mediawiki.bots.MediaWikiBot;
import utils.CSVUtils;




public class WikipediaMediaData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

    	/*
    	1)url de la page wikipedia
    	2)doc est le fichier dom (Document de Jsoup permet d'avoir accès aux dom)
    	3)tables est l'ensemble des tableaux (Elements de Jsoup permet d'avoir accès à un ensemble d'éléments du dom)
    	4)table est un tableau (Element de Jsoup permet d'avoir accès à un élément du dom)
    	5)rows est l'ensemble des lignes du tableau 
    	6)donnees est l'ensemble des données d'une ligne du tableau
    	7)listLigneTableau est l'ensemble des lignes du tableau
    	8)listLigneChaqTableau est l'ensemble des ensembles de ligne de chaque tableau
    	*/
    	
		/*
    	
        String url = "https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras";
        Document doc = null;
        Element table = null;
        Elements rows = null;
        Elements tables = null;
        
        String csvFileRacine =  "outputApp" + File.separator + "html" + File.separator;
        int numTab = 0;
        
        /* 
         * pour la refonte du code
         * 
         * 
         *   Ligne ligne = new Ligne();
         *   Tableau tableau = new Tableau();
         *   Page page = new Page();
         */
      
        
        /*
        
        List<String> donnees = new ArrayList<String>();
        List<List<String>> listLigneTableau = new ArrayList<List<String>>() ;
        List<List<List<String>>> listLigneChaqTableau = new ArrayList<List<List<String>>>() ;
        
       
        /*
         * Faire une méthode qui permet d'avoir accès au dom de wikipédia; la méthode aura pour paramètre l'url
         * 1-vérifier si l'url existe
         * 2-Vérifier qu'il sagit d'une page wikipedia
         * 3-Retourner le dom de la page
         */
        
        /*
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        /*
         * Faire une méthode qui permet de convertir les tableaux html en csv
         * 1- récupére tout les tableaux 
         * 2- parcourir chaque tableau
         * 2-1 créer le nom du chemin du tableau parcouru (tableau courant)
         * 2-2 numTab est le numéro du tableau
         * 2-3 créer le FileWriter w pour la création du csv en écriture
         * 2-4 récupérer le tableau tableau courant 
         * 2-5 récupérer toute les lignes du tableau courant
         * 2-6 récupérer toutes les infos des cellules de chaque ligne pour les insérrer dans différentes liste de données, 1e ligne=1e liste
         * 2-7 écrire la ligne courante dans le fichier csv du tableau courant
         * 2-8 ajouter la ligne courante a l'ensemble des lignes du tableau
         */
 
       /* 
        tables = doc.select("table"); 

        for (int t = 0; t < (tables.size() - 1); t++){
        	numTab++;
        	String tableau =csvFileRacine +"tableau_N_"+numTab+".csv";
        	 System.out.println("début de la création N° "+ numTab+ " ) "+tableau+" \n");
        	FileWriter w = new FileWriter(tableau);
        	
            table = tables.get(t);          
            rows = table.select("tr"); 
 
            Elements data = null;
            for (int i = 1; i < rows.size(); i++){
                data = rows.get(i).select("td");
 
                System.out.println("début de la ligne N° "+i+" \n");
                
                for (int k = 0; k < data.size(); k++){
                    System.out.println(" | " +data.get(k).text() + " | ");
                    donnees.add(data.get(k).text());
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
        
        */
		
		String BASE_WIKIPEDIA_URL = "https://en.wikipedia.org/w/";
		
		MediaWikiBot wikiBot = new MediaWikiBot(BASE_WIKIPEDIA_URL);
	    Article article = wikiBot.getArticle("Comparison_between_Esperanto_and_Ido");
	    System.out.println(article.getText());
	    
	    String html =  WikiModel.toHtml(article.getText());
	    Document docHtml = Jsoup.parse(html);
        
	}
		

	}


