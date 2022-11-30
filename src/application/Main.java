package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			Parent root = loader.load(new FileInputStream("src/application/HomePage.fxml"));
			Scene scene = new Scene(root,347,350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			HomePageController controller = (HomePageController)loader.getController();
			controller.setMyScene(scene);
			//ontroller.applicationStage = primaryStage;

			primaryStage.setTitle("Taste of India - Food Ordering App");
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		launch(args);		
	}
}
