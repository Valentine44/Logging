package by.epam.atmentoring.logging.pages;

import org.openqa.selenium.By;

import by.epam.atmentoring.logging.logger.MyLogger;
/**
 * Google account page class
 * @author Valiantsin_Ivashynka
 *
 */
public class GoogleAccountPage extends Page{

	private static final By GMAIL = By.xpath("//a[@aria-label='Mail']");
	/**
	 * GoogleAccountPage class constructor
	 * @param driver
	 */
	public GoogleAccountPage() {
		super();
	}
	/**
	 * go to mail
	 * @return inbox page instance
	 */
	public InboxPage selectMail() {
		MyLogger.info("Selecting Mail in Google account");
		waitElementVisible(GMAIL);
		driver.findElement(GMAIL).click();
		return new InboxPage();
	}
}