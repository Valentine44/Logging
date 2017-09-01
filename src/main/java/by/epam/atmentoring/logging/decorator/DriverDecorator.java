package by.epam.atmentoring.logging.decorator;

import java.util.*;

import org.openqa.selenium.*;
//import org.testng.Reporter;

import by.epam.atmentoring.logging.logger.ScreenCapture;
/**
 * WebDriver decorator class
 * @author Valiantsin_Ivashynka
 *
 */
public class DriverDecorator implements WebDriver, JavascriptExecutor, TakesScreenshot {

	protected WebDriver driver;
	ScreenCapture screenCapture = new ScreenCapture();

	public DriverDecorator(WebDriver driver) {
		this.driver = driver;
	}

	public void get(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}
	/**
	 * Overriding findElements() method so that each element being interacted with is highlighted during a test run
	 */
	public List<WebElement> findElements(By by) {
		screenCapture.highlightElement(driver, driver.findElement(by));
		return driver.findElements(by);
	}
	/**
	 * Overriding findElement() method so that each element being interacted with is highlighted during a test run
	 */
	public WebElement findElement(By by) {
		screenCapture.highlightElement(driver, driver.findElement(by));
		return driver.findElement(by);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		//Reporter.log("Switching to new window", true);
		return driver.switchTo();
	}

	public Navigation navigate() {
		return driver.navigate();
	}

	public Options manage() {
		return driver.manage();
	}

	@Override
	public Object executeAsyncScript(String arg0, Object... arg1) {
		return ((JavascriptExecutor) driver).executeAsyncScript(arg0, arg1);
	}

	@Override
	public Object executeScript(String arg0, Object... arg1) {
		return ((JavascriptExecutor) driver).executeScript(arg0, arg1);
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		return ((TakesScreenshot) driver).getScreenshotAs(arg0);
	}
}