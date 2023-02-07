package vtiger.Practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	@Test
	public void assertTest1() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		//Assert.assertEquals(true, true);   //Pass
		//Assert.assertEquals(false, true);  //Fail
		Assert.assertTrue(false);
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
	@Test
	public void assertTest2() {
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 5");
		sa.assertEquals("A", "B");
		System.out.println("Step 6");
		sa.assertEquals(true, true);
		System.out.println("Step 7");
		sa.assertTrue(false);
		System.out.println("Step 8");
		sa.assertAll();
	}

}
