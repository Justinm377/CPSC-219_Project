package application;

import javafx.scene.control.TextField;

public class PaymentInfoValidation  {

	public PaymentInfoValidation() {
	}

    public String isNumeric(TextField stringInputToValidate) throws InvalidUserInputException{
    	String infoToValidate = stringInputToValidate.getText();
		String goodCardInfo = "";
		String errorMessage = "";
		boolean validCardInfo = true;
    	double invalidCharacterCounter = 0;
    	    	
    	for (char c : infoToValidate.toCharArray()){
    		if (!Character.isDigit(c) && c != '.' ) {
    			validCardInfo = false;
    			errorMessage = "Invalid Card Number";
    			
    		}
    		if (c == '.' || c == '/' || c == '!' || c =='@' || 
    			c == '#' || c == '$' || c =='+'  || c =='%' ||
    			c == '^' || c == '&' || c == '*' || c == '('||
    			c == ')' || c == '-' || c == '_' || c == '='||
    			c == '?' || c == ',' || c == '.' || c == '<'||
    			c == '>') {
    			
    			invalidCharacterCounter += 1;
    			throw new InvalidUserInputException ("Invalid character entered. Do not include the character: " + c);
    		}
    		if (invalidCharacterCounter > 0) {
    			validCardInfo = false;
    			errorMessage = "Credit card info is invalid: " + invalidCharacterCounter + "invalid characters were entered." ;
    		}
    	}
    	
    	if(validCardInfo == true) {
    		  goodCardInfo = (infoToValidate);
    	}   	
    	
    	return goodCardInfo;
	}
    
    public String isAlphabeticValidation (TextField stringInputToValidate ) {
    	String validInfo = stringInputToValidate.getText();
    	String validatedInfo = "";
		String errorMessage = "";
		boolean validInput = true;
		
		for(char c : validInfo.toCharArray()) {
			if(Character.isDigit(c)) {
				validInput = false;
				errorMessage = "Do not include any numerical characters.";
			}else if (c == '.' || c == '/' || c == '!' || c =='@' || 
    			c == '#' || c == '$' || c =='+'  || c =='%' ||
    			c == '^' || c == '&' || c == '*' || c == '('||
    			c == ')' || c == '-' || c == '_' || c == '='||
    			c == '?' || c == ',' || c == '.' || c == '<'||
    			c == '>'){
				validInput = false;
				errorMessage = "Do not include any non alphabetic characters.";
				
			}else {
				validatedInfo = validInfo;
				validInput = true;
			}
		}
		return errorMessage;
    }

}
