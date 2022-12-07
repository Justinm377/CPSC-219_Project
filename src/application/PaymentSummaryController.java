package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * The PaymentSummaryController switches scenes from the payment summary page to the ordering page or to the payment info page. It
 * also sets the total price and total price with tax labels and validates the payment type selection for the user. 
 * @author CS219-user
 *
 */
public class PaymentSummaryController {

	private Stage primaryStage;
	private Scene myScene;
	private OrderMenuController orderMenuSceneController; 
	private PaymentInfoController paymentInfoController;

	@FXML
	private Label totalPriceLabel;
	@FXML
	private Label totalPriceWithTaxLabel;
	@FXML
	private ChoiceBox<String> paymentTypeChoiceBox;
	@FXML
	private Label errorLabelPaymentType;

	/**
	 *  Sets the given stage as the primary stage of the application. 
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
	 * Switches the controller from the OrderMenuController to the PaymentSummaryController.
	 * @param next The next controller. 
	 */
	public void setNextController(OrderMenuController next) {
		orderMenuSceneController = next;
	}

	/**
	 * Sets the given scene as the primary stage's scene. This displays the given scene to the user utilizing the application.
	 */
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

	/**
	 * Sets the total price label with the user's order's total price.
	 * @param totalPrice The total price of the user's order. 
	 */
	public void setTotalPrice(double totalPrice) {
		totalPriceLabel.setText(String.format("%.2f", totalPrice)); //getting total price from user's order menu and setting the label with the total price
	}

	/**
	 * Sets the total price with tax label with the user's order's total price with tax.
	 * @param totalPriceWithTax The total price with tax of the user's order. 
	 */
	public void setTotalPriceWithTax(double totalPriceWithTax) {
		totalPriceWithTaxLabel.setText(String.format("%.2f", totalPriceWithTax)); //getting the total price with tax from the user's order menu and setting the label to that value
	}

	/**
	 * Switches scenes from the payment summary page to the ordering page when user decides to go to the ordering page.
	 * @param event Represents the action of the user pressing the button to go to the ordering page. 
	 */
	@FXML
	public void switchToOrderMenu(ActionEvent event) { 
		if (orderMenuSceneController != null) {
			orderMenuSceneController.takeFocus();
		} 
	}

	/**
	 * Switches scenes from the payment summary page to the payment information page when user decides to pay. 
	 * @param event Represents the action of the user pressing the button to go to the payment information page. 
	 */
	@FXML
	public void switchToPaymentInfo(ActionEvent event) {
		if (paymentTypeChoiceBox.getValue() != null) { //checking to see that user has selected a payment type
			if (paymentInfoController == null) {
				try {
					FXMLLoader loader = new FXMLLoader();
					Parent root = loader.load(new FileInputStream("src/application/Payment Info.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					paymentInfoController = loader.getController();
					paymentInfoController.setPrimaryStage(primaryStage);
					paymentInfoController.setMyScene(scene);
					paymentInfoController.setNextController(this);
					errorLabelPaymentType.setText(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			paymentInfoController.takeFocus();
		} else {
			errorLabelPaymentType.setText("Please select a type of payment."); //if user doesn't select a payment type, error message will be displayed
		}
	}
}