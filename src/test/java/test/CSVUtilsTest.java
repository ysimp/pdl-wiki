package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utils.CSVUtils;


class CSVUtilsTest {

	@Test
	void testAssureFomatCSV() {
		String valeur= "yaya,wel,mkk", resultatAttendu= "yaya wel mkk";
		String resultat= CSVUtils.assureFomatCSV(valeur);
		assertEquals(resultat,resultatAttendu,"Le résultat n'est pas égal au résultat attendu!!");
	
	}

	@Test
	void testConstructFileName() {
		fail("Not yet implemented");
	}

	@Test
	void testWriteTable() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteOutPutFiles() {
		fail("Not yet implemented");
	}

	@Test
	void testCreatOutPutFolder() {
		fail("Not yet implemented");
	}

	@Test
	void testMkCSVFileName() {
		fail("Not yet implemented");
	}

	@Test
	void testIsCsvFileValid() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetListFromFile() {
		fail("Not yet implemented");
	}

}
