package listeners;

import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener, ISuiteListener {

	public static int testCount = 1;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: " + result.getName());
		testCount++;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());
	}

}
