package by.epam.atmentoring.logging.test_steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
/**
 * class containing definitions of Gherkin steps related to navigation within Gmail
 * @author Valiantsin_Ivashynka
 *
 */
public class BDDStepsDefinitions_Navigation extends BDDStepDefinition {
	/**
	 * open Gmail after successful login to Google account
	 */
	@When ("^user opens Gmail$")
	public void userOpensGmail() {
		inbox = googleAccount.selectMail();
	}
	/**
	 * refresh page
	 */
	@And ("^user refreshes page$")
	public void userRefreshesPage() {
		BDDStepDefinition.currentPage.jsRefreshPage();
	}
	/**
	 * navigate to some Gmail page (Inbox, Drafts, Sent mail)
	 * @param page
	 */
	@And ("^user navigates to \"([^\"]+)\"$")
	public void userNavigetesTo(String page) {
		switch(page) {
			case "Inbox": inbox = BDDStepDefinition.currentPage.toInboxPage();
			case "Drafts": drafts = BDDStepDefinition.currentPage.toDraftsPage();
			case "Sent Mail": sentMail = BDDStepDefinition.currentPage.toSentMailPage();
		}
	}
}