package application;

import java.util.ArrayList;

/**
 * Holds a list of MenuItems and Drinks to calculate the total order price of the user,
 * after they input their quantities for menu items and drinks. 
 * @author CS219-user Group 5
 *
 */
public class Order {
	private ArrayList<MenuItem> itemList;
	private ArrayList<Drinks> drinksList;

	/**
	 * Constructs a new order by taking lists of the menu items and drinks and 
	 * setting the instance variables as those lists.
	 * @param foodItemList a list of all the MenuItems 
	 * @param drinksItemList a list of all the Drinks
	 */
	public Order(ArrayList<MenuItem> menuItemList, ArrayList<Drinks> drinksItemList) {
		setItemList(menuItemList);
		setDrinksList(drinksItemList);
	}

	/**
	 * @return A list of the MenuItem objects.
	 */
	public ArrayList<MenuItem> getItemList() {
		return itemList;
	}

	/**
	 * Sets the itemList as the list of MenuItem objects.
	 * @param itemList the list of MenuItem objects to be set.
	 */
	public void setItemList(ArrayList<MenuItem> itemList) {
		this.itemList = itemList;
	}

	/**
	 * @return A list of the Drinks objects.
	 */
	public ArrayList<Drinks> getDrinksList() {
		return drinksList;
	}

	public void setDrinksList(ArrayList<Drinks> drinksList) {
		this.drinksList = drinksList;
	}

	/**
	 * Calculates the total price of the user's order and returns that total price.
	 * @return the total price of the user's entire order of items
	 */
	public double calculateTotalPrice() {
		double priceToReturn = 0.00;

		//takes total price of each item and adds them to a total order price
		for (int i = 0; i < getItemList().size(); i++) {
			priceToReturn = priceToReturn + getItemList().get(i).calculateItemTotalPrice();
		}

		//takes total price of each drink and adds them to a total order price
		for (int i = 0; i < getDrinksList().size(); i++) {
			try {
				priceToReturn = priceToReturn + getDrinksList().get(i).calculateDrinkTotalPrice();
			} catch (InvalidUserInputException e) {
				e.printStackTrace();
			}
		}

		return priceToReturn;
	}

	/**
	 * Calculates the total price of the user's order with 5% tax and returns the total price with tax.
	 * @return the total price of the user's entire order of items with 5% tax.
	 */
	public double calculateTotalPriceWithTax() {
		double priceToReturnWithTax = calculateTotalPrice() + (calculateTotalPrice() * 0.05); //we're using GST tax of 5%

		return priceToReturnWithTax;
	}

}