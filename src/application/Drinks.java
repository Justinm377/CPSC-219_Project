
package application;

/**
 * This class is a sub-class of the MenuItem class. It uses size to calculate total price of the drink and the quantity
 * of the drink.
 * @author CS219-user Group 5
 *
 */

public class Drinks extends MenuItem {
	private String size ;

	/**
	 * Constructs a new Drinks. 
	 */
	public Drinks() {
		super();
	}

	/**
	 * This constructor takes the drink size and drink quantity and sets the instance variables size and quantity.
	 * 
	 * @param drinkSize A size (Small, Medium, Large) selected by the user. 
	 * @param drinkAmount a String that holds the value of the quantity of drinks intended by the user to be a quantity of that item. 
	 * @throws InvalidUserInputException 
	 */

	public Drinks(String drinkSize, String drinkAmount) throws InvalidUserInputException {
		setSize(drinkSize);
		setQuantity(drinkAmount);
	}

	/**
	 * @return The size of the drink.
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Sets the size provided by the user's input.
	 * @param size The size given by user input. 
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * This method calculates the total price of the drink item selected by the user. 
	 * 
	 * @return the total price of the drink.
	 * @throws InvalidUserInputException when no size is selected by user. 
	 */
	public double calculateDrinkTotalPrice() throws InvalidUserInputException {
		if (getSize().equals("Small")) {
			setPrice(1.99); //small is $1.99
		} else if (getSize().equals("Medium")) {
			setPrice(2.49); //medium is $2.49
		} else if (getSize().equals("Large")) {
			setPrice(2.99); //large is $2.99
		} else if (getSize().equals("")) {
			setPrice(0.00);
			throw new InvalidUserInputException("Please select a size for your drink.");
		}

		return calculateItemTotalPrice();
	}

}
