package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to all the methods in ITestListener Interface of testNG.
 * @author Prashant
 *
 */
public class ListenersImplementationClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		test = report.createTest(methodName);
		test.log(Status.INFO,"===== "+methodName+" - Execution Started =====");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS,"===== "+methodName+" - Test Script Passed =====");
	}

	public void onTestFailure(ITestResult result) {
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL,"===== "+methodName+" - Test Script Failed =====");
		test.log(Status.FAIL, result.getThrowable());
		System.out.println(result.getThrowable());
		
		String screenshotName = methodName;
		
		try {
			String path = wUtil.takeScreenshot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP,"===== "+methodName+" - Test Script Skipped =====");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		JavaUtility jUtil = new JavaUtility();
		System.out.println("===== Suite Execution Started =====");
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(IConstantsUtility.ReportsPath+jUtil.getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setReportName("Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Reporter Name", "Prashant");
	}

	public void onFinish(ITestContext context) {
		System.out.println("===== Suite Execution Finished =====");
		
		report.flush();
	}

}
