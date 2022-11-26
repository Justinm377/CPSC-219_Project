package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.*;

public class projcontroller {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
    private Label orderNumber;
	
	@FXML
    private TextField samosaTextField;
    @FXML
    private CheckBox samosaCheckBox;
    
    @FXML
    private TextField paniPuriTextField;
    @FXML
    private CheckBox paniPuriCheckBox;
    
    @FXML
    private TextField butterChickenTextField;
    @FXML
    private CheckBox butterChickenCheckBox;
    
    @FXML
    private TextField chefsChoiceTextField;
    @FXML
    private CheckBox chefsChoiceCheckBox;
    
    @FXML
    private TextField gulabJamunTextField;
    @FXML
    private CheckBox gulabJamunCheckBox;
    
    @FXML
    private TextField brownieTextField;
    @FXML
    private CheckBox brownieCheckBox;

    @FXML
    void samosaTextFieldAppears(ActionEvent event) {
    	if (samosaCheckBox.isSelected()) { //if checkbox is selected, then the textfield appears (assuming it's not visible)
    		if (!samosaTextField.isVisible()) {
    			samosaTextField.setVisible(true); 
    		}
    	}
    	if (!samosaCheckBox.isSelected()) { //if checkbox is unselected by user, visible textfield disappears
    		if (samosaTextField.isVisible()) {
    			samosaTextField.setVisible(false); 
    		}
    		samosaTextField.clear(); //clear any text user may have inputed
    	}
    }
    
    @FXML
    void paniPuriTextFieldAppears(ActionEvent event) {
    	if (paniPuriCheckBox.isSelected()) { //if checkbox is selected, then the textfield appears (assuming it's not visible)
    		if (!paniPuriTextField.isVisible()) {
    			paniPuriTextField.setVisible(true); 
    		}
    	}
    	if (!paniPuriCheckBox.isSelected()) { //if checkbox is unselected by user, visible textfield disappears
    		if (paniPuriTextField.isVisible()) {
    			paniPuriTextField.setVisible(false); 
    		}
    		paniPuriTextField.clear(); //clear any text user may have inputed
    	}
    }

    @FXML
    void butterChickenTextFieldAppears(ActionEvent event) {
    	if (butterChickenCheckBox.isSelected()) { //if checkbox is selected, then the textfield appears (assuming it's not visible)
    		if (!butterChickenTextField.isVisible()) {
    			butterChickenTextField.setVisible(true); 
    		}
    	}
    	if (!butterChickenCheckBox.isSelected()) { //if checkbox is unselected by user, visible textfield disappears
    		if (butterChickenTextField.isVisible()) {
    			butterChickenTextField.setVisible(false); 
    		}
    		butterChickenTextField.clear(); //clear any text user may have inputed
    	}
    }

    @FXML
    void chefsChoiceTextFieldAppears(ActionEvent event) {
    	if (chefsChoiceCheckBox.isSelected()) { //if checkbox is selected, then the textfield appears (assuming it's not visible)
    		if (!chefsChoiceTextField.isVisible()) {
    			chefsChoiceTextField.setVisible(true); 
    		}
    	}
    	if (!chefsChoiceCheckBox.isSelected()) { //if checkbox is unselected by user, visible textfield disappears
    		if (chefsChoiceTextField.isVisible()) {
    			chefsChoiceTextField.setVisible(false); 
    		}
    		chefsChoiceTextField.clear(); //clear any text user may have inputed
    	}
    }

    @FXML
    void gulabJamunTextFieldAppears(ActionEvent event) {
    	if (gulabJamunCheckBox.isSelected()) { //if checkbox is selected, then the textfield appears (assuming it's not visible)
    		if (!gulabJamunTextField.isVisible()) {
    			gulabJamunTextField.setVisible(true); 
    		}
    	}
    	if (!gulabJamunCheckBox.isSelected()) { //if checkbox is unselected by user, visible textfield disappears
    		if (gulabJamunTextField.isVisible()) {
    			gulabJamunTextField.setVisible(false); 
    		}
    		gulabJamunTextField.clear(); //clear any text user may have inputed
    	}
    }

    @FXML
    void brownieTextFieldAppears(ActionEvent event) {
    	if (brownieCheckBox.isSelected()) { //if checkbox is selected, then the textfield appears (assuming it's not visible)
    		if (!brownieTextField.isVisible()) {
    			brownieTextField.setVisible(true); 
    		}
    	}
    	if (!brownieCheckBox.isSelected()) { //if checkbox is unselected by user, visible textfield disappears
    		if (brownieTextField.isVisible()) {
    			brownieTextField.setVisible(false); 
    		}
    		brownieTextField.clear(); //clear any text user may have inputed
    	}
    }
	
	public void switchtoHomePage(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchtoViewMenu(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("View_Menu.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoOrderMenu(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("Order_Menu.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoPaymentSummary(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("Payment Summary.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoPaymentInfo(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("Payment Info.fxml"));
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	public void switchtoOrderComfirmation(ActionEvent event) throws IOException {	
		FXMLLoader loader = new FXMLLoader();
		Parent root = loader.load(new FileInputStream("src/application/Order_Confirmation.fxml"));
		projcontroller controller = (projcontroller)(loader.getController());
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
		//generate random order number
		//this site was used to learn about the random class, and how it works: https://www.digitalocean.com/community/tutorials/java-random
		String orderNumberAsString = ""; 
		Random randomNumbers = new Random();
		int number = 0;
		for (int i = 0; i < 4; i++) {
			number = randomNumbers.nextInt(10);
			orderNumberAsString = orderNumberAsString + Integer.toString(number);
		}
		
		controller.orderNumber.setText(orderNumberAsString); //sets the order number label to randomly generated number
	}
}
