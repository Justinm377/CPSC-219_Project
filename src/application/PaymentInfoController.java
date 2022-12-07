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

/**
 * The PaymentInfoController switches scenes from the payment information page to the order confirmation page, provided that user 
 * input for personal information and payment information is valid. 
 * @author CS219-user Group 5
 *
 */
public class PaymentInfoController {

	private Stage primaryStage;
	private Scene myScene;
	private OrderConfirmationController orderConfirmationController;
	private PaymentSummaryController paymentSummaryController;

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
	private TextField expiryMonthTextField;
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
	@FXML
	private TextField cvvTextField;
	@FXML
	private Label cvvErrorLabel;

	/**
	 * Sets the given stage as the primary stage of the application.
	 * @param aStage The stage to be set as the application's primary stage.
	 */
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}

	/**
	 * Sets the given scene as the controller's scene.
	 * @param aScene The scene intended to be displayed to the user.
	 */
	public void setMyScene(Scene aScene) { 
		myScene = aScene;
	}

	/**
	 * Switches the controller from the PaymentSummaryController to the PaymentInfoController. 
	 * @param next The next controller. 
	 */
	public void setNextController(PaymentSummaryController next) {
		paymentSummaryController = next;
	}

	/**
	 * Sets the given scene as the primary stage's scene. This displays the given scene to the user utilizing the application.
	 */
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

	/**
	 * Switches scenes from the payment information page to the order confirmation page.
	 * @param event Represents the action of the user pressing the submit button in the payment information page. 
	 */
	@FXML
	public void switchToOrderConfirmation(ActionEvent event) {
		boolean allValidationPassed = true;

		//creating a new instance of an user, using User class
		User user = new User();

		//attempting to set personal user information (first name, last name, address, phone number) based on user input
		//and if input is invalid, a proper error message will be displayed to the user
		try {
			firstNameErrorLabel.setText(""); //clear text once error is gone
			user.setFirstName(firstNameTextField.getText());			
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			firstNameErrorLabel.setText(iuie.getMessage());
		}

		try {
			lastNameErrorLabel.setText(""); //clear text once error is gone
			user.setLastName(lastNameTextField.getText());			
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			lastNameErrorLabel.setText(iuie.getMessage());
		}

		try {
			addressErrorLabel.setText(""); //clear text once error is gone
			user.setAddress(addressTextField.getText());			
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			addressErrorLabel.setText(iuie.getMessage());
		}

		try {
			postalCodeErrorLabel.setText(""); //clear text once error is gone
			user.setPostalCode(postalCodeTextField.getText());			
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			postalCodeErrorLabel.setText(iuie.getMessage());
		}

		try {
			phoneNumberErrorLabel.setText(""); //clear text once error is gone
			user.setPhoneNumber(phoneNumberTextField.getText());			
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			phoneNumberErrorLabel.setText(iuie.getMessage());
		}

		//creating the user's credit or debit card
		Card userPaymentCard = new Card();

		//attempting to set user's card name, card number, expiry date, and cvv in their Card. if invalid input is detected,
		// user is displayed an appropriate error message. 
		try {
			nameErrorLabel.setText(""); //clear text once error is gone
			userPaymentCard.setCardName(nameOnCardTextField.getText());			
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			nameErrorLabel.setText(iuie.getMessage());
		}

		try {
			cardNumberErrorLabel.setText(""); //clear text once error is gone
			userPaymentCard.setCardNumber(cardNumberTextField.getText());			
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			cardNumberErrorLabel.setText(iuie.getMessage());
		}

		try {
			expiryMonthErrorLabel.setText(""); //clear text once error is gone
			userPaymentCard.setExpiryMonth(expiryMonthTextField.getText());
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			expiryMonthErrorLabel.setText(iuie.getMessage());
		}

		try {
			expiryYearErrorLabel.setText(""); //clear text once error is gone
			userPaymentCard.setExpiryYear(expiryYearTextField.getText());			
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			expiryYearErrorLabel.setText(iuie.getMessage());
		}
		
		try { //checking that if user enters year 22, month is not before 12. if it is, error message is displayed to user. 
			expiryMonthErrorLabel.setText("");
			userPaymentCard.checkIfExpiryDateIsValid(expiryMonthTextField.getText(), expiryYearTextField.getText());
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			expiryMonthErrorLabel.setText(iuie.getMessage());
		}

		try {
			cvvErrorLabel.setText(""); //clear text once error is gone
			userPaymentCard.setCVV(cvvTextField.getText());			
		} catch (InvalidUserInputException iuie) {
			allValidationPassed = false;
			cvvErrorLabel.setText(iuie.getMessage());
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
				orderConfirmationController.setLabelText(orderNumberAsString); //set order number as this number
			} catch (IOException e) {
				e.printStackTrace();
			}
			orderConfirmationController.takeFocus();
		}

	}
}