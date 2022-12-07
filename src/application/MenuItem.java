package application;

/**
 * Takes information about a Menu item, like amount of item and price of item, and calculates the total price of 
 * the item, provided that the user input is valid. Otherwise, an InvalidUserInputException is thrown.   
 * @author CS219-user Group 5
 *
 */
public class MenuItem {
	private int quantity;
	private double price = 0.00;

	/**
	 * Empty constructor for the class. 
	 */
	public MenuItem() {

	}

	/**
	 * This constructor takes the price of item and the user input for quantity of item and sets the instance variables,
	 * provided that the user inputs a valid positive integer value between 0 and 10 for quantity. 
	 * @param amountItemAsString a String that holds the value of the amount of item intended by the user to be a quantity of that item. 
	 * @param priceItem a double that holds the price of the item.
	 * @throws InvalidUserInputException is thrown when user input for amount of item is anything other than a positive integer between 0 and 10. 
	 */
	public MenuItem(String amountItemAsString, Double priceItem) throws InvalidUserInputException {
		setQuantity(amountItemAsString);
		setPrice(priceItem);
	}

	/**
	 * This getter method is an accessor method that allows for the amount instance variable to be accessed throughout the class
	 * and its child class, Drinks. 
	 * @return the quantity entered by the user for the item, set by the constructor. 
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * This setter method is a mutator method that sets the quantity instance variable, as long as the quantity
	 * is a positive integer between 0 and 10. 
	 * @param amountItemAsString a String intended to be a quantity value entered by the user. 
	 * @throws InvalidUserInputException is thrown when quantity of item is anything other than a positive integer between 1 and 10.
	 */
	public void setQuantity(String amountItemAsString) throws InvalidUserInputException {
		int amountItem = 0;

		int decimalCounter = 0;
		boolean validAmount = true;
		if (amountItemAsString != "" || amountItemAsString != null) {
			for (char c : amountItemAsString.toCharArray()) { //if anything other than an integer number is provided, it's not valid
				if (!Character.isDigit(c)) validAmount = false;
				if (c == '.') decimalCounter++;
				if (c == '0' && amountItemAsString.length() == 1) throw new InvalidUserInputException("Order quantity cannot be 0."); //user cannot order 0 items
			}
		} else if (amountItemAsString == "" || amountItemAsString == null) { //checks for when an user enters no input
			validAmount = false;
			amountItem = 0;
			throw new InvalidUserInputException("Please input a value in this field.");
		}

		//non-numeric value for the amount will throw an exception
		if (validAmount == true && amountItemAsString != "") {
			amountItem = Integer.parseInt(amountItemAsString);
		} else if (validAmount == false && decimalCounter != 0) {
			throw new InvalidUserInputException("Order quantity cannot contain decimals.");
		} else if (validAmount == false && decimalCounter == 0) {
			throw new InvalidUserInputException("Order quantity cannot contain non-numeric characters. Please enter a positive numeric value.");
		}

		//let's assume that the max amount an user can order of a quantity is 10
		if (amountItem > 10) {
			throw new InvalidUserInputException("To order a quantity of more than 10, please contact us directly by phone or in-person.");
		}

		this.quantity = amountItem;
	}

	/**
	 * This getter method is an accessor method that allows for the price instance variable to be accessed throughout
	 * the MenuItem class and its child class, Drinks.
	 * @return the price of the item
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * This setter method is a mutator method that sets the price instance variable. 
	 * @param price the price of the item. 
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * This method calculates the total price of the given item based on the quantity entered by the user and price 
	 * of the item. 
	 * @return the total price of the item based on the quantity entered by the user and price of the item.
	 */
	public double calculateItemTotalPrice() {
		double totalItemPrice = getQuantity() * getPrice(); 
		return totalItemPrice;
	}


}