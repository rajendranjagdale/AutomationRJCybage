package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.helpers.Reporter;

import web.DriverLibrary;

public class HomePage extends BasePage {

	public WebDriver driver;

	// Constructor for the class
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// Locators on home page
	private By linksHomePage = By.tagName("a");
	private By lnkABTesting = By.xpath("//a[text()='A/B Testing']");
	private By lnkElementalSelenium = By.xpath("//a[@href='http://elementalselenium.com/']");
	private By lnkInputElement = By.xpath("//a[text()='Inputs']");
	private By inputElement = By.xpath("//input[@type='number']");
	private By lnkGitHub = By.xpath("//a[contains(@href, 'github.com')]");
	private By btnChooseFile = By.xpath("//input[@id='file-upload']");
	private By btnUploadFile = By.xpath("//input[@id='file-submit']");

	/**
	 * The method to get the links count on Home page
	 */
	public int getLinksCountHomePage() {
		List<WebElement> links = driver.findElements(linksHomePage);
		return links.size();
	}

	/**
	 * The method to print the links on Home page
	 */
	public boolean verifyLinksHomePage(List<String> linkNames) {
		List<WebElement> links = driver.findElements(linksHomePage);
		List<String> linkNamesActual = new ArrayList<>();

		for (WebElement link : links) {
			linkNamesActual.add(link.getText());
		}

		linkNamesActual.remove(0);

		for (int i = 0; i < linkNamesActual.size(); i++) {
			if (linkNamesActual.get(i).equals(linkNames.get(i))) {
				Reporter.info(
						"Success! Actual link: " + linkNamesActual.get(i) + ", Expected link: " + linkNames.get(i));
			} else {
				Reporter.info(
						"Failure! Actual link: " + linkNamesActual.get(i) + ", Expected link: " + linkNames.get(i));
			}
		}

		return linkNamesActual.equals(linkNames);
	}

	/**
	 * The method to click on the AB Testing link
	 */
	public void clickABTestingLink() {
//		driver.findElement(lnkABTesting).click();
		DriverLibrary.click(lnkABTesting);
	}

	/**
	 * The method to click on the Elemental Selenium link
	 */
	public void clickEleSeleniumLink() {
//		driver.findElement(lnkElementalSelenium).click();
		DriverLibrary.click(lnkElementalSelenium);
	}

	/**
	 * The method to close the newly opened tab window
	 */
	public void closeNewTab() {
		closeTabWindow();
	}

	/**
	 * The method to click on the input element link
	 */
	public void clickInputElementLink() {
		DriverLibrary.click(lnkInputElement);
	}

	/**
	 * The method to set the input field value
	 *
	 * @param value the value to be set
	 */
	public void setInputValue(String value) {
		DriverLibrary.setInputValue(inputElement, String.valueOf(value));

	}

	/**
	 * The method to set the input field value character by character
	 *
	 * @param value the value to be set
	 */
	public void setInputValueByCharacter(int value) {
		DriverLibrary.setInputValue(inputElement, String.valueOf(value));

	}

	/**
	 * The method to click on the GitHub element link
	 */
	public void clickGitHubLink() {
		DriverLibrary.click(lnkGitHub);
	}

	/**
	 * The method to click on the choose file button
	 */
	public void clickChooseFileButton() {
		DriverLibrary.click(btnChooseFile);
	}

	/**
	 * The method to click on the upload file button
	 */
	public void clickUploadFileButton() {
		DriverLibrary.click(btnUploadFile);
	}

	/**
	 * The method to click on the link by name
	 *
	 * @param linkName the link to click
	 */
	public void clickLinkByName(String linkName) {
		String locator = "//a[text()='" + linkName + "']";
		DriverLibrary.click(By.xpath(locator));
	}

	/**
	 * The method to upload the test file
	 */
	public void uploadFile() {
		WebElement uploadElement = driver.findElement(btnChooseFile);
		uploadElement.sendKeys("E:\\rajendra\\project\\sampletest.txt");
		DriverLibrary.click(btnUploadFile);
	}
}
