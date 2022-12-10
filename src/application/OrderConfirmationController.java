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

/**
 * The OrderConfirmationController switches scenes from the order confirmation page to the home page. 
 * The order number is set when the order confirmation page is opened. 
 * @author CS219-user Group 5
 *
 */
public class OrderConfirmationController {

	private Stage primaryStage;
	private Scene myScene;
	private PaymentInfoController paymentInfoController;
	private HomePageController homePageController;

	@FXML
	private Label orderNumber;

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
	 * Switches the controller from the PaymentInfoController to the OrderConfirmationController. 
	 * @param next The next controller. 
	 */
	public void setNextController(PaymentInfoController next) {
		paymentInfoController = next;
	}

	/**
	 * Sets the given scene as the primary stage's scene. This displays the given scene to the user 
	 * utilizing the application.
	 */
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

	/**
	 * Sets the order number label as the randomly generated number.
	 * @param randomNumber The random number to set as the order number. 
	 */
	public void setOrderNumber(String randomNumber) {
		orderNumber.setText(randomNumber); 
	}

	/**
	 * Switches scenes from the order confirmation page to the home page, when user decides to go to the home page.
	 * @param event Represents the action of the user pressing the button to return to the home page. 
	 */
	@FXML
	public void switchToHomePage(ActionEvent event) { 
		if (homePageController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/HomePage.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				homePageController = loader.getController();
				homePageController.setPrimaryStage(primaryStage);
				homePageController.setMyScene(scene);
				homePageController.setNextControllerOrderConfirmation(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		homePageController.takeFocus();
	}

}