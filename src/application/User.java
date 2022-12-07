package application;

public class User {

	private String firstName; 
	private String lastName; 
	private String address;
	private String postalCode;
	private String phoneNumber;
	
	public User() {
	
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws InvalidUserInputException {
		
		//checks if first name input given by user is only letters, and if not, throws invalid input exception
		if (firstName == "") {
			throw new InvalidUserInputException("Please input your first name in this field.");
		} else if (firstName != "") {	
    		for (char c : firstName.toCharArray()){
        		if (!Character.isLetter(c)&& c!=' ') {
        			throw new InvalidUserInputException("Only include letters in this field.");
        		}
        	}
		} else {
			this.firstName = firstName; //sets the instance variable when valid input is given
		}
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) throws InvalidUserInputException {
		
		//checks if last name input given by user is only letters, and if not, throws invalid input exception
		if (lastName == "") {
			throw new InvalidUserInputException("Please input your last name in this field.");
		} else if (lastName != "") {	
    		for (char c : lastName.toCharArray()){
        		if (!Character.isLetter(c) && c!=' ') {
        			throw new InvalidUserInputException("Only include letters in this field.");
        		}
        	}
		} else {
			this.lastName = lastName; //sets the instance variable when valid input is given
		}
	}
	
	public String getAddress() {
		return address;
	}
	
	/**
	 * 
	 * @param address
	 * @throws InvalidUserInputException 
	 */
	public void setAddress(String address) throws InvalidUserInputException {
		int hashCount = 0; //user is allowed to input one hash (some addresses contain a hash)
		
		//checks if address input given by user is letters and numbers, and contains no special characters except 0 hashes or 1 hash
		if (address == "") {
			throw new InvalidUserInputException("Please input your address in this field.");
		} else if (address != "") {	
			for (char c : address.toCharArray()){
        		if (c == '#') hashCount++; 
        	}
			for (char c : address.toCharArray()){
        		if (hashCount > 1) { //more than 1 hash in input will cause exception to be thrown
        			throw new InvalidUserInputException("Only one # is allowed to be used in this field.");
        		}
    			if (!Character.isDigit(c) && !Character.isLetter(c) && c!=' ' && c != '#' && (hashCount == 0 || hashCount == 1)) {
        			throw new InvalidUserInputException("Only include letters or numbers in this field.");
        		}
        	}
		} else {
			this.address = address; //sets the instance variable when valid input is given
		}	
	}
	
	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 * @throws InvalidUserInputException 
	 */
	public void setPostalCode(String postalCode) throws InvalidUserInputException {
		if (postalCode == "") {
			throw new InvalidUserInputException("Please input your postal code in this field.");
		} else if (postalCode != "") {	
			for (char c : postalCode.toCharArray()){
				if (c == ' ') {
					throw new InvalidUserInputException("Postal code should be in this format: X1X1X1");
				}
				if (postalCode.replace(" ", "").length() != 6 && c != ' ' && (Character.isDigit(c) || Character.isLetter(c))) {
    				throw new InvalidUserInputException (String.format("Postal should have 6 characters, not %d characters.", postalCode.length()));
    			}
				if (!Character.isDigit(c) && !Character.isLetter(c)) {
        			throw new InvalidUserInputException("Only include letters or numbers in this field, no whitespaces as well.");
        		}
        	}
			//checks if postal code is in X1X1X1 format or not (alternating letters and numbers)
			if (!(Character.isLetter(postalCode.toCharArray()[0]) && Character.isDigit(postalCode.toCharArray()[1])
				&& Character.isLetter(postalCode.toCharArray()[2]) && Character.isDigit(postalCode.toCharArray()[3])
				&& Character.isLetter(postalCode.toCharArray()[4]) && Character.isDigit(postalCode.toCharArray()[5]))) {
				throw new InvalidUserInputException("Postal code should be in this format: X1X1X1");
			}
		} else {
			this.postalCode = postalCode; //sets the instance variable when valid input is given
		}	
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 * @throws InvalidUserInputException 
	 */
	public void setPhoneNumber(String phoneNumber) throws InvalidUserInputException {
		
		//checks if phone number input given by user has no letters and is 10 digits long
		if (phoneNumber == "") {
			throw new InvalidUserInputException("Please input your phone number in this field.");
		} else if (phoneNumber != "") {
    		for (char c : phoneNumber.toCharArray()){
    			if (phoneNumber.length() != 10 && Character.isDigit(c)) {
    				throw new InvalidUserInputException (String.format("Phone number should have 10 digits, not %d digits.", phoneNumber.length()));
    			}
        		if (!Character.isDigit(c) && c!=' ') {
        			throw new InvalidUserInputException("Only include numbers in this field.");
        		}
        	}
		} else {
			this.phoneNumber = phoneNumber; //sets the instance variable when valid input is given
		}
		
	}
	
	

}
