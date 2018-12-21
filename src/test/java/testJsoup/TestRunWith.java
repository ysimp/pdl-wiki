package testJsoup;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

import testBliki.TestExtraTableBliki;
import testPDL.BenchTest;


@RunWith(JUnitPlatform.class)
@SelectPackages("pdl_V_1_0")
@IncludeTags({"Connexion","TransfoEnCSV"})
public class TestRunWith {

	public static void  test(String[] args) {
		Result result = JUnitCore.runClasses(TestConnexionJsoup.class, 
				TestExtraTableJsoup.class,
				TestExtraTableBliki.class, BenchTest.class);		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}		
		System.out.println(result.wasSuccessful());
	}

}
