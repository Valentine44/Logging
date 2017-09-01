package by.epam.atmentoring.logging.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import by.epam.atmentoring.logging.singleton.WebDriverSingleton;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = true,
				 features = "src/main/java/by/epam/atmentoring/logging/feature/GmailTest.feature",
				 glue = {"by.epam.atmentoring.logging.test_steps"}
				 )
public class GmailTestBDD extends AbstractTestNGCucumberTests {
	private static WebDriver driver = WebDriverSingleton.getWebDriverInstance();

	@BeforeClass(description = "Start browser, add implicit wait and maximize window")
	public void startBrowser() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass(description = "Stop Browser")
	public void stopBrowser() {
		driver.quit();
	}
}