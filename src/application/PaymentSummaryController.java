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
	private Label errorLabelChoiceBox;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}

	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}

	public void setNextController(OrderMenuController next) {
		orderMenuSceneController = next;
	}

	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	public void setTotalPrice(double totalPrice) {
		totalPriceLabel.setText(String.format("%.2f", totalPrice)); //getting total price from user's order menu and setting the label with the total price
	}
	
	public void setTotalPriceWithTax(double totalPriceWithTax) {
		totalPriceWithTaxLabel.setText(String.format("%.2f", totalPriceWithTax)); //getting the total price with tax from the user's order menu and setting the label to that value
	}

	@FXML
	public void switchtoOrderMenu(ActionEvent event) { 
		if (orderMenuSceneController != null) {
			orderMenuSceneController.takeFocus();
		} 
	}
	
	@FXML
	public void switchtoPaymentInfo(ActionEvent event) {
		
		if (paymentTypeChoiceBox.getValue() != null) {
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
					errorLabelChoiceBox.setText(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			paymentInfoController.takeFocus();
		} else {
			errorLabelChoiceBox.setText("Please select a type of payment."); //if user doesn't select a payment type, error message will be displayed
		}
	}
}