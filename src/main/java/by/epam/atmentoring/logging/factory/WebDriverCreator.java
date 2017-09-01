package by.epam.atmentoring.logging.factory;

import org.openqa.selenium.WebDriver;
/**
 * Driver factory parent class
 * @author Valiantsin_Ivashynka
 *
 */
public abstract class WebDriverCreator {
	protected WebDriver driver;
	/**
	 * abstract driver factory method
	 * @return WebDriver instance
	 */
	public abstract WebDriver factoryMethod();
}
