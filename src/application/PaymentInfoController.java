package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PaymentInfoController {
	
	private Stage primaryStage;
	private Scene myScene;
	
	private OrderConfirmationController orderConfirmationController;
	
	@FXML
	private Label firstNameErrorLabel;
	@FXML
	private TextField firstNameTextField;
	@FXML
	private Label lastNameErrorLabel;
	@FXML
	private TextField lastNameTextField;
	@FXML
	private Label addressErrorLabel;
	@FXML
	private TextField addressTextField;
	@FXML
	private Label phoneNumberErrorLabel;
	@FXML
	private TextField phoneNumberTextField;
	@FXML
	private Label nameErrorLabel;
	@FXML
	private TextField nameOnCardTextField;
	@FXML
	private Label cardNumberErrorLabel;
	@FXML
	private TextField cardNumberTextField;
	@FXML
	private Label expiryMonthErrorLabel;
	@FXML
	private TextField expireMonthTextField;
	@FXML
	private Label expiryYearErrorLabel;
	@FXML
	private TextField expiryYearTextField;
	@FXML
	private Label postalCodeErrorLabel;
	@FXML
	private TextField postalCodeTextField;
	@FXML
	private Label lengthErrorLabel;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}

	public void setMyScene(Scene aScene) { 
		myScene = aScene;
	}

	public void setNextController(PaymentSummaryController next) {
		//paymentSummaryController = next;
	}

	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	public void isUserInputValid (TextField userInput, int typeOfValidation) throws InvalidUserInputException{
		String infoToValidate = userInput.getText();
    	if (infoToValidate == "") {throw new InvalidUserInputException ("Please input information in this field.");}	
    	if ( typeOfValidation == 1) {
    		for (char c : infoToValidate.toCharArray()){
        		if (!Character.isDigit(c)&& c!=' ') {
        			throw new InvalidUserInputException ("Please input numerical values only in this field.");
        		}
        	}
    	}else if (typeOfValidation == 2) {
    		for(char c : infoToValidate.toCharArray()) {
    			if(!Character.isLetter(c)&& c!=' ') {
    				throw new InvalidUserInputException ( "Do not include non alphabetical characters in this field.");
    			}
    		}
    	}else if ( typeOfValidation == 3) {
    		for (char c : infoToValidate.toCharArray()){
        		if (!Character.isDigit(c)&& !Character.isLetter(c)&& c!= ' ') {
        			throw new InvalidUserInputException ("Please do not input special characters in this field.");
        		}
        	}
    	}
	}
	
	public void checkInputLength() throws InvalidUserInputException{
		if(expireMonthTextField.getText().length() != 2 && expireMonthTextField.getText().length() != 0) {throw new InvalidUserInputException ("Month of expiry input should be 2 digits.");}
		if(expiryYearTextField.getText().length() != 2 && expiryYearTextField.getText().length() != 0) {throw new InvalidUserInputException ("Year of expiry input should be 2 digits.");}
		if(cardNumberTextField.getText().length() != 16 && cardNumberTextField.getText().length() != 0) {throw new InvalidUserInputException ("Card number input should be 12 digits.");}
		if(postalCodeTextField.getText().length() != 6 && postalCodeTextField.getText().length() != 0) {throw new InvalidUserInputException ("Postal code input should be 6 digits.");}
	}
	
	public void switchtoOrderConfirmation(ActionEvent event) {
		boolean allValidationPassed = true;
		
		User user = new User(); //creating a new instance of an user, using User class
		
		try {
			firstNameErrorLabel.setText(""); //clear text once error is gone
			user.setFirstName(firstNameTextField.getText());			
		} catch (InvalidUserInputException iuie){
			allValidationPassed = false;
			firstNameErrorLabel.setText(iuie.getMessage());
		}
		
		try {
			lastNameErrorLabel.setText(""); //clear text once error is gone
			user.setLastName(lastNameTextField.getText());			
		} catch (InvalidUserInputException iuie){
			allValidationPassed = false;
			lastNameErrorLabel.setText(iuie.getMessage());
		}
		
		try {
			addressErrorLabel.setText(""); //clear text once error is gone
			user.setAddress(addressTextField.getText());			
		} catch (InvalidUserInputException iuie){
			allValidationPassed = false;
			addressErrorLabel.setText(iuie.getMessage());
		}
		
		try {
			phoneNumberErrorLabel.setText(""); //clear text once error is gone
			user.setPhoneNumber(phoneNumberTextField.getText());			
		} catch (InvalidUserInputException iuie){
			allValidationPassed = false;
			phoneNumberErrorLabel.setText(iuie.getMessage());
		}
		
		
		
		try {
			nameErrorLabel.setText(""); //clear text once error is gone
			isUserInputValid(nameOnCardTextField,2);			
		} catch (InvalidUserInputException iuie){
			allValidationPassed = false;
			nameErrorLabel.setText(iuie.getMessage());
		}
		
		try {
			cardNumberErrorLabel.setText(""); //clear text once error is gone
			isUserInputValid(cardNumberTextField,1);			
		} catch (InvalidUserInputException iuie){
			allValidationPassed = false;
			cardNumberErrorLabel.setText(iuie.getMessage());
		}
		
		try {
			expiryMonthErrorLabel.setText(""); //clear text once error is gone
			isUserInputValid(expireMonthTextField,1);			
		} catch (InvalidUserInputException iuie){
			allValidationPassed = false;
			expiryMonthErrorLabel.setText(iuie.getMessage());
		}
		
		try {
			expiryYearErrorLabel.setText(""); //clear text once error is gone
			isUserInputValid(expiryYearTextField,1);			
		} catch (InvalidUserInputException iuie){
			allValidationPassed = false;
			expiryYearErrorLabel.setText(iuie.getMessage());
		}
		
		try {
			postalCodeErrorLabel.setText(""); //clear text once error is gone
			isUserInputValid(postalCodeTextField,3);			
		} catch (InvalidUserInputException iuie){
			allValidationPassed = false;
			postalCodeErrorLabel.setText(iuie.getMessage());
		}
		
		try {
			checkInputLength();
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			lengthErrorLabel.setText(iuie.getMessage());

		}
		
		if (orderConfirmationController == null && allValidationPassed == true) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/Order_Confirmation.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				orderConfirmationController = loader.getController();
				orderConfirmationController.setPrimaryStage(primaryStage);
				orderConfirmationController.setMyScene(scene);
				orderConfirmationController.setNextController(this);
				
				//generate random order number
				//this site was used to learn about the random class, and how it works: https://www.digitalocean.com/community/tutorials/java-random
				String orderNumberAsString = ""; 
				Random randomNumbers = new Random();
				int number = 0;
				for (int i = 0; i < 4; i++) {
					number = randomNumbers.nextInt(10);
					orderNumberAsString = orderNumberAsString + Integer.toString(number);
				}
				orderConfirmationController.setLabelText(orderNumberAsString);
			} catch (IOException e) {
				e.printStackTrace();
			}
			orderConfirmationController.takeFocus();
		}
				
	}
}