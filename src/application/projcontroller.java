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
import javafx.scene.control.ChoiceBox;
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
    private ChoiceBox <String> paymentTypeChoiceBox;
    
    @FXML
    private Label totalPriceLabel;
    
    
    private void setTextFieldVisibility (CheckBox foodChoiceBox, TextField foodType) {
    	
    	if (foodChoiceBox.isSelected()) { //if checkbox is selected, then the textfield appears (assuming it's not visible)
    		if (!foodType.isVisible()) {
    			foodType.setVisible(true); 
    		}
    	}
    	if (!foodChoiceBox.isSelected()) { //if checkbox is unselected by user, visible textfield disappears
    		if (foodType.isVisible()) {
    			foodType.setVisible(false); 
    		}
    		foodType.clear(); //clear any text user may have inputed
    		
    	}
    }
    
    @FXML
    void samosaTextFieldAppears(ActionEvent event) {
       	setTextFieldVisibility(samosaCheckBox,samosaTextField ); 
    }   
      
    @FXML
    void paniPuriTextFieldAppears(ActionEvent event) {
    	setTextFieldVisibility(paniPuriCheckBox,paniPuriTextField );
    }

    @FXML
    void butterChickenTextFieldAppears(ActionEvent event) {
       	setTextFieldVisibility(butterChickenCheckBox,butterChickenTextField );
       	}

    @FXML
    void chefsChoiceTextFieldAppears(ActionEvent event) {   	
       	setTextFieldVisibility(chefsChoiceCheckBox,chefsChoiceTextField );
    }

    @FXML
    void gulabJamunTextFieldAppears(ActionEvent event) {   	
       	setTextFieldVisibility(gulabJamunCheckBox,gulabJamunTextField );
    }

    @FXML
    void brownieTextFieldAppears(ActionEvent event) {
       	setTextFieldVisibility(brownieCheckBox,brownieTextField );
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
		FXMLLoader loader = new FXMLLoader();
		Parent root = loader.load(new FileInputStream("src/application/Order_Menu.fxml"));
		projcontroller controller = (projcontroller)(loader.getController());
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
		/*double priceSamosa = 5.99;
		double pricePaniPuri = 8.99;
		double priceButterChicken = 17.99;
		double priceChefsChoice = 14.99;
		double priceGulabJamun = 6.99;
		double priceBrownie = 4.99;
		double totalPrice = 0.0;
		
		try {
			MenuItem samosa = new MenuItem(controller.samosaTextField.getText(), priceSamosa);
			MenuItem paniPuri = new MenuItem(controller.paniPuriTextField.getText(), pricePaniPuri);
			MenuItem butterChicken = new MenuItem(controller.butterChickenTextField.getText(), priceButterChicken);
			MenuItem chefsChoice = new MenuItem(controller.chefsChoiceTextField.getText(), priceChefsChoice);
			MenuItem gulabJamun = new MenuItem(controller.gulabJamunTextField.getText(), priceGulabJamun);
			MenuItem brownie = new MenuItem(controller.brownieTextField.getText(), priceBrownie);
			
			totalPrice = samosa.calculateItemTotalPrice() + paniPuri.calculateItemTotalPrice() + 
					butterChicken.calculateItemTotalPrice() + chefsChoice.calculateItemTotalPrice() +
					gulabJamun.calculateItemTotalPrice() + brownie.calculateItemTotalPrice();
		} catch (InvalidUserInputException e) {
			e.printStackTrace();
		} 
		//NOTE: this code is not working right now because of the Controller issue. Controller needs to be separated into multiple */
		
	}
	public void switchtoPaymentSummary(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		Parent root = loader.load(new FileInputStream("src/application/Payment Summary.fxml"));
		projcontroller controller = (projcontroller)(loader.getController());
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		
//		String totalPriceAsString = Double.toString(totalPrice); These two lines of code will will not work right now. This is because the commented code in above method does not work. 
//		controller.totalPriceLabel.setText("hello"); 
		
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
