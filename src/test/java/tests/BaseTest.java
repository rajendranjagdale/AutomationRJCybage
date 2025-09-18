package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import web.DriverFactory;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		DriverFactory.setDriver("Chrome");
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
