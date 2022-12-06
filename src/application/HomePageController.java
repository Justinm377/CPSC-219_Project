package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomePageController {

	private Stage primaryStage;
	private Scene myScene;

	private OrderMenuController orderMenuSceneController;
	private ViewMenuController viewMenuController;
	private OrderConfirmationController orderConfirmationController;


	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}

	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}

	public void takeFocus() {
		primaryStage.setScene(myScene);
	}
	
	public void setNextController(OrderMenuController next) {
		orderMenuSceneController = next;
	}

	public void setNextController2(OrderConfirmationController next) {
		orderConfirmationController = next;
	}
	
	@FXML
	public void switchtoViewMenu(ActionEvent event) {
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

	@FXML
	public void switchtoOrderMenu(ActionEvent event) {
		if (orderMenuSceneController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/Order_Menu.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				orderMenuSceneController = loader.getController();
				orderMenuSceneController.setPrimaryStage(primaryStage);
				orderMenuSceneController.setMyScene(scene);
				orderMenuSceneController.setNextController(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		orderMenuSceneController.takeFocus();
	}

}