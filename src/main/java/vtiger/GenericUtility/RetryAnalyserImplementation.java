package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide implementation to the IRetryAnalyser Interface of testNG
 * @author Prashant
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{
	
	int count=0;
	int retryCount=3;
	/**
	 * Retry until retry count is met
	 */

	public boolean retry(ITestResult result) {
		
		while(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}
}
