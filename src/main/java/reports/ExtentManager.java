package reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * This class defines the methods that include thread safe ExtentTest instance
 * creation for report creation in case the parallel test execution happens.
 */
public class ExtentManager {

	private ExtentManager() {
	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static synchronized ExtentTest getExtentTest() {
		return extentTest.get();
	}

	static synchronized void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}

	static synchronized void unload() {
		extentTest.remove();
	}
}
