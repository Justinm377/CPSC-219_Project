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

	//	public boolean isHabitated(TextField userInfo) {
	//		boolean empty = true;
	//		if ( userInfo.getText() == "") {
	//			empty = false;
	//		}
	//	return empty;
	//	}


	public String isAlphabeticValidation (TextField stringInputToValidate ) throws InvalidUserInputException {
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

	public void switchtoOrderConfirmation(ActionEvent event) {
		boolean allValidationPassed = true;

		try {
			firstNameErrorLabel.setText(""); //clear text once error is gone
			isAlphabeticValidation(firstNameTextField);			
		}catch (InvalidUserInputException IUIE){
			allValidationPassed = false;
			firstNameErrorLabel.setText(IUIE.getMessage());
		}		
		try {
			lastNameErrorLabel.setText(""); //clear text once error is gone
			isAlphabeticValidation(lastNameTextField);			
		}catch (InvalidUserInputException IUIE){
			allValidationPassed = false;
			lastNameErrorLabel.setText(IUIE.getMessage());
		}
		try {
			phoneNumberErrorLabel.setText(""); //clear text once error is gone
			isNumeric(phoneNumberTextField);			
		}catch (InvalidUserInputException IUIE){
			allValidationPassed = false;
			phoneNumberErrorLabel.setText(IUIE.getMessage());
		}
		try {
			nameErrorLabel.setText(""); //clear text once error is gone
			isAlphabeticValidation(nameOnCardTextField);			
		}catch (InvalidUserInputException IUIE){
			allValidationPassed = false;
			nameErrorLabel.setText(IUIE.getMessage());
		}		
		try {
			cardNumberErrorLabel.setText(""); //clear text once error is gone
			isNumeric(cardNumberTextField);			
		}catch (InvalidUserInputException IUIE){
			allValidationPassed = false;
			cardNumberErrorLabel.setText(IUIE.getMessage());
		}
		try {
			expiryMonthErrorLabel.setText(""); //clear text once error is gone
			isNumeric(expireMonthTextField);			
		}catch (InvalidUserInputException IUIE){
			allValidationPassed = false;
			expiryMonthErrorLabel.setText(IUIE.getMessage());
		}
		try {
			expiryYearErrorLabel.setText(""); //clear text once error is gone
			isNumeric(expiryYearTextField);			
		}catch (InvalidUserInputException IUIE){
			allValidationPassed = false;
			expiryYearErrorLabel.setText(IUIE.getMessage());
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