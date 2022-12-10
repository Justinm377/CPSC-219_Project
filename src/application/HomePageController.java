package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The HomePageController switches scenes from the home page to the view menu page or order menu page. 
 * @author CS219-user Group 5 
 *
 */
public class HomePageController {

	private Stage primaryStage;
	private Scene myScene;
	private OrderMenuController orderMenuSceneController;
	private ViewMenuController viewMenuController;
	private OrderConfirmationController orderConfirmationController;

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
	 * Switches the controller from the OrderMenuController to the HomePageController.
	 * @param next The next controller. 
	 */
	public void setNextControllerOrderMenu(OrderMenuController next) {
		orderMenuSceneController = next;
	}

	/**
	 * Switches the controller from the OrderConfirmationController to the HomePageController.
	 * @param next The next controller.
	 */
	public void setNextControllerOrderConfirmation(OrderConfirmationController next) {
		orderConfirmationController = next;
	}

	/**
	 * Sets the given scene as the primary stage's scene. This displays the given scene to the user utilizing the application.
	 */
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

	/**
	 * Switches scenes from home page scene to view menu scene when user decides to view the menu. 
	 * @param event Represents the action of the user pressing the button to view the menu. 
	 */
	@FXML
	public void switchToViewMenu(ActionEvent event) {
		if (viewMenuController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/View_Menu.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				viewMenuController = loader.getController();
				viewMenuController.setPrimaryStage(primaryStage);
				viewMenuController.setMyScene(scene);
				viewMenuController.setNextController(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		viewMenuController.takeFocus();
	}

	/**
	 * Switches scenes from the home page scene to order menu scene when user decides to go to the ordering page.
	 * @param event Represents the action of the user pressing the button to go to the ordering page.
	 */
	@FXML
	public void switchToOrderMenu(ActionEvent event) {
		if (orderMenuSceneController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/Order_Menu.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				orderMenuSceneController = loader.getController();
				orderMenuSceneController.setPrimaryStage(primaryStage);
				orderMenuSceneController.setMyScene(scene);
				orderMenuSceneController.setNextControllerHomePage(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		orderMenuSceneController.takeFocus();
	}

}