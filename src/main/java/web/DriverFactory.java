package web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class to provide the Thread safe implementation of WebDriver
 */

public class DriverFactory {

	private DriverFactory() {

	}

	// ThreadLocal for WebDriver
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	// Get driver
	public static WebDriver getDriver() {
		return driver.get();
	}

	// Set driver
	public static void setDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			throw new IllegalArgumentException("Browser not supported: " + browser);
		}
	}

	// Quit driver
	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove(); // ✅ Important: avoids memory leaks
		}
	}
}
