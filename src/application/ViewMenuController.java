package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewMenuController {

	private Stage primaryStage;
	private Scene myScene;
	private HomePageController homePageController; 
	private OrderMenuController orderMenuSceneController;
	
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}

	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}
	
	public void setNextController(HomePageController next) {
		homePageController = next;
	}

	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	@FXML
	public void switchtoHomePage(ActionEvent event) {
		if (homePageController != null) {
			homePageController.takeFocus();
		} 
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
				orderMenuSceneController.setNextController2(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		orderMenuSceneController.takeFocus();
	}

}
