package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaymentInfoController {
	
	private Stage primaryStage;
	private Scene myScene;
	
	private OrderConfirmationController orderConfirmationController;
	
	
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
	
	public void switchtoOrderConfirmation(ActionEvent event) {
		if (orderConfirmationController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/Order_Confirmation.fxml"));
				orderConfirmationController = loader.getController();
				orderConfirmationController.setPrimaryStage(primaryStage);
				orderConfirmationController.setMyScene(new Scene(root));
				orderConfirmationController.setNextController(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
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
		
		orderConfirmationController.takeFocus();
	}
}
