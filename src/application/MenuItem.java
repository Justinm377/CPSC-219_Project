package application;

public class MenuItem {
	private int amount;
	private double price = 0.00;
	
	public MenuItem(int amountItem, double priceItem) {
		amount = amountItem;
		price = priceItem;
	}
	
	public MenuItem(String amountItemAsString, String priceItemAsString) throws InvalidUserInputException {
		int amountItem = 0;
		double priceItem = 0.00;
		
		boolean validAmount = true;
		for (char c : amountItemAsString.toCharArray()) { //if anything other than an integer number is provided, it's not valid
			if (!Character.isDigit(c)) validAmount = false;
		}
		//non-numeric value for the amount will throw an exception
		if (validAmount == true) {
			amountItem = Integer.parseInt(amountItemAsString);
		} else if (validAmount == false) {
			throw new InvalidUserInputException("Amount value should only contain numeric values. Decimals and non-numeric values are not allowed.");
		}
		//let's assume that the max amount an user can order of a quantity is 10
		if (amountItem > 10) {
			throw new InvalidUserInputException("The maximum amount is 10 items.");
		}
		//user cannot order negative amount
		if (amountItem < 0) {
			throw new InvalidUserInputException("Please enter a positive number between 0 and 10");
		}
		
		//remove '$' from price, eg. "$0.00"
		String newPriceAsString = priceItemAsString.substring(1, priceItemAsString.length()-1);
		priceItem = Double.parseDouble(newPriceAsString);
		
		//set the instance variables
		amount = amountItem;
		price = priceItem;
	}

}
