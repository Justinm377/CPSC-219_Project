package application;

import java.util.ArrayList;

public class Order {
	private ArrayList<MenuItem> itemList;
	private ArrayList<Drinks> drinksList;
	
	public Order(ArrayList<MenuItem> foodItemList, ArrayList<Drinks> drinksItemList) {
		itemList = foodItemList;
		drinksList = drinksItemList;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public double calculateTotalPrice() {
		double priceToReturn = 0.00;
		
		for (int i = 0; i < itemList.size(); i++) {
			priceToReturn = priceToReturn + itemList.get(i).calculateItemTotalPrice();
		}
		
		for (int i = 0; i < drinksList.size(); i++) {
			priceToReturn = priceToReturn + drinksList.get(i).calculateDrinkTotalPrice();
		}
		
		return priceToReturn;
	}

}