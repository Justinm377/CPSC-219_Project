package application;

/**
 * Stores information about an user, such as their name, address, postal code, and phone number. This information can
 * be set based on valid user input, and later accessed. 
 * @author CS219-user Group 5
 *
 */
public class User {
	private String firstName; 
	private String lastName; 
	private String address;
	private String postalCode;
	private String phoneNumber;

	/**
	 * Constructs a new User. 
	 */
	public User() {
	}

	/**
	 * @return the first name of the user
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the user's input of their first name, if input is valid. Valid input contains only letter characters.
	 *  
	 * @param firstName A string intended to be the first name of the user. 
	 * @throws InvalidUserInputException if the user inputs characters apart from letters in first name or 
	 * does not input anything. 
	 */
	public void setFirstName(String firstName) throws InvalidUserInputException {
		//checks if first name input given by user is only letters, and if not, throws invalid input exception
		if (firstName == "") {
			throw new InvalidUserInputException("Please input your first name in this field."); //user doesn't input anything in text field, so exception is thrown
		} else if (firstName != "") {	
			for (char c : firstName.toCharArray()){
				if (!Character.isLetter(c)&& c!=' ') {
					throw new InvalidUserInputException("Only include letters in this field."); //user inputs numbers in text field, so exception is thrown
				}
			}
		} else {
			this.firstName = firstName; //sets the instance variable when valid input is given
		}
	}

	/**
	 * @return the last name of the user
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the user's input of their last name, if input is valid. Valid input contains only letter characters.
	 * 
	 * @param lastName A string intended to be the last name of the user.
	 * @throws InvalidUserInputException if the user inputs characters apart from letters in last name or does not 
	 * input anything. 
	 */
	public void setLastName(String lastName) throws InvalidUserInputException {

		//checks if last name input given by user is only letters, and if not, throws invalid input exception
		if (lastName == "") {
			throw new InvalidUserInputException("Please input your last name in this field."); //user doesn't input anything in text field, so exception is thrown
		} else if (lastName != "") {	
			for (char c : lastName.toCharArray()){
				if (!Character.isLetter(c) && c!=' ') {
					throw new InvalidUserInputException("Only include letters in this field."); //user inputs characters other than letters, so exception is thrown
				}
			}
		} else {
			this.lastName = lastName; //sets the instance variable when valid input is given
		}
	}

	/**
	 * @return the address of the user 
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the user's input of their address, if input is valid. Valid input contains only letter or number characters. 
	 * and one hash is allowed. 
	 * 
	 * @param address A string intended to be the address of the user. 
	 * @throws InvalidUserInputException if the user inputs characters apart from letters or numbers, more than one 
	 * hash character, or does not input anything. 
	 */
	public void setAddress(String address) throws InvalidUserInputException {
		int hashCount = 0; //user is allowed to input one hash (some addresses contain a hash)

		//checks if address input given by user is letters and numbers, and contains no special characters except 0 hashes or 1 hash
		if (address == "") {
			throw new InvalidUserInputException("Please input your address in this field.");
		} else if (address != "") {	
			for (char c : address.toCharArray()){
				if (c == '#') hashCount++; //counting the number of hashes in user input first
			}
			for (char c : address.toCharArray()){
				if (hashCount > 1) { //more than 1 hash in input will cause exception to be thrown
					throw new InvalidUserInputException("Only one # is allowed to be used in this field.");
				}
				if (!Character.isDigit(c) && !Character.isLetter(c) && c!=' ' && c != '#' && (hashCount == 0 || hashCount == 1)) {
					throw new InvalidUserInputException("Only include letters or numbers in this field."); //user enters an invalid character (apart from a hash), so exception is thrown
				}
			}
		} else {
			this.address = address; //sets the instance variable when valid input is given
		}	
	}

	/**
	 * @return the postal code of the user
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the user's input of their postal code, if input is valid. Valid input is in the format "X1X1X1" and
	 * contains only 6 characters (only letters and numbers, no white spaces). 
	 * 
	 * @param postalCode A string intended to be the postal code of the user. 
	 * @throws InvalidUserInputException if the user doesn't input a postal code with format "X1X1X1", input has more 
	 * than 6 characters, input has characters other than letters or numbers, or user doesn't input anything 
	 */
	public void setPostalCode(String postalCode) throws InvalidUserInputException {
		if (postalCode == "") {
			throw new InvalidUserInputException("Please input your postal code in this field."); //user cannot enter nothing in text field
		} else if (postalCode != "") {	
			for (char c : postalCode.toCharArray()){
				//user may have entered postal code in format "X1X 1X1", but white spaces are not allowed, so exception is thrown
				if (c == ' ') {
					throw new InvalidUserInputException("Please do not include white space.");
				}
				
				//user cannot input more or less than 6 characters, or exception is thrown
				if (postalCode.replace(" ", "").length() != 6 && c != ' ' && (Character.isDigit(c) || Character.isLetter(c))) {
					throw new InvalidUserInputException (String.format("Postal should have 6 characters, not %d characters.", postalCode.length()));
				}
				
				//user can only input letters or numbers, or exception is thrown
				if (!Character.isDigit(c) && !Character.isLetter(c)) {
					throw new InvalidUserInputException("Only include letters or numbers in this field.");
				}
			}
			//checks if postal code is in X1X1X1 format or not (alternating letters and numbers), or exception is thrown
			if (!(Character.isLetter(postalCode.toCharArray()[0]) && Character.isDigit(postalCode.toCharArray()[1])
					&& Character.isLetter(postalCode.toCharArray()[2]) && Character.isDigit(postalCode.toCharArray()[3])
					&& Character.isLetter(postalCode.toCharArray()[4]) && Character.isDigit(postalCode.toCharArray()[5]))) {
				throw new InvalidUserInputException("Postal code should be in this format: X1X1X1");
			}
		} else {
			this.postalCode = postalCode; //sets the instance variable when valid input is given
		}	
	}

	/**
	 * @return the phone number of the user
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the user's input of their phone number, if input is valid. Valid input contains 10 digits, and characters
	 * that are only numbers. The phone number is in the format "1112223333".
	 * 
	 * @param phoneNumber A string intended to be the phone number of the user. 
	 * @throws InvalidUserInputException if the user inputs an phone number containing characters (including white spaces) other 
	 * than numbers, more than or less than 10 digits, if phone number format is not "1112223333", or inputs nothing. 
	 */
	public void setPhoneNumber(String phoneNumber) throws InvalidUserInputException {
		if (phoneNumber == "") {
			throw new InvalidUserInputException("Please input your phone number in this field."); //user doesn't enter anything so exception is thrown
		} else if (phoneNumber != "") {
			for (char c : phoneNumber.toCharArray()){
				//no dashes or whitespaces are allowed. if entered, exception is thrown
				if (c == ' ' || c == '-') {
					throw new InvalidUserInputException("Phone number should not include '-' or white spaces.");
				}
				
				//user cannot enter non-digit characters 
				if (!Character.isDigit(c)) {
					throw new InvalidUserInputException("Only include numbers in this field.");	
				}
				
				//user cannot enter more than or less than 10 digits 
				if (phoneNumber.replaceAll(" ","").length() != 10 && c != ' ' && c != '-') {
					throw new InvalidUserInputException (String.format("Phone number should have 10 digits, not %d digits.", phoneNumber.length()));	
				}
			}
		} else {
			this.phoneNumber = phoneNumber; //sets the instance variable when valid input is given
		}
	}

}
