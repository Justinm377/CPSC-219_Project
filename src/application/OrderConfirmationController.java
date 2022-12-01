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
import javafx.stage.Stage;

public class OrderConfirmationController {
	
	private Stage primaryStage;
	private Scene myScene;
	
	private PaymentInfoController paymentInfoController;
	private HomePageController homePageController;
	
	@FXML
    private Label orderNumber;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}

	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}

	public void setNextController(PaymentInfoController next) {
		paymentInfoController = next;
	}

	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	@FXML
	public void switchtoHomePage(ActionEvent event) { 
		if (homePageController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/HomePage.fxml"));
				homePageController = loader.getController();
				homePageController.setPrimaryStage(primaryStage);
				homePageController.setMyScene(new Scene(root));
				homePageController.setNextController2(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		homePageController.takeFocus();
	}
	
	@FXML
	private void setLabelText() {
		//generate random order number
		//this site was used to learn about the random class, and how it works: https://www.digitalocean.com/community/tutorials/java-random
		String orderNumberAsString = ""; 
		Random randomNumbers = new Random();
		int number = 0;
		for (int i = 0; i < 4; i++) {
			number = randomNumbers.nextInt(10);
			orderNumberAsString = orderNumberAsString + Integer.toString(number);
		}
				
		orderNumber.setText(orderNumberAsString); //sets the order number label to randomly generated number
	}

}
