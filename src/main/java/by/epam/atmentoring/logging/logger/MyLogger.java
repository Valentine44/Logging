package by.epam.atmentoring.logging.logger;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MyLogger {
	
	private static Logger logger = Logger.getLogger(MyLogger.class);
	/**
	 * log at INFO level
	 * @param message
	 */
	public static void info(String message) {
		logger.info(message);
	}
	/**
	 * log at ERROR level
	 * @param message
	 */
	public static void error (String message, Throwable throwable, WebDriver driver) {
		ScreenCapture screenshot = new ScreenCapture();
		screenshot.takeScreenShot(driver);
		logger.error(message, throwable);
	}
}