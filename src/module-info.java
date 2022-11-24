
module CPSC_219_Project {

	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}

//String creditCardInfo = "1234123412341234";
//
//public String isNumeric(String creditCardInfo) {
//	String validatedCardInfo = "";
//	String errorMessage = "";
//	boolean validCardInfo = true;
//	double invalidCharacterCounter = 0;
//	    	
//	for (char c : creditCardInfo.toCharArray()){
//		if (!Character.isDigit(c) && c != '.' ) {
//			validCardInfo = false;
//				errorMessage = "Invalid Card Number";
//		}
//		if (c == '.' || c == '/' || c == '!' || c =='@' || 
//			c == '#' || c == '$' || c =='+'  || c =='%' ||
//			c == '^' || c == '&' || c == '*' || c == '('||
//			c == ')' || c == '-' || c == '_' || c == '='||
//			c == '?' || c == ',' || c == '.' || c == '<'||
//			c == '>') {
//			
//			invalidCharacterCounter += 1;
//		}
//		if (invalidCharacterCounter > 0) {
//			validCardInfo = false;
//			errorMessage = "Credit card info is invalid: " + invalidCharacterCounter + "invalid characters were entered." ;
//		}
//	}
//	
//	if(validCardInfo == true) {
//		 validatedCardInfo = (creditCardInfo);
//	}   	
//	
//	
//	return errorMessage;
//}