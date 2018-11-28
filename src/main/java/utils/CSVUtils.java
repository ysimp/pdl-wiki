package utils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class CSVUtils {

	private static final char DEFAULT_SEPARATOR = ',';
    
    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    //https://tools.ietf.org/html/rfc4180
    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }
    
    
    
    
    
  //lorsau'il y a une virgule dans la cellule mettre le 
    public static String assureFomatCSV(String value) {

        String result = value;
        if (result.contains(",")) {
            result = result.replace(",", "\"\"");
        }
        return result;

    }

    
    
  //Pour former le nom du fichier grâce au nom du lien  
    public static String assureFomatDosTab(String url) {

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
    
    
    

    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());


    }
    
    
    public static String mkCSVFileName(String url, int n) {
		return url.trim() + "-" + n + ".csv";
	}

	
}
