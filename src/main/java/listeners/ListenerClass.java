package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerClass implements ITestListener, ISuiteListener {

	public static final Logger logs = LogManager.getLogger(ListenerClass.class);
	public static int testCount = 1;

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(":::::::::::::::: Starting with test case (" + testCount + ") : " + result.getName()
				+ " ::::::::::::::::");
		logs.info(":::::::::::::::: Starting with test case (" + testCount + ") : " + result.getName()
				+ " ::::::::::::::::");
		testCount++;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(":::::::::::::::: Test pass : " + result.getName() + " ::::::::::::::::");
		logs.info(":::::::::::::::: Test pass : " + result.getName() + " ::::::::::::::::");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(":::::::::::::::: Test failed : " + result.getName() + " ::::::::::::::::");
		logs.info(":::::::::::::::: Test pass : " + result.getName() + " ::::::::::::::::");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log(":::::::::::::::: Test skipped : " + result.getName() + " ::::::::::::::::");
		logs.info(":::::::::::::::: Test pass : " + result.getName() + " ::::::::::::::::");
	}
}
