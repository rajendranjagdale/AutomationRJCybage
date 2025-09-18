package web;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.helpers.Reporter;

public class DriverLibrary {

	public static void setExplicitWait(int seconds) {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/**
	 * The method to click on the element link
	 *
	 * @param by the element locator
	 */
	public static void click(By by) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		element.click();
		Reporter.info("Element click successful.");
	}

	/**
	 * The method to set the value for Input field
	 *
	 * @param by    the element locator
	 * @param value the value to be set
	 */
	public static void setInputValue(By by, String value) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();
		element.clear();
		element.sendKeys(value);
		element.sendKeys(Keys.TAB);
		Reporter.info("Element set with value: " + value);
	}

	/**
	 * The method to set the value for Input field character by character
	 *
	 * @param by    the element locator
	 * @param value the value to be set
	 */
	public static void setInputValueByCharacter(By by, String value) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();

		String number = String.valueOf(value);
		for (char digit : number.toCharArray()) {
			element.sendKeys(String.valueOf(digit));
			waitForSeconds(1);
		}

		element.sendKeys(Keys.TAB);
		Reporter.info("Element set with value: " + value);
	}

	/**
	 * The method to pause the execution for specified seconds
	 *
	 * @param seconds the time in seconds
	 */
	public static void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
