package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The Main class is used to start the application, with the home page being the first page displayed
 * to the user. 
 * @author CS219-user Group 5
 *
 */
public class Main extends Application {

	/**
	 * Starts the application by setting the first scene of the application's home page on the
	 * primary stage and sets its title to "Taste of India - Food Ordering App". 
	 * @param primaryStage The stage where the scene is set. 
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(new FileInputStream("src/application/HomePage.fxml"));
			Scene scene = new Scene(root,626,317);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			HomePageController controller = (HomePageController)loader.getController();
			controller.setMyScene(scene);
			controller.setPrimaryStage(primaryStage);

			primaryStage.setTitle("Taste of India - Food Ordering App");
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
