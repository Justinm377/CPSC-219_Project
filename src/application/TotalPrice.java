package application;

import java.util.ArrayList;

public class TotalPrice {
	private ArrayList<MenuItem> itemList; 
	
	public TotalPrice(ArrayList<MenuItem> foodItemList) {
		itemList = foodItemList;
	}
	
	public TotalPrice() {
		// TODO Auto-generated constructor stub
	}

	public double calculateTotalPrice() {
		double priceToReturn = 0.00;
		
		for (int i = 0; i < itemList.size(); i++) {
			priceToReturn = priceToReturn + itemList.get(i).calculateItemTotalPrice();
		}
		priceToReturn = priceToReturn*1.05;
		return priceToReturn;
	}

}
