package application;

import java.io.FileInputStream;
import java.io.IOException;

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
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				homePageController = loader.getController();
				homePageController.setPrimaryStage(primaryStage);
				homePageController.setMyScene(scene);
				homePageController.setNextController2(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		homePageController.takeFocus();
	}

	public void setLabelText(String randomNum) {
		String num = randomNum;
		orderNumber.setText(num); //sets the order number label to randomly generated number
	}

}