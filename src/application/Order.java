package application;

import java.util.ArrayList;

public class Order {
	private ArrayList<MenuItem> itemList; 
	
	public Order(ArrayList<MenuItem> foodItemList) {
		itemList = foodItemList;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public double calculateTotalPrice() {
		double priceToReturn = 0.00;
		
		for (int i = 0; i < itemList.size(); i++) {
			priceToReturn = priceToReturn + itemList.get(i).calculateItemTotalPrice();
		}
		
		return priceToReturn;
	}

}