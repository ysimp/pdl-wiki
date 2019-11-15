package test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * @author Hajar 
 * @author Jihad
 * @author yaya
 * @author El Mahjoub
 *
 */

@RunWith(JUnitPlatform.class)
@SelectPackages("pdl_V_1_0")
@IncludeTags({"Connexion","TransfoEnCSV"})
public class TestRunWith {

	public static void  test(String[] args) {
		/*Result result = JUnitCore.runClasses(TestConverterLaunch.class);		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}		
		System.out.println(result.wasSuccessful());*/
	}

}
