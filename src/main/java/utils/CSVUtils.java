package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import model.Ligne;
import model.Tableau;

public class CSVUtils {
	
	

	private static final char DEFAULT_SEPARATOR = ',';
    
  //lorsau'il y a une virgule dans la cellule mettre le 
   /** 
    * TODO
    * S'il y'a une virgule dans la cellule on doit le remplacer par un point si c'est numeric : 12,5 => 12.5
     *Sinon on remplace par un espace : a,b => a b ou 12,a => 12 a etc...
     * 
     * @param value
     * @return
     */
    public static String assureFomatCSV(String value) {

        String result = value;
        if (result.contains(",")) {
            result = result.replace(",", " ");
        }
        return result;

    }

    /**
     * 
     * @param url
     * @param n
     * @return
     */
    public static String mkCSVFileName(String url, int n) {
		return url.trim() + "-" + n + ".csv";
	}
    
    /**
     * 
     * @param url
     * @return
     */
  //Pour former le nom du fichier grâce au nom du lien  
    public static String constructFileName(String url) {

        String result = url;
        
        if (result.contains("https:")) {
            result = result.replace("https:", "");
        }
        
        else
        	
        	if (result.contains("\"")) {
        		result = result.replace("\"", "_");
		}
        
        	else
	        	
	        	if (result.contains("*")) {
	        		result = result.replace("*", "_");
			}
	        	else
		        	
		        	if (result.contains("?")) {
		        		result = result.replace("?", "_");
				}
		        	else
			        	
			        	if (result.contains("<")) {
			        		result = result.replace("<", "_");
					}
			        	else
				        	
				        	if (result.contains(">")) {
				        		result = result.replace(">", "_");
						}
				        	else if (result.contains("|")){
				        		result = result.replace("|", "_");
				        	}
        						
				        	else if (result.contains("\\")){
				        		result = result.replace("\\", "_");
				        	}
        
        
        return result;

    }
    
    
    /**
     * 
     * @param w
     * @param table
     * @throws IOException
     */
    public static void writeTable(Writer w, Tableau table) throws IOException { 
    	
    	for (Ligne  line : table.getlisteLignes()) {
    		
				w.append(line.toString());
				w.append("\n ");
		}
    }
    /**
     * 
     * @param tempFile
     */
    // supprimer un directory avec ses fichiers
    public static void deleteOutPutFiles(File tempFile) {
    	
        try
        {
            if(tempFile.isDirectory()){
               File[] entries = tempFile.listFiles();
               for(File currentFile: entries){
            	   deleteOutPutFiles(currentFile);
               }
               tempFile.delete();
            }else{
               tempFile.delete();
            }
        //getLogger().info("DELETED Temporal File: " + tempFile.getPath());
        }
        catch(Throwable t)
        {
            //getLogger().error("Could not DELETE file: " + tempFile.getPath(), t);
        }
    }
    
    /**
     * 
     */
    public static void creatOutPutFolder() {
    	
    	// supprimer ancien fichiers 
    	deleteOutPutFiles(new File(Constant.OUTPUT_PATH));
    	
    	//cree a nouveau 
    	new File(Constant.OUTPUT_PATH).mkdir();
    	new File(Constant.CSV_HTML_PATH).mkdir();
    	new File(Constant.CSV_WIKI_PATH).mkdir();
    	
    }
    


    
    /**
     * 
     * @param fileName
     * @return
     * @throws Exception
     */
 // lire un  fichier et return sous forme d'un arrayliste ( ligne = string) 
	public static List<String> getListFromFile(String fileName) throws Exception
	{
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		List<String> liste=new ArrayList<String>();
		String classe="";
		
		while((classe=br.readLine())!=null) {
			
			liste.add(classe);
		}
		
		br.close();
		
		return liste;
	}
	
    /**
     * Permet de verifier si le fichier csv est valide
     * @param le chemin du fichier csv
     * @return boolean
     * @throws 
     * **/
    
    public boolean isCsvFileValid(String filePaht) {
    	return true;
    }
	
}
