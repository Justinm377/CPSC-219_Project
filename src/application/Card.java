package application;

public class Card {
	private String cardName;
	private String cardNumber;
	private String expiryMonth;
	private String expiryYear;
	private String cvv;
	
	public Card() {
		
	}

	/**
	 * @return the cardName
	 */
	public String getCardName() {
		return cardName;
	}

	/**
	 * @param cardName the cardName to set
	 * @throws InvalidUserInputException 
	 */
	public void setCardName(String cardName) throws InvalidUserInputException {
		//checks if the card name input provided by user is only letters and if not, provides a clear error message
		if (cardName == "") {
			throw new InvalidUserInputException("Please input your card name in this field.");
		} else if (cardName != "") {	
    		for (char c : cardName.toCharArray()){
        		if (!Character.isLetter(c)&& c!=' ') {
        			throw new InvalidUserInputException("Only include letters in this field.");
        		}
        	}
		} else {
			this.cardName = cardName; //sets the instance variable when valid input is given
		}
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 * @throws InvalidUserInputException
	 */
	public void setCardNumber(String cardNumber) throws InvalidUserInputException {
		//checks if user input for card number has only numbers and 16 digits. if not, it throws an appropriate exception
		if (cardNumber == "") {
			throw new InvalidUserInputException("Please input your card number in this field.");
		} else if (cardNumber != "") {
    		for (char c : cardNumber.toCharArray()){
    			if (cardNumber.length() != 16 && Character.isDigit(c)) {
    				throw new InvalidUserInputException (String.format("Card number should have 16 digits, not %d digits.", cardNumber.length()));
    			}
        		if (!Character.isDigit(c) && c!=' ') {
        			throw new InvalidUserInputException("Only include numbers in this field.");
        		}
        	}
		} else {
			this.cardNumber = cardNumber; //sets the instance variable when valid input is given
		}
	}

	/**
	 * @return the expiryMonth
	 */
	public String getExpiryMonth() {
		return expiryMonth;
	}

	/**
	 * @param expiryMonth the expiryMonth to set
	 * @throws InvalidUserInputException 
	 */
	public void setExpiryMonth(String expiryMonth) throws InvalidUserInputException {
		
		if (expiryMonth == "") {
			throw new InvalidUserInputException("Please input your card's expiry month in this field.");
		} else if (expiryMonth != "") {
    		for (char c : expiryMonth.toCharArray()){
    			if (expiryMonth.length() != 2 && Character.isDigit(c)) {
    				throw new InvalidUserInputException (String.format("Expiry month should have 2 digits, not %d digits.", expiryMonth.length()));
    			}
        		if (!Character.isDigit(c) && c!=' ') {
        			throw new InvalidUserInputException("Only include numbers in this field.");
        		}
        	}
    		if (Integer.parseInt(expiryMonth) < 1 || Integer.parseInt(expiryMonth) > 12) {
    			throw new InvalidUserInputException("Card expiry month input should be between 1 and 12.");
    		}
		} else {
			this.expiryMonth = expiryMonth; //sets the instance variable when valid input is given
		}
	}

	/**
	 * @return the expiryYear
	 */
	public String getExpiryYear() {
		return expiryYear;
	}

	/**
	 * @param expiryYear the expiryYear to set
	 * @throws InvalidUserInputException 
	 */
	public void setExpiryYear(String expiryYear) throws InvalidUserInputException {
		
		if (expiryYear == "") {
			throw new InvalidUserInputException("Please input your card's expiry year in this field.");
		} else if (expiryYear != "") {
    		for (char c : expiryYear.toCharArray()){
    			if (expiryYear.length() != 2 && Character.isDigit(c)) {
    				throw new InvalidUserInputException (String.format("Expiry year should have 2 digits, not %d digits.", expiryYear.length()));
    			}
        		if (!Character.isDigit(c) && c!=' ') {
        			throw new InvalidUserInputException("Only include numbers in this field.");
        		}
        	}
    		if (Integer.parseInt(expiryYear) < 22) {
    			throw new InvalidUserInputException("Card expiry year input should be 22 or after.");
    		}
		} else {
			this.expiryYear = expiryYear; //sets the instance variable when valid input is given
		}
		System.out.println(Integer.parseInt(expiryYear));
	}

	/**
	 * @return the cvv
	 */
	public String getCvv() {
		return cvv;
	}

	/**
	 * @param cvv the cvv to set
	 * @throws InvalidUserInputException 
	 */
	public void setCvv(String cvv) throws InvalidUserInputException {
		
		if (cvv == "") {
			throw new InvalidUserInputException("Please input your card's CVV in this field.");
		} else if (cvv != "") {
    		for (char c : cvv.toCharArray()){
    			if (cvv.length() != 3 && Character.isDigit(c)) {
    				throw new InvalidUserInputException (String.format("CVV should have 3 digits, not %d digits.", cvv.length()));
    			}
        		if (!Character.isDigit(c) && c!=' ') {
        			throw new InvalidUserInputException("Only include numbers in this field.");
        		}
        	}
		} else {
			this.cvv = cvv; //sets the instance variable when valid input is given
		}
	}
	
	

}
