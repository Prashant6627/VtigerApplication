package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(vtiger.GenericUtility.ListenersImplementationClass.class)
public class RetryAnalyserPractice {
	@Test(retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void retryAnalyserTest1() {
		System.out.println("Executed Test1");
		Assert.fail();
	}
	
	@Test
	public void retryAnalyserTest2() {
		System.out.println("Executed Test2");
	}

}
