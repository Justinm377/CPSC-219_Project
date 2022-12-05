package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
	private CheckBox drink1CBsmall;
	@FXML
	private CheckBox drink1CBmed;
	@FXML
	private CheckBox drink1CBlarge;
	@FXML
	private CheckBox drink2CBsmall;
	@FXML
	private CheckBox drink2CBmed;
	@FXML
	private CheckBox drink2CBlarge;

	@FXML
	private CheckBox drink2CheckBox;

	@FXML
	private TextField drink2TextFieldSmall;
	@FXML
	private TextField drink2TextFieldMed;
	@FXML
	private TextField drink2TextFieldLarge;
	@FXML
	private TextField drink1TextFieldSmall;
	@FXML
	private TextField drink1TextFieldMed;
	@FXML
	private TextField drink1TextFieldLarge;

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
			foodType.clear();
			//clear any text user may have inputed
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
	void drink1RadioButtonAppearsForDrinks(ActionEvent event) {
		if(drink1CheckBox.isSelected()) {
			setTextFieldVisibility(drink1CBsmall, drink1TextFieldSmall);
			setTextFieldVisibility(drink1CBmed, drink1TextFieldMed);
			setTextFieldVisibility(drink1CBlarge, drink1TextFieldLarge);
		}

	}

	@FXML
	void drink2RadioButtonAppearsForDrinks(ActionEvent event) {
		if(drink2CheckBox.isSelected()) {
			setTextFieldVisibility(drink2CBsmall, drink2TextFieldSmall);
			setTextFieldVisibility(drink2CBmed, drink2TextFieldMed);
			setTextFieldVisibility(drink2CBlarge, drink2TextFieldLarge);
		}

	}


	/**
	 * This method checks if any of the check boxes are selected and throws an exception if no check boxes are selected.
	 * @throws InvalidUserInputException if no check boxes are selected.
	 */
	public void ifAnySelected() throws InvalidUserInputException {
		// checks if any of the menu check boxes are selected.
		if (samosaCheckBox.isSelected() == false && paniPuriCheckBox.isSelected() == false && butterChickenCheckBox.isSelected()==false
				&& chefsChoiceCheckBox.isSelected() == false && gulabJamunCheckBox.isSelected()==false && brownieCheckBox.isSelected()==false
				&& drink1CheckBox.isSelected() == false && drink2CheckBox.isSelected() == false) {
			throw new InvalidUserInputException ("Please select at least one item to continue.");
		}		 
	}

	/**
	 * This method checks if the user has selected a check box and has input a value in the quantity text field.
	 * if there is no input and the check box is selected it throws an InvalidUserInputException
	 * @param itemSelected takes the check box for the menu item
	 * @param inputQuantity takes the user input in the quantity text field for the corresponding check box ( menu item)
	 * @throws InvalidUserInputException when user selects a check box and does not enter any input.
	 */
	public  void ifItemIsSelected(CheckBox itemSelected, TextField inputQuantity) throws InvalidUserInputException{
		// if the check box is selected and the corresponding quantity text field 
		if (itemSelected.isSelected() == true && inputQuantity.getText() == "") throw new InvalidUserInputException ("Please input a quantity."); 
	}

	@FXML  
	public void switchtoPaymentSummary(ActionEvent event) {
		boolean errorPresent = false; //no errors present in user input

		//setting the price of each menu item 
		double priceSamosa = 5.99;
		double pricePaniPuri = 8.99;
		double priceButterChicken = 17.99;
		double priceChefsChoice = 14.99;
		double priceGulabJamun = 6.99;
		double priceBrownie = 4.99;

		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>(); //list of MenuItems (appetizer, main course, dessert)
		ArrayList<Drinks> drinksItemList = new ArrayList<Drinks>(); //list of Drinks

		try {	
			//creating MenuItem objects for each menu item 
			MenuItem samosa = new MenuItem(samosaTextField.getText(), priceSamosa);			
			MenuItem paniPuri = new MenuItem(paniPuriTextField.getText(), pricePaniPuri);
			MenuItem butterChicken = new MenuItem(butterChickenTextField.getText(), priceButterChicken);
			MenuItem chefsChoice = new MenuItem(chefsChoiceTextField.getText(), priceChefsChoice);
			MenuItem gulabJamun = new MenuItem(gulabJamunTextField.getText(), priceGulabJamun);
			MenuItem brownie = new MenuItem(brownieTextField.getText(), priceBrownie);

			//creating Drinks objects for each drink item
			Drinks drink1small = new Drinks("Small",drink1TextFieldSmall.getText());

			Drinks drink1med = new Drinks("Medium",drink1TextFieldMed.getText());

			Drinks drink1large = new Drinks("Large",drink1TextFieldLarge.getText());


			Drinks drink2small = new Drinks("Small",(String)drink1TextFieldSmall.getText());

			Drinks drink2med = new Drinks("Medium",(String)drink2TextFieldMed.getText());

			Drinks drink2large = new Drinks("Large",(String)drink2TextFieldLarge.getText());


			//adding all the menu items to the list
			menuItemList.add(samosa);
			menuItemList.add(paniPuri);
			menuItemList.add(butterChicken);
			menuItemList.add(chefsChoice);
			menuItemList.add(gulabJamun);
			menuItemList.add(brownie);

			//adding all the drinks to the list
			drinksItemList.add(drink1small);
			drinksItemList.add(drink2small);
			drinksItemList.add(drink1med);
			drinksItemList.add(drink2med);
			drinksItemList.add(drink1large);
			drinksItemList.add(drink2large);
		} catch (InvalidUserInputException iuie) {
			inputErrorLabel.setText(iuie.getMessage()); //if exception is caught because of invalid user input, an appropriate error message will be displayed
			errorPresent = true; //errors are present in user input			
		}catch (NullPointerException npe) {

		}

		try {
			//checks if any of the check boxes are selected
			ifAnySelected();
			// checks if the check box is selected and the 
			ifItemIsSelected(samosaCheckBox,samosaTextField);	
			ifItemIsSelected(paniPuriCheckBox,paniPuriTextField);	
			ifItemIsSelected(butterChickenCheckBox,butterChickenTextField);	
			ifItemIsSelected(chefsChoiceCheckBox,chefsChoiceTextField);	
			ifItemIsSelected(gulabJamunCheckBox,gulabJamunTextField);	
			ifItemIsSelected(brownieCheckBox,brownieTextField);	
		} catch (InvalidUserInputException iuie) {
			errorPresent = true; // indicates errors are present in user input
			inputErrorLabel.setText(iuie.getMessage()); // sets the error label to whatever exception is thrown
		}

		if (errorPresent == false) { // if there is no error message it will allow the button to take the user to the next scene.
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
				Order finalPrice = new Order(menuItemList, drinksItemList); //created TotalPrice object to contain all the MenuItems and Drinks
				paymentController.setTotalPrice(finalPrice.calculateTotalPrice()); //sharing the total price information to the PaymentSummaryController		
				paymentController.setTotalPriceWithTax(finalPrice.calculateTotalPriceWithTax()); //sharing the total price with tax information to the PaymentSummaryController

			} catch (IOException e) {
				e.printStackTrace();
			}
			paymentController.takeFocus();
		}
	}
}