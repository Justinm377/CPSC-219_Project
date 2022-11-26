package application;

public class InvalidUserInputException extends Exception {

	public InvalidUserInputException() {
	}
	
	public InvalidUserInputException(String message) {
		super(message);
	}
	
	public InvalidUserInputException(Throwable cause) {
		super(cause);
	}
	
	public InvalidUserInputException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidUserInputException(String message, Throwable cause, boolean enableSupression, boolean writableStackTrace) {
		super(message, cause, enableSupression, writableStackTrace);
	}

}
