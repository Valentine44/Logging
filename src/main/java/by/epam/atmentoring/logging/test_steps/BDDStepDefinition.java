package by.epam.atmentoring.logging.test_steps;

import by.epam.atmentoring.logging.pages.*;
/**
 * class to store page object references common for Gherkin test steps definitions
 * @author Valiantsin_Ivashynka
 *
 */
public class BDDStepDefinition {
	protected static LogIn_EmailPage emailPage;
	protected static LogIn_PasswordPage passwordPage;
	protected static GoogleAccountPage googleAccount;
	protected static InboxPage inbox;
	protected static SentMailPage sentMail;
	protected static DraftsPage drafts;
	protected static LetterPage letter;
	protected static LetterWindow letterInNewWindow;
	
	public static GmailPage currentPage;
}