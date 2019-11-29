package test;

/**
 * @author Mahamadou Kandé Konaté
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Ligne;
import model.Tableau;
import utils.CSVUtils;
import utils.Constant;

/**

 * @author Konate
 *
 */
class TestCSVUtils {
	/**
	 * La classe CSVUtilsTest teste toutes les méthodes de la classe à laquelle elle est rattachée
	 */

	@Test
	void testAssureFomatCSV() {
		String valeur= "yaya,wel,mkk", resultatAttendu= "yaya wel mkk";
		String resultat= CSVUtils.assureFomatCSV(valeur);
		assertTrue(!resultat.contains(","),"Format CSV incorrect!!");
		assertEquals(resultat,resultatAttendu,"Le résultat n'est pas égal au résultat attendu!!");
		}

	@Test
	void testConstructFileName() {
		String url= "https://en.wikipedia.org/wiki/Luka_Modri%C4%87";
		String res= CSVUtils.constructFileName(url);
		assertFalse(res.contains("http"),"Problème: le nom du fichier contient 'https' ou 'http'");
		assertFalse(res.contains("\""),"Problème: le nom du fichier contient \" ");
		assertFalse(res.contains("*")||res.contains("?"),"Problème: le nom du fichier contient '*' ou '?'");
		assertFalse(res.contains("<")||res.contains(">"),"Problème: le nom du fichier contient '<' ou '>'");
		assertFalse(res.contains("|")||res.contains("\\"),"Problème: le nom du fichier contient '|' ou '\\'");
	}

	@Test
	void testWriteTable() throws Exception {
		File essais= new File(Constant.OUTPUT_PATH+"essais_writer");
		
		if (!essais.exists()) {
			essais.createNewFile(); 
		}
		
		Writer writer= new BufferedWriter(new FileWriter(essais.getAbsoluteFile()));
		Tableau tableau = new Tableau();
		Ligne ligne1= new Ligne(); Ligne ligne2= new Ligne();
		ligne1.addCellule("1e ligne"); ligne1.addCellule("2e colonne");
		ligne2.addCellule("2e ligne"); ligne2.addCellule("2e colonne");
		tableau.addLine(ligne1);
		tableau.addLine(ligne2);
		CSVUtils.writeTable(writer, tableau);
		
		List<String> liste = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(essais));
		String classe="";
		
		while((classe=br.readLine())!=null) {
			liste.add(classe);
		}
		
		br.close();
		//assertNotNull(writer,"Problème avec le writer qui contient null!");
		assertTrue(liste.get(0).trim().contains("1e ligne")&&liste.get(0).trim().contains("2e colonne"));
		assertTrue(liste.get(1).trim().contains("2e ligne")&&liste.get(1).trim().contains("2e colonne"));
	}
	
	@Test
	void testDeleteOutPutFiles() throws IOException {
		File essais= new File(Constant.OUTPUT_PATH+"essais_delete");
		if (!essais.exists()) {
		essais.createNewFile(); }
		CSVUtils.deleteOutPutFiles(essais);
		assertFalse(essais.exists(),"la suppression de l'output n'a pas fonctionné!");
	}

	@Test
	void testCreatOutPutFolder() {
		CSVUtils.creatOutPutFolder("CreateFolder");
		File projet= new File(Constant.OUTPUT_PATH + "CreateFile");
		
       	assertTrue(projet.exists(),"le dossier output existe déjà");
	}

	@Test
	void testMkCSVFileName() {
		String url= " Our_group_has_5members ", resurl="";
		resurl= CSVUtils.mkCSVFileName(url, 1);
		assertFalse(resurl.contains(" "),"Le nom du fichier contient un espace");
		assertTrue(resurl.contains("1"),"Le fichier doit  contenir le numero");
		assertTrue(resurl.endsWith(".csv"),"Le fichier n'a pas d'extension .csv");
	}

	@Test
	void testIsCsvFileValid() throws Exception {
		File essais= new File(Constant.OUTPUT_PATH+"essais_csvvalid");
		if (!essais.exists()) {
		essais.createNewFile(); }
		File essais2= new File(Constant.OUTPUT_PATH+"essais_csvvalid2");
		if (!essais2.exists()) {
		essais2.createNewFile(); }
		 Writer writer= new FileWriter(essais.getAbsoluteFile());
		 Writer writer2= new FileWriter(essais2.getAbsoluteFile());
		Tableau tableau = new Tableau();
		Tableau tableau2 = new Tableau();
		Ligne ligne1= new Ligne(); Ligne ligne2= new Ligne(); Ligne ligne3= new Ligne();
		ligne1.addCellule("1ère ligne"); ligne1.addCellule("2e colonne");
		ligne2.addCellule("2e ligne"); ligne2.addCellule("2e colonne");
		ligne3.addCellule("une 3e ligne");
		tableau.addLine(ligne1); tableau.addLine(ligne2);
		tableau2.addLine(ligne1); tableau2.addLine(ligne2); tableau2.addLine(ligne3);
		
		for (Ligne  line : tableau.getlisteLignes()) {
			writer.append(line.toString());
			writer.append("\n");
	}
	writer.flush();
	writer.close();
	
	for (Ligne  line : tableau2.getlisteLignes()) {
		writer2.append(line.toString());
		writer2.append("\n");
	}
	writer2.flush();
	writer2.close();
	
		assertTrue(CSVUtils.isCsvFileValid(Constant.OUTPUT_PATH+"essais_csvvalid"),"problème avec la fonction isCSVFileValid");
		assertFalse(CSVUtils.isCsvFileValid(Constant.OUTPUT_PATH+"essais_csvvalid2"),"problème avec la fonction isCSVFileValid");
	}
	
	@Test
	void testGetListFromFile() throws Exception {
		
		List<String> listeDepart = new ArrayList<String>();
		listeDepart.add("yaya"); listeDepart.add("hajar"); listeDepart.add("jihad");
		listeDepart.add("mahjoub"); listeDepart.add("mkk");
		List<String> maliste = new ArrayList<String>();
		File essais= new File(Constant.OUTPUT_PATH+"essais_ListfromFile");
		if (!essais.exists()) {
		essais.createNewFile(); 
		}
		Writer writer= new BufferedWriter(new FileWriter(essais.getAbsoluteFile()));
		for (String nom: listeDepart) {
			writer.append(nom);
			writer.append("\n");
		}
		
		writer.flush();
		writer.close();
		
		maliste= CSVUtils.getListFromFile(Constant.OUTPUT_PATH+"essais_ListfromFile");
	
		assertEquals(listeDepart.size(), maliste.size(), "Les deux listes devrait avoir la meme taille");
		
		for(int i=0; i<listeDepart.size();i++) {
				assertNotNull(maliste.get(i),"Problème de transformation! La table String dérivée contient null.");
				assertEquals(maliste.get(i).trim(),listeDepart.get(i).trim(),"Le deux listes listes devrait avoir le meme contenu.");
		}
	}

}