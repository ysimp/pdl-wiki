package utils;

import java.io.IOException;
import java.io.Writer;

import model.Page;

public class Stat {
	
	

	/**
	 * ecrire dans un fichier de stats le nom du url avec le nbre de tableau extraire
	 * @param p
	 */
	
	public  static void generateStatByPage(Page p, Writer w)
	{
		
		try {
			
			
			
			w.append(p.getNomPage() + " : "+p.getNombreTable());
			w.append("\n");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
