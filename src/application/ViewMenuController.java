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
 * The ViewMenuController switches scenes to home page or order menu page from the view menu page. 
 * @author CS219-user Group 5
 *
 */
public class ViewMenuController {

	private Stage primaryStage;
	private Scene myScene;
	private HomePageController homePageController; 
	private OrderMenuController orderMenuSceneController;

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
	 * Switches the controller from the HomePageController to the ViewMenuController. 
	 * @param next The next controller. 
	 */
	public void setNextController(HomePageController next) {
		homePageController = next;
	}

	/**
	 * Sets the given scene as the primary stage's scene. This displays the given scene to the user utilizing the application.
	 */
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

	/**
	 * Switches scenes from the view menu page to the home page when user decides to return to the home page.
	 * @param event Represents the action of the user pressing the button to return to the home page.
	 */
	@FXML
	public void switchToHomePage(ActionEvent event) {
		if (homePageController != null) {
			homePageController.takeFocus();
		} 
	}

	/**
	 * Switches scenes from the view menu page to the ordering page when user decides to go to the ordering page.
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
				orderMenuSceneController.setNextControllerViewMenu(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		orderMenuSceneController.takeFocus();
	}

}