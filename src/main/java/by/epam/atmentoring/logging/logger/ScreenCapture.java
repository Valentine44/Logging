package by.epam.atmentoring.logging.logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import by.epam.atmentoring.logging.singleton.WebDriverSingleton;

public class ScreenCapture {
	@SuppressWarnings("unused")
	private WebDriver driver = WebDriverSingleton.getWebDriverInstance();
	/**
	 * Take screenshot
	 * @param driver
	 */
	public void takeScreenShot(WebDriver driver) {
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String screenShotPath = "./target/screenshots/" + getTimeStamp() + ".png";
	try {
		FileUtils.copyFile(source, new File(screenShotPath));
	} catch (IOException e) {
		MyLogger.error("Error copying file at: " + screenShotPath, e, driver);
	}
	MyLogger.info("Screenshot saved at: " + screenShotPath);
	}
	/**
	 * Get timestamp to provide unique name for screenshot
	 * @return
	 */
	public String getTimeStamp() {
		return new SimpleDateFormat("yyyy_dd-MMM_HH_mm_sss").format(new Date());
	}
	/**
	 * Highlight element being interacted with
	 * @param driver
	 * @param element
	 */
	public void highlightElement(WebDriver driver, WebElement element) {
		@SuppressWarnings("unused")
		String background = element.getCssValue("backgroundColor");
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
	}
}