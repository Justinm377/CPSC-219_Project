package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class projcontroller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchtoHomePage(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoViewMenu(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("View_Menu.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoOrderMenu(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("Order_Menu.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoPaymentSummary(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("Payment Summary.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoPaymentInfo(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("Payment Info.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoOrderComfirmation(ActionEvent event) throws IOException {
		Parent root=FXMLLoader.load(getClass().getResource("Order_Confirmation.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
