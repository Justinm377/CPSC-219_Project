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
	private Label totalPriceTextField;
	
	@FXML
	private ChoiceBox paymentTypeChoiceBox;
	
	@FXML
	private Label errorLabelChoicebox;
	
	
	private double totalPrice;
	
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

	@FXML
	public void switchtoOrderMenu(ActionEvent event) { 
		if (orderMenuSceneController != null) {
			orderMenuSceneController.takeFocus();
		} 
	}
	
	@FXML
	public void switchtoPaymentInfo(ActionEvent event) {
		
//		try {
//			PaymentInfoValidation firstName = new PaymentInfoValidation()}catch
		if ( paymentTypeChoiceBox.getValue() != null) {
			if (paymentInfoController == null) {
				try {
					FXMLLoader loader = new FXMLLoader();
					Parent root = loader.load(new FileInputStream("src/application/Payment Info.fxml"));
					paymentInfoController = loader.getController();
					paymentInfoController.setPrimaryStage(primaryStage);
					paymentInfoController.setMyScene(new Scene(root));
					paymentInfoController.setNextController(this);
					errorLabelChoicebox.setText(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			paymentInfoController.takeFocus();
		} else {
			errorLabelChoicebox.setText("Please select a type of payment.");
		}
		
	}

	public void setTotalPrice(double price) {
		totalPrice = price;
		totalPriceTextField.setText(String.format("%.2f", totalPrice));
	}
	
}