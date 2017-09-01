package by.epam.atmentoring.logging.singleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import by.epam.atmentoring.logging.decorator.DriverDecorator;
import by.epam.atmentoring.logging.factory.ChromeDriverCreator;
/**
 * WebDriver instantiation class by Singleton pattern
 * @author Valiantsin_Ivashynka
 *
 */
public class WebDriverSingleton {
	private static WebDriver driver;
	/**
	 * get existing WebDriver instance or create new if there is no existing instance
	 * @return WebDriver instance
	 */
	public static WebDriver getWebDriverInstance() {
		if (driver == null) {
			driver = new ChromeDriverCreator().factoryMethod();
			driver = new DriverDecorator(driver);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return driver;
	}
}