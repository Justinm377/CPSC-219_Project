package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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

public class OrderMenuController {

	private Stage primaryStage;
	private Scene myScene;
	private HomePageController homePageController; 
	private PaymentSummaryController paymentController;
	private ViewMenuController viewMenuController;
	
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
    private CheckBox drink1CheckBox;
    @FXML
    private TextField drink1TextField;
    @FXML
    private ChoiceBox drink1ChoiceBox;
    @FXML
    private CheckBox drink2CheckBox;
    @FXML
    private TextField drink2TextField;
    @FXML
    private ChoiceBox drink2ChoiceBox;
    
    @FXML
    private Label inputErrorLabel;

	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}

	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}

	public void setNextController(HomePageController next) {
		homePageController = next;
	}
	
	public void setNextController2(ViewMenuController next) {
		viewMenuController = next;
	}

	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

	@FXML
	public void switchtoHomePage(ActionEvent event) {
		if (homePageController == null) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/HomePage.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				homePageController = loader.getController();
				homePageController.setPrimaryStage(primaryStage);
				homePageController.setMyScene(scene);
				homePageController.setNextController(this);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		homePageController.takeFocus();
	}
	
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
		setTextFieldVisibility(samosaCheckBox,samosaTextField); 
	}   
	      
	@FXML
	void paniPuriTextFieldAppears(ActionEvent event) {
		setTextFieldVisibility(paniPuriCheckBox,paniPuriTextField);
	}

	@FXML
	void butterChickenTextFieldAppears(ActionEvent event) {
		setTextFieldVisibility(butterChickenCheckBox,butterChickenTextField);
	}

	@FXML
	void chefsChoiceTextFieldAppears(ActionEvent event) {   	
		setTextFieldVisibility(chefsChoiceCheckBox,chefsChoiceTextField);
	}

	@FXML
	void gulabJamunTextFieldAppears(ActionEvent event) {   	
		setTextFieldVisibility(gulabJamunCheckBox,gulabJamunTextField);
	}

	@FXML
	void brownieTextFieldAppears(ActionEvent event) {
		setTextFieldVisibility(brownieCheckBox,brownieTextField);
	}
	
	@FXML
	void drink1TextFieldAppears(ActionEvent event) {
		setTextFieldVisibility(drink1CheckBox,drink1TextField);
	}
	
	@FXML
	void drink2TextFieldAppears(ActionEvent event) {
		setTextFieldVisibility(drink2CheckBox,drink2TextField);
	}
	
	@FXML  
	public void switchtoPaymentSummary(ActionEvent event) {
		boolean errorPresent = false;
		
		double priceSamosa = 5.99;
		double pricePaniPuri = 8.99;
		double priceButterChicken = 17.99;
		double priceChefsChoice = 14.99;
		double priceGulabJamun = 6.99;
		double priceBrownie = 4.99;
		
		ArrayList<MenuItem> foodItemList = new ArrayList<MenuItem>();
		ArrayList<Drinks> drinksItemList = new ArrayList<Drinks>();
		
		try {
			MenuItem samosa = new MenuItem(samosaTextField.getText(), priceSamosa);
			MenuItem paniPuri = new MenuItem(paniPuriTextField.getText(), pricePaniPuri);
			MenuItem butterChicken = new MenuItem(butterChickenTextField.getText(), priceButterChicken);
			MenuItem chefsChoice = new MenuItem(chefsChoiceTextField.getText(), priceChefsChoice);
			MenuItem gulabJamun = new MenuItem(gulabJamunTextField.getText(), priceGulabJamun);
			MenuItem brownie = new MenuItem(brownieTextField.getText(), priceBrownie);
			
			Drinks drink1 = new Drinks(drink1ChoiceBox.getValue().toString(), drink1TextField.getText());
			Drinks drink2 = new Drinks(drink2ChoiceBox.getValue().toString(), drink2TextField.getText());
			
			foodItemList.add(samosa);
			foodItemList.add(paniPuri);
			foodItemList.add(butterChicken);
			foodItemList.add(chefsChoice);
			foodItemList.add(gulabJamun);
			foodItemList.add(brownie);
			
			drinksItemList.add(drink1);
			drinksItemList.add(drink2);
		} catch (InvalidUserInputException iuie) {
			inputErrorLabel.setText(iuie.getMessage());
			errorPresent = true;			
		}
		
		if (errorPresent == false) {
			try {
				FXMLLoader loader = new FXMLLoader();
				Parent root = loader.load(new FileInputStream("src/application/Payment Summary.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				paymentController = loader.getController();
				paymentController.setPrimaryStage(primaryStage);
				paymentController.setMyScene(scene);
				paymentController.setNextController(this);	
				inputErrorLabel.setText(""); //clears error label text
				Order finalPrice = new Order(foodItemList, drinksItemList); //created TotalPrice object to contain all the MenuItems 
				paymentController.setTotalPrice(finalPrice.calculateTotalPrice()); //sharing that information to the PaymentSummaryController		
				} catch (IOException e) {
					e.printStackTrace();
				}
				paymentController.takeFocus();
			}
		
	}
}