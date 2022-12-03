package application;

import javafx.scene.control.TextField;

public class User {

	private String firstName; 
	private String lastName; 
	private String address;
	private String phoneNumber;
	private String cardName; 
	private int cardNumber;
	private int expiry; 
	
	public User() {
	}
	
	public String isAlphabeticValidation (TextField stringInputToValidate) throws InvalidUserInputException {
    	String infoToValidate = stringInputToValidate.getText();
    	String validatedInfo = "";
		String errorMessage = "";
		boolean validInput = true;
		
		if (infoToValidate == "") {
			throw new InvalidUserInputException ("Please enter a value");
		}
		
		for(char c : infoToValidate.toCharArray()) {
			if(Character.isDigit(c)) {
				validInput = false;
				throw new InvalidUserInputException ( "Do not include any numerical characters.");
			}else if (c == '.' || c == '/' || c == '!' || c =='@' || 
    			c == '#' || c == '$' || c =='+'  || c =='%' ||
    			c == '^' || c == '&' || c == '*' || c == '('||
    			c == ')' || c == '-' || c == '_' || c == '='||
    			c == '?' || c == ',' || c == '.' || c == '<'||
    			c == '>'){
				validInput = false;
				throw new InvalidUserInputException ("Do not include any non alphabetic characters.");		
			}else {
				validatedInfo = infoToValidate;
				validInput = true;
			}
		}
		return validatedInfo;
    }
	
	public String isNumeric (TextField integerToValidate) throws InvalidUserInputException{
		String infoToValidate = integerToValidate.getText();
		String goodCardInfo = "";
		boolean validCardInfo = true;
    	double invalidCharacterCounter = 0;
    	
    	if (infoToValidate == "") {
			throw new InvalidUserInputException ("Please enter a value");
    	}
    	
    	for (char c : infoToValidate.toCharArray()){
    		if (!Character.isDigit(c)) {
    			validCardInfo = false;
    			throw new InvalidUserInputException ("Please input numerical values only");
    		}
    		if (c == '.' || c == '/' || c == '!' || c =='@' || 
    			c == '#' || c == '$' || c =='+'  || c =='%' ||
    			c == '^' || c == '&' || c == '*' || c == '('||
    			c == ')' || c == '-' || c == '_' || c == '='||
    			c == '?' || c == ',' || c == '.' || c == '<'||
    			c == '>') {
    			
    			invalidCharacterCounter += 1;
    		}
    		if (invalidCharacterCounter > 0) {
    			validCardInfo = false;
    			throw new InvalidUserInputException( "Credit card info is invalid: " + invalidCharacterCounter + " invalid characters were entered.") ;
    		}
    	}
    	
    	if(validCardInfo == true) {
    		  goodCardInfo = infoToValidate;
    	} 
    	return goodCardInfo;
	}

}