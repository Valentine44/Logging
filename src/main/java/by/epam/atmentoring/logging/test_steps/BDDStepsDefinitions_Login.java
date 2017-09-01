package by.epam.atmentoring.logging.test_steps;

import by.epam.atmentoring.logging.bo.Account;
import by.epam.atmentoring.logging.pages.LogIn_EmailPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
/**
 * class containing definitions of Gherkin steps related to logging in/out
 * @author Valiantsin_Ivashynka
 *
 */
public class BDDStepsDefinitions_Login extends BDDStepDefinition {
	/**
	 * open Google login form
	 */
	@Given ("^user opens Google login form$")
	public void userOpensGmailLoginForm() {
		BDDStepDefinition.emailPage = new LogIn_EmailPage().open();
	}
	/**
	 * submit email (login)
	 */
	@And ("^user submits \"([^\"]+)\" email$")
	public void userLoginsGmail(String emailValidity) {
		BDDStepDefinition.passwordPage = BDDStepDefinition.emailPage.inputEmail().submitEmail();
	}
	/**
	 * submit "correct" or "incorrect" password
	 * @param paswordValidity
	 */
	@And ("^user submits \"([^\"]+)\" password$")
	public void userSubmitsPassword(String passwordValidity) {
		
		switch(passwordValidity) {
			case "correct": BDDStepDefinition.googleAccount = BDDStepDefinition.passwordPage.inputPassword(Account.getPassword()).submitPassword();
			break;
			case "incorrect": BDDStepDefinition.passwordPage = BDDStepDefinition.passwordPage.inputPassword(Account.getIncorrectPassword()).attemptSubmitPassword();
			break;
		}
	}
	/**
	 * log out
	 */
	@And ("^user logs out$")
	public void userLogsOut() {
		BDDStepDefinition.currentPage.logOut();
	}
}
