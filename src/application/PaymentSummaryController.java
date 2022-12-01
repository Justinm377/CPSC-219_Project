package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PaymentSummaryController {


	private Stage primaryStage;
	private Scene myScene;
	private OrderMenuController orderMenuSceneController; 
	
	@FXML
	private Label totalPriceTextField;
	
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
	public void switchtoOrderMenu(ActionEvent event) throws IOException { 
		if (orderMenuSceneController != null) {
			orderMenuSceneController.takeFocus();
		} 
	}
	
	@FXML
	public void switchtoPaymentInfo(ActionEvent event) {}

	public void setTotalPrice(double price) {
		totalPrice = price;
		totalPriceTextField.setText(String.format("%.2f", totalPrice));
	}
	
}
