package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import testdata.Data;
import web.DriverFactory;

public class HomePageTest extends BaseTest {

	@Test(priority = 1, groups = {
			"Smoke" }, description = "This method to verify the links display and count on Home page.")
	public void testLinksCountOnHomePage() {
		HomePage homePage = new HomePage(DriverFactory.getDriver());

		// Verify the link count on Home page
		int linkCountHomePage = homePage.getLinksCountHomePage();
		Assert.assertEquals(linkCountHomePage, 46);

		// Print the links on the Home page
		boolean result = homePage.verifyLinksHomePage(Data.getHomePageLinks());
		Assert.assertTrue(result, "The link verification on home page failed.");
	}

	/**
	 * The test is the basic navigation from the landing page
	 */
	@Test(priority = 2, groups = {
			"Smoke" }, description = "This test method to check the ABTesting link click and its navigation check")
	public void testABTestingLinkNavigation() {
		HomePage homePage = new HomePage(DriverFactory.getDriver());

		// Click on the ABTesting link
		homePage.clickABTestingLink();
		Assert.assertEquals(homePage.getPageTitle(), "The Internet");

		// Verify Elements Selenium link click opens new tab
		homePage.clickEleSeleniumLink();
		homePage.closeNewTab();

		// Navigate back to Home page
		homePage.navigateBack();
		Assert.assertEquals(homePage.getPageTitle(), "The Internet");
	}

	@Test(priority = 3, groups = { "Smoke", "Regression" }, description = "The test method to check the file upload.")
	public void testFileUpload() {
		HomePage homePage = new HomePage(DriverFactory.getDriver());

		// Click on the File upload link
		homePage.clickLinkByName("File Upload");

		// Verify file upload and navigate back to Home page
		homePage.uploadFile();
		homePage.navigateBack();
	}

	@Test(priority = 4, enabled = false, groups = {
			"Staging" }, description = "The method to check the input box field value update")
	public void testInputBoxNavigation() {
		HomePage homePage = new HomePage(DriverFactory.getDriver());

		// Click on the Input element link
		homePage.clickInputElementLink();
		Assert.assertEquals(homePage.getPageTitle(), "The Internet");

		// Setup the value for Input box
		homePage.setInputValueByCharacter(12345);

		// Verify the GitHub link click open new tab
		homePage.clickGitHubLink();
		homePage.closeNewTab();

		// Navigate back to Home page
		homePage.navigateBack();
	}
}
