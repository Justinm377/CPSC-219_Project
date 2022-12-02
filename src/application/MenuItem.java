package application;

public class MenuItem {
	private int amount;
	private double price = 0.00;
	
	public MenuItem() {
	}
	
	public MenuItem(int amountItem, double priceItem) {
		setAmount(amountItem);
		setPrice(priceItem);
	}
	
	public MenuItem(String amountItemAsString, Double priceItem) throws InvalidUserInputException {
		int amountItem = 0;
		
		int decimalCounter = 0;
		boolean validAmount = true;
		if (amountItemAsString != "" || amountItemAsString != null) {
			for (char c : amountItemAsString.toCharArray()) { //if anything other than an integer number is provided, it's not valid
				if (!Character.isDigit(c)) validAmount = false;
				if (c == '.') decimalCounter++;
			}
		} else if (amountItemAsString == "" || amountItemAsString == null) {
			validAmount = false;
			amountItem = 0;
			throw new InvalidUserInputException("Please input a value in this field.");
		}
		
		//user cannot order negative amount
		if (amountItem < 0) {
			throw new InvalidUserInputException("Please enter a positive number between 0 and 10");
		}
		
		//non-numeric value for the amount will throw an exception
		if (validAmount == true && amountItemAsString != "") {
			amountItem = Integer.parseInt(amountItemAsString);
		} else if (validAmount == false && decimalCounter != 0) {
			throw new InvalidUserInputException("Order quantity cannot contain decimals.");
		} else if (validAmount == false && decimalCounter == 0) {
			throw new InvalidUserInputException("Order quantity cannot contain non-numeric characters. Please enter a numeric value.");
		}
		
		//let's assume that the max amount an user can order of a quantity is 10
		if (amountItem > 10) {
			throw new InvalidUserInputException("To order a quantity of more than 10, please contact us directly by phone or in-person.");
		}
		
		//set the instance variables
		setAmount(amountItem);
		setPrice(priceItem);
	}

	public double calculateItemTotalPrice() {
		double totalItemPrice = getAmount() * getPrice(); 
		return totalItemPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}