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

/**
 * The OrderMenuController switches scenes from order menu to home page or payment summary. It reacts accordingly to
 * the user's selection of check boxes for each menu item and drink sizes, making text fields visible when check boxes
 * are selected and vice versa. It also validates user input in text fields. It only switches scenes to payment summary
 * when valid user input is provided. 
 * @author CS219-user Group 5
 *
 */
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
	private CheckBox chaiMainCheckBox;
	@FXML
	private CheckBox chaiCheckBoxSmall;
	@FXML
	private CheckBox chaiCheckBoxMedium;
	@FXML
	private CheckBox chaiCheckBoxLarge;
	@FXML
	private TextField chaiTextFieldSmall;
	@FXML
	private TextField chaiTextFieldMedium;
	@FXML
	private TextField chaiTextFieldLarge;
	
	@FXML
	private CheckBox sherbetMainCheckBox;
	@FXML
	private CheckBox sherbetCheckBoxSmall;
	@FXML
	private CheckBox sherbetCheckBoxMedium;
	@FXML
	private CheckBox sherbetCheckBoxLarge;
	@FXML
	private TextField sherbetTextFieldSmall;
	@FXML
	private TextField sherbetTextFieldMedium;
	@FXML
	private TextField sherbetTextFieldLarge;

	@FXML
	private Label inputErrorLabel;

	/**
	 * This method sets the given stage as the primary stage of the application. 
	 * @param aStage The stage to be set as the application's primary stage.
	 */
	public void setPrimaryStage(Stage aStage) {
		primaryStage = aStage;
	}

	/**
	 * This method sets the given scene as the controller's scene. 
	 * @param aScene The scene intended to be displayed to the user. 
	 */
	public void setMyScene(Scene aScene) {
		myScene = aScene;
	}

	/**
	 * This method switches the controller from OrderMenuController to HomePageController. 
	 * @param next The controller that it is switching to. 
	 */
	public void setNextController(HomePageController next) {
		homePageController = next;
	}

	/**
	 * This method switches the controller from OrderMenuController to ViewMenuController.
	 * @param next The controller that it is switching to. 
	 */
	public void setNextController2(ViewMenuController next) {
		viewMenuController = next;
	}

	/**
	 * This method sets the given scene as the primary stage's scene. This displays the given scene to the user
	 * utilizing the application.
	 */
	public void takeFocus() {
		primaryStage.setScene(myScene);
	}

	/**
	 * This method sets the home page as the scene when the user decides to return to the home page. 
	 * @param event Represents the action of the user pressing the button to return to the home page.
	 */
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

	/**
	 * This method sets a text field visible when the user selects the respective check box for that text field. When
	 * the user deselects the check box, the text field will be invisible. 
	 * @param checkBox The check box that will be selected or unselected by user. 
	 * @param textField The text field to set visible or invisible.
	 */
	private void setTextFieldVisibility(CheckBox checkBox, TextField textField) {
		if (checkBox.isSelected()) { //if checkbox is selected, then the textfield appears (assuming it's not visible)
			if (!textField.isVisible()) {
				textField.setVisible(true); 
			}
		}
		if (!checkBox.isSelected()) { //if checkbox is unselected by user, visible textfield disappears
			if (textField.isVisible()) {
				textField.setVisible(false); 
			}
			textField.clear();
			//clear any text user may have inputed
		}
	}

	/**
	 * Upon selecting the check box for the samosa menu item, its quantity text field will be visible. Deselecting 
	 * the check box will make the quantity text field invisible.
	 * @param event The user selecting or deselecting the check box for the samosa menu item. 
	 */
	@FXML
	void samosaTextFieldAppears(ActionEvent event) {
		setTextFieldVisibility(samosaCheckBox,samosaTextField); 
	}   

	/**
	 * Upon selecting the check box for the pani puri menu item, its quantity text field will be visible. Deselecting
	 * the check box will make the quantity text field invisible.
	 * @param event The user selecting or deselecting the check box for the pani puri menu item. 
	 */
	@FXML
	void paniPuriTextFieldAppears(ActionEvent event) {
		setTextFieldVisibility(paniPuriCheckBox,paniPuriTextField);
	}

	/**
	 * Upon selecting the check box for the butter chicken meal menu item, its quantity text field will be visible.
	 * Deselecting the check box will make the quantity text field invisible.
	 * @param event The user selecting or deselecting the check box for the butter chicken meal menu item. 
	 */
	@FXML
	void butterChickenTextFieldAppears(ActionEvent event) {
		setTextFieldVisibility(butterChickenCheckBox,butterChickenTextField);
	}

	/**
	 * Upon selecting the check box for the chef's choice meal menu item, its quantity text field will be visible. 
	 * Deselecting the check box will make the quantity text field invisible. 
	 * @param event The user selecting or deselecting the check box for the chef's choice meal menu item. 
	 */
	@FXML
	void chefsChoiceTextFieldAppears(ActionEvent event) {   	
		setTextFieldVisibility(chefsChoiceCheckBox,chefsChoiceTextField);
	}

	/**
	 * Upon selecting the check box for the gulab jamun menu item, its quantity text field will be visible.
	 * Deselecting the check box will make the quantity text field invisible.
	 * @param event The user selecting or deselecting the check box for the gulab jamun menu item. 
	 */
	@FXML
	void gulabJamunTextFieldAppears(ActionEvent event) {   	
		setTextFieldVisibility(gulabJamunCheckBox,gulabJamunTextField);
	}

	/**
	 * Upon selecting the check box for the brownie menu item, its quantity text field will be visible. Deselecting
	 * the check box will make the quantity text field invisible. 
	 * @param event The user selecting or deselecting the check box for brownie menu item. 
	 */
	@FXML
	void brownieTextFieldAppears(ActionEvent event) {
		setTextFieldVisibility(brownieCheckBox,brownieTextField);
	}

	/**
	 * This method makes quantity text fields visible when its respective size check box is selected for a drink,
	 * only if the main drink check box is selected. If the size check box is deselected, the text field will be 
	 * invisible. If user deselects the main drink item check box, all the size check boxes will be deselected and 
	 * all its text fields will become invisible.
	 * @param event The action of the user selecting the chai check box and its size check boxes. 
	 */
	@FXML
	void chaiTextFieldsAppear(ActionEvent event) {
		if(chaiMainCheckBox.isSelected()) {
			setTextFieldVisibility(chaiCheckBoxSmall, chaiTextFieldSmall);
			setTextFieldVisibility(chaiCheckBoxMedium, chaiTextFieldMedium);
			setTextFieldVisibility(chaiCheckBoxLarge, chaiTextFieldLarge);
		}
		ifDrinkIsUnselectedWithSizeSelected(chaiMainCheckBox, chaiTextFieldSmall, chaiCheckBoxSmall, chaiTextFieldMedium,
				chaiCheckBoxMedium, chaiTextFieldLarge, chaiCheckBoxLarge); //if user decides to unselect  a drink, the size check boxes will be unselected and the text fields will not be visible
	} 

	/**
	 * This method makes quantity text fields visible when its respective size check box is selected for a drink,
	 * only if the main drink check box is selected. If the size check box is deselected, the text field will be 
	 * invisible. If user deselects the main drink item check box, all the size check boxes will be deselected and 
	 * all its text fields will become invisible.
	 * @param event The action of the user selecting the rose sherbet check box and its size check boxes.
	 */
	@FXML
	void sherbetTextFieldsAppear(ActionEvent event) {
		if(sherbetMainCheckBox.isSelected()) {
			setTextFieldVisibility(sherbetCheckBoxSmall, sherbetTextFieldSmall);
			setTextFieldVisibility(sherbetCheckBoxMedium, sherbetTextFieldMedium);
			setTextFieldVisibility(sherbetCheckBoxLarge, sherbetTextFieldLarge);
		}
		ifDrinkIsUnselectedWithSizeSelected(sherbetMainCheckBox, sherbetTextFieldSmall, sherbetCheckBoxSmall, sherbetTextFieldMedium,
				sherbetCheckBoxMedium, sherbetTextFieldLarge, sherbetCheckBoxLarge);
	}

	/**
	 * This method checks if any of the menu item and drinks check boxes are selected and throws an 
	 * InvalidUserInputException if no check boxes are selected.
	 * @throws InvalidUserInputException if no check boxes are selected.
	 */
	public void ifAnyItemsAreSelected() throws InvalidUserInputException {
		// checks if any of the menu check boxes are selected.
		if (samosaCheckBox.isSelected() == false && paniPuriCheckBox.isSelected() == false && butterChickenCheckBox.isSelected()==false
				&& chefsChoiceCheckBox.isSelected() == false && gulabJamunCheckBox.isSelected()==false && brownieCheckBox.isSelected()==false
				&& chaiMainCheckBox.isSelected() == false && sherbetMainCheckBox.isSelected() == false) {
			throw new InvalidUserInputException ("Please select at least one item to continue.");
		}		 
	}

	/**
	 * This method checks if the user has selected a check box and if they have inputed a quantity in the quantity 
	 * text field. If there is no input and the check box is selected it throws an InvalidUserInputException. 
	 * @param itemSelected takes the check box for the menu item
	 * @param inputQuantity takes the user input in the quantity text field for the corresponding check box ( menu item)
	 * @throws InvalidUserInputException when user selects a check box and does not enter any input.
	 */
	public void ifItemIsSelected(CheckBox itemSelected, TextField inputQuantity) throws InvalidUserInputException{
		// if the check box is selected and the corresponding quantity text field 
		if (itemSelected.isSelected() == true && inputQuantity.getText() == "") throw new InvalidUserInputException ("Please input a quantity."); 
	}

	/**
	 * This method checks if the user has selected a drinks check box, but has selected no size. If they have selected no
	 * size but have selected a drink, an InvalidUserInputException is thrown. 
	 * @param drinkSelected the drink that is selected by user
	 * @param smallCB CheckBox of the small size of given drink
	 * @param mediumCB CheckBox of the medium size of given drink
	 * @param largeCB CheckBox of the large size of given drink
	 * @throws InvalidUserInputException is thrown when a drink is selected, but no size is selected by user. 
	 */
	public void ifDrinkIsSelectedWithNoSize(CheckBox drinkSelected, CheckBox smallCB, CheckBox mediumCB, CheckBox largeCB) throws InvalidUserInputException {
		if (drinkSelected.isSelected() == true && smallCB.isSelected() == false && mediumCB.isSelected() == false
				&& largeCB.isSelected() == false) {
			throw new InvalidUserInputException("Please select a drink size.");
		}
	}

	/**
	 * This method unselects the different size check boxes for a drink and their respective text fields when the user
	 * unselects the main drink check box. 
	 * @param drinkSelected CheckBox of the Drinks item. 
	 * @param smallTF TextField for the small size option. 
	 * @param smallCB CheckBox for the small size option. 
	 * @param mediumTF TextField for the medium size option. 
	 * @param mediumCB CheckBox for the medium size option. 
	 * @param largeTF TextField for the large size option.
	 * @param largeCB CheckBox for the large size option.
	 */
	public void ifDrinkIsUnselectedWithSizeSelected(CheckBox drinkSelected, TextField smallTF, CheckBox smallCB, 
			TextField mediumTF, CheckBox mediumCB, TextField largeTF, CheckBox largeCB) {
		if (drinkSelected.isSelected() == false && (smallTF.isVisible() == true || mediumTF.isVisible() == true 
				|| smallTF.isVisible() == true)) {
			smallTF.setVisible(false);
			mediumTF.setVisible(false);
			largeTF.setVisible(false);
			smallCB.setSelected(false);
			mediumCB.setSelected(false);
			largeCB.setSelected(false);
			//if drink check box is unselected, and a quantity textfield is visible for any of the size options, it
			//will be set unvisible and its checkbox will be unselected. 
		}
	}

	/**
	 * This method switches the scene to the Payment Summary scene after user places their order. Before switching,
	 * it will validate user input for the quantity of items and the selection, and display an error message if 
	 * invalid input is provided. It also displays an error message if user attempts to continue without selecting
	 * an item, or selects a drink without a size. 
	 * @param event Represents the action of the user pressing the button to continue to payment summary. 
	 */
	@FXML  
	public void switchtoPaymentSummary(ActionEvent event) {
		boolean errorPresent = false; //currently no errors present in user input

		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>(); //list of MenuItems (appetizer, main course, dessert)
		ArrayList<Drinks> drinksItemList = new ArrayList<Drinks>(); //list of Drinks

		try {	
			//creating MenuItem objects for each menu item 
			MenuItem samosa = new MenuItem(samosaTextField.getText(), 5.99);			
			MenuItem paniPuri = new MenuItem(paniPuriTextField.getText(), 8.99);
			MenuItem butterChicken = new MenuItem(butterChickenTextField.getText(), 17.99);
			MenuItem chefsChoice = new MenuItem(chefsChoiceTextField.getText(), 14.99);
			MenuItem gulabJamun = new MenuItem(gulabJamunTextField.getText(), 6.99);
			MenuItem brownie = new MenuItem(brownieTextField.getText(), 4.99);

			//creating Drinks objects for Chai, based on its different sizes
			Drinks drink1small = new Drinks("Small",chaiTextFieldSmall.getText());
			Drinks drink1med = new Drinks("Medium",chaiTextFieldMedium.getText());
			Drinks drink1large = new Drinks("Large",chaiTextFieldLarge.getText());

			//creating Drinks objects for Rose Sherbet, based on its different sizes
			Drinks drink2small = new Drinks("Small",sherbetTextFieldSmall.getText());
			Drinks drink2med = new Drinks("Medium",sherbetTextFieldMedium.getText());
			Drinks drink2large = new Drinks("Large",sherbetTextFieldLarge.getText());

			//adding all the menu items to the list
			menuItemList.add(samosa);
			menuItemList.add(paniPuri);
			menuItemList.add(butterChicken);
			menuItemList.add(chefsChoice);
			menuItemList.add(gulabJamun);
			menuItemList.add(brownie);

			//adding all the drinks (specifically, their sizes) to the list
			drinksItemList.add(drink1small);
			drinksItemList.add(drink2small);
			drinksItemList.add(drink1med);
			drinksItemList.add(drink2med);
			drinksItemList.add(drink1large);
			drinksItemList.add(drink2large);

			//checks if any of the check boxes are not selected, and if none are, user is given an error message when they attempt to continue
			ifAnyItemsAreSelected();

			//checks if the check box is selected for the menu items, and if one is, but text field is empty, user is given error message when they attempt to continue
			ifItemIsSelected(samosaCheckBox,samosaTextField);	
			ifItemIsSelected(paniPuriCheckBox,paniPuriTextField);	
			ifItemIsSelected(butterChickenCheckBox,butterChickenTextField);	
			ifItemIsSelected(chefsChoiceCheckBox,chefsChoiceTextField);	
			ifItemIsSelected(gulabJamunCheckBox,gulabJamunTextField);	
			ifItemIsSelected(brownieCheckBox,brownieTextField);

			//checks if drink is selected, but no size is selected, and if a size isn't selected, user is given error message 
			ifDrinkIsSelectedWithNoSize(chaiMainCheckBox, chaiCheckBoxSmall, chaiCheckBoxMedium, chaiCheckBoxLarge);
			ifDrinkIsSelectedWithNoSize(sherbetMainCheckBox, sherbetCheckBoxSmall, sherbetCheckBoxMedium, sherbetCheckBoxLarge);

			//checks if the check box is selected for the different sizes of the drinks, and if one is, but text field is empty, user is given error message when they attempt to continue
			ifItemIsSelected(chaiCheckBoxSmall, chaiTextFieldSmall);
			ifItemIsSelected(chaiCheckBoxMedium, chaiTextFieldMedium);
			ifItemIsSelected(chaiCheckBoxLarge, chaiTextFieldLarge);
			ifItemIsSelected(sherbetCheckBoxSmall, sherbetTextFieldSmall);
			ifItemIsSelected(sherbetCheckBoxMedium, sherbetTextFieldMedium);
			ifItemIsSelected(sherbetCheckBoxLarge, sherbetTextFieldLarge);

		} catch (InvalidUserInputException iuie) {
			inputErrorLabel.setText(iuie.getMessage()); //if exception is caught because of invalid user input, an appropriate error message will be displayed
			errorPresent = true; //errors are present in user input
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

