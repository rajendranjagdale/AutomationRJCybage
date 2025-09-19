package listeners;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import reports.ExtentLogger;
import reports.ExtentReport;

/**
 * This class defines the implementation of ITestListener and ISuiteListener
 * methods to report the Pass, Fail or Skip tests
 */
public class ListenerClass implements ITestListener, ISuiteListener {

	public static final Logger logs = LogManager.getLogger(ListenerClass.class);
	public static int testCount = 1;

	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReports();
			Reporter.log("##################### Start of Test Execution #####################");
			logs.info("##################### Start of Test Execution #####################");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		ExtentLogger.info(result.getMethod().getMethodName());
		Reporter.log(
				":::::::::::::::: Starting test case (" + testCount + ") : " + result.getName() + " ::::::::::::::::");
		logs.info(
				":::::::::::::::: Starting test case (" + testCount + ") : " + result.getName() + " ::::::::::::::::");
		testCount++;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass("Test case (" + result.getMethod().getMethodName() + ") PASS");
		Reporter.log(":::::::::::::::: Test pass : " + result.getName() + " ::::::::::::::::");
		logs.info(":::::::::::::::: Test pass : " + result.getName() + " ::::::::::::::::");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail("Test case (" + result.getMethod().getMethodName() + ") FAILED");
		Reporter.log(":::::::::::::::: Test failed : " + result.getName() + " ::::::::::::::::");
		logs.info(":::::::::::::::: Test failed : " + result.getName() + " ::::::::::::::::");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip("Test case (" + result.getMethod().getMethodName() + ") SKIPPED");
		Reporter.log(":::::::::::::::: Test skipped : " + result.getName() + " ::::::::::::::::");
		logs.info(":::::::::::::::: Test skipped : " + result.getName() + " ::::::::::::::::");
	}

	@Override
	public void onFinish(ITestContext context) {
		try {
			ExtentReport.writeResultsToExcel(context);
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		Reporter.log("Tests Passed = " + context.getPassedTests().size() + ", " + "Tests Failed = "
				+ context.getFailedTests().size() + ", " + "Tests Skipped = " + context.getSkippedTests().size());
		logs.info("Tests Passed = " + context.getPassedTests().size() + ", " + "Tests Failed = "
				+ context.getFailedTests().size() + ", " + "Tests Skipped = " + context.getSkippedTests().size());

		ExtentReport.flushReports();

		Reporter.log("##################### End of Test Execution #####################");
		logs.info("##################### End of Test Execution #####################");
	}
}
