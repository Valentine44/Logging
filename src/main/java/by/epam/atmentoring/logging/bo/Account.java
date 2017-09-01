package by.epam.atmentoring.logging.bo;

import by.epam.atmentoring.logging.logger.MyLogger;

/**
 * test Google account class
 * @author Valiantsin_Ivashynka
 *
 */
public class Account {

	private static final String EMAIL = "iv.selenium.test@gmail.com";
	private static final String PASSWORD = "$T123456";
	private static final String INCORRECT_PASSWORD = "wrong!";
	/**
	 * get email of the test Google account
	 * @return email of the test Google account
	 */
	public static String getEmail() {
		MyLogger.info("Retrieving EMAIL from Account");
		return EMAIL;
	}
	/**
	 * get password to access the test Google account
	 * @return password to access the test Google account
	 */
	public static String getPassword() {
		MyLogger.info("Retrieving PASSWORD from Account");
		return PASSWORD;
	}
	/**
	 * get incorrect password of the test Google account
	 * @return incorrect password of the test Google account
	 */
	public static String getIncorrectPassword() {
		MyLogger.info("Retrieving INCORRECT_PASSWORD from Account");
		return INCORRECT_PASSWORD;
	}
}