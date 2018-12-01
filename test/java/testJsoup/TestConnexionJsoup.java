package testJsoup;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestConnexionJsoup {
	
	//private static final Logger loggerConnexion = LogManager.getLogger("InfoConnexion");
	Document doc = null;
	String url = null;

	
	@DisplayName("Connexion")
	@Tag("Connexion")
	@Test
	void connexion() {
		System.out.println(">>Connecter vous à http://en.wikipedia.org...");
	       
	   //  Boolean connexion = false;
			
	        try {
	            @SuppressWarnings("unused")
				Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras").get();
	            
	           
	        } catch (IOException ex) {
	        	System.out.println("Erreur de connexion, vous vous êtes sans doute trompé dans la saisie de l'url");
	        	//connexion = false;
	        //	Assertions.assertEquals(true, connexion);
	           
	            
	        }
	        System.out.println(">> Connexion établie, vous avez accès au dom ...");
	      //  connexion = true;
	      //  Assertions.assertEquals(true, connexion);
	}

	
	
	@DisplayName("ConnexionBenchTest")
	@Tag("ConnexionBenchTest")
	@Test
	Document connexion(String url) {
		System.out.println(">>Connecter vous à http://en.wikipedia.org...");
	       
	   //  Boolean connexion = false;
			
	        try {
	            @SuppressWarnings("unused")
				Document doc = Jsoup.connect(url).get();
	         //   connexion = true;
	           
	        } catch (IOException ex) {
	        	System.out.println("Erreur de connexion, vous vous êtes sans doute trompé dans la saisie de l'url");
	        	//connexion = false;
	        	//Assertions.assertEquals(true, connexion);
	           
	            
	        }
	        System.out.println(">> Connexion établie, vous avez accès au dom ...");
	        
	      //  Assertions.assertEquals(true, connexion);
	        
	        return doc;
	}
	
	
	
	
}
