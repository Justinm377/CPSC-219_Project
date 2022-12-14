package application;

/**
 * Takes information about the user's credit or debit card, like card name, card number, expiry month, expiry year,
 * and CVV, and validates the user's input for these attributes. 
 * @author CS219-user Group 5
 *
 */
public class Card {
	private String cardName;
	private String cardNumber;
	private String expiryMonth;
	private String expiryYear;
	private String cvv;

	/**
	 * Constructs new user card.
	 */
	public Card() {

	}

	/**
	 * @return the card name entered by user.  
	 */
	public String getCardName() {
		return cardName;
	}

	/**
	 * Sets the user input of their card name, as long as input is valid. Valid input only allows letters, no numbers
	 * or special characters.
	 * @param cardName a String intended to be a card name entered by the user and set as cardName.
	 * @throws InvalidUserInputException when user provides a card name containing characters other than letters
	 */
	public void setCardName(String cardName) throws InvalidUserInputException {
		//checks if the card name input provided by user is only letters and if not, exception is thrown
		if (cardName == "") { 
			throw new InvalidUserInputException("Please input your card name in this field."); //if user enters no name, exception is thrown
		} else if (cardName != "") {	
			for (char c : cardName.toCharArray()){
				if (!Character.isLetter(c)&& c!=' ') {
					throw new InvalidUserInputException("Only include letters in this field."); //if user enters non-letter characters, exception is thrown
				}
			}
		} else {
			this.cardName = cardName; //sets the instance variable when valid input is given
		}
	}

	/**
	 * @return the card number entered by user.  
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Sets the card number given by user input, as long as input is valid. Valid input allows only numbers 
	 * and limits the size to 16 digits. No alphabets or special characters will be allowed. It will also 
	 * show error when card size exceeds 16 digits.
	 * @param cardNumber A String intended to be a card number entered by the user and set as cardNumber. 
	 * @throws InvalidUserInputException when user provides a card number that doesn't contain 16 numbers and characters other than digits.
	 */
	public void setCardNumber(String cardNumber) throws InvalidUserInputException {
		//checks if user input for card number has only numbers and 16 digits. if not, it throws an appropriate exception
		if (cardNumber == "") {
			throw new InvalidUserInputException("Please input your card number in this field."); //if user enters no card number, exception is thrown
		} else if (cardNumber != "") {
			for (char c : cardNumber.toCharArray()){
				if (c == ' ') {
					throw new InvalidUserInputException("Please do not include white spaces."); //checking for white spaces user may have accidentally entered
				}

				if (!Character.isDigit(c)) {
					throw new InvalidUserInputException("Only include numbers in this field."); //if user enters non-digit characters, exception is thrown
				}

				if (cardNumber.replace(" ", "").length() != 16 && Character.isDigit(c) && c != ' ') {
					throw new InvalidUserInputException(String.format("Card number should have 16 digits, not %d digits.", cardNumber.length())); //if user enters card number that doesn't have 16 digits, exception is thrown
				}
			}
		} else {
			this.cardNumber = cardNumber; //sets the instance variable when valid input is given
		}
	}

	/**
	 * @return the expiry month entered by user. 
	 */
	public String getExpiryMonth() {
		return expiryMonth;
	}

	/**
	 * Sets the expiry month given by user input, as long as it is valid. Valid input allows only digits 
	 * between 1 and 12.
	 * @param expiryMonth a String intended to be the expiry month entered by the user and set as expiryMonth.
	 * @throws InvalidUserInputException when the user provides an expiry month that contains characters that are not digits, does 
	 * not have 2 digits, or provides a value that is not between 1 and 12.
	 */
	public void setExpiryMonth(String expiryMonth) throws InvalidUserInputException {
		//sets user input for expiry month, only if it is between 1 and 12 and contains only digits, else it throws an exception
		if (expiryMonth == "") {
			throw new InvalidUserInputException("Please input your card's expiry month in the first field."); //if user enters no expiry month, exception is thrown
		} else if (expiryMonth != "") {
			for (char c : expiryMonth.toCharArray()){
				if (c == ' ') {
					throw new InvalidUserInputException("Please do not include white spaces in the first field."); //checking for white spaces user may have accidentally entered
				}

				if (!Character.isDigit(c) && c != ' ') {
					throw new InvalidUserInputException("Only include numbers in the first field."); //if user enters expiry month with non-digit characters, exception is thrown
				}

				if (expiryMonth.replace(" ", "").length() != 2 && Character.isDigit(c) && c != ' ') {
					throw new InvalidUserInputException (String.format("Expiry month should have 2 digits, not %d digits.", expiryMonth.length())); //if user enters expiry month that doesn't have 2 digits, exception is thrown
				}
			}
			if (Integer.parseInt(expiryMonth) < 1 || Integer.parseInt(expiryMonth) > 12) {
				throw new InvalidUserInputException("Card expiry month input should be between 1 and 12."); //if user enters expiry month that isn't in the range of 1-12, exception is thrown
			}
		} else {
			this.expiryMonth = expiryMonth; //sets the instance variable when valid input is given
		}
	}

	/**
	 * @return the expiry year entered by user. 
	 */
	public String getExpiryYear() {
		return expiryYear;
	}

	/**
	 * Sets the expiry year entered by the user input, as long as input is valid. Valid input allows only 2 digits
	 * and does not allow years less than 22 (2022). 
	 * @param expiryYear a String intended to be the expiry year entered by the user and set as expiryYear.
	 * @throws InvalidUserInputException when the user enters an expiry year that contains characters other than digits, does not have 2 digits, or provides a value less than the current year, 22. 
	 */
	public void setExpiryYear(String expiryYear) throws InvalidUserInputException {
		//sets user input for expiry year as long as its a digit and 22 or later, else it throws an exception
		if (expiryYear == "") {
			throw new InvalidUserInputException("Please input your card's expiry year in the second field."); //if user enters no expiry year, exception is thrown
		} else if (expiryYear != "") {
			for (char c : expiryYear.toCharArray()){
				if (c == ' ') {
					throw new InvalidUserInputException("Please do not include white spaces in the second field."); //checking for white spaces user may have accidentally entered
				}

				if (!Character.isDigit(c) && c != ' ') {
					throw new InvalidUserInputException("Only include numbers in the second field."); //if user enters expiry year with non-digit characters, exception is thrown
				}

				if (expiryYear.replace(" ", "").length() != 2 && Character.isDigit(c) && c != ' ') {
					throw new InvalidUserInputException (String.format("Expiry year should have 2 digits, not %d digits.", expiryYear.length())); //if user enters expiry year that doesn't have 2 digits, exception is thrown
				}
			}
			if (Integer.parseInt(expiryYear) < 22) {
				throw new InvalidUserInputException("Card expiry year input should be 22 or after."); //if user enters expiry year that is before 22 (2022, current year), exception is thrown
			}
		} else {
			this.expiryYear = expiryYear; //sets the instance variable when valid input is given
		}
	}

	/**
	 * @return the cvv entered by the user. 
	 */
	public String getCVV() {
		return cvv;
	}

	/**
	 * Sets the CVV entered by user input, as long as user input is valid. Valid input allows only 3 digits. 
	 * @param cvv a String intended to be the CVV entered by the user and set as cvv. 
	 * @throws InvalidUserInputException when the user provides a cvv value that is not 3 digits long, or contains characters that are not digits. 
	 */
	public void setCVV(String cvv) throws InvalidUserInputException {
		//checks if CVV input by user is 3 digits only. if not it throws an exception
		if (cvv == "") {
			throw new InvalidUserInputException("Please input your card's CVV in this field."); //if user enters no cvv, exception is thrown
		} else if (cvv != "") {
			for (char c : cvv.toCharArray()){
				if (c == ' ') {
					throw new InvalidUserInputException("Please do not include white spaces."); //checking for white spaces user may have accidentally entered
				}

				if (!Character.isDigit(c) && c != ' ') {
					throw new InvalidUserInputException("Only include numbers in this field."); //if user enters a cvv value with non-digit characters, exception is thrown
				}

				if (cvv.replace(" ", "").length() != 3 && Character.isDigit(c) && c != ' ') {
					throw new InvalidUserInputException (String.format("CVV should have 3 digits, not %d digits.", cvv.length())); //if user enters a cvv that doesn't contain 3 digits, exception is thrown
				}
			}
		} else {
			this.cvv = cvv; //sets the instance variable when valid input is given
		}
	}

	/**
	 * Checks that the user input for expiry month is valid when their input for expiry year is 22 (2022), to match the
	 * current time (December 2022). 
	 * @param expiryMonth a String intended to be the expiry month entered by the user
	 * @param expiryYear a String intended to be the expiry year user entered by the user
	 * @throws InvalidUserInputException when expiry date does not match the current time (December 2022). 
	 */
	public void checkIfExpiryDateIsValid(String expiryMonth, String expiryYear) throws InvalidUserInputException {
		if (expiryMonth != "" && expiryYear != "") {
			if (Integer.parseInt(expiryYear) == 22 && Integer.parseInt(expiryMonth)<12) {
				throw new InvalidUserInputException("For year 22, expiry month cannot be before 12.");
			}
		}
	}

}
