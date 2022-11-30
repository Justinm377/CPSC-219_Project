package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomePageController {
	
	private Stage primaryStage;
	private Scene myScene;

	private OrderMenuController orderMenuSceneController;
	
	private Label totalPriceTextField;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}

	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}

	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

	@FXML
	public void switchtoOrderMenu(ActionEvent event) {

		if (orderMenuSceneController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/Order_Menu.fxml"));
				orderMenuSceneController = loader.getController();
				orderMenuSceneController.setPrimaryStage(primaryStage);
				orderMenuSceneController.setMyScene(new Scene(root));
				orderMenuSceneController.setNextController(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
			orderMenuSceneController.takeFocus();
		}
	}

	@FXML
	public void switchtoViewMenu(ActionEvent event) {
	}
}
