package application;

/**
 * Used throughout the application's classes to throw exceptions when the user enters an invalid input.
 * @author CS219-user
 *
 */
public class InvalidUserInputException extends Exception {

	/**
	 * Constructs a new InvalidUserInputException. 
	 */
	public InvalidUserInputException() {
	}

	/**
	 * Constructs a new InvalidUserInputException with a detailed message. 
	 * @param message the specified detailed message about invalid user input
	 */
	public InvalidUserInputException(String message) {
		super(message);
	}

	/**
	 * Constructs a new InvalidUserInputException with the cause.
	 * @param cause the cause of the exception
	 */
	public InvalidUserInputException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new InvalidUserInputException with the detailed message and cause.
	 * @param message the specified detailed message about invalid user input
	 * @param cause the cause of the exception
	 */
	public InvalidUserInputException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new InvalidUserInputException with the detailed message, cause, whether suppression is enabled, and whether
	 * stack trace is writable. 
	 * @param message the specified detailed message about invalid user input
	 * @param cause the cause of the exception
	 * @param enableSupression whether suppression is enabled
	 * @param writableStackTrace whether stack trace is writable
	 */
	public InvalidUserInputException(String message, Throwable cause, boolean enableSupression, boolean writableStackTrace) {
		super(message, cause, enableSupression, writableStackTrace);
	}

	// This docs oracle page was used to learn about the exceptions class: https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html
}