package by.epam.atmentoring.logging.bo;

import by.epam.atmentoring.logging.logger.MyLogger;

/**
 * class for Email letter business object
 * @author Valiantsin_Ivashynka
 *
 */
public class Letter {

	private static final String ADDRESSEE = "iv.selenium.test2@yopmail.com";
	private static final String SUBJECT = "Test subject";
	private static final String LETTER_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n\nKind regards,\nJohn Doe";
	/**
	 * get email address of addressee
	 * @return email address of addressee
	 */
	public static String getAddressee() {
		MyLogger.info("Retrieving ADDRESSEE from Letter");
		return ADDRESSEE;
	}
	/**
	 * get email subject
	 * @return email subject
	 */
	public static String getSubject() {
		MyLogger.info("Retrieving SUBJECT from Letter");
		return SUBJECT;
	}
	/**
	 * get email text
	 * @return email text
	 */
	public static String getLetterText() {
		MyLogger.info("Retrieving LETTER_TEXT from Letter");
		return LETTER_TEXT;
	}
}