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
    private RadioButton drink1RBsmall;
    @FXML
    private RadioButton drink1RBmed;
    @FXML
    private RadioButton drink1RBlarge;
    @FXML
    private RadioButton drink2RBsmall;
    @FXML
    private RadioButton drink2RBmed;
    @FXML
    private RadioButton drink2RBlarge;
    
    @FXML
    private CheckBox drink2CheckBox;
   
    @FXML
    private ChoiceBox drink2ChoiceBoxSmall;
    @FXML
    private ChoiceBox drink2ChoiceBoxMed;
    @FXML
    private ChoiceBox drink2ChoiceBoxLarge;
    @FXML
    private ChoiceBox drink1ChoiceBoxSmall;
    @FXML
    private ChoiceBox drink1ChoiceBoxMed;
    @FXML
    private ChoiceBox drink1ChoiceBoxLarge;
    
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
	
	private void setTextFieldVisibilityForDrinks (CheckBox drinksChoiceBox, RadioButton rb, ChoiceBox cb) {
		if (drinksChoiceBox.isSelected()) { //if checkbox is selected, then radiobutton should appear, if radiobutton is selected then choice box should appear (assuming it's not visible)
			if (!rb.isVisible()) {
	    		rb.setVisible(true);
	    		if (rb.isSelected()) {
	    			if(!cb.isVisible()) {
	    				cb.setVisible(true);
	    			}
	    		}
	    		
	    		
	    }
		}
		/*options I was going through:
		if(drinksChoiceBox.isSelected()&& rb.isVisible()&& rb.isSelected() && !cb.isVisible()) {
			
	    		cb.setVisible(true);
	}
		if(drinksChoiceBox.isSelected()&& rb.isVisible()&& !rb.isSelected() && cb.isVisible()) {
			
	    		cb.setVisible(false);
		
	}*/
	    if (!drinksChoiceBox.isSelected()) { //if checkbox is unselected by user, visible textfield disappears
	    	if (rb.isVisible()) {
	    		rb.setVisible(false); 
	    		cb.setVisible(false);
	    	}
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
		setTextFieldVisibilityForDrinks(drink1CheckBox,drink1RBsmall, drink1ChoiceBoxSmall);
		setTextFieldVisibilityForDrinks(drink1CheckBox,drink1RBmed, drink1ChoiceBoxMed);
		setTextFieldVisibilityForDrinks(drink1CheckBox,drink1RBlarge, drink1ChoiceBoxLarge);
	}
	
	@FXML
	void drink2RadioButtonAppearsForDrinks(ActionEvent event) {
		setTextFieldVisibilityForDrinks(drink2CheckBox,drink2RBsmall, drink2ChoiceBoxSmall);
		setTextFieldVisibilityForDrinks(drink2CheckBox,drink2RBmed, drink2ChoiceBoxMed);
		setTextFieldVisibilityForDrinks(drink2CheckBox,drink2RBlarge, drink2ChoiceBoxLarge);
	}
	
	
	public void ifAnySelected() throws InvalidUserInputException {
		if (samosaCheckBox.isSelected() == false && paniPuriCheckBox.isSelected() == false && butterChickenCheckBox.isSelected()==false
			&& chefsChoiceCheckBox.isSelected() == false && gulabJamunCheckBox.isSelected()==false && brownieCheckBox.isSelected()==false
			&& drink1CheckBox.isSelected() == false && drink2CheckBox.isSelected() == false) {
			throw new InvalidUserInputException ("Please select at least one item to continue.");
		}		 
	}
	
	public boolean ifItemIsSelected(CheckBox itemSelected, TextField inputQuantity) throws InvalidUserInputException{
		boolean empty = false;
		if (itemSelected.isSelected() == true && inputQuantity.getText() == "") {
			empty = true;
			throw new InvalidUserInputException ("Please input a quantity.");
		} else if (itemSelected.isSelected()== true && inputQuantity.getText() != "") {
			empty = false;
		}
		return empty;
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
			Drinks drink1small = new Drinks(drink1RBsmall.getText(),(String)drink1ChoiceBoxSmall.getValue());
			if((String)drink1ChoiceBoxSmall.getValue()==null) {
				String a=(String)drink1ChoiceBoxSmall.getValue();
				a="0";
			}
			Drinks drink1med = new Drinks(drink1RBmed.getText(),(String)drink1ChoiceBoxMed.getValue());
			if((String)drink1ChoiceBoxMed.getValue()==null) {
				String a=(String)drink1ChoiceBoxMed.getValue();
				a="0";
			}
			Drinks drink1large = new Drinks(drink1RBlarge.getText(),(String)drink1ChoiceBoxSmall.getValue());
			if((String)drink1ChoiceBoxLarge.getValue()==null) {
				String a=(String)drink1ChoiceBoxLarge.getValue();
				a="0";
			}
			
			Drinks drink2small = new Drinks(drink2RBsmall.getText(),(String)drink2ChoiceBoxSmall.getValue());
			if((String)drink2ChoiceBoxSmall.getValue()==null) {
				String a=(String)drink2ChoiceBoxSmall.getValue();
				a="0";
			}
			Drinks drink2med = new Drinks(drink2RBmed.getText(),(String)drink2ChoiceBoxMed.getValue());
			if((String)drink2ChoiceBoxMed.getValue()==null) {
				String a=(String)drink2ChoiceBoxMed.getValue();
				a="0";
			}
			Drinks drink2large = new Drinks(drink2RBlarge.getText(),(String)drink2ChoiceBoxLarge.getValue());
			if((String)drink2ChoiceBoxLarge.getValue()==null) {
				String a=(String)drink2ChoiceBoxLarge.getValue();
				a="0";
			}
			
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
		}
		
		try {
			ifAnySelected();
			ifItemIsSelected(samosaCheckBox,samosaTextField);	
			ifItemIsSelected(paniPuriCheckBox,paniPuriTextField);	
			ifItemIsSelected(butterChickenCheckBox,butterChickenTextField);	
			ifItemIsSelected(chefsChoiceCheckBox,chefsChoiceTextField);	
			ifItemIsSelected(gulabJamunCheckBox,gulabJamunTextField);	
			ifItemIsSelected(brownieCheckBox,brownieTextField);	
		} catch (InvalidUserInputException iuie) {
			errorPresent = true;
			inputErrorLabel.setText(iuie.getMessage());
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