package by.epam.atmentoring.logging.pages;

import org.openqa.selenium.By;

import by.epam.atmentoring.logging.logger.MyLogger;
import by.epam.atmentoring.logging.utilities.SwitchWindows;
/**
 * Letter page class
 * @author Valiantsin_Ivashynka
 *
 */
public class LetterPage extends GmailPage {
	private static final By IN_NEW_WINDOW_BUTTON = By.xpath("//img[@alt='In new window']");
	/**
	 * LetterPage constructor
	 * @param driver
	 */
	public LetterPage() {
		super();
	}
	/**
	 * open letter in new window
	 * @return letter window instance
	 */
	public LetterWindow inNewWindow() {
		MyLogger.info("Opening letter in new window");
		waitElementVisible(IN_NEW_WINDOW_BUTTON);
		driver.findElement(IN_NEW_WINDOW_BUTTON).click();
		SwitchWindows.switchToNewWindow(driver);
		return new LetterWindow();
	}
}