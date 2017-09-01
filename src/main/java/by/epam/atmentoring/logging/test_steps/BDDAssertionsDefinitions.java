package by.epam.atmentoring.logging.test_steps;

import org.testng.Assert;

import by.epam.atmentoring.logging.bo.Account;
import by.epam.atmentoring.logging.bo.Letter;
import by.epam.atmentoring.logging.logger.MyLogger;
import by.epam.atmentoring.logging.pages.LogIn_PasswordPage;
import by.epam.atmentoring.logging.singleton.WebDriverSingleton;
import by.epam.atmentoring.logging.test_data.GmailTestData;
import cucumber.api.java.en.Then;
/**
 * class containing Gherkin expected ("@Then") results definitions 
 * @author Valiantsin_Ivashynka
 *
 */
public class BDDAssertionsDefinitions extends BDDStepDefinition {
	/**
	 * assert that letter removal notification is displayed
	 */
	@Then ("^message 'The message has been moved to the Trash.' is displayed$")
	public void assertMovedToTrashMessage(){
		MyLogger.info("asserting message 'The message has been moved to the Trash.' is displayed");
		Assert.assertTrue(BDDStepDefinition.sentMail.getMovedToTrashMessage().isDisplayed());
	}
	/**
	 * assert user has successfully logged into Gmail
	 */
	@Then ("^user is in Gmail Inbox$")
	public void assertUserIsInInbox() {
		MyLogger.info("asserting user is in Gmail Inbox");
		Assert.assertTrue(BDDStepDefinition.inbox.jsGetTitle().contains("Inbox"));
	}
	/**
	 * assert the sent letter is stored in Sent Mail
	 */
	@Then ("^letter just sent is in Sent Mail$")
	public void assertSentLetterInSentMail() {
		MyLogger.info("asserting letter just sent is in Sent Mail");
		Assert.assertEquals(BDDStepDefinition.sentMail.getEmailTime(), GmailTestData.getSendingTime());
	}
	/**
	 * assert the sent letter has been removed from Sent Mail
	 */
	@Then ("^letter just sent is not in Sent Mail$")
	public void assertLetterNotInSentMail() {
		MyLogger.info("asserting letter just sent is not in Sent Mail");
		Assert.assertFalse(BDDStepDefinition.sentMail.getEmailTime().equals(GmailTestData.getSendingTime()));
	}
	/**
	 * assert that invalid password notification is displayed
	 */
	@Then ("^message 'Wrong password. Try again.' is displayed$")
	public void assertWrongPasswordMessageIsDisplayed() {
		MyLogger.info("asserting message 'Wrong password. Try again.' is displayed");
		Assert.assertTrue(WebDriverSingleton.getWebDriverInstance().findElement(LogIn_PasswordPage.getWrongPasswordMessage()).isDisplayed());
	}
	/**
	 * assert the input letter subject is displayed in separate letter window
	 */
	@Then ("^letter subject is correct$")
	public void assertLetterWindowSubject() {
		MyLogger.info("asserting letter subject is correct");
		Assert.assertEquals(BDDStepDefinition.letterInNewWindow.getActualSubject(), Letter.getSubject());
	}
	/**
	 * assert the letter sender is displayed in separate letter window
	 */
	@Then ("^letter sender is correct$")
	public void assertLetterWindowSender() {
		MyLogger.info("asserting letter sender is correct");
		Assert.assertTrue(BDDStepDefinition.letterInNewWindow.getActualSender().contains(Account.getEmail()));
	}
	/**
	 * assert the input letter body is displayed in separate letter window
	 */
	@Then ("^letter body is correct$")
	public void assertLetterWindowBody() {
		MyLogger.info("asserting letter body is correct");
		Assert.assertTrue(BDDStepDefinition.letterInNewWindow.getActualLetterText().equals(Letter.getLetterText()));
	}
}