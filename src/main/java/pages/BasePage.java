package pages;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

import web.DriverFactory;

/**
 * This is the base class for all the page classes listing the common and useful
 * methods for inherited class to use
 */

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		return DriverFactory.getDriver().getTitle();
	}

	public void navigateBack() {
		DriverFactory.getDriver().navigate().back();
	}

	public void closeTabWindow() {
		WebDriver driver = DriverFactory.getDriver();
		// Get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();

		String mainWindow = iterator.next(); // first handle
		String newTab = iterator.next(); // second handle

		// Switch to new tab
		driver.switchTo().window(newTab);
		System.out.println("Title of new tab: " + driver.getTitle());

		// Close new tab
		driver.close();

		// Switch back to main tab
		driver.switchTo().window(mainWindow);
		System.out.println("Back to main tab: " + driver.getTitle());
	}

	public void waitForSeconds(int seconds) {
		try {
			driver.wait(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
