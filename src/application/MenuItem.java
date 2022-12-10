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
	 * Constructs a new MenuItem. 
	 */
	public MenuItem() {

	}

	/**
	 * Constructs a new MenuItem by taking the price of item and the user input for quantity of item and sets the instance variables,
	 * provided that the user inputs a valid positive integer value between 1 and 10 for quantity. 
	 * @param quantityItemAsString a String that holds the value of the amount of item intended by the user to be a quantity of that item. 
	 * @param priceItem a double that holds the price of the item.
	 * @throws InvalidUserInputException is thrown when user input for amount of item is anything other than a positive integer between 0 and 10. 
	 */
	public MenuItem(String quantityItemAsString, Double priceItem) throws InvalidUserInputException {
		setQuantity(quantityItemAsString);
		setPrice(priceItem);
	}

	/**
	 * @return The quantity of the item. 
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity instance variable, as long as the quantity is a positive integer between 1 and 10. 
	 * @param quantityItemAsString a String intended to be a quantity value entered by the user. 
	 * @throws InvalidUserInputException is thrown when quantity of item is anything other than a positive integer between 1 and 10.
	 */
	public void setQuantity(String quantityItemAsString) throws InvalidUserInputException {
		int quantityItem = 0;

		int decimalCounter = 0;
		boolean validQuantity = true;
		if (quantityItemAsString != "" || quantityItemAsString != null) {
			for (char c : quantityItemAsString.toCharArray()) { //if anything other than an integer number is provided, it's not valid
				if (!Character.isDigit(c)) validQuantity = false;
				if (c == '.') decimalCounter++;
				if (c == '0' && quantityItemAsString.length() == 1) throw new InvalidUserInputException("Order quantity cannot be 0."); //user cannot order 0 items
			}
		} else if (quantityItemAsString == "" || quantityItemAsString == null) { //checks for when an user enters no input
			validQuantity = false;
			quantityItem = 0;
			throw new InvalidUserInputException("Please input a value in this field.");
		}

		//non-numeric value for the amount will throw an exception
		if (validQuantity == true && quantityItemAsString != "") {
			quantityItem = Integer.parseInt(quantityItemAsString);
		} else if (validQuantity == false && decimalCounter != 0) {
			throw new InvalidUserInputException("Order quantity cannot contain decimals.");
		} else if (validQuantity == false && decimalCounter == 0) {
			throw new InvalidUserInputException("Order quantity cannot contain non-numeric characters. Please enter a positive numeric value.");
		}

		//let's assume that the max amount an user can order of a quantity is 10
		if (quantityItem > 10) {
			throw new InvalidUserInputException("To order a quantity of more than 10, please contact us directly by phone or in-person.");
		}

		this.quantity = quantityItem;
	}

	/**
	 * @return the price of the item
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price instance variable. 
	 * @param price the price of the item. 
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Calculates the total price of the given item based on the quantity entered by the user and price of the item. 
	 * @return the total price of the item based on the quantity entered by the user and price of the item.
	 */
	public double calculateItemTotalPrice() {
		double totalItemPrice = getQuantity() * getPrice(); 
		return totalItemPrice;
	}
	
}