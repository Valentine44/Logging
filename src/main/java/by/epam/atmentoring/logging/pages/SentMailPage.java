package by.epam.atmentoring.logging.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import by.epam.atmentoring.logging.logger.MyLogger;

/**
 * Sent mail page class
 * @author Valiantsin_Ivashynka
 *
 */
public class SentMailPage extends GmailPage{
	private static final By MOVED_TO_TRASH_MESSAGE = By.xpath("//span[contains(text(), 'The message has been moved to the Trash.')]");
	private static final By LAST_SENT_LETTER = By.xpath("//tbody/tr[@aria-labelledby][1]");
	private static final By LAST_EMAIL_SENDING_TIME = By.xpath("//*[@role='main']/div[4]//table/tbody/tr[1]/td[8]/span");
	/**
	 * SentMailPage class constructor
	 * @param driver
	 */
	public SentMailPage() {
		super();
	}
	/**
	 * parse the email's sending time
	 * @return the time when the email was sent
	 */
	public String getEmailTime() {
		MyLogger.info("Getting the letter's sending time");
		return (driver.findElement(LAST_EMAIL_SENDING_TIME).getText());
	}
	/**
	 * get the last sent letter
	 * @return last sent letter location
	 */
	public By getLastSentLetter() {
		MyLogger.info("getting the latest sent letter");
		return LAST_SENT_LETTER;
	}
	/**
	 * confirm "No sent messages" message is displayed
	 * @return "Moved to trash" message element
	 */
	public WebElement getMovedToTrashMessage() { 
		MyLogger.info("getting the 'Moved to Trash' message");
		waitElementVisible(MOVED_TO_TRASH_MESSAGE);
		return driver.findElement(MOVED_TO_TRASH_MESSAGE);
	}
}