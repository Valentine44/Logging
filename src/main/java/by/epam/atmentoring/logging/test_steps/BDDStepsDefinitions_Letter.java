package by.epam.atmentoring.logging.test_steps;

import org.openqa.selenium.WebDriver;

import by.epam.atmentoring.logging.bo.Letter;
import by.epam.atmentoring.logging.logger.MyLogger;
import by.epam.atmentoring.logging.singleton.WebDriverSingleton;
import by.epam.atmentoring.logging.test_data.GmailTestData;
import cucumber.api.java.en.And;
/**
 * class containing definitions of Gherkin steps related to Letter (creation, removal etc.)
 * @author Valiantsin_Ivashynka
 *
 */
public class BDDStepsDefinitions_Letter extends BDDStepDefinition {
	
	private WebDriver driver = WebDriverSingleton.getWebDriverInstance();
	/**
	 * create letter
	 */
	@And ("^user composes a letter$")
	public void userComposesLetter() { 
		BDDStepDefinition.inbox.clickCompose().inputAddressee(Letter.getAddressee()).inputSubject().inputLetterText();
		}
	/**
	 * send the letter just created
	 */
	@And ("^user sends a letter$")
	public void userSendsLetter() { 
		BDDStepDefinition.inbox.sendDraft();
		}
	/**
	 * save just created letter as a draft
	 */
	@And ("^user saves draft$")
	public void userSavesDraft() {
		BDDStepDefinition.inbox.closeAndSave();
		}
	/**
	 * open draft
	 */
	@And ("^user opens draft$")
	public void userOpensDraft() { 
		BDDStepDefinition.drafts.openDraft();
		}
	/**
	 * send open draft
	 */
	@And ("^user sends draft$")
	public void userSendsDraft() { 
		BDDStepDefinition.drafts.sendDraft();
		}
	/**
	 * remove the letter just sent letter (the one atop SentMail page)
	 */
	@And ("^user removes last sent letter$")
	public void userRemovesLastSentLetter() {
		BDDStepDefinition.sentMail.expandLeftNavBar().letterToTrash(BDDStepDefinition.sentMail.getLastSentLetter());
		}
	/**
	 * search letter 
	 */
	@And ("^user searches letter$")
	public void userRunsSearch() {
		BDDStepDefinition.sentMail.inputSearchQuery(GmailTestData.getSearchQuery()).clickSearch();
		}
	/**
	 * open search result
	 */
	@And ("^user opens found letter$")
	public void userOpensSearchResult() {
		BDDStepDefinition.letter = BDDStepDefinition.sentMail.openSearchResult();
		}
	/**
	 * open letter in a new browser window
	 */
	@And ("^user opens letter in new window$")
	public void userOpensLetterInNewWindow () {
		BDDStepDefinition.letterInNewWindow = BDDStepDefinition.letter.inNewWindow();
		}
	/**
	 * remove letter open in separate browser window
	 */
	@And ("^user removes letter open in separate window$")
	public void userRemovesLetterOpenInSeparateWindow() {
		try {
			BDDStepDefinition.letterInNewWindow.removeLetter();
		} catch (Exception e) {
			MyLogger.error(e.getMessage(), e, driver);
		}
	}
	/**
	 * close letter window
	 */
	@And ("^user closes letter window$")
	public void userClosesletterWindow() {
		BDDStepDefinition.letterInNewWindow.closeLetterWindow();
		}
}